/**
 *
 */
package com.ebookb2b.facades.comingsoon;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import javax.annotation.Resource;

import com.ebookb2b.core.comingsoon.service.ComingSoonService;


/**
 * @author raghared
 *
 */
public class ComingSoonfacades
{
	@Resource(name = "comingSoonService")
	private ComingSoonService comingSoonService;

	public List<ProductModel> productreturnedlist()
	{
		final List<ProductModel> facadesList = comingSoonService.productreturnedlist();
		return facadesList;
	}


}
