package com.demoaut.newtours.pages;

import com.demoaut.newtours.objectRepo.Locators;
import com.demoaut.newtours.utilities.SeleniumWrapper;
import com.google.gson.JsonObject;

/*
 * RegisterPage class contains methods which perform action on register page UI. 
 */
public class RegisterPage 
{
	private static SeleniumWrapper objSele;
	
	public RegisterPage()
	{
		objSele = new SeleniumWrapper();
	}
	
	public void clickOnSubmit()
	{
		objSele.click(Locators.REGISTERPAGE_SUBMIT_BUTTON);
	}
	
	
	/*
	 * This method used to fill all given values on jsonObject in registration form
	 * 
	 * jsonObject example
	 * 
	 * {
	 *		"firstName" : "Opesydra",
	 *		"lastName" : "Uhet",
	 *		"phone" : 1234567890,
     * 		"email" : "Esasgwat@tco.com",
     *		"address" : "India 1245",
     *		"city" : "XYN",
     * 		"state" : "ABC",
     *		"postalCode" : 123456,
     *		"country" : "INDIA",
     *		"userName" : "optest",
     *		"password" : "P@$$W00rd",
     *		"confirmPassword" : "P@$$W00rd"
	 * }
	 * 
	 */
	public void fillRegistrationForm(JsonObject fillFormData)
	{
		if(fillFormData.has("firstName"))
		{
			objSele.inputText(Locators.REGISTERPAGE_FIRSTNAME_TEXTBOX, fillFormData.get("firstName").getAsString());
		}
		
		if(fillFormData.has("lastName"))
		{
			objSele.inputText(Locators.REGISTERPAGE_LASTNAME_TEXTBOX, fillFormData.get("lastName").getAsString());
		}
		
		if(fillFormData.has("phone"))
		{
			objSele.inputText(Locators.REGISTERPAGE_PHONE_TEXTBOX, fillFormData.get("phone").getAsString());
		}
		
		if(fillFormData.has("email"))
		{
			objSele.inputText(Locators.REGISTERPAGE_EMAIL_TEXTBOX, fillFormData.get("email").getAsString());
		}
		
		if(fillFormData.has("address"))
		{
			objSele.inputText(Locators.REGISTERPAGE_ADDRESS1_TEXTBOX, fillFormData.get("address").getAsString());
		}
		
		if(fillFormData.has("city"))
		{
			objSele.inputText(Locators.REGISTERPAGE_CITY_TEXTBOX, fillFormData.get("city").getAsString());
		}
		
		if(fillFormData.has("state"))
		{
			objSele.inputText(Locators.REGISTERPAGE_STATE_TEXTBOX, fillFormData.get("state").getAsString());
		}
		
		if(fillFormData.has("postalCode"))
		{
			objSele.inputText(Locators.REGISTERPAGE_POSTALCODE_TEXTBOX, fillFormData.get("postalCode").getAsString());
		}
		
		if(fillFormData.has("country"))
		{
			objSele.selectByVisibleTextFromDropDown(Locators.REGISTERPAGE_COUNTRY_DROPDOWN, fillFormData.get("country").getAsString());
		}
		
		if(fillFormData.has("userName"))
		{
			objSele.inputText(Locators.REGISTERPAGE_USERNAME_TEXTBOX, fillFormData.get("userName").getAsString());
		}
		
		if(fillFormData.has("password"))
		{
			objSele.inputText(Locators.REGISTERPAGE_PASSWORD_TEXTBOX, fillFormData.get("password").getAsString());
		}
		
		if(fillFormData.has("confirmPassword"))
		{
			objSele.inputText(Locators.REGISTERPAGE_CONFIRMPASSWORD_TEXTBOX, fillFormData.get("confirmPassword").getAsString());
		}
	}
	
}
