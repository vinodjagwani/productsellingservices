/**
 * 
 */
package de.hybris.platform.productsellingservices.service.impl;

import de.hybris.platform.productsellingservices.dao.SellingProductDao;
import de.hybris.platform.productsellingservices.data.SellingProductData;
import de.hybris.platform.productsellingservices.model.SellingProductModel;
import de.hybris.platform.productsellingservices.service.SellingProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 * @author VJA
 * 
 */
public class DefaultSellingProductService implements SellingProductService
{



	private SellingProductDao sellingProductDAO;

	/**
	 * @param sellingProductDAO
	 *           the sellingProductDAO to set
	 */
	@Required
	public void setSellingProductDAO(final SellingProductDao sellingProductDAO)
	{
		this.sellingProductDAO = sellingProductDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.productsellingservices.service.SellingProductService#sendProduct(java.lang.String,
	 * java.lang.String, java.lang.String, double, java.lang.String)
	 */
	@Override
	public void sendProduct(final String code, final String name, final String description, final String address,
			final String dateandtime, final Double priceOfProduct, final String picture, final String storename)
	{
		sellingProductDAO.sendProduct(code, name, description, address, dateandtime, priceOfProduct, picture, storename);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.productsellingservices.service.SellingProductService#recieveProduct(de.hybris.platform.
	 * commercefacades.product.data.ProductData)
	 */
	@Override
	public void recieveProduct(final SellingProductData sellingProductData)
	{
		sellingProductDAO.recieveProduct(sellingProductData);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.productsellingservices.service.SellingProductService#findAllProducts()
	 */
	@Override
	public List<SellingProductModel> findAllProducts()
	{
		// YTODO Auto-generated method stub
		return sellingProductDAO.findAllProducts();
	}

}
