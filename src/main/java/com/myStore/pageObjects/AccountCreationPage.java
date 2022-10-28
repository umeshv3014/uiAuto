package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement formTitle;

	public boolean isFormTitleDisplayed() throws Throwable {
		return Action.isDisplayed(getDriver(), formTitle);
	}

}
