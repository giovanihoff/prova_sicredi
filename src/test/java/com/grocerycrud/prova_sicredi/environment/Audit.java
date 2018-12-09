package com.grocerycrud.prova_sicredi.environment;

import java.io.File;
import java.io.FileOutputStream;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.OutputType;

public class Audit extends WebInterface{
	
    public void captureScreenshot(String fileName) {
        try {
            new File("target/surefire-reports/").mkdirs();
            FileOutputStream out = new FileOutputStream("target/surefire-reports/screenshot-" + fileName + ".png");
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
        	System.err.println(e);
        }
    }

}
