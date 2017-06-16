package com.automation.pom.demo.tests;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.automation.pom.demo.objectRepository.Locators;
import com.automation.pom.demo.pages.HuffingtonPostHomePage;
import com.automation.pom.demo.utilities.SeleniumWrapper;
import com.automation.pom.demo.utilities.TestDataReader;
import com.google.gson.JsonObject;

/*
 * Test Steps for the assignment2
 */
public class Assignment2_TestSteps extends BaseTest 
{
	private HuffingtonPostHomePage huffingtonPage;
	private JsonObject testData;
	private static SeleniumWrapper seleniumClient;
	private static HashMap<String, String> articleInfo;
	
	public void setData() 
	{
		testData = TestDataReader.loadTestData(Assignment2.class.getName().replace("com.automation.pom.demo.tests.",""));	
	}
	
	public Assignment2_TestSteps(JsonObject testScriptData)
	{
		seleniumClient = new SeleniumWrapper();
		huffingtonPage = new HuffingtonPostHomePage();
		testData = testScriptData;
		articleInfo = new HashMap<String, String>();
	}
	
	public void openHuffingtonPostWebPage()
	{
		huffingtonPage.goTo();
	}
	public void veriFyHuffingtonPostPageisDisplayed()
	{
		Assert.assertTrue(huffingtonPage.verifyLocation(),"Huffington Post page is not displayed");
	}
	
	public void mouseHoverToLifestyleTab()
	{
		seleniumClient.hoverOnElement(Locators.HUFFINGTONPOST_HOMEPAGE_LIFESTYLETAB);
	}
	
	public void clickOnLifeStyleTechOption()
	{
		seleniumClient.waitForElementToBeDisplayed(Locators.HUFFINGTONPOST_HOMEPAGE_LIFESTYLE_TECHOPTION);
		seleniumClient.click(Locators.HUFFINGTONPOST_HOMEPAGE_LIFESTYLE_TECHOPTION);
	}
	
	public void getAllArticleTitlesAndAuthors()
	{	
		List<WebElement>articleNames;
		String ID;
		String Author;
		articleNames= seleniumClient.findAllElements(Locators.HUFFINGTONPOST_TECHPAGE_ALL_ARTICLES);
		for(WebElement ele:articleNames){
			ID = ele.getAttribute("id");
			if(getArticleAuthor(ID)!=null && (!getArticleAuthor(ID).isEmpty()))
			{	
				Author = getArticleAuthor(ID);
				articleInfo.put(ID, Author);
			}
			else
			{
				Author = null;
			}
		}	
		
		articleInfo.forEach((key,value)->{
			String locator = Locators.HUFFINGTONPOST_TECHPAGE_ARTICLES_HEADLINE.replace("#",key);
			System.out.println("Article name :- "+ seleniumClient.getText(locator));
			System.out.println("Author name :-  " + value);
		});
	}
	
	private String getArticleAuthor(String ArticleID)
	{
		 try {
			 return seleniumClient.findElement(Locators.HUFFINGTONPOST_TECHPAGE_ALL_ARTICLEAUTHORS.replace("#", ArticleID)).getText();
		} catch (Exception e) {
			return null;
		}		 
	}

}
