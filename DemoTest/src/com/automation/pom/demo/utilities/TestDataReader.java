package com.automation.pom.demo.utilities;

import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/*
 * TestDataReader Class parse the test-data in json file
 */
public class TestDataReader 
{
	public static String currentDir = System.getProperty("user.dir");
	
	public static JsonObject loadTestData(String fileName)
	{
		JsonParser parser = new JsonParser();

        try 
        { 
            Object obj = parser.parse(new FileReader(currentDir+"\\src\\com\\automation\\pom\\demo\\testData\\"+fileName+".json"));

            return  (JsonObject) obj;
        }
        catch(Exception e)
        {
        	throw new RuntimeException("Unable to load test-data for fileName: " + fileName + " " + e.getMessage());
        }
	}
}
