/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Nov 30, 2016 10:06:21 AM                    ---
 * ----------------------------------------------------------------
 */
package com.ebookb2b.jalo;

import com.ebookb2b.constants.Ebookb2bcommerceservicesConstants;
import com.ebookb2b.jalo.ProductQuantityThresholdFreeGiftPromotion;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>Ebookb2bcommerceservicesManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedEbookb2bcommerceservicesManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
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
	
	public ProductQuantityThresholdFreeGiftPromotion createProductQuantityThresholdFreeGiftPromotion(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( Ebookb2bcommerceservicesConstants.TC.PRODUCTQUANTITYTHRESHOLDFREEGIFTPROMOTION );
			return (ProductQuantityThresholdFreeGiftPromotion)type.newInstance( ctx, attributeValues );
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
			throw new JaloSystemException( e ,"error creating ProductQuantityThresholdFreeGiftPromotion : "+e.getMessage(), 0 );
		}
	}
	
	public ProductQuantityThresholdFreeGiftPromotion createProductQuantityThresholdFreeGiftPromotion(final Map attributeValues)
	{
		return createProductQuantityThresholdFreeGiftPromotion( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return Ebookb2bcommerceservicesConstants.EXTENSIONNAME;
	}
	
}
