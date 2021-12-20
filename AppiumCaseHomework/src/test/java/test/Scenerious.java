package test;


import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Scenerious extends BaseClass {
	
	@Test
	public void test1() throws InterruptedException, IOException
	{
		System.out.println("Test1 Started.....");
		
		XSSFRow row2= excelReaderAccordingToRow(0);	
		XSSFCell cell1 = row2.getCell(1);
		XSSFCell cell2 = row2.getCell(2);
	    String name= cell1.getStringCellValue() + "  " +  cell2.getStringCellValue();



		MobileElement chromeButton = (MobileElement) ad.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview"));
		chromeButton.click();

		Thread.sleep(2000);
		ad.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"Say Hello Demo\"]/android.view.View[2]/android.widget.EditText")).clear();
		ad.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"Say Hello Demo\"]/android.view.View[2]/android.widget.EditText")).sendKeys(name);
		ad.findElement(By.xpath("//android.widget.Spinner[@content-desc=\"Volvo\"]\r\n")).click();
		ad.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]\r\n"
				+ "")).click();

		Thread.sleep(2000);

		ad.findElement(MobileBy.AccessibilityId("Send me your name!")).click();

		Thread.sleep(2000);

		boolean result = ad.findElement(By.xpath("//android.webkit.WebView[@content-desc=\"Hello: MURAT GUVEN\"]/android.view.View[4]\r\n")).isDisplayed();
		Assert.assertTrue(result);
		System.out.println("Test1 Finished.....");

	}

	@Test
	public void test2() throws InterruptedException, IOException
	{
		System.out.println("Test2 Started.....");
		
		XSSFRow row2= excelReaderAccordingToRow(1);	
		XSSFCell cell1 = row2.getCell(1);
		XSSFCell cell2 = row2.getCell(2);
		XSSFCell cell3 = row2.getCell(3);
		XSSFCell cell4 = row2.getCell(4);


		MobileElement registerButton = (MobileElement) ad.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
		registerButton.click();

		Thread.sleep(2000);
		ad.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys(cell1.getStringCellValue());
		ad.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys(cell2.getStringCellValue());
		ad.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys(cell3.getStringCellValue());
		ad.findElement(By.id("io.selendroid.testapp:id/inputName")).clear();
		ad.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys(cell4.getStringCellValue());
	
		scrollAndClick("Ruby");
		Thread.sleep(2000);
		
		ad.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[6]")).click();

	
		Thread.sleep(2000);

		ad.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
		
		Thread.sleep(1000);
		ad.findElement(By.id("io.selendroid.testapp:id/buttonRegisterUser")).click();
		Thread.sleep(1000);
		
		boolean result = ad.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")).isDisplayed();
		Assert.assertTrue(result);

		System.out.println("Test2 Finished.....");
		
	}
	
	public void scrollAndClick(String visibleText)
	{
	     ad.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	     
	}
	   
}


