package Practice.FrameworkAppium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	public	static  void startServer() {
		service= AppiumDriverLocalService.buildDefaultService();
		service.start();	
	}
	
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("C:\\Users\\Lenskart\\eclipse-workspace\\FrameworkAppium\\src\\main\\java\\Resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	public static AndroidDriver<AndroidElement> Cap(String device, String Appname) throws IOException, InterruptedException {
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Practice\\FrameworkAppium\\Global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		File f = new File("src");
		File fs = new File(f, (String) prop.get(Appname));
		DesiredCapabilities cap = new DesiredCapabilities();
//		String devices=prop.getProperty(device);
		String devices = System.getProperty("deviceName");
		if(devices.contains("Nexus")){
			startEmulator();
		}
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,devices);		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
	public static  void getScreenshot(String s,String f) throws IOException 
		{
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\Users\\Lenskart\\Documents\\"+f+"\\"+s+".png"));
		
		}
	
	}

