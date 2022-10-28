package com.myStore.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myStore.base.BaseClass;
import com.myStore.pageObjects.IndexPage;

public class IndexPageTest extends BaseClass {
	public IndexPage ip;

	@BeforeMethod(groups = { "smoke", "sanity", "regression" })
	@Parameters("browser")
	public void setup(String browser) throws Throwable {
		launchApp(browser);
	}

	@AfterMethod(groups = { "smoke", "sanity", "regression" })
	public void close() {
		getDriver().close();
	}

	@Test(groups = "smoke")
	public void verifyLogo() throws Throwable {
		ip = new IndexPage();
		AssertJUnit.assertTrue(ip.validateLogo());
	}

	@Test(groups = "smoke")
	public void verifyTitle() throws Throwable {
		ip = new IndexPage();
		AssertJUnit.assertEquals(ip.getMyStoreTitle(), "My Store");
	}

}
