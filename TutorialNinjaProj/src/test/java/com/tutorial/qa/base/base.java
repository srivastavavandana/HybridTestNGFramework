package com.tutorial.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorial.utils.Utilities;

public class base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public  base() {
	//public void loadPropertiesFile() {
		
	    prop = new Properties();
	    File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\TutorialNinja\\qa\\config\\config.properties");
	// dataProperties
	    dataProp = new Properties();
	    File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\qa\\testdata\\testdata.properties");
	    try {
	        FileInputStream dataFis = new FileInputStream(dataPropFile);
	        dataProp.load(dataFis);
	    }catch(Throwable e) {
	    	e.printStackTrace();
	    }
	    try {
		    FileInputStream fis = new FileInputStream(propFile);
		    prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserandOpenApplicationURL(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} 
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
		
}       
}