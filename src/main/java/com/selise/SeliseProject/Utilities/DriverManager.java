package com.selise.SeliseProject.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	static {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Files\\chromedriver_win32\\chromedriver.exe");
	}
	public static WebDriver driver = new ChromeDriver();

	private DriverManager() {

	}

}
