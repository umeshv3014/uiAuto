package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement myWishlist;

	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement Orders;

	public boolean validateMyWishlist() throws Throwable {
		return Action.isDisplayed(getDriver(), myWishlist);
	}

	public boolean validateOrdersHistory() throws Throwable {
		return Action.isDisplayed(getDriver(), Orders);
	}

	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

}
