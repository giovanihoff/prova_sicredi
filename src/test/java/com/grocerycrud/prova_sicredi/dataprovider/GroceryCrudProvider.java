package com.grocerycrud.prova_sicredi.dataprovider;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class GroceryCrudProvider {

	protected static  String url			= "https://www.grocerycrud.com/demo/bootstrap_theme";
	protected static  String version4		= "Bootstrap V4 Theme";
	private String name						= "Teste Sicredi";
	private String lastName 				= "Teste";
	private String contactFirstName			= "Giovani Hoff";
	private String phone		 			= "51 9999-9999";
	private String addressLine1	 			= "Av Assis Brasil, 3970";
	private String addressLine2 			= "Torre D";
	private String city			 			= "Porto Alegre";
	private String state		 			= "RS";
	private String postalCode				= "91000-000";
	private String country					= "Brasil";
	private String fromEmployeer			= "Fixter";
	private String creditLimit				= "200";
	private String successStoredMessage		= "Your data has been successfully stored into the database.";
	private String popupMessage				= "Are you sure that you want to delete this 1 item?";
	private String successDeletedMessage	= "Your data has been successfully deleted from the database.";
	
    @DataProvider
    public static Object[][] AddCustomer() {
    	GroceryCrudProvider gcp = new GroceryCrudProvider();
        return new Object[][]{
        	{gcp.name, gcp.lastName, gcp.contactFirstName, gcp.phone, gcp.addressLine1, gcp.addressLine2, gcp.city, gcp.state, gcp.postalCode, gcp.country, gcp.fromEmployeer, gcp.creditLimit, gcp.successStoredMessage}
        };
    }
    
    @DataProvider
    public static Object[][] DeleteCustomer() {
    	GroceryCrudProvider gcp = new GroceryCrudProvider();
        return new Object[][]{
        	{gcp.name, gcp.popupMessage, gcp.successDeletedMessage}
        };
    }

}
