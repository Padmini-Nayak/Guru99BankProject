package login;

import org.testng.annotations.Test;


import util.Util;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LogInTest {

	WebDriver driver;

	@Test
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserId("mngr463116");
		loginPage.enterPassword("atAhama");
		loginPage.clickLogin();
		System.out.println(driver.getTitle());
		Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
		}

	@BeforeClass
	public void beforeClass() {
		ProfilesIni profile = new ProfilesIni();
		//FirefoxProfile myprofile = profile.getProfile("PadminiFireFoxProfile");
		System.setProperty("windows.firefox.driver", Util.Driver_Location);
		driver = new FirefoxDriver();

		driver.get(Util.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
