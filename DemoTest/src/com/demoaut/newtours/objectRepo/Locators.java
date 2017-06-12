package com.demoaut.newtours.objectRepo;

/*
 * Class used to store objects/locators of different Pages of UI 
 */
public class Locators 
{
	/*
	 * Home page locators
	 */
	
	public static String HOMEPAGE_REGISTER_LINK           = "//a[contains(@href,'mercuryregister')]";
	
	public static String HOMEPAGE_SIGNIN_USERNAME_TEXTBOX = "//input[@name='userName']";
	public static String HOMEPAGE_SIGNIN_PASSWORD_TEXTBOX = "//input[@name='password']";
	public static String HOMEPAGE_SIGNIN_BUTTON           = "//input[@name='login']";
	
	/*
	 * Register page locators
	 */
	
	public static String REGISTERPAGE_FIRSTNAME_TEXTBOX = "//input[@name='firstName']";
	public static String REGISTERPAGE_LASTNAME_TEXTBOX  = "//input[@name='lastName']";
	public static String REGISTERPAGE_PHONE_TEXTBOX     = "//input[@name='phone']";
	public static String REGISTERPAGE_EMAIL_TEXTBOX     = "//input[@name='userName']";
	
	public static String REGISTERPAGE_ADDRESS1_TEXTBOX   = "//input[@name='address1']";
	public static String REGISTERPAGE_ADDRESS2_TEXTBOX   = "//input[@name='address2']";
	public static String REGISTERPAGE_CITY_TEXTBOX       = "//input[@name='city']";
	public static String REGISTERPAGE_STATE_TEXTBOX      = "//input[@name='state']";
	public static String REGISTERPAGE_POSTALCODE_TEXTBOX = "//input[@name='postalCode']";
	public static String REGISTERPAGE_COUNTRY_DROPDOWN   = "//select[@name='country']";
	
	public static String REGISTERPAGE_USERNAME_TEXTBOX         = "//input[@name='email']";
	public static String REGISTERPAGE_PASSWORD_TEXTBOX         = "//input[@name='password']";
	public static String REGISTERPAGE_CONFIRMPASSWORD_TEXTBOX  = "//input[@name='confirmPassword']";

	public static String REGISTERPAGE_SUBMIT_BUTTON     = "//input[@name='register']";
	
	/*
	 * Flight Finder page locators
	 */
	
	public static String FLIGHTFINDERPAGE_FLIGHT_DETAILS = "//b//font[contains(text(),'Flight ')]";
}
