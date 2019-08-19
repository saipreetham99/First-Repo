package Utilities;

import Practice.FrameworkAppium.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scroll extends base {
	AndroidDriver<AndroidElement> driver;
	public Scroll (AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	public void scrollText(String Text) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Text+"\"));");
		

	}
}

