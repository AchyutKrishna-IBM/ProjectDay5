package com.ibm.test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.ibm.initialization.WebDriverLaunch;
import com.ibm.pages.AdminPage;
import com.ibm.pages.Login;
import com.sun.java.swing.plaf.windows.resources.windows;


public class BaseTest extends WebDriverLaunch {
	
	    @Test
        public void positiveCredentials() throws FileNotFoundException, IOException
        {
		String url = p.getProperty("url");
		String UserName = p.getProperty("user");
		String Password = p.getProperty("password");
        driver.get(url);
		Login login = new Login(driver,wait);
		login.enterEmailAddress(UserName);
		login.enterPassword(Password);
		login.clickOnLogin();

        }
	   @AfterMethod
	    public void AddNewUser() throws InterruptedException
	    {
		   
		   
		   String username=p.getProperty("username");
		   String usergroup=p.getProperty("usergroup");
		   String name=p.getProperty("name");
		   String email=p.getProperty("email");
		   String password=p.getProperty("passwordForUser");
		   String status=p.getProperty("status");
	    	AdminPage adm=new AdminPage(driver,wait);
	    	adm.clickOnSystem();
	    	Thread.sleep(3000);
	    	adm.clickOnUsers();
	    	Thread.sleep(3000);
	    	adm.clickOnAdd();
	    	adm.giveUserName(username);
	    	adm.selectUserGroup(usergroup);
	    	adm.giveName(name);
	    	adm.giveEmail(email);
	    	adm.givePassword(password);
	    	adm.confPassword(password);
	    	adm.selectStatus(status);
	    	Thread.sleep(3000);
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("scroll(250, 0)");
	    	adm.clickOnSave();
	    	Thread.sleep(3000);
	    	adm.verifyAddedUser(username);
	    	
	    	
	    }
}
