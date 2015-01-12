/**
 * 
 */
package de.hybris.platform.productsellingservices.facade.impl;

import de.hybris.platform.productsellingservices.data.SellingProductData;
import de.hybris.platform.productsellingservices.facade.SellingProductFacade;
import de.hybris.platform.productsellingservices.model.SellingProductModel;
import de.hybris.platform.productsellingservices.service.SellingProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * @author VJA
 * 
 */
public class DefaultSellingProductFacade implements SellingProductFacade
{


	private SellingProductService sellingProductService;


	/**
	 * @param sellingProductService
	 *           the sellingProductService to set
	 */
	@Required
	public void setSellingProductService(final SellingProductService sellingProductService)
	{
		this.sellingProductService = sellingProductService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.productsellingservices.facade.SellingProductFacade#sendProduct(java.lang.String,
	 * java.lang.String, java.lang.String, double, java.lang.String)
	 */
	@Override
	public void sendProduct(final String code, final String name, final String description, final String address,
			final String dateandtime, final Double priceOfProduct, final String picture, final String storename)
	{
		sellingProductService.sendProduct(code, name, description, address, dateandtime, priceOfProduct, picture, storename);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.productsellingservices.facade.SellingProductFacade#recieveProduct(de.hybris.platform.
	 * commercefacades.product.data.ProductData)
	 */
	@Override
	public void recieveProduct(final SellingProductData sellingProductData)
	{
		sellingProductService.recieveProduct(sellingProductData);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.productsellingservices.facade.SellingProductFacade#findAllProducts()
	 */
	@Override
	public List<SellingProductModel> findAllProducts()
	{

		return sellingProductService.findAllProducts();
	}

}
