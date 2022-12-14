package com.d_blaze.testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.d_blaze.pageObject.LoginPage;
import com.d_blaze.utilities.Ilistener;

@Listeners(Ilistener.class)
public class LoginTest extends BaseClass {

	@Test//(dataProvider = "loginData")
	public void loginTest() throws InterruptedException, IOException {
		test=report.createTest("User able to login to the home page and verify the title of home page");
		Thread.sleep(2000);
		driver.get(baseURL);
		
		lp=new LoginPage(driver);
		lp.getBtnlogin();
		lp.getTxtUsername(username);
		
		lp.getTxtpassword(password);
		Thread.sleep(2000);
		lp.getBtnloglogin();
		
		test.info("Capturing the page contains Pointer");
		if(driver.getPageSource().contains("pointer"))
		{
			Assert.assertTrue(true);
			test.pass("Page contains pointer verified");
			captureScreenshot(driver,"loginTest");
		}
		else
		{  
			
			Assert.assertTrue(false);
			test.fail("Page not contain Pointer");
		}
	   
		//Thread.sleep(2000);
		//lp.getBtnlogout();
	}
	
}
