package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//import io.appium.java_client.AppiumDriver;

public class Preferences {

	@FindBy(xpath="//android.widget.TextView[@content-desc='3. Preference dependencies']")
	public WebElement dependencies;
	
	public Preferences(AndroidDriver<AndroidElement> driver){
		PageFactory.initElements(driver, this);
	}
}
