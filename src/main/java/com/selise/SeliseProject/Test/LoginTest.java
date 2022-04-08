package com.selise.SeliseProject.Test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selise.SeliseProject.DataProvider.LoginDataProvider;
import com.selise.SeliseProject.DataTransferObject.LoginDTO;
import com.selise.SeliseProject.Utilities.DriverManager;
import com.selise.SeliseProject.Utilities.TestNGReporting;
import com.selise.SeliseProject.Utilities.UrlTextUtils;
import com.selise.SeliseProject.Utilities.XpathUtils;

@Listeners(TestNGReporting.class)
public class LoginTest {

	Logger log = LogManager.getLogger(LoginTest.class.getName());
	private WebDriver driver = null;

	@Test
	public void CheckLoginPageTitle() {
		driver = DriverManager.driver;
		driver.get(UrlTextUtils.URL.Base_URL);
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.TEXT.HomePageTitle);
		System.out.println("Landing Page Title Verified");
	}

	@Test(dependsOnMethods = "CheckLoginPageTitle", dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void Logintest(List<LoginDTO> logdata) {
		for (LoginDTO login : logdata) {

			driver.findElement(By.xpath(XpathUtils.LoginModule.Username)).sendKeys(login.getUsername());
			driver.findElement(By.xpath(XpathUtils.LoginModule.Password)).sendKeys(login.getPassword());
			driver.findElement(By.xpath(XpathUtils.LoginModule.LoginBTN)).click();
            log.debug("Invalid credentials");
		}

	}

}
