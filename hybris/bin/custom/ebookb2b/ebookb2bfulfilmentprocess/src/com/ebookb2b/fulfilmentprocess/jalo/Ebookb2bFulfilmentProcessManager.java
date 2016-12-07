/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *  
 */
package com.ebookb2b.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.ebookb2b.fulfilmentprocess.constants.Ebookb2bFulfilmentProcessConstants;

@SuppressWarnings("PMD")
public class Ebookb2bFulfilmentProcessManager extends GeneratedEbookb2bFulfilmentProcessManager
{
	public static final Ebookb2bFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (Ebookb2bFulfilmentProcessManager) em.getExtension(Ebookb2bFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
