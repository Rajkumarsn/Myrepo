package com.d_blaze.testScript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.d_blaze.pageObject.LoginPage;
import com.d_blaze.utilities.Readconfig;
import com.d_blaze.utilities.XLUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	Readconfig read=new Readconfig();
	
	public String baseURL=read.getApplicationURL();
	public String username=read.getUserName();
	public String password=read.getPassword();
	
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public XLUtils excel=new XLUtils();
    public static LoginPage lp;
	public static WebDriver driver;
	
	@DataProvider(name="loginData")
	String[][] getData() throws EncryptedDocumentException, IOException{
		return excel.getDataFromExcel("com.d_blaze.testData/Contactinfo.xlsx", "LoginP");
	}
	
	@BeforeTest
	public void setup() {
		report=new ExtentReports();
		spark=new ExtentSparkReporter("test-output/D-blaze.html");
		report.attachReporter(spark);
		
		WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		report.flush();
	}
	public void captureScreenshot(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dst = new File(".\\Screenshot\\" +tname+".png");
    	FileUtils.copyFile(src, dst);
    	System.out.println("Screenshot taken");
	}
}
