package com.myStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStore.actionDrivers.Action;
import com.myStore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "SubmitLogin")
	WebElement SubmitLogin;

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement email_create;

	@FindBy(id = "SubmitCreate")
	WebElement SubmitCreate;
	
	public HomePage login(String userName, String password) throws Throwable {
		Action.type(email, userName);
		Action.type(passwd, password);
		Action.click(getDriver(), SubmitLogin);
		return new HomePage();
	}
	
	public AddressPage loginToAddress(String userName, String password) throws Throwable {
		Action.type(email, userName);
		Action.type(passwd, password);
		Action.click(getDriver(), SubmitLogin);
		return new AddressPage();
	}
	
	
	public AccountCreationPage createNewAccount(String email) throws Throwable {
		Action.type(email_create, email);
		Action.click(getDriver(), SubmitCreate);
		return new AccountCreationPage();
	}
	
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

}
