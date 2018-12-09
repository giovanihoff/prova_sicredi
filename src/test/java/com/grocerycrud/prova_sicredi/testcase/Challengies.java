package com.grocerycrud.prova_sicredi.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.grocerycrud.prova_sicredi.dataprovider.GroceryCrudProvider;
import com.grocerycrud.prova_sicredi.environment.WebInterface;
import com.grocerycrud.prova_sicredi.pageobject.AddCustomer;
import com.grocerycrud.prova_sicredi.pageobject.ListCustomer;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class Challengies extends GroceryCrudProvider {

	@BeforeClass
	public static void startChrome(){
		WebInterface.startChromeDriver();
		WebInterface.setDefaultTimeout();
		WebInterface.maximize();
		WebInterface.accessURL(url);
	}
	
	@Test
	@UseDataProvider("AddCustomer")
	public void testCaseAddCustomer(String name, String lastName, String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String	country, String fromEmployeer, String creditLimit, String successStoredMessage){
	    ListCustomer listCustomer	= new ListCustomer();
	    AddCustomer addCustomer	= new AddCustomer();
	    
	    System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	    
	    listCustomer
			.selectVersion(version4)
	    	.addCustomer();

	    addCustomer
	    	.customerName(name)
		    .contactLastName(lastName)
		    .contactFirstName(contactFirstName)
		    .phone(phone)
		    .addressLine1(addressLine1)
		    .addressLine2(addressLine2)
		    .city(city)
		    .state(state)
		    .postalCode(postalCode)
		    .country(country)
	    	.fromEmployeer(fromEmployeer)
	    	.creditLimit(creditLimit)
	    	.save()
	    	.successStoredMessage(successStoredMessage);

	    System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	@UseDataProvider("DeleteCustomer")
	public void testCaseDeleteCustomer(String name, String popupMessage, String successDeletedMessage){
	    ListCustomer listCustomer	= new ListCustomer();
	    AddCustomer addCustomer	= new AddCustomer();
	    
	    System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());

	    addCustomer
    		.saveAndGoBack();
	    
	    listCustomer
	    	.search(name)
	    	.selectResult()
	    	.delete()
	    	.popupMessage(popupMessage)
	    	.confirmDelete()
	    	.successDeletedMessage(successDeletedMessage);

	    System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@AfterClass
	public static void closeBrowser(){
		WebInterface.closeChromeDriver();
		WebInterface.quitChromeDriver();
	}

}
