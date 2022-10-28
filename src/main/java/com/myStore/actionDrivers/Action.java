package com.myStore.actionDrivers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myStore.base.BaseClass;
import com.myStore.utility.Log;

public class Action extends BaseClass {

	public void scrollByVisibilityOfElement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public static void click(WebDriver ldriver, WebElement locatorName) throws Throwable {

		Actions act = new Actions(ldriver);
		// act.moveToElement(ldriver.findElement(locatorName)).click().build().perform();
		act.moveToElement(locatorName).click().build().perform();

	}

	public static void implicitlyWait(WebDriver ldriver) throws Throwable {

		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean findElement(WebDriver ldriver, WebElement locatorName) throws Throwable {
		boolean flag = false;
		try {
			locatorName.isDisplayed();
			flag = true;
		} catch (Exception e) {
			Log.error(e.getMessage());
			flag = false;
		} finally {
			if (flag) {
				Log.info("Successfully Found element at");

			} else {
				Log.info("Unable to locate element at");
			}
		}
		return flag;
	}

	public static boolean isDisplayed(WebDriver ldriver, WebElement locator) throws Throwable {
		boolean flag = false;
		flag = findElement(ldriver, locator);
		if (flag) {
			flag = locator.isDisplayed();
			if (flag) {
				Log.info("The element is Displayed");
			} else {
				Log.info("The element is not Displayed");
			}
		} else {
			Log.info("Not displayed " + locator);
		}
		return flag;
	}

	public static void selectByVisibleText(WebDriver driver, WebElement locator, String textToSelect) throws Throwable {
		Select select = new Select(locator);
		select.selectByVisibleText(textToSelect);
	}

	public static boolean isSelected(WebDriver ldriver, WebElement locator) throws Throwable {
		boolean flag = false;
		flag = findElement(ldriver, locator);
		if (flag) {
			flag = locator.isSelected();
			if (flag) {
				System.out.println("The element is Selected");
			} else {
				System.out.println("The element is not Selected");
			}
		} else {
			System.out.println("Not selected " + locator);
		}
		return flag;
	}

	public static boolean isEnabled(WebDriver ldriver, WebElement locator) throws Throwable {
		boolean flag = false;
		flag = findElement(ldriver, locator);
		if (flag) {
			flag = locator.isEnabled();
			if (flag) {
				System.out.println("The element is Enabled");
			} else {
				System.out.println("The element is not Enabled");
			}
		} else {
			System.out.println("Not Enabled " + locator);
		}
		return flag;
	}

	/**
	 * Type text at location
	 * 
	 * @param locatorName
	 * @param text
	 * @return - true/false
	 * @throws Throwable
	 */
	public static boolean type(WebElement locator, String text) throws Throwable {
		boolean flag = false;
		try {
			flag = locator.isDisplayed();
			locator.clear();
			locator.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			Log.error("Location Not found: " + locator);
			flag = false;
		} finally {
			if (flag) {
				Log.info("Successfully entered value at: \"" + locator + "\"");
			} else {
				Log.info("Unable to enter value at: \"" + locator + "\"");
			}

		}
		return flag;
	}

	public static String getText(WebElement locator) throws Throwable {
		String text = "";
		try {
			text = locator.getText();
		} catch (Exception e) {
			Log.error("Location Not found: " + locator);
		}
		return text;
	}

	public static boolean selectBySendkeys(By locator, String value, String locatorName) throws Throwable {

		boolean flag = false;
		try {
			((WebElement) locator).sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				Log.info("Element Selected by SenKeys");
			} else {
				Log.info("Element not Selected by SenKeys");
				// throw new ElementNotFoundException("", "", "")
			}
		}
	}

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */
	public boolean selectByIndex(By locator, int index, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(BaseClass.getDriver().findElement(locator));
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				Log.info("Option selected by Index");
			} else {
				Log.info("Option not selected by Index");
			}
		}
	}

	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	public boolean selectByValue(By locator, String value, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(BaseClass.getDriver().findElement(locator));
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {
			Log.error(e.getMessage());
			return false;
		} finally {
			if (flag) {
				Log.info("Option selected by Value");
			} else {
				Log.info("Option not selected by Value");
			}
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	public boolean selectByVisibleText(By locator, String visibletext, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(BaseClass.getDriver().findElement(locator));
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				Log.info("Option selected by VisibleText");
			} else {
				Log.info("Option not selected by VisibleText");
			}
		}
	}

	public static boolean mouseHoverByJavaScript(WebDriver driver, WebElement locator) throws Throwable {
		boolean flag = false;
		try {
			WebElement mo = locator;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				Log.info("MouseOver Action is performed");
			} else {
				Log.info("MouseOver Action is not performed");
			}
		}
	}

	public static boolean JSClick(WebDriver driver, WebElement locator) throws Throwable {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", locator);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				Log.info("Click Action is performed");
			} else if (!flag) {
				Log.info("Click Action is not performed");
			}
		}
		return flag;
	}

	public boolean switchToFrameByIndex(int index) throws Throwable {
		boolean flag = false;
		try {
			new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			BaseClass.getDriver().switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {
			Log.error(e.getMessage());
			return false;
		} finally {
			if (flag) {
				Log.info("Frame with index \"" + index + "\" is selected");
			} else {
				Log.info("Frame with index \"" + index + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */
	public boolean switchToFrameById(String idValue) throws Throwable {
		boolean flag = false;
		try {
			BaseClass.getDriver().switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {
			Log.error(e.getMessage());
			return false;
		} finally {
			if (flag) {
				Log.info("Frame with Id \"" + idValue + "\" is selected");
			} else {
				Log.info("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * 
	 */
	public boolean switchToFrameByName(String nameValue) throws Throwable {
		boolean flag = false;
		try {
			BaseClass.getDriver().switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {
			Log.error(e.getMessage());
			return false;
		} finally {
			if (flag) {
				Log.info("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				Log.info("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}

	public boolean switchToDefaultFrame() throws Throwable {
		boolean flag = false;
		try {
			BaseClass.getDriver().switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			Log.error(e.getMessage());
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!flag) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}

	public static void mouseOverElement(WebDriver driver, WebElement element) throws Throwable {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			Log.error(e.getMessage());
		} finally {
			if (flag) {
				Log.info(" MouserOver Action is performed on ");
			} else {
				Log.info("MouseOver action is not performed on");
			}
		}
	}

	public boolean moveToElement(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", locator);
			Actions actions = new Actions(BaseClass.getDriver());
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(locator).build().perform();
			flag = true;
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		return flag;
	}

	public boolean mouseover(WebElement locator, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			WebElement mo = locator;
			new Actions(BaseClass.getDriver()).moveToElement(mo).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
		}
	}

	public String screenShot(String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenShots/" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;
	}

	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

}