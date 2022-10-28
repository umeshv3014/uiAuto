package com.myStore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}


	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]//img")
	WebElement productResult;

	public boolean isProductAvailable() throws Throwable {
		return Action.isDisplayed(getDriver(), productResult);
	}

	public AddToCartPage clickOnProduct() throws Throwable {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}

}
