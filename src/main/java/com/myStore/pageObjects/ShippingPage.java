package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class ShippingPage extends BaseClass{

	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(id = "cgv")
	WebElement TermsOfService;

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement proceedToCheckOut;

	public void acceptTandC() throws Throwable {
		Action.click(getDriver(), TermsOfService);
	}

	public PaymentPage clickToCheckOut() throws Throwable {
		Action.click(getDriver(), proceedToCheckOut);
		return new PaymentPage();
	}

}
