package com.ebookb2b.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebookb2b.core.comingsoon.service.ComingSoonService;
import com.ebookb2b.facades.comingsoon.ComingSoonfacades;



@Controller
@Scope("tenant")
@RequestMapping("/coming-soon/products")
public class ComingSoonController extends ProductPageController
{

	protected static final String COMINGSOON_CMS_PAGE = "comingSoon";
	public final boolean COMINGSOON = true;
	@Resource
	private ComingSoonService comingSoonService;


	@Resource(name = "accountBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder accountBreadcrumbBuilder;

	@Resource(name = "comingSoonfacades")
	private ComingSoonfacades comingSoonfacades;

	@RequestMapping(method = RequestMethod.GET)
	public String productComingSoonHome(final Model model) throws CMSItemNotFoundException
	{
		final List<ProductModel> productListData = comingSoonService.productreturnedlist();
		//final List<ProductModel> listProducts = comingSoonfacades.productreturnedlist();
		storeCmsPageInModel(model, getContentPageForLabelOrId(COMINGSOON_CMS_PAGE));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(COMINGSOON_CMS_PAGE));
		model.addAttribute("breadcrumbs", accountBreadcrumbBuilder.getBreadcrumbs("text.comingsoon.products"));
		model.addAttribute("metaRobots", "no-index,no-follow");
		//model.addAttribute("produtList", listProducts);
		model.addAttribute("produtList", productListData);
		return getViewForPage(model);
	}



}