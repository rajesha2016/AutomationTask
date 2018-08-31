package com.Automation.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.framework.TestDataProviderClass;
import com.automation.framework.Utilities;

/**
 * @author r.moharana
 *  This class is to automate API test for country validation
 *  Get test data from TestDataProviderClass class
 */
public class CountryValidationAPITest extends Utilities{
	
	@Test(dataProvider="CountryVerificationTestData", dataProviderClass=TestDataProviderClass.class)
	public static void getRequestFindCountry(String _countryNameToBeValidate) {
		
		try {
				//initialize properties file and get API url
				initConfig();
				URL url = new URL(config.getProperty("APICOUNTRYVALIDATEURL"));
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
	
				//verify response code of API
				
				//Assert.assertTrue(conn.getResponseCode() == 200);
				Assert.assertTrue(conn.getResponseCode() == 200, " code: "+conn.getResponseCode());
				/*if (conn.getResponseCode() == 200) {
					
					throw new RuntimeException(" HTTP error code : "+ conn.getResponseCode());
				}*/
				
				Scanner scan = new Scanner(url.openStream());
				String entireResponse = new String();
				
				while (scan.hasNext())
					entireResponse += scan.nextLine();
	
				scan.close();
	
				
				JSONArray jsonarray=new JSONArray(entireResponse);
				List<String> countries=new ArrayList<String>();
				
				//get all countries name
				for (int i = 0; i < jsonarray.length(); i++) {
					
					countries.add(jsonarray.getJSONObject(i).getString("name"));
				
					conn.disconnect();
				}
			
				//validate the country
				Assert.assertTrue(countries.contains(_countryNameToBeValidate));
				
				
				System.out.println("*** API Test passed for country "+_countryNameToBeValidate+" ***" );
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}

	}

}
