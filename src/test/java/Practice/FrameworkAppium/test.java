package Practice.FrameworkAppium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
	public static void main(String args[]) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://technical.city/en/system-requirements/paladins");
	WebElement dropdown= driver.findElement(By.xpath("//*[@id=\"select_container_video\"]/div/div[1]"));
	dropdown.click();
	
	WebElement graphicsCard = driver.findElement(By.xpath("(//div[contains(text(),'NVIDIA GeForce 940MX')])"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", graphicsCard);
	graphicsCard.click();
	
	driver.findElement(By.xpath("//*[@id=\"select_container_cpu\"]/div/div[1]")).click();

	WebElement processor = driver.findElement(By.xpath("//div[contains(text(),'i5-6200U')]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", processor);
	processor.click();

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h1[contains(text(),'Paladins system requirements')]")));
	driver.findElement(By.xpath("//*[@id=\"select_container_memory\"]/div/div[1]")).click();
	
	WebElement ram=driver.findElement(By.xpath("//div[contains(text(),'8 GB')]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ram);
	ram.click();

	driver.findElement(By.xpath("//input[@class='compare_button']")).click();
	
	driver.manage().window().maximize();
	WebElement result= driver.findElement(By.xpath("//*[@id=\"result\"]/div/div[2]"));
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",result);
	
	
	
	
	
	}
}
