package com.grocerycrud.prova_sicredi.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.grocerycrud.prova_sicredi.environment.WebInterface;
import com.grocerycrud.prova_sicredi.environment.Audit;

import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.containsString;

public class AddCustomer extends WebInterface{
	
	private By customerNameLocator			= By.id("field-customerName");
	private By contactLastNameLocator		= By.id("field-contactLastName");
	private By contactFirstNameLocator		= By.id("field-contactFirstName");
	private By phoneLocator					= By.id("field-phone");
	private By addressLine1Locator			= By.id("field-addressLine1");
	private By addressLine2Locator			= By.id("field-addressLine2");
	private By cityLocator					= By.id("field-city");
	private By stateLocator					= By.id("field-state");
	private By postalCodeLocator			= By.id("field-postalCode");
	private By countryLocator				= By.id("field-country");
	private By fromEmployeerLocator			= By.id("field_salesRepEmployeeNumber_chosen");
	private By fromEmployeerInputLocator	= By.xpath("//div[@id='field_salesRepEmployeeNumber_chosen']//input");
	private By creditLimitLocator			= By.id("field-creditLimit");
	private By saveLocator					= By.id("form-button-save");
	private By messageLocator				= By.xpath("//div[@id='report-success']//p");
	private By saveAndGoBackLocator			= By.id("save-and-go-back-button");
	
	protected static String fileName = "grocerycrud-addcustmoer";
	Audit audit = new Audit();
				
	public AddCustomer customerName(String value){
		driver.findElement(customerNameLocator).sendKeys(value);
		return this;
	}
	
	public AddCustomer contactLastName(String value){
		driver.findElement(contactLastNameLocator).sendKeys(value);
		return this;
	}
	
	public AddCustomer contactFirstName(String value){
		driver.findElement(contactFirstNameLocator).sendKeys(value);
		return this;
	}
	
	public AddCustomer phone(String value){
		driver.findElement(phoneLocator).sendKeys(value);
		return this;
	}
	
	public AddCustomer addressLine1(String value){
		driver.findElement(addressLine1Locator).sendKeys(value);
		return this;
	}
	
	public AddCustomer addressLine2(String value){
		driver.findElement(addressLine2Locator).sendKeys(value);
		return this;
	}
	
	public AddCustomer city(String value){
		driver.findElement(cityLocator).sendKeys(value);
		return this;
	}
	
	public AddCustomer state(String value){
		driver.findElement(stateLocator).sendKeys(value);
		return this;
	}
	
	public AddCustomer postalCode(String value){
		driver.findElement(postalCodeLocator).sendKeys(value);
		return this;
	}
	
	public AddCustomer country(String value){
		driver.findElement(countryLocator).sendKeys(value);
		return this;
	}
	
	public AddCustomer fromEmployeer(String value){
		driver.findElement(fromEmployeerLocator).click();
		driver.findElement(fromEmployeerInputLocator).sendKeys(value + Keys.ENTER);
		return this;
	}	
	
	public AddCustomer creditLimit(String value){
		driver.findElement(creditLimitLocator).sendKeys(value);
		return this;
	}
	
	public AddCustomer save(){
		driver.findElement(saveLocator).click();
		return this;
	}
	
	public AddCustomer successStoredMessage(String value){
		WebElement element = driver.findElement(messageLocator);
		String messageText = element.getText();
		audit.captureScreenshot(fileName);
		assertThat(messageText, containsString(value));
		return this;
	}
	
	public AddCustomer saveAndGoBack(){
		driver.findElement(saveAndGoBackLocator).click();
		return this;
	}

}
