package com.HealthGraph.pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="AccountLink")	
	@CacheLookup
	WebElement txtAccLoginlink;	

	
@FindBy(id="uid")	
@CacheLookup
WebElement txtUserName;

@FindBy(id="passw")	
@CacheLookup
WebElement txtPassword;


@FindBy(name="btnSubmit")	
@CacheLookup
WebElement btnSubmit;

public void setAccLoginlink()
{
	txtAccLoginlink.click();
}

public void setUsername(String uname)
{
	txtUserName.sendKeys(uname);
}


public void setPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
}

public void clickSubmit()
{
	btnSubmit.click();
}

}
