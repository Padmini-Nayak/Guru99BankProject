package login;

import org.openqa.selenium.WebDriver;

import util.Util;

public class LoginPage {
	WebDriver driver;
	

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUserId(String userId) {
		driver.findElement(Util.userId).sendKeys(userId);
	}
	public void enterPassword(String password) {
		driver.findElement(Util.password).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(Util.password).click();
	}
	public void clickReset() {
		driver.findElement(Util.resetButton).click();
	}
	
}
