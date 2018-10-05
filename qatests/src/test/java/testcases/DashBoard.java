package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestDriver;
import java.io.IOException;
import java.util.Calendar;
import page.HomePage;

public class DashBoard extends TestDriver {
	public Calendar cal;
	public String uniq_code;
	HomePage login = new HomePage();

	@Test
	public void validate_page1_has_hello() throws IOException, InterruptedException {

		Assert.assertTrue(driver.getPageSource().contains("Hello"), "Page doesn't contain Hello");

	}

	@Test
	public void validate_page2_sums_as_expected() throws IOException, InterruptedException {
		driver.findElement(By.linkText("Page 2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.sum_button));
		driver.findElement(login.input1).sendKeys("2");
		driver.findElement(login.input2).sendKeys("3");

		driver.findElement(login.sum_button).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.textmsg));
		Assert.assertTrue(driver.getPageSource().contains("Sum of the above two numbers is"));

	}
	
	@Test
	public void validate_page2_accepts_only_numbers() throws IOException, InterruptedException {
		driver.findElement(By.linkText("Page 2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.sum_button));
		driver.findElement(login.input1).sendKeys("a");
		driver.findElement(login.input2).sendKeys("3");
		driver.findElement(login.sum_button).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.textmsg));
	    Assert.assertTrue(driver.getPageSource().contains("Please enter only numbers"));

	}

}
