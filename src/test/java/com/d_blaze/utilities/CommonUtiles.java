package com.d_blaze.utilities;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtiles {
	public WebDriver driver;
	public CommonUtiles(WebDriver driver) {
		this.driver=driver;
	}
	public void waitForElement(WebElement ele,long timOutInSeconds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
				
	}
	public static String  randomstring()
	{
		 String generatestr = RandomStringUtils.randomAlphabetic(10);
		 return generatestr;
	}
}
