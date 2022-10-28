package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class PaymentPage extends BaseClass {

	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	WebElement PayByBankWire;

	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	WebElement PayByCheck;

	public OrderSummaryPage clickToPayByBankWire() throws Throwable {
		Action.click(getDriver(), PayByBankWire);

		return new OrderSummaryPage();
	}

	public OrderSummaryPage clickToPayByCheck() throws Throwable {
		Action.click(getDriver(), PayByBankWire);
		return new OrderSummaryPage();
	}

}
