/**
 * 
 */
package de.hybris.platform.productsellingservices.controller;

import de.hybris.platform.productsellingservices.data.SellingProductData;
import de.hybris.platform.productsellingservices.facade.SellingProductFacade;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;


/**
 * @author VJA
 * 
 */

@Controller
@RequestMapping(value = "/receivingproduct")
public class ReceiveProductController
{

	private static final Logger LOG = Logger.getLogger(ReceiveProductController.class.getName());


	@Resource(name = "sellingProductFacade")
	private SellingProductFacade sellingProductFacade;

	@RequestMapping(value = "/response", method = RequestMethod.POST)
	@ResponseBody
	public SellingProductData receiveProduct(final HttpServletRequest request, final HttpServletResponse response)
	{
		SellingProductData sellingProductData = null;
		try
		{
			final InputStream in = request.getInputStream();
			final String datastream = IOUtils.toString(in);
			final Gson gson = new Gson();
			sellingProductData = gson.fromJson(datastream, SellingProductData.class);
			sellingProductFacade.recieveProduct(sellingProductData);
			LOG.info("controller is called: SellingProductData ");
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		return sellingProductData;
	}
}
