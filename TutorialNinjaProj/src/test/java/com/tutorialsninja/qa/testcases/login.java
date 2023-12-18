package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorial.qa.base.base;
import com.tutorial.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login extends base {
	public login() {
		super();
	}
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		  driver = initializeBrowserandOpenApplicationURL(prop.getProperty("browser"));
		  driver.findElement(By.xpath("//input[@id='m_LoginControl_UserName']")).sendKeys(prop.getProperty("validLogin"));
		  driver.findElement(By.xpath("//input[@id='m_LoginControl_Password']")).sendKeys(prop.getProperty("validPassword"));
		  driver.findElement(By.xpath("//span[text()='Login']")).click();
		
		}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	//public WebDriver driver;
	
   @Test
    public void verifyloginWithValidCredentials() throws InterruptedException {
	   WebDriverManager.chromedriver().setup();
	 
	   
	   
	   ChromeOptions chromeOptions = new ChromeOptions();

	   chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");

	    Actions action = new Actions(driver);
		  // click on Licensing Header
		  action.moveToElement(driver.findElement(By.linkText("Licensing"))).build().perform();
		  Thread.sleep(3000);
	    //driver.findElement(By.id("ctl00_linkLogout")).click();
	    //Thread.sleep(3000);
		  action.moveToElement(driver.findElement(By.linkText("Business Entity"))).build().perform();
		  //click on New 
		  driver.findElement(By.linkText("Modify")).click();
		  Thread.sleep(4000);
		  //For dropdown
		 // WebElement dropdownBU=
		  WebElement dropdownBU = (driver.findElement(By.id("ddlProgramInternal")));
		 // WebElement dropdownBU = (driver.findElement (By.className("//input[@class=\"select2-search__field\"]")));
		  Select objSelect =new Select(dropdownBU);
		  objSelect.selectByIndex(1);
		  driver.findElement(By.id("txtFacilityName")).sendKeys(prop.getProperty("FacilityName"));
		  driver.findElement(By.name("txtCredentialNumberInternal")).sendKeys(prop.getProperty("CredentialNumberInternal"));
		  driver.findElement(By.name("txtRegisteredNamewithSecretaryofState")).sendKeys(prop.getProperty("RegisteredNamewithSecretaryofState"));
		  driver.findElement(By.name("txtEntityNumber")).sendKeys(prop.getProperty("EntityNumber"));
		 // driver.findElement(By.name("")).sendKeys("");
		 //dropdownlicenseType
		  WebElement dropdownLT = (driver.findElement(By.id("ddlCredentialTypeInternal")));
		  Select objSelect1 =new Select(dropdownLT);
		  objSelect1.selectByValue("BBL");
		  WebElement dropdownLS = (driver.findElement(By.id("ddlStatusInternal")));
		  Select objSelect11 =new Select(dropdownLS);
		  objSelect11.selectByValue("ACT");
		  WebElement dropdownService = (driver.findElement(By.id("ddlEndorsmentInternal")));
		  Select objSelect111 =new Select(dropdownService);
		  objSelect111.selectByValue("CSC");
		  WebElement dropdownOwnership = (driver.findElement(By.id("ddlOrganizationalType")));
		  Select objSelect1111 =new Select(dropdownOwnership);
		  objSelect1111.selectByValue("GVT");
		  driver.findElement(By.id("lnkAddress")).click();
		  WebElement dropdownPhysicaladdress = (driver.findElement(By.id("ddlAddressType")));
		  Select objSelect11111 =new Select(dropdownPhysicaladdress);
		  objSelect11111.selectByValue("PHL");
		  WebElement dropdownState = (driver.findElement(By.id("ddlMailingState")));
		  Select objSelect111111 =new Select(dropdownState);
		  objSelect111111.selectByValue("AL");
		  driver.findElement(By.id("txtAddress")).sendKeys(prop.getProperty("Address"));
		  driver.findElement(By.id("txtMailingCityInternal")).sendKeys(prop.getProperty("MailingCityInternal"));
		  driver.findElement(By.id("txtZipInternal")).sendKeys(prop.getProperty("ZipInternal"));
		  driver.findElement(By.id("txtPhone")).sendKeys(prop.getProperty("Phone"));
		  driver.findElement(By.id("txtEmail")).sendKeys(Utilities.generateEmailTimestamp());
		  WebElement dropdownMailingCounty = (driver.findElement(By.id("ddlMailingCounty")));
	      Select objSelect1111111 =new Select(dropdownMailingCounty);
		  objSelect1111111.selectByValue("03");
		  //Thread.sleep(3000);
		  driver.findElement(By.name("Search")).click();
		  //driver.findElement(By.name("Reset")).click();
		// driver.findElement(By.name("Search")).click();
		  
}
   
   
   
   
   
   
}