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

public class AccountCreationPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;

	@BeforeMethod(groups = { "smoke", "sanity", "regression" })
	@Parameters("browser")
	public void setup() throws Throwable {
		launchApp("browser");
	}

	@AfterMethod(groups = { "smoke", "sanity", "regression" })
	public void close() {
		getDriver().close();
	}

	@Test(groups = "sanity")
	public void verifyAccountCreationPage() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSingIn();
		accountCreationPage = loginPage.createNewAccount("bhia@gmail.com");
		AssertJUnit.assertTrue(accountCreationPage.isFormTitleDisplayed());
	}
}
