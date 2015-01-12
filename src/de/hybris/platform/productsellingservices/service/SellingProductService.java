/**
 * 
 */
package de.hybris.platform.productsellingservices.service;

import de.hybris.platform.productsellingservices.data.SellingProductData;
import de.hybris.platform.productsellingservices.model.SellingProductModel;

import java.util.List;


/**
 * @author VJA
 * 
 */
public interface SellingProductService
{
	void sendProduct(final String code, final String name, final String description, final String address,
			final String dateandtime, final Double priceOfProduct, final String picture, final String storename);

	void recieveProduct(final SellingProductData sellingProductData);

	List<SellingProductModel> findAllProducts();
}
