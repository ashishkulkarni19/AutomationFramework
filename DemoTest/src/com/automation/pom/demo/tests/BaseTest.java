package com.automation.pom.demo.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.pom.demo.utilities.SeleniumWrapper;

/*
 * BaseTest class which is extend by every Test-Script class.
 */
public abstract class BaseTest 
{
	public SeleniumWrapper objSele = new SeleniumWrapper();
	
	public abstract void setData();
	
	@BeforeSuite
	@Parameters({"browserName"})
	public void init(@Optional("chrome")String browserName)
	{
		objSele.setWebDriver(browserName);
	}
	
	@AfterSuite
	public void clean()
	{
		objSele.clean();
	}

}
