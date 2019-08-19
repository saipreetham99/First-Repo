package Practice.FrameworkAppium;

import java.io.IOException;
//import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.HomePage;
import Pageobjects.Preferences;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemo extends base {
	@Test(dataProvider= "InputData",dataProviderClass= TestData.class)
	public void apiDemoTest(String input) throws IOException, InterruptedException{
		//startServer();
		AndroidDriver<AndroidElement> driver=Cap("device", "ApiDemo" );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		HomePage h =new HomePage(driver);
		Preferences p = new Preferences(driver);
		h.pref.click();
		p.dependencies.click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']")).sendKeys(input);
		driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
		//service.stop();
	}



}
