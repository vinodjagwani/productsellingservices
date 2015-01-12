/**
 * 
 */
package de.hybris.platform.productsellingservices.dao.impl;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.catalog.model.KeywordModel;
import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.europe1.model.PriceRowModel;
import de.hybris.platform.product.UnitService;
import de.hybris.platform.productsellingservices.dao.SellingProductDao;
import de.hybris.platform.productsellingservices.data.SellingProductData;
import de.hybris.platform.productsellingservices.model.SellingProductModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.media.MediaService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.UserService;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;


/**
 * @author VJA
 * 
 */
@Component(value = "sellingProductDAO")
public class DefaultSellingProductDao implements SellingProductDao
{

	private static final Logger LOG = Logger.getLogger(DefaultSellingProductDao.class.getName());

	@Autowired
	private ModelService modelService;

	@Autowired
	private CatalogVersionService catalogVersionService;

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommonI18NService commonI18NService;

	@Autowired
	private UnitService unitService;

	@Autowired
	private UserService userService;

	@Autowired
	private MediaService mediaService;


	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.productsellingservices.dao.SellingProductDao#sendProduct(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.sql.Blob)
	 */
	@Override
	public void sendProduct(final String code, final String name, final String description, final String address,
			final String dateandtime, final Double priceOfProduct, final String picture, final String storename)
	{
		try
		{
			final SellingProductModel sellingProductModel = new SellingProductModel();
			sellingProductModel.setCode(code);
			sellingProductModel.setName(name);
			sellingProductModel.setDescription(description);
			sellingProductModel.setAddress(address);
			sellingProductModel.setProductAvailablity(dateandtime);
			sellingProductModel.setPriceOfProduct(priceOfProduct);
			sellingProductModel.setCreationtime(new Date());
			sellingProductModel.setThumbnail(picture);
			sellingProductModel.setStorename(storename);
			modelService.save(sellingProductModel);

		}
		catch (final Exception e)
		{
			LOG.error("DefaultSellingProductDao: ", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hybris.platform.productsellingservices.dao.SellingProductDao#recieveProduct(de.hybris.platform.commercefacades
	 * .product.data.ProductData)
	 */
	@Override
	public void recieveProduct(final SellingProductData sellingProductData)
	{
		try
		{
			final ProductModel productModel = new ProductModel();
			productModel.setCode(sellingProductData.getCode());
			productModel.setName(sellingProductData.getName(), Locale.ENGLISH);

			//Settings for catalogversion
			final CatalogVersionModel catalogVersionModel = catalogVersionService.getCatalogVersion("apparelProductCatalog",
					"Staged");
			catalogVersionService.addSessionCatalogVersion(catalogVersionModel);
			productModel.setCatalogVersion(catalogVersionModel);

			productModel.setDescription(sellingProductData.getDescription(), Locale.ENGLISH);
			productModel.setCreationtime(new Date());
			productModel.setManufacturerName(sellingProductData.getAddress());

			//Setting for category
			final CategoryModel categoryModel = categoryService.getCategoryForCode(catalogVersionModel, "18000");
			final Collection<CategoryModel> categoryCollection = new ArrayList<CategoryModel>();
			categoryCollection.add(categoryModel);
			productModel.setSupercategories(categoryCollection);

			//Settings for Price
			final PriceRowModel priceRowModel = new PriceRowModel();
			priceRowModel.setCatalogVersion(catalogVersionModel);
			priceRowModel.setCurrency(commonI18NService.getCurrency("EUR"));
			priceRowModel.setUnit(unitService.getUnitForCode("pieces"));
			priceRowModel.setPrice(sellingProductData.getPriceOfProduct());
			priceRowModel.setProduct(productModel);
			priceRowModel.setMinqtd(Long.valueOf(1));

			final Collection<PriceRowModel> collPriceRowModel = new ArrayList<PriceRowModel>();
			collPriceRowModel.add(priceRowModel);

			productModel.setEurope1Prices(collPriceRowModel);
			productModel.setApprovalStatus(de.hybris.platform.catalog.enums.ArticleApprovalStatus.APPROVED);

			//Setting for keywords against product
			final KeywordModel keywordModel = new KeywordModel();
			keywordModel.setKeyword(sellingProductData.getAddress());
			keywordModel.setCatalogVersion(catalogVersionModel);
			keywordModel.setLanguage(commonI18NService.getCurrentLanguage());
			keywordModel.setProducts(Collections.singletonList(productModel), Locale.ENGLISH);
			keywordModel.setCategories(categoryCollection, Locale.ENGLISH);
			productModel.setKeywords(Collections.singletonList(keywordModel), Locale.ENGLISH);

			//Media data for thumbnail
			final MediaModel mediaModelThumb = new MediaModel();
			mediaModelThumb.setCode("/96Wx96H/" + sellingProductData.getCode() + ".jpg");
			mediaModelThumb.setCatalogVersion(catalogVersionModel);
			mediaModelThumb.setFolder(mediaService.getFolder("images"));
			mediaModelThumb.setMime("image/jpeg");
			mediaModelThumb.setRealFileName(sellingProductData.getCode() + ".jpg");
			mediaModelThumb.setMediaFormat(mediaService.getFormat("96Wx96H"));

			//Media data for picture
			final MediaModel mediaModelPicture = new MediaModel();
			mediaModelPicture.setCode("/300Wx300H/" + sellingProductData.getCode() + ".jpg");
			mediaModelPicture.setCatalogVersion(catalogVersionModel);
			mediaModelPicture.setFolder(mediaService.getFolder("images"));
			mediaModelPicture.setMime("image/jpeg");
			mediaModelPicture.setRealFileName(sellingProductData.getCode() + ".jpg");
			mediaModelPicture.setMediaFormat(mediaService.getFormat("300Wx300H"));


			//Media data for container
			final MediaModel mediaModelForContainer = new MediaModel();
			mediaModelForContainer.setCode("/515Wx515H/" + sellingProductData.getCode() + ".jpg");
			mediaModelForContainer.setCatalogVersion(catalogVersionModel);
			mediaModelForContainer.setFolder(mediaService.getFolder("images"));
			mediaModelForContainer.setMime("image/jpeg");
			mediaModelForContainer.setRealFileName(sellingProductData.getCode() + ".jpg");
			mediaModelForContainer.setMediaFormat(mediaService.getFormat("515Wx515H"));


			productModel.setThumbnail(mediaModelThumb);
			productModel.setPicture(mediaModelPicture);


			//MediaContainer
			final MediaContainerModel mediaContainerModel = new MediaContainerModel();
			mediaContainerModel.setQualifier(sellingProductData.getCode());
			mediaContainerModel.setCatalogVersion(catalogVersionModel);
			mediaContainerModel.setName(sellingProductData.getCode(), Locale.ENGLISH);


			final List<MediaModel> mediaModelList = new ArrayList<MediaModel>();
			mediaModelList.add(mediaModelThumb);
			mediaModelList.add(mediaModelPicture);
			mediaModelList.add(mediaModelForContainer);
			mediaContainerModel.setMedias(mediaModelList);

			mediaModelThumb.setMediaContainer(mediaContainerModel);
			mediaModelPicture.setMediaContainer(mediaContainerModel);

			productModel.setGalleryImages(Collections.singletonList(mediaContainerModel));

			modelService.save(productModel);

			//Read imagedata
			final byte[] imagebytes = sellingProductData.getPicture().getBytes();
			final ByteArrayInputStream imageByte96WStream = new ByteArrayInputStream(Base64.decode(imagebytes));
			final ByteArrayInputStream imageByte300WStream = new ByteArrayInputStream(Base64.decode(imagebytes));
			final ByteArrayInputStream imageByte515WStream = new ByteArrayInputStream(Base64.decode(imagebytes));

			final DataInputStream imageData96WStream = new DataInputStream(imageByte96WStream);
			final DataInputStream imageData300WStream = new DataInputStream(imageByte300WStream);

			final DataInputStream imageData515WSStream = new DataInputStream(imageByte515WStream);


			mediaService.setStreamForMedia(mediaModelThumb, imageData96WStream);
			mediaService.setStreamForMedia(mediaModelPicture, imageData300WStream);
			mediaService.setStreamForMedia(mediaModelForContainer, imageData515WSStream);


			// Settings for sending email
			final HtmlEmail email = new HtmlEmail();
			email.setHostName("smtp.live.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("vinod_jagwani@hotmail.com", "testets"));
			email.setTLS(true);
			email.setFrom("vinod_jagwani@hotmail.com");
			email.setSubject("Selling Product information: " + productModel.getCode());
			email.setMsg(productModel.toString());
			email.addTo("vinod_jagwani@hotmail.com");
			email.send();
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.productsellingservices.dao.SellingProductDao#findAllProducts()
	 */
	@Override
	public List<SellingProductModel> findAllProducts()
	{
		final StringBuilder builder = new StringBuilder();
		builder.append("SELECT {p:").append(SellingProductModel.PK).append("} ");
		builder.append("FROM {").append(SellingProductModel._TYPECODE).append(" AS p}");
		final FlexibleSearchQuery query = new FlexibleSearchQuery(builder.toString());
		query.setNeedTotal(true);
		return flexibleSearchService.<SellingProductModel> search(query).getResult();
	}

}
