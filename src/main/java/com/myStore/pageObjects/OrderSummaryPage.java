package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class OrderSummaryPage extends BaseClass {

	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement iConfirmMyOrder;

	public OrderConfirmationPage clickToConfirmOrder() throws Throwable {
		Action.click(getDriver(), iConfirmMyOrder);

		return new OrderConfirmationPage();
	}

}
