package com.demoaut.newtours.pages;

import com.demoaut.newtours.objectRepo.Locators;
import com.demoaut.newtours.utilities.SeleniumWrapper;

/*
 * HomePage class contains methods which perform action on home page UI. 
 */
public class HomePage 
{
	private static SeleniumWrapper objSele;
	
	public HomePage()
	{
		objSele = new SeleniumWrapper();
	}
	
	public void clickOnRegisterLink()
	{
		objSele.click(Locators.HOMEPAGE_REGISTER_LINK);
	}
	
	public void open(String url)
	{
		objSele.openUrl(url);
	}
	
	/*
	 * Perform sign-In action with given userName and password.
	 */
	public void signIn(String userName, String password)
	{
		objSele.inputText(Locators.HOMEPAGE_SIGNIN_USERNAME_TEXTBOX, userName);
		objSele.inputText(Locators.HOMEPAGE_SIGNIN_PASSWORD_TEXTBOX, password);
		objSele.click(Locators.HOMEPAGE_SIGNIN_BUTTON);
	}
}
