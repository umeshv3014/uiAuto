package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class AddressPage extends BaseClass{

	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;

	public ShippingPage clickToproceedToCheckout() throws Throwable {
		Action.click(getDriver(), proceedToCheckOut);

		return new ShippingPage();
	}
}
