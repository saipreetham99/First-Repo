package Pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class FormPage {

	public  FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement name;
	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	public WebElement female;
	@FindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement country;
	
	@FindBy(xpath="//*[@text='Argentina']")
	public WebElement argentina;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement shop;
	
	public WebElement  getNameField() {
		System.out.println("Sending Name");
		return name;
		
		
	}
}
