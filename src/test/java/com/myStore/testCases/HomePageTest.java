package com.myStore.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;

public class HomePageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod(groups = { "smoke", "sanity", "regression" })
	@Parameters("browser")
	public void setup(String browser) throws Throwable {
		launchApp(browser);
	}

	@AfterMethod(groups = { "smoke", "sanity", "regression" })
	public void close() {
		getDriver().close();
	}

	@Test(groups = "smoke")
	public void wishListTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSingIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.validateMyWishlist());
	}

	@Test(groups = "smoke")
	public void validateOrdersHistoryTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSingIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.validateOrdersHistory());
	}
}
