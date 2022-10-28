package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//p/strong[@class='dark']")
	WebElement orderSuccessMsg;

	public String verifyOrderSuccessMsg() throws Throwable {
		return Action.getText(orderSuccessMsg);
	}
}
