package com.d_blaze.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.d_blaze.testScript.BaseClass;


public class Ilistener implements ITestListener {
	
	public WebDriver driver;
    public void onTestFailure(ITestResult result) {
    	//BaseClass base=new BaseClass();
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dst = new File("/Screenshot"+System.currentTimeMillis()+".png");
    	String path = dst.getAbsolutePath();
    	
    	try {
    		FileUtils.copyFile(src, dst);
    	}
    	catch(IOException e){
    		e.printStackTrace();
    	}
    	BaseClass.test.fail("Test script has got failed===>"+result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }
}
