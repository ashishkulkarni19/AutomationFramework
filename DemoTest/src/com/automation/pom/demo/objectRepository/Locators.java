package com.automation.pom.demo.objectRepository;

/*
 * Class used to store objects/locators of different Pages of UI 
 */
public class Locators 
{
	/*
	 * Home page locators
	 */
	public static String HUFFINGTONPOST_HOMEPAGE_TITLEBAR 				= "//img[@alt= 'The Huffington Post']";	
	public static String HUFFINGTONPOST_HOMEPAGE_LIFESTYLETAB			= "//div[contains(@class,'lifestyle')]";
	public static String HUFFINGTONPOST_HOMEPAGE_LIFESTYLE_TECHOPTION	= "//div[contains(text(),'Tech')]/parent::a";
	public static String HUFFINGTONPOST_TECHPAGE_ALL_ARTICLES			= "//article[contains(@id,'entry')]";
	public static String HUFFINGTONPOST_TECHPAGE_ALL_ARTICLEAUTHORS		= "//article[@id='#']/div/div[contains(@class,'apage__author')]";
	public static String HUFFINGTONPOST_TECHPAGE_ARTICLES_HEADLINE		= "//article[contains(@id,'#')]//h2[contains(@class,'headline')]/a";
}
