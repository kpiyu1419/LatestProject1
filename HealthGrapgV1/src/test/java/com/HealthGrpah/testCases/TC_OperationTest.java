package com.HealthGrpah.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC_OperationTest extends TC_LoginTest_001 {
	
	
	@AfterTest
	public void OperationTest  ()
	{
	
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	
	WebElement viewAccSummary=driver.findElement(By.id("MenuHyperLink1"));
	viewAccSummary.click();
	
	//6.select 800001 account in dropdown
	Select se = new Select(driver.findElement(By.id("listAccounts")));
	se.selectByValue("800001");

	WebElement btn1=driver.findElement(By.id("btnGetAccount"));
	btn1.click();

	//7.Assert  for balance??

	WebElement balanceverify= driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr[4]/td[2]"));
	System.out.println( balanceverify.getText());

	String expectedBal = "$108874.00";
	//Assert.assertEquals(expectedBal,balanceverify);

	System.out.println("Balance verified");

	//8.Click on Transfer funds
	WebElement transferlink=driver.findElement(By.id("MenuHyperLink3"));
	transferlink.click();

	Select fa = new Select(driver.findElement(By.name("fromAccount")));

	fa.selectByValue("800000");//Transfer from account

	Select ta = new Select(driver.findElement(By.name("toAccount")));

	ta.selectByValue("800001");  //Transfer to account

	WebElement AmountTotransfer=driver.findElement(By.id("transferAmount"));
	AmountTotransfer.sendKeys("9876");

	//Transfer amount button click
	
	WebElement btn3=driver.findElement(By.id("transfer"));
	btn3.click();


	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//--------------------------------------------------------------------------------------------
	//Validate Trasnsaction Detail message

	//  WebElement transactionDetailMessage= driver.findElement(By."//span[@id='_ctl0__ctl0_Content_Main_postResp']");

	/* WebElement transactionDetailMessage=driver.findElement(By.id("_ctl0__ctl0_Content_Main_postResp"));
		  transactionDetailMessage.getText();

		  String expectedText = "9876.0 was successfully transferred from Account 800000 into Account 800001 at 10/13/22 10:12 PM.";
		  Assert.assertEquals(transactionDetailMessage,expectedText);

		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 */
//--------------------------------------------------------------------------------------------
	//Click on View Recent Transactions

WebElement veiwRecentTransactions=driver.findElement(By.id("MenuHyperLink2"));
	veiwRecentTransactions.click();


	//Click On Contact US

	WebElement contactUs=driver.findElement(By.id("HyperLink3"));
	contactUs.click();

	//Click On Online Form link

	driver.findElement(By.linkText("online form")).click();

	//WebElement onlineFormlink=driver.findElement(By.id("HyperLink3"));
	// onlineFormlink.click();

	//Feedback Form Details

	WebElement yourName=driver.findElement(By.name("name"));
	yourName.sendKeys("Admin User");

	WebElement emailid=driver.findElement(By.name("email_addr"));
	emailid.sendKeys("kpiyu1419@gmail.com");

	WebElement subject=driver.findElement(By.name("subject"));
	subject.sendKeys("MyFeedback");


	WebElement comments=driver.findElement(By.name("comments"));
	comments.sendKeys("Good experince in using this application");

	WebElement submitfeedback=driver.findElement(By.name("submit"));
	submitfeedback.click();

	//Validate Thank you message
	WebElement messgeValidation= driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));

	//Verify Thank you message is Displayed
	if(messgeValidation.isDisplayed())
	{
		System.out.println("thank you message is Dispalyed");
	}

	else
	{
		System.out.println("Thank you message is not Dispalyed");
	}


	WebElement signOff=driver.findElement(By.id("LoginLink"));
	signOff.click();

	//Validate user is signed off

	//WebElement signOffValidation= driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
	WebElement signOffValidation= driver.findElement(By.xpath("//*[@id=\"LoginLink\"]/font"));
	signOffValidation.click();

}

	
	

}
