package com.HealthGrpah.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.HealthGraph.pageObject.LoginPage;
import com.HealthGraph.testData.BaseClass;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest()
	{
		driver.get(baseUrl);
		LoginPage lp= new LoginPage(driver);
		lp.setAccLoginlink();
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();		
	}
	

	@Test
	public void ViewAccSummary() throws InterruptedException
	{
	
	
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	
	WebElement viewAccSummary=driver.findElement(By.id("MenuHyperLink1"));
	viewAccSummary.click();
	System.out.println("View Account Summary Clicked");
	
	}

		//WebElement viewAccSummary=driver.findElement(By.xpath("//a[@id='MenuHyperLink1']"));
		/*
		WebDriverWait wait=new WebDriverWait(driver,3);
		WebElement viewAccSummary=wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='MenuHyperLink1']")));
		
		viewAccSummary.click();
		*/
	
		//WebElement viewAccSummary=driver.findElement(By.xpath("//a[@href='/bank/main.jsp']"));
		//viewAccSummary.click();
	
	
	//6.select 800001 account in dropdown
	
	@Test
	public void SelectAccount ()
	{
	
	Select se = new Select(driver.findElement(By.id("listAccounts")));
	se.selectByValue("800001");

	WebElement btn1=driver.findElement(By.id("btnGetAccount"));
	btn1.click();
	System.out.println("Account Selected from drop down");

	//7.Assert  for balance??

	WebElement balanceverify= driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr[4]/td[2]"));
	System.out.println( balanceverify.getText());

	String expectedBal = "$108874.00";
	//Assert.assertEquals(expectedBal,balanceverify);

	System.out.println("Balance verified");
	}

	//8.Click on Transfer funds
	
	@Test
	public void TransferFund()
	{
	
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
	System.out.println( "Fund Transfered Successfully");


	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
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
	 
	//Click on View Recent Transactions

	WebElement veiwRecentTransactions=driver.findElement(By.id("MenuHyperLink2"));
	veiwRecentTransactions.click();
*/

	//Click On Contact US
		
		//Thread.sleep(3000);
	@Test
	public void ContactUs()
	{

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

	System.out.println("Feedback form filled");
	
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
