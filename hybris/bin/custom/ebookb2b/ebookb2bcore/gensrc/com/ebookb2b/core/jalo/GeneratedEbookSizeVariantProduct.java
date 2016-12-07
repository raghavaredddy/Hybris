/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Nov 30, 2016 10:06:21 AM                    ---
 * ----------------------------------------------------------------
 */
package com.ebookb2b.core.jalo;

import com.ebookb2b.core.constants.Ebookb2bCoreConstants;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.variants.jalo.VariantProduct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link com.ebookb2b.core.jalo.EbookSizeVariantProduct EbookSizeVariantProduct}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEbookSizeVariantProduct extends VariantProduct
{
	/** Qualifier of the <code>EbookSizeVariantProduct.bookSize</code> attribute **/
	public static final String BOOKSIZE = "bookSize";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(VariantProduct.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(BOOKSIZE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EbookSizeVariantProduct.bookSize</code> attribute.
	 * @return the bookSize - No of sizes the book.
	 */
	public String getBookSize(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedEbookSizeVariantProduct.getBookSize requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, BOOKSIZE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EbookSizeVariantProduct.bookSize</code> attribute.
	 * @return the bookSize - No of sizes the book.
	 */
	public String getBookSize()
	{
		return getBookSize( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EbookSizeVariantProduct.bookSize</code> attribute. 
	 * @return the localized bookSize - No of sizes the book.
	 */
	public Map<Language,String> getAllBookSize(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,BOOKSIZE,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>EbookSizeVariantProduct.bookSize</code> attribute. 
	 * @return the localized bookSize - No of sizes the book.
	 */
	public Map<Language,String> getAllBookSize()
	{
		return getAllBookSize( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EbookSizeVariantProduct.bookSize</code> attribute. 
	 * @param value the bookSize - No of sizes the book.
	 */
	public void setBookSize(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedEbookSizeVariantProduct.setBookSize requires a session language", 0 );
		}
		setLocalizedProperty(ctx, BOOKSIZE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EbookSizeVariantProduct.bookSize</code> attribute. 
	 * @param value the bookSize - No of sizes the book.
	 */
	public void setBookSize(final String value)
	{
		setBookSize( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EbookSizeVariantProduct.bookSize</code> attribute. 
	 * @param value the bookSize - No of sizes the book.
	 */
	public void setAllBookSize(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,BOOKSIZE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>EbookSizeVariantProduct.bookSize</code> attribute. 
	 * @param value the bookSize - No of sizes the book.
	 */
	public void setAllBookSize(final Map<Language,String> value)
	{
		setAllBookSize( getSession().getSessionContext(), value );
	}
	
}
