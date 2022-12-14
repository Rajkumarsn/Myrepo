package com.d_blaze.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	   WebDriver ldriver;

	   public LoginPage(WebDriver driver) {
	   	ldriver=driver;
	   	PageFactory.initElements(driver, this);
	   }

	   @FindBy(xpath = "//a[@id='login2']")
	   private WebElement btnlogin;

	   @FindBy(xpath = "//input[@id='loginusername']")
	   private WebElement txtUsername;

	   @FindBy(xpath = "//input[@id='loginpassword']")
	   private WebElement txtpassword;

	   @FindBy(xpath = "//button[text()='Log in']")
	   private WebElement btnloglogin;
	   
	   @FindBy(xpath = "//a[text()='Log out']")
	   private WebElement btnlogout;

	   public void getBtnlogin() {
	   	btnlogin.click();
	   }

	   public void getTxtUsername(String user) {
	   	txtUsername.sendKeys(user);
	   }

	   public void getTxtpassword(String pswd) {
	   	txtpassword.sendKeys(pswd);
	   }

	   public void getBtnloglogin() {
	   	 btnloglogin.click();
	   }

	   public void getBtnlogout() {
	   	btnlogout.click();
	   }
}
