package com.automation.pom.demo.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * SeleniumWrapper class provide all method related to selenium.
 */
public class SeleniumWrapper {

	public static WebDriver driver = null;
	
	public static String currentDir = System.getProperty("user.dir");
	
	public static int TIMEOUT =30;
	
	public void setWebDriver(String browserName)
	{
		if(browserName.toLowerCase().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", currentDir+"./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.toLowerCase().equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", currentDir+"./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
	}
	
	public void click(String locator)
	{
		try
		{
			this.waitForElementToBePresent(locator);
			WebElement webEle = driver.findElement(By.xpath(locator));
			webEle.click();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Unable to perform click operation : "+ e.getMessage());
		}
	}
	
	
	public void openUrl(String url)
	{
		try
		{
			driver.get(url);
			driver.manage().window().maximize();
		}
		catch(Exception e)
		{
			throw new RuntimeException("Unable to perform open url operation : "+ e.getMessage());
		}
	}
	
	public void inputText(String locator, String text)
	{
		try
		{
			WebElement webEle = driver.findElement(By.xpath(locator));
			
			if(webEle.isDisplayed())
			{
				webEle.clear();
				webEle.sendKeys(text);
			}
			else
			{
				System.out.println("Element not displyed on UI for locator: " + locator);
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("Unable to enter text click operation : "+ e.getMessage());
		}
	}
	
	public void selectByVisibleTextFromDropDown(String locator, String text)
	{
		try
		{
			Select objSelect = new Select(driver.findElement(By.xpath(locator)));
			
			objSelect.selectByVisibleText(text);
		}
		catch(Exception e)
		{
			throw new RuntimeException("Unable to select by visible text from dropdown : "+ e.getMessage());
		}
	}
	
	public boolean isDisplayed(String locator)
	{
		try
		{
			if( driver.findElement(By.xpath(locator)).isDisplayed())
			{
				return true;
			}
			else
			{	
				waitForElementToBeDisplayed(locator);
				return driver.findElement(By.xpath(locator)).isDisplayed();
			}	
		}
		catch(Exception e)
		{
			throw new RuntimeException("Unable to check element is displayed : "+ e.getMessage());
		}
	}
	
	public void clean()
	{
		try
		{
			if(driver!= null)
			{
				driver.quit();
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException("Unable to perform clean operation : "+ e.getMessage());
		}
	}
	
	public void waitForElementToBeDisplayed(String locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		
	  try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		} catch (Exception e) {
			throw new RuntimeException("Unable to wait for elemet : "+ e.getMessage());
		}
		
	}

	public void waitForElementToBePresent(String locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		
	  try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} catch (Exception e) {
			throw new RuntimeException("Unable to wait for elemet : "+ e.getMessage());
		}
		
	}

	public WebElement findElement(String locator)
	{
		WebElement element;
		try 
		{
			this.waitForElementToBeDisplayed(locator);
			element = driver.findElement(By.xpath(locator));
			return element;
		} catch (Exception e) {
			throw new RuntimeException("Unable to find element : "+ e.getMessage());
		}
		
	}
	
	public List<WebElement> findAllElements(String locator)
	{
		List <WebElement>elements ;
		try 
		{
			this.waitForElementToBeDisplayed(locator);
			elements = driver.findElements(By.xpath(locator));
			return elements;
		} catch (Exception e) {
			throw new RuntimeException("Unable to find element : "+ e.getMessage());
		}
	}	

	public void hoverOnElement(String locator)
	{
		try 
		{
			Actions act = new Actions(driver);
			act.moveToElement(this.findElement(locator));
			act.build().perform();
			
		} catch (Exception e) {
			throw new RuntimeException("Unable to hover to element : "+ e.getMessage());
		}
	}
	
	public String getText(String locator)
	{
		try 
		{
			this.waitForElementToBePresent(locator);			
			return driver.findElement(By.xpath(locator)).getText().toString().trim();
			
		} catch (Exception e) {
			throw new RuntimeException("Unable to get text of the element : "+ e.getMessage());
		}
	}
	
}
