package com.grocerycrud.prova_sicredi.environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public abstract class WebInterface {
	
	protected static ChromeDriver driver;
	protected static Integer timeout = 15;
	 
    public WebInterface() {}
    
    public static ChromeDriver startChromeDriver() {
		File file = new File("driver/chromedriver_win32.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	    return driver = new ChromeDriver();
	}
    
    public static void closeChromeDriver() {
    	driver.close();
	}
    
    public static void quitChromeDriver() {
    	driver.quit();
	}

	public static void setDefaultTimeout() {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void accessURL(String url) {
		driver.get(url);
	}
    
}
