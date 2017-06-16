package com.automation.pom.demo.pages;

import com.automation.pom.demo.objectRepository.Locators;
import com.automation.pom.demo.utilities.SeleniumWrapper;

/*
 * HuffingtonPage class contains methods which perform action on page UI. 
 */
public class HuffingtonPostHomePage 
{
	private static SeleniumWrapper seleniumClient;
	
	public HuffingtonPostHomePage()
	{
		seleniumClient = new SeleniumWrapper();
	}
	
	public void goTo()
	{
		seleniumClient.openUrl("http://www.huffingtonpost.in/");
	}
	
	public boolean verifyLocation()
	{
		return seleniumClient.isDisplayed(Locators.HUFFINGTONPOST_HOMEPAGE_TITLEBAR);
	}

}
