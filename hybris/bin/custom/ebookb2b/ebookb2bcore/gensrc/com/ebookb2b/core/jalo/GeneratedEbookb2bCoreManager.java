/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Nov 30, 2016 10:06:21 AM                    ---
 * ----------------------------------------------------------------
 */
package com.ebookb2b.core.jalo;

import com.ebookb2b.core.constants.Ebookb2bCoreConstants;
import com.ebookb2b.core.jalo.ApparelProduct;
import com.ebookb2b.core.jalo.ApparelSizeVariantProduct;
import com.ebookb2b.core.jalo.ApparelStyleVariantProduct;
import com.ebookb2b.core.jalo.EbookSizeVariantProduct;
import com.ebookb2b.core.jalo.ElectronicsColorVariantProduct;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>Ebookb2bCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEbookb2bCoreManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("ComingSoon", AttributeMode.INITIAL);
		tmp.put("bookRating", AttributeMode.INITIAL);
		tmp.put("bookCustomerSatisfaction", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("contactNumber", AttributeMode.INITIAL);
		tmp.put("currentLocation", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.bookCustomerSatisfaction</code> attribute.
	 * @return the bookCustomerSatisfaction - Customer Satisfaction of  the book.
	 */
	public String getBookCustomerSatisfaction(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, Ebookb2bCoreConstants.Attributes.Product.BOOKCUSTOMERSATISFACTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.bookCustomerSatisfaction</code> attribute.
	 * @return the bookCustomerSatisfaction - Customer Satisfaction of  the book.
	 */
	public String getBookCustomerSatisfaction(final Product item)
	{
		return getBookCustomerSatisfaction( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.bookCustomerSatisfaction</code> attribute. 
	 * @param value the bookCustomerSatisfaction - Customer Satisfaction of  the book.
	 */
	public void setBookCustomerSatisfaction(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, Ebookb2bCoreConstants.Attributes.Product.BOOKCUSTOMERSATISFACTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.bookCustomerSatisfaction</code> attribute. 
	 * @param value the bookCustomerSatisfaction - Customer Satisfaction of  the book.
	 */
	public void setBookCustomerSatisfaction(final Product item, final String value)
	{
		setBookCustomerSatisfaction( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.bookRating</code> attribute.
	 * @return the bookRating - Customer Rating of  the book.
	 */
	public String getBookRating(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, Ebookb2bCoreConstants.Attributes.Product.BOOKRATING);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.bookRating</code> attribute.
	 * @return the bookRating - Customer Rating of  the book.
	 */
	public String getBookRating(final Product item)
	{
		return getBookRating( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.bookRating</code> attribute. 
	 * @param value the bookRating - Customer Rating of  the book.
	 */
	public void setBookRating(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, Ebookb2bCoreConstants.Attributes.Product.BOOKRATING,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.bookRating</code> attribute. 
	 * @param value the bookRating - Customer Rating of  the book.
	 */
	public void setBookRating(final Product item, final String value)
	{
		setBookRating( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ComingSoon</code> attribute.
	 * @return the ComingSoon - Coming Soon Products
	 */
	public Boolean isComingSoon(final SessionContext ctx, final Product item)
	{
		return (Boolean)item.getProperty( ctx, Ebookb2bCoreConstants.Attributes.Product.COMINGSOON);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ComingSoon</code> attribute.
	 * @return the ComingSoon - Coming Soon Products
	 */
	public Boolean isComingSoon(final Product item)
	{
		return isComingSoon( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ComingSoon</code> attribute. 
	 * @return the ComingSoon - Coming Soon Products
	 */
	public boolean isComingSoonAsPrimitive(final SessionContext ctx, final Product item)
	{
		Boolean value = isComingSoon( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.ComingSoon</code> attribute. 
	 * @return the ComingSoon - Coming Soon Products
	 */
	public boolean isComingSoonAsPrimitive(final Product item)
	{
		return isComingSoonAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ComingSoon</code> attribute. 
	 * @param value the ComingSoon - Coming Soon Products
	 */
	public void setComingSoon(final SessionContext ctx, final Product item, final Boolean value)
	{
		item.setProperty(ctx, Ebookb2bCoreConstants.Attributes.Product.COMINGSOON,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ComingSoon</code> attribute. 
	 * @param value the ComingSoon - Coming Soon Products
	 */
	public void setComingSoon(final Product item, final Boolean value)
	{
		setComingSoon( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ComingSoon</code> attribute. 
	 * @param value the ComingSoon - Coming Soon Products
	 */
	public void setComingSoon(final SessionContext ctx, final Product item, final boolean value)
	{
		setComingSoon( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.ComingSoon</code> attribute. 
	 * @param value the ComingSoon - Coming Soon Products
	 */
	public void setComingSoon(final Product item, final boolean value)
	{
		setComingSoon( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.contactNumber</code> attribute.
	 * @return the contactNumber
	 */
	public String getContactNumber(final SessionContext ctx, final Customer item)
	{
		return (String)item.getProperty( ctx, Ebookb2bCoreConstants.Attributes.Customer.CONTACTNUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.contactNumber</code> attribute.
	 * @return the contactNumber
	 */
	public String getContactNumber(final Customer item)
	{
		return getContactNumber( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.contactNumber</code> attribute. 
	 * @param value the contactNumber
	 */
	public void setContactNumber(final SessionContext ctx, final Customer item, final String value)
	{
		item.setProperty(ctx, Ebookb2bCoreConstants.Attributes.Customer.CONTACTNUMBER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.contactNumber</code> attribute. 
	 * @param value the contactNumber
	 */
	public void setContactNumber(final Customer item, final String value)
	{
		setContactNumber( getSession().getSessionContext(), item, value );
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Ebookb2bCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Ebookb2bCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Ebookb2bCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public EbookSizeVariantProduct createEbookSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Ebookb2bCoreConstants.TC.EBOOKSIZEVARIANTPRODUCT );
			return (EbookSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating EbookSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public EbookSizeVariantProduct createEbookSizeVariantProduct(final Map attributeValues)
	{
		return createEbookSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Ebookb2bCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.currentLocation</code> attribute.
	 * @return the currentLocation
	 */
	public String getCurrentLocation(final SessionContext ctx, final Customer item)
	{
		return (String)item.getProperty( ctx, Ebookb2bCoreConstants.Attributes.Customer.CURRENTLOCATION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.currentLocation</code> attribute.
	 * @return the currentLocation
	 */
	public String getCurrentLocation(final Customer item)
	{
		return getCurrentLocation( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.currentLocation</code> attribute. 
	 * @param value the currentLocation
	 */
	public void setCurrentLocation(final SessionContext ctx, final Customer item, final String value)
	{
		item.setProperty(ctx, Ebookb2bCoreConstants.Attributes.Customer.CURRENTLOCATION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.currentLocation</code> attribute. 
	 * @param value the currentLocation
	 */
	public void setCurrentLocation(final Customer item, final String value)
	{
		setCurrentLocation( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return Ebookb2bCoreConstants.EXTENSIONNAME;
	}
	
}
