/**
 * 
 */
package de.hybris.platform.productsellingservices.controller;

import de.hybris.platform.productsellingservices.data.SellingProductData;
import de.hybris.platform.productsellingservices.facade.SellingProductFacade;
import de.hybris.platform.productsellingservices.model.SellingProductModel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author VJA
 * 
 */
@Controller
@RequestMapping(value = "/sellingproduct")
public class SellingProductController
{

	private static final Logger LOG = Logger.getLogger(SellingProductController.class.getName());

	@Resource(name = "sellingProductFacade")
	private SellingProductFacade sellingProductFacade;

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public SellingProductData sendProduct(@RequestParam(required = false) final String code,
			@RequestParam(required = false) final String name, @RequestParam(required = false) final String description,
			@RequestParam(required = false) final String address, @RequestParam(required = false) final String dateandtime,
			@RequestParam(required = false) final Double priceOfProduct, @RequestParam(required = false) final String picture,
			@RequestParam(required = false) final String storename)
	{
		SellingProductData sellingProductData = null;
		try
		{
			final String base64Image = picture.substring(picture.indexOf(",") + 1);
			sellingProductFacade.sendProduct(code, name, description, address, dateandtime, priceOfProduct, base64Image, storename);
			sellingProductData = new SellingProductData();
			sellingProductData.setCode(code);
			sellingProductData.setName(name);
			sellingProductData.setDescription(description);
			sellingProductData.setAddress(address);
			sellingProductData.setProductAvailablity(dateandtime);
			sellingProductData.setPriceOfProduct(priceOfProduct);
			sellingProductData.setStorename(storename);
			sellingProductData.setPicture(base64Image);
		}
		catch (final Exception e)
		{
			LOG.error("SellingProductData sendProduct :", e);
		}
		LOG.info("controller is called " + code);
		return sellingProductData;
	}





	@RequestMapping(value = "/searchAll", method = RequestMethod.GET)
	@ResponseBody
	public List<SellingProductData> viewAllProducts()
	{
		LOG.info("controller is called: List<SellingProductModel> viewAllProducts() ");

		final List<SellingProductData> list = new ArrayList<SellingProductData>();
		for (final SellingProductModel model : sellingProductFacade.findAllProducts())
		{
			final SellingProductData data = new SellingProductData();
			data.setCode(model.getCode());
			data.setAddress(model.getAddress());
			data.setDescription(model.getDescription());
			data.setThumbnail(model.getThumbnail());
			data.setPicture(model.getThumbnail().toString());
			data.setName(model.getName());
			data.setPriceOfProduct(model.getPriceOfProduct());
			list.add(data);
		}
		return list;
	}

}
