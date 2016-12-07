/**
 *
 */
package com.ebookb2b.facades.populators;

import de.hybris.platform.commercefacades.user.converters.populator.CustomerPopulator;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.core.model.user.CustomerModel;




/**
 * @author raghared
 *
 */
public class EbookCustomerAttributesPopulator extends CustomerPopulator
{

	@Override
	public void populate(final CustomerModel source, final CustomerData target)
	{
		super.populate(source, target);
		target.setContactNumber(source.getContactNumber());
		target.setCurrentLocation(source.getCurrentLocation());


	}

}
