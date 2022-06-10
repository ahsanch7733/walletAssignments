package wallet.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wallet.base.BaseClass;

public class FacebookPage extends BaseClass {

	@FindBy(id = "email") WebElement emailKey;
	@FindBy(id = "pass") WebElement passKey;
	@FindBy(name = "login") WebElement loginBtn;
	@FindBy(xpath ="//*[contains(text(), \"What's on your mind\")]") WebElement postMsg;
	@FindBy(xpath = "//*[contains(@aria-label, \"What's on your mind\")]") WebElement status;
	@FindBy(xpath="//*[contains(@aria-label, \"Post\")]") WebElement post;
	
	
	
	public FacebookPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginFB(String email, String password) {
		sendKeysToWebElement(emailKey, email);
		sendKeysToWebElement(passKey, password);
		waitAndClickElement(loginBtn);
		
	}
	public void postMessage() {
		waitAndClickElement(postMsg);
		sendKeysToWebElement(emailKey,"hello world");
		waitAndClickElement(post);
		
		
	}
}
