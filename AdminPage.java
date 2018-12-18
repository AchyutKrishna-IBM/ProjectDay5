package com.ibm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminPage{
	WebDriver driver;
	WebDriverWait wait;
    @FindBy(xpath="//*[@id='side-menu']/li[6]/a")
    WebElement systemEle;
   @FindBy(xpath="//*[@id='side-menu']/li[6]/ul/li[2]/a")
   WebElement usersEle;
   @FindBy(xpath="//*[@id='page-wrapper']/div/div[1]/div/ol/li[1]/a")
   WebElement addUsersEle;
   @FindBy(xpath="//input[@name='username']")
   WebElement userNameEle;
   @FindBy(xpath="//select[@name='usergroup']")
   WebElement userGroupEle;
   @FindBy(xpath="//input[@name='name']")
   WebElement nameEle;
   @FindBy(xpath="//input[@name='email']")
   WebElement emailEle;
   @FindBy(xpath="//input[@name='pword']")
   WebElement passwordEle;
   @FindBy(xpath="//input[@name='cpword']")
   WebElement confPasswordEle;
   @FindBy(xpath="//select[@name='status']")
   WebElement statusEle;
   @FindBy(xpath="//button[@type='Submit']")
	WebElement saveEle;
	public AdminPage(WebDriver driver,WebDriverWait wait)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait=wait;
	}
	public void clickOnSystem()
	{
		systemEle.click();
	}
	public void clickOnUsers()
	{
		usersEle.click();
	}
	public void clickOnAdd()
	{
		addUsersEle.click();
	}
	public void giveUserName(String un)
	{
		userNameEle.sendKeys(un);
	}
	public void selectUserGroup(String ug)
	{
		Select s=new Select(userGroupEle);
		s.selectByVisibleText(ug);
	}
	public void giveName(String nm)
	{
		nameEle.sendKeys(nm);
	}
	public void giveEmail(String eml)
	{
		emailEle.sendKeys(eml);
	}
	public void givePassword(String pw)
	{
		passwordEle.sendKeys(pw);
	}
	public void confPassword(String cpw)
	{
		confPasswordEle.sendKeys(cpw);
	}
	public void selectStatus(String st)
	{
		Select s=new Select(statusEle);
		s.selectByVisibleText(st);
	}
	public void clickOnSave()
	{
	saveEle.click();
		
	}
	public void verifyAddedUser(String uname)
	{
		Assert.assertTrue(driver.getPageSource().contains(uname));//username is added
	}
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
