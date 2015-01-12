/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 18.12.2014 23:42:16                         ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 *  
 * Copyright (c) 2000-2011 hybris AG
 * All rights reserved.
 *  
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *  
 */
package de.hybris.platform.productsellingservices.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.media.Media;
import de.hybris.platform.productsellingservices.constants.ProductsellingservicesConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.productsellingservices.jalo.SellingProduct SellingProduct}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedSellingProduct extends GenericItem
{
	/** Qualifier of the <code>SellingProduct.thumbnail</code> attribute **/
	public static final String THUMBNAIL = "thumbnail";
	/** Qualifier of the <code>SellingProduct.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>SellingProduct.storename</code> attribute **/
	public static final String STORENAME = "storename";
	/** Qualifier of the <code>SellingProduct.productAvailablity</code> attribute **/
	public static final String PRODUCTAVAILABLITY = "productAvailablity";
	/** Qualifier of the <code>SellingProduct.picture</code> attribute **/
	public static final String PICTURE = "picture";
	/** Qualifier of the <code>SellingProduct.address</code> attribute **/
	public static final String ADDRESS = "address";
	/** Qualifier of the <code>SellingProduct.description</code> attribute **/
	public static final String DESCRIPTION = "description";
	/** Qualifier of the <code>SellingProduct.priceOfProduct</code> attribute **/
	public static final String PRICEOFPRODUCT = "priceOfProduct";
	/** Qualifier of the <code>SellingProduct.name</code> attribute **/
	public static final String NAME = "name";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(THUMBNAIL, AttributeMode.INITIAL);
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(STORENAME, AttributeMode.INITIAL);
		tmp.put(PRODUCTAVAILABLITY, AttributeMode.INITIAL);
		tmp.put(PICTURE, AttributeMode.INITIAL);
		tmp.put(ADDRESS, AttributeMode.INITIAL);
		tmp.put(DESCRIPTION, AttributeMode.INITIAL);
		tmp.put(PRICEOFPRODUCT, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.address</code> attribute.
	 * @return the address
	 */
	public String getAddress(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ADDRESS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.address</code> attribute.
	 * @return the address
	 */
	public String getAddress()
	{
		return getAddress( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.address</code> attribute. 
	 * @param value the address
	 */
	public void setAddress(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ADDRESS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.address</code> attribute. 
	 * @param value the address
	 */
	public void setAddress(final String value)
	{
		setAddress( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.code</code> attribute.
	 * @return the code
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.code</code> attribute.
	 * @return the code
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.description</code> attribute.
	 * @return the description
	 */
	public String getDescription(final SessionContext ctx)
	{
		return (String)getProperty( ctx, DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.description</code> attribute.
	 * @return the description
	 */
	public String getDescription()
	{
		return getDescription( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.description</code> attribute. 
	 * @param value the description
	 */
	public void setDescription(final SessionContext ctx, final String value)
	{
		setProperty(ctx, DESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.description</code> attribute. 
	 * @param value the description
	 */
	public void setDescription(final String value)
	{
		setDescription( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.name</code> attribute.
	 * @return the name
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.name</code> attribute.
	 * @return the name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.picture</code> attribute.
	 * @return the picture
	 */
	public Media getPicture(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, PICTURE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.picture</code> attribute.
	 * @return the picture
	 */
	public Media getPicture()
	{
		return getPicture( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.picture</code> attribute. 
	 * @param value the picture
	 */
	public void setPicture(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, PICTURE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.picture</code> attribute. 
	 * @param value the picture
	 */
	public void setPicture(final Media value)
	{
		setPicture( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.priceOfProduct</code> attribute.
	 * @return the priceOfProduct
	 */
	public Double getPriceOfProduct(final SessionContext ctx)
	{
		return (Double)getProperty( ctx, PRICEOFPRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.priceOfProduct</code> attribute.
	 * @return the priceOfProduct
	 */
	public Double getPriceOfProduct()
	{
		return getPriceOfProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.priceOfProduct</code> attribute. 
	 * @return the priceOfProduct
	 */
	public double getPriceOfProductAsPrimitive(final SessionContext ctx)
	{
		Double value = getPriceOfProduct( ctx );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.priceOfProduct</code> attribute. 
	 * @return the priceOfProduct
	 */
	public double getPriceOfProductAsPrimitive()
	{
		return getPriceOfProductAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.priceOfProduct</code> attribute. 
	 * @param value the priceOfProduct
	 */
	public void setPriceOfProduct(final SessionContext ctx, final Double value)
	{
		setProperty(ctx, PRICEOFPRODUCT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.priceOfProduct</code> attribute. 
	 * @param value the priceOfProduct
	 */
	public void setPriceOfProduct(final Double value)
	{
		setPriceOfProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.priceOfProduct</code> attribute. 
	 * @param value the priceOfProduct
	 */
	public void setPriceOfProduct(final SessionContext ctx, final double value)
	{
		setPriceOfProduct( ctx,Double.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.priceOfProduct</code> attribute. 
	 * @param value the priceOfProduct
	 */
	public void setPriceOfProduct(final double value)
	{
		setPriceOfProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.productAvailablity</code> attribute.
	 * @return the productAvailablity
	 */
	public String getProductAvailablity(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRODUCTAVAILABLITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.productAvailablity</code> attribute.
	 * @return the productAvailablity
	 */
	public String getProductAvailablity()
	{
		return getProductAvailablity( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.productAvailablity</code> attribute. 
	 * @param value the productAvailablity
	 */
	public void setProductAvailablity(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRODUCTAVAILABLITY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.productAvailablity</code> attribute. 
	 * @param value the productAvailablity
	 */
	public void setProductAvailablity(final String value)
	{
		setProductAvailablity( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.storename</code> attribute.
	 * @return the storename
	 */
	public String getStorename(final SessionContext ctx)
	{
		return (String)getProperty( ctx, STORENAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.storename</code> attribute.
	 * @return the storename
	 */
	public String getStorename()
	{
		return getStorename( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.storename</code> attribute. 
	 * @param value the storename
	 */
	public void setStorename(final SessionContext ctx, final String value)
	{
		setProperty(ctx, STORENAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.storename</code> attribute. 
	 * @param value the storename
	 */
	public void setStorename(final String value)
	{
		setStorename( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.thumbnail</code> attribute.
	 * @return the thumbnail
	 */
	public Object getThumbnail(final SessionContext ctx)
	{
		return getProperty( ctx, THUMBNAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>SellingProduct.thumbnail</code> attribute.
	 * @return the thumbnail
	 */
	public Object getThumbnail()
	{
		return getThumbnail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.thumbnail</code> attribute. 
	 * @param value the thumbnail
	 */
	public void setThumbnail(final SessionContext ctx, final Object value)
	{
		setProperty(ctx, THUMBNAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>SellingProduct.thumbnail</code> attribute. 
	 * @param value the thumbnail
	 */
	public void setThumbnail(final Object value)
	{
		setThumbnail( getSession().getSessionContext(), value );
	}
	
}
