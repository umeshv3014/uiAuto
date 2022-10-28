package com.myStore.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AddToCartPage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@BeforeMethod(groups = {"smoke","sanity","regression"})
	@Parameters("browser")
	public void setup() throws Throwable {
		launchApp("browser");
	}

	@AfterMethod(groups = { "smoke", "sanity", "regression" })
	public void close() {
		getDriver().close();
	}

	@Test(groups = { "smoke", "regression" })
	public void addToCartTest() throws Throwable {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.addQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		Assert.assertTrue(addToCartPage.addToSuccessMsgDisplayed());
	}

}
