package wallet.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public static Properties prop;

	

	public BaseClass(){
		String current = System.getProperty("user.dir");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					current+"\\src\\main\\java\\wallet\\Properties\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("base_url"));

	}
	
	
	
	public void waitAndClickElement(WebElement element) {
		
		element.click();
		System.out.println("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
		
}

public void sendKeysToWebElement(WebElement element, String textToSend) {


	element.clear();
	element.sendKeys(textToSend);
	System.out.println("Successfully Sent the following keys: '" + textToSend + "' to element: " + "<"
			+ element.toString() + ">");

}	
}
