package com.myStore.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import com.myStore.utility.Log;

public class LoginPageTest extends BaseClass {
	private WebDriver driver;
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod(groups = { "smoke", "sanity", "regression" })
	@Parameters("browser")
	public void loginTestCase(String browser) throws Throwable {
		Log.startTestCase("loginTestCase");
		launchApp(browser);
	}

	@AfterMethod(groups = { "smoke", "sanity", "regression" })
	public void close() {
		getDriver().close();
		Log.endTestCase("loginTestCase");
	}

	@Test(groups = { "smoke", "sanity" })
	public void loginTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSingIn();
		Log.info("Entering user name and password");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("verifying the logined page");
		String actualUrl = homePage.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		AssertJUnit.assertEquals(actualUrl, expectedUrl);
	}

}
