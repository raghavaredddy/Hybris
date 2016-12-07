/**
 *
 */

package com.ebookb2b.facades.customer.impl;

import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commercefacades.user.exceptions.PasswordMismatchException;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.core.model.user.UserModel;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;


/**
 * @author raghared
 *
 */

public class EbookDefaultCustomerFacade extends DefaultCustomerFacade
{

	@Override
	public void register(final RegisterData registerData) throws DuplicateUidException
	{
		//validateParameterNotNullStandardMessage("registerData", registerData);
		//validateParameterNotNullStandardMessage("registerData", registerData);
		Assert.hasText(registerData.getFirstName(), "The field [FirstName] cannot be empty");
		Assert.hasText(registerData.getLastName(), "The field [LastName] cannot be empty");
		Assert.hasText(registerData.getLogin(), "The field [Login] cannot be empty");

		final CustomerModel newCustomer = getModelService().create(CustomerModel.class);
		newCustomer.setName(getCustomerNameStrategy().getName(registerData.getFirstName(), registerData.getLastName()));

		if (StringUtils.isNotBlank(registerData.getFirstName()) && StringUtils.isNotBlank(registerData.getLastName()))
		{
			newCustomer.setName(getCustomerNameStrategy().getName(registerData.getFirstName(), registerData.getLastName()));
		}
		final TitleModel title = getUserService().getTitleForCode(registerData.getTitleCode());
		newCustomer.setTitle(title);
		setUidForRegister(registerData, newCustomer);
		newCustomer.setSessionLanguage(getCommonI18NService().getCurrentLanguage());
		newCustomer.setSessionCurrency(getCommonI18NService().getCurrentCurrency());
		newCustomer.setContactNumber(registerData.getContactNumber());
		newCustomer.setCurrentLocation(registerData.getCurrentLocation());
		getCustomerAccountService().register(newCustomer, registerData.getPassword());
	}//regiseter method



	@Override
	public void updateProfile(final CustomerData customerData) throws DuplicateUidException
	{
		validateDataBeforeUpdate(customerData);

		//	final String name = getCustomerNameStrategy().getName(customerData.getFirstName(), customerData.getLastName());
		final CustomerModel customer = getCurrentSessionCustomer();
		customer.setOriginalUid(customerData.getDisplayUid());
		customer.setCurrentLocation(customerData.getCurrentLocation());
		customer.setContactNumber(customerData.getContactNumber());
		getModelService().save(customer);

		//getCustomerAccountService().updateProfile(customer, customerData.getTitleCode(), name, customerData.getUid());
	}//update profile ()

	/**
	 * @param string
	 * @param registerData
	 */


	public void changeContactNo(final String newcontactno, final String currentPassword)
	{
		Assert.hasText(newcontactno, "The field [newContactNo] cannot be empty");
		Assert.hasText(currentPassword, "The field [currentPassword] cannot be empty");

		/* final String newcontactnoLower = newcontactno.toLowerCase(); */

		final CustomerModel currentUser = (CustomerModel) getUserService().getCurrentUser();
		currentUser.setContactNumber(newcontactno);
		final boolean status = checkPassword(currentUser, currentPassword);
		if (status == true)
		{

			currentUser.setContactNumber(newcontactno);

			getModelService().save(currentUser);
		}
		else
		{
			throw new PasswordMismatchException(currentUser.getUid());
		}

	}

	protected boolean checkPassword(final UserModel currentUser, final String currentPassword) throws PasswordMismatchException
	{

		// Validate that the current password is correct
		final String encodedCurrentPassword = getPasswordEncoderService().encode(currentUser, currentPassword,
				currentUser.getPasswordEncoding());
		if (!encodedCurrentPassword.equals(currentUser.getEncodedPassword()))
		{
			throw new PasswordMismatchException(currentUser.getUid());
		}

		return true;

	}
}
