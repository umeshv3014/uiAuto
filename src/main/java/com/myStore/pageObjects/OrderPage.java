package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class OrderPage extends BaseClass {

	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//td[@class='cart_unit']//span/span")
	WebElement unitPrice;

	@FindBy(id = "total_price")
	WebElement totalPrice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;

	public double getUnitPrice() throws Throwable {
		return Double.parseDouble(Action.getText(unitPrice).replaceAll("[^a-zA-Z0-9.]", ""));
	}

	public double getTotalPrice() throws Throwable {
		return Double.parseDouble(Action.getText(totalPrice).replaceAll("[^a-zA-Z0-9.]", ""));
	}

	public LoginPage clickToCheckOut() throws Throwable {
		Action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
}
