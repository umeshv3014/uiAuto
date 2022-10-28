package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class IndexPage extends BaseClass{

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;

	@FindBy(id = "search_query_top")
	WebElement searchProductTextBox;

	@FindBy(name = "submit_search")
	WebElement submitsearch;

	public LoginPage clickOnSingIn() throws Throwable {
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(getDriver(), logo);
	}

	public String getMyStoreTitle() {
		return getDriver().getTitle();
	}

	public SearchResultPage searchProduct(String productToSearch) throws Throwable {
		Action.type(searchProductTextBox, productToSearch);
		Action.click(getDriver(), submitsearch);
		return new SearchResultPage();
	}

}
