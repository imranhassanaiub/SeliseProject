package com.selise.SeliseProject.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selise.SeliseProject.DataProvider.AssignLeaveDataProvider;
import com.selise.SeliseProject.DataTransferObject.AssignLeaveDTO;
import com.selise.SeliseProject.Utilities.DriverManager;
import com.selise.SeliseProject.Utilities.TestNGReporting;
import com.selise.SeliseProject.Utilities.UrlTextUtils;
import com.selise.SeliseProject.Utilities.XpathUtils;

@Listeners(TestNGReporting.class)
public class AssignLeaveTest {
	private WebDriver driver = null;

	@Test
	public void AssignLeavePage() {
		driver = DriverManager.driver;
		driver.get(UrlTextUtils.URL.AssignLeavePageURL);
	}

	@Test(dependsOnMethods = "AssignLeavePage", dataProvider = "assignleaveData", dataProviderClass = AssignLeaveDataProvider.class)
	public void assignleavetest(List<AssignLeaveDTO> assleavdata) {
		for (AssignLeaveDTO assignleave : assleavdata) {

			driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.EmployeeName))
					.sendKeys(assignleave.getEmployeename());
			Select leavetype = new Select(driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.LeaveType)));
			leavetype.selectByVisibleText(assignleave.getLeavetype());
			driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.Fromdate)).click();
			WebDriverWait wait = new WebDriverWait(driver, null);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.AssignLeaveModule.FromDateMonth)));
			Select frdamo = new Select(driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.FromDateMonth)));
			frdamo.selectByVisibleText(assignleave.getFromdatemonth());
			Select frday = new Select(driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.FromDateYear)));
			frday.selectByVisibleText(assignleave.getFromdateyear());

			WebElement dateWidget = driver.findElement(By.className("ui-datepicker-calendar"));
			List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

			for (WebElement cell : columns) {
				// Select From Date
				if (cell.getText().equals(assignleave.getFromdatedate())) {
					cell.findElement(By.linkText(assignleave.getFromdatedate())).click();
					break;
				}
			}
			driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.Todate)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.AssignLeaveModule.ToDateMonth)));
			Select todamo = new Select(driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.ToDateMonth)));
			todamo.selectByVisibleText(assignleave.getTodatemonth());
			Select today = new Select(driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.TomDateYear)));
			today.selectByVisibleText(assignleave.getTodateyear());
			WebElement dateWidget2 = driver.findElement(By.className("ui-datepicker-calendar"));
			List<WebElement> columns2 = dateWidget2.findElements(By.tagName("td"));
			for (WebElement cell : columns2) {
				// Select To Date
				if (cell.getText().equals(assignleave.getTodatedate())) {
					cell.findElement(By.linkText(assignleave.getTodatedate())).click();
					break;
				}
			}
			driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.Comment)).sendKeys(assignleave.getComment());
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.AssignLeaveModule.AssignButton)));
			driver.findElement(By.xpath(XpathUtils.AssignLeaveModule.AssignButton)).click();

		}
	}
}
