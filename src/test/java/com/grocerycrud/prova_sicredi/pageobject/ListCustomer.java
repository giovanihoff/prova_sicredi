package com.grocerycrud.prova_sicredi.pageobject;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.grocerycrud.prova_sicredi.environment.Audit;
import com.grocerycrud.prova_sicredi.environment.WebInterface;

public class ListCustomer extends WebInterface{

	private By selectVersionLocator		= By.id("switch-version-select");
	private By addCustomerLocator		= By.linkText("Add Customer");
	private By insertSearchLocator		= By.name("search");
	private By searchLocator			= By.xpath("//*[@id='gcrud-search-form']/div[1]/div[2]/a[3]/i");
	private By loadingLocator			= By.cssSelector("div[class='container-fluid gc-container loading-opacity']");
	private By checkboxResultLocator	= By.className("select-all-none");
	private By deleteLocator			= By.linkText("Delete");
	private By popupMessageLocator		= By.cssSelector("p[class='alert-delete-multiple-one']");
	private By confirmDeleteLocator		= By.cssSelector("button[class='btn btn-danger delete-multiple-confirmation-button']");
	private By statusMessageLocator 	= By.xpath("//span[@data-growl='message']/p");
	
	protected static String fileName = "grocerycrud-deletecustmoer";
	Audit audit = new Audit();

	public ListCustomer selectVersion(String value){
	    new Select(driver.findElement(selectVersionLocator)).selectByVisibleText(value);
		return this;
	}

	public ListCustomer addCustomer(){
		driver.findElement(addCustomerLocator).click();
		return this;
	}	

	public ListCustomer search(String value){
		driver.findElement(searchLocator).click();
		driver.findElement(insertSearchLocator).sendKeys(value + Keys.ENTER);
		return this;
	}

	public ListCustomer selectResult(){
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(loadingLocator));
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	    driver.findElement(checkboxResultLocator).click();
		return this;
	}
	
	public ListCustomer delete(){
		driver.findElement(deleteLocator).click();
		return this;
	}
	
	public ListCustomer popupMessage(String value){
	    String popupMessage = driver.findElement(popupMessageLocator).getText();
	    assertEquals(popupMessage, value);
		return this;
	}
	
	public ListCustomer confirmDelete(){
		driver.findElement(confirmDeleteLocator).click();
		return this;
	}
	
	public ListCustomer successDeletedMessage(String value){
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(statusMessageLocator));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(statusMessageLocator));
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	    String popupMessage = driver.findElement(statusMessageLocator).getText();
		audit.captureScreenshot(fileName);
	    assertEquals(popupMessage, value);
		return this;
	}
	
}
