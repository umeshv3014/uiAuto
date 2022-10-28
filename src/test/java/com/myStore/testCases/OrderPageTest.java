package com.myStore.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.AddToCartPage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.OrderPage;
import com.myStore.pageObjects.SearchResultPage;

public class OrderPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

	@BeforeMethod(groups = { "smoke", "sanity", "regression" })
	@Parameters("browser")
	public void setup(String browser) throws Throwable {
		launchApp(browser);
	}

	@AfterMethod(groups = { "smoke", "sanity", "regression" })
	public void close() {
		getDriver().close();
	}

	@Test(groups = "regression")
	public void addToCartTest() throws Throwable {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.addQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.proceedToCheckOut();
		double unitPrice = orderPage.getUnitPrice();
		double totalPrice = orderPage.getTotalPrice();
		double totalUnitPrice = (unitPrice * 2) + 2;
		System.out.println(totalPrice + " " + totalUnitPrice);
		AssertJUnit.assertEquals(totalUnitPrice, totalPrice);

	}

}
