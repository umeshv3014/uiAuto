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
import com.myStore.pageObjects.AddressPage;
import com.myStore.pageObjects.IndexPage;
import com.myStore.pageObjects.LoginPage;
import com.myStore.pageObjects.OrderConfirmationPage;
import com.myStore.pageObjects.OrderPage;
import com.myStore.pageObjects.OrderSummaryPage;
import com.myStore.pageObjects.PaymentPage;
import com.myStore.pageObjects.SearchResultPage;
import com.myStore.pageObjects.ShippingPage;

public class EndToEndTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;

	@BeforeMethod(groups = {"smoke","sanity","regression"})
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
		loginPage = orderPage.clickToCheckOut();
		addressPage = loginPage.loginToAddress(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.clickToproceedToCheckout();
		shippingPage.acceptTandC();
		paymentPage = shippingPage.clickToCheckOut();
		orderSummaryPage = paymentPage.clickToPayByBankWire();
		orderConfirmationPage = orderSummaryPage.clickToConfirmOrder();
		String actual = orderConfirmationPage.verifyOrderSuccessMsg();
		String expected = "Your order on My Store is complete.";
		AssertJUnit.assertEquals(actual, expected);

	}

}
