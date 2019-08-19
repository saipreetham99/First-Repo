package Practice.FrameworkAppium;

import java.io.IOException;
//import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.FormPage;
import Utilities.Scroll;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class General extends base {
	public static double getAmount(String value) {
		value = value.substring(1);
		double d = Double.parseDouble(value);
		return d;
	}

//	@BeforeTest
//	public void killAllNodes() throws IOException {
//		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
//	}
	@Test
	public void totalValidation() throws IOException, InterruptedException {
		
		startServer();
		AndroidDriver<AndroidElement> driver = Cap("device", "GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FormPage f= new FormPage(driver);
		Scroll scroll= new Scroll(driver);
		f.getNameField().sendKeys("Hello");
		//driver.hideKeyboard();
		f.female.click();
		f.country.click();
		Thread.sleep(1000);
		
		scroll.scrollText("Argentina");
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		f.argentina.click();
		f.shop.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));");
		// driver.findElement(MobileBy.AndroidUIAutomator("new
		// UiScrollable(newUiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new
		// UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
//		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//		for (int i = 0; i < count; i++) {
//			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//			if (text.equalsIgnoreCase("Jordan 6 Rings")) {
//				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//				break;
//			}
//		}
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		Thread.sleep(1000);

		String p1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		String p2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		String p3 = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double d1 = getAmount(p1);
		double d2 = getAmount(p2);
		double d3 = getAmount(p3);
		Assert.assertEquals(d3, d1 + d2);
		//System.out.println("true");
		//service.stop();

	}

}
