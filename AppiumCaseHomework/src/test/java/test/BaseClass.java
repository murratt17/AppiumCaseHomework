package test;

import java.net.URL;
import java.util.logging.LogManager;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;



public class BaseClass {
	
	AndroidDriver<MobileElement> ad;
	DesiredCapabilities dc ;
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		
		try {
        dc= new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "MuratDevice4");
	//	dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");


		dc.setCapability(MobileCapabilityType.APP, "http://search.maven.org/remotecontent?filepath=io/selendroid/selendroid-test-app/0.17.0/selendroid-test-app-0.17.0.apk");
		
		URL urll = new URL("http://127.0.0.1:4723/wd/hub");
		
		ad = new AndroidDriver<MobileElement>(urll,dc);
		System.out.println("Appliaction Started.....");

		}
		
		catch(Exception exc)
		{
			System.out.println("Cause is "  + exc.getCause());
			System.out.println("Message is " + exc.getMessage()); 
			exc.printStackTrace();	
		}
		
	}
	
	
	
	@AfterMethod
	public void teardown() {
		
		System.out.println("Appliaction closed.....");
		ad.quit();
		//adb -emu kill;
		
	}
	
		
	
	public XSSFRow excelReaderAccordingToRow(int indexOfRow) throws IOException
	{
		 File TestexcelFile;

	
		TestexcelFile  =    new File("src/test/resources/TestData.xlsx");
        FileInputStream inputStream = new FileInputStream(TestexcelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet workSheet = workbook.getSheetAt(0);
        
        
   
        
        
        workbook.close();
        return workSheet.getRow(indexOfRow);
      




	}


}
