package com.myStore.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AccountCreationPage;
import com.myStore.pageObjects.HomePage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import com.myStore.pageObjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AccountCreationPage accountCreationPage;

	@BeforeMethod(groups = { "smoke", "sanity", "regression" })
	@Parameters("browser")
	public void setup(String browser) throws Throwable {
		launchApp(browser);
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = "smoke")
	public void validateProductDisplayed() throws Throwable {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		AssertJUnit.assertTrue(searchResultPage.isProductAvailable());
	}

}
