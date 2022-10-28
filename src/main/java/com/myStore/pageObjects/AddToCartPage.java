package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement sucessMsg;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedToCheckoutBtn;

	public void addQuantity(String qty) throws Throwable {
		Action.type(quantity, qty);
	}

	public int getQuantity() throws Throwable {
		return Integer.parseInt(Action.getText(quantity));
	}

	public void selectSize(String sizeToSelect) throws Throwable {
		Action.selectByVisibleText(getDriver(), size, sizeToSelect);
	}

	public void clickOnAddToCart() throws Throwable {
		Action.click(getDriver(), addToCart);
		Action.fluentWait(getDriver(), sucessMsg, 20);
	}

	public boolean addToSuccessMsgDisplayed() throws Throwable {
		Action.fluentWait(getDriver(), sucessMsg, 20);
		return Action.isDisplayed(getDriver(), sucessMsg);
	}

	public OrderPage proceedToCheckOut() throws Throwable {
		Thread.sleep(20);
		Action.click(getDriver(), proceedToCheckoutBtn);
		return new OrderPage();
	}

}
