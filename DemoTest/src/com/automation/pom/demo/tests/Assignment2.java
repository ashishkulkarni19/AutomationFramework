package com.automation.pom.demo.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.automation.pom.demo.utilities.TestDataReader;
import com.google.gson.JsonObject;

/*
 * Goto HuffingtonPost page LifeStyle>Tech 
 * Get all the articles and their authors
 */
public class Assignment2 extends BaseTest 
{
	private Assignment2_TestSteps steps;
	private JsonObject testData;
	
	@Override
	@BeforeTest
	public void setData() 
	{
		testData = TestDataReader.loadTestData(Assignment2.class.getName().replace("com.automation.pom.demo.tests.",""));	
		steps = new Assignment2_TestSteps(testData);
	}
	
	
	@Test
	@Parameters()
	public void test()
	{
		//Open huffington post home page and verify the page is open.		
		steps.openHuffingtonPostWebPage();
		steps.veriFyHuffingtonPostPageisDisplayed();
		
		//Click on lifestyle->Tech 
		steps.mouseHoverToLifestyleTab();
		steps.clickOnLifeStyleTechOption();
		
		//Get all article info and their authors
		steps.getAllArticleTitlesAndAuthors();
	}
	
	
}
