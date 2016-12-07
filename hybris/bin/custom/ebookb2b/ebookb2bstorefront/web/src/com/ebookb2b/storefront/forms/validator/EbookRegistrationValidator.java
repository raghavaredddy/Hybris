/**
 *
 */
package com.ebookb2b.storefront.forms.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ebookb2b.storefront.forms.EbookRegistrationForm;


/**
 * @author raghared
 *
 */
public class EbookRegistrationValidator implements Validator
{

	private Pattern pattern;
	private Matcher matcher;

	@NotNull
	//@DateTimeFormat(pattern = "dd/MM/YY")
	private String location;
	public static final Pattern EMAIL_REGEX = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
	public String MOBILE_PATTERN = "[0-9]{10}";


	public boolean supports(final Class<?> aClass)
	{
		return EbookRegistrationForm.class.equals(aClass);
	}


	public void validate(final Object object, final Errors errors)
	{
		final EbookRegistrationForm registerForm = (EbookRegistrationForm) object;
		final String titleCode = registerForm.getTitleCode();
		final String firstName = registerForm.getFirstName();
		final String lastName = registerForm.getLastName();
		final String email = registerForm.getEmail();
		final String pwd = registerForm.getPwd();
		final String checkPwd = registerForm.getCheckPwd();
		final String contactNumber = registerForm.getContactNumber();
		final String location = registerForm.getCurrentLocation();


		if (StringUtils.isEmpty(titleCode))
		{
			errors.rejectValue("titleCode", "register.title.invalid");
		}
		else if (StringUtils.length(titleCode) > 255)
		{
			errors.rejectValue("titleCode", "register.title.invalid");
		}

		if (StringUtils.isBlank(firstName))
		{
			errors.rejectValue("firstName", "register.firstName.invalid");
		}
		else if (StringUtils.length(firstName) > 255)
		{
			errors.rejectValue("firstName", "register.firstName.invalid");
		}

		if (StringUtils.isBlank(lastName))
		{
			errors.rejectValue("lastName", "register.lastName.invalid");
		}
		else if (StringUtils.length(lastName) > 255)
		{
			errors.rejectValue("lastName", "register.lastName.invalid");
		}

		if (StringUtils.length(firstName) + StringUtils.length(lastName) > 255)
		{
			errors.rejectValue("lastName", "register.name.invalid");
			errors.rejectValue("firstName", "register.name.invalid");
		}

		if (StringUtils.isEmpty(email))
		{
			errors.rejectValue("email", "register.email.invalid");
		}
		else if (StringUtils.length(email) > 255 || !validateEmailAddress(email))
		{
			errors.rejectValue("email", "register.email.invalid");
		}

		if (StringUtils.isEmpty(pwd))
		{
			errors.rejectValue("pwd", "register.pwd.invalid");
		}
		else if (StringUtils.length(pwd) < 6 || StringUtils.length(pwd) > 255)
		{
			errors.rejectValue("pwd", "register.pwd.invalid");
		}

		if (StringUtils.isNotEmpty(pwd) && StringUtils.isNotEmpty(checkPwd) && !StringUtils.equals(pwd, checkPwd))
		{
			errors.rejectValue("checkPwd", "validation.checkPwd.equals");
		}
		else
		{
			if (StringUtils.isEmpty(checkPwd))
			{
				errors.rejectValue("checkPwd", "register.checkPwd.invalid");
			}
		}


		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "required.contactNumber", "contactNumber is required.");
		// phone number validation
		if (!(contactNumber != null && contactNumber.isEmpty()))
		{
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(contactNumber);
			if (!matcher.matches())
			{
				errors.rejectValue("contactNumber", "contactNumber.incorrect", "Enter a correct contact number");
			}
		}
		if (StringUtils.isBlank(location))
		{
			errors.rejectValue("location", "register.location.invalid");
		}
		else if (StringUtils.length(location) > 255)
		{
			errors.rejectValue("location", "register.location.invalid");
		}

		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "required.dateOfBirth", "dateOfBirth is required.");
		/*
		 * else if (StringUtils.isNumeric("0")) { errors.rejectValue("contactNumber", "register.contactNumber.invalid"); }
		 */
		/*
		 * else if (StringUtils.length(contactNumber) < 10 || StringUtils.length(contactNumber) < 10) {
		 * errors.rejectValue("contactNumber", "register.contactNumber.invalid"); }
		 */
	}


	/**
	 * @param email
	 * @return
	 */
	public boolean validateEmailAddress(final String email)
	{
		final Matcher matcher = EMAIL_REGEX.matcher(email);
		return matcher.matches();
	}


}
