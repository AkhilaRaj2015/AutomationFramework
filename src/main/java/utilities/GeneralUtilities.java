package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementTagname(WebElement element) {
		String text = element.getTagName();
		return text;
	}

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getElementCssValue(WebElement element, String cssattribute) {
		String text = element.getCssValue(cssattribute);
		return text;
	}

	public String getElementAttribute(WebElement element, String attributevalue) {
		String text = element.getAttribute(attributevalue);
		return text;
	}

	public boolean isElementDisplayed(WebElement element) {
		boolean isBoolean = element.isDisplayed();
		return isBoolean;
	}

	public void mediumDelay() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void inputDataToTextfield(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public String selectDropDownValue(WebElement element, String txtvalue) {
		Select s = new Select(element);
		s.selectByVisibleText(txtvalue);
		WebElement selValue = s.getFirstSelectedOption();
		return (selValue.getText());
	}

	public boolean isElementSelected(WebElement element) {
		boolean isBoolean = element.isSelected();
		return isBoolean;
	}

	public boolean isElementDeSelected(WebElement element) {
		boolean isBoolean = isElementDeSelected(element);
		return isBoolean;
	}

	public String getToolTipValue(WebElement element) {
		String tooltipValue = element.getAttribute("data-original-title");
		return tooltipValue;
	}

	public void uploadFile(WebDriver driver, WebElement element, String path) throws AWTException {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();
		robot.delay(250);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getCurrentTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public List<String> selectedItems(WebDriver driver, String xpath) {
		List<WebElement> allElements = driver.findElements(By.xpath(xpath));
		List<String> list = new ArrayList<String>();
		for (WebElement element : allElements) {

			list.add(element.getText());
		}
		return list;
	}

	public void mediumWait() throws InterruptedException {
		Thread.sleep(5000);
	}

	public boolean verifyTextOfStringList(List<String> list, String item1, String item2) {
		boolean actual = true;
		for (String str : list) {
			if ((!str.equals(item1)) || (!str.equals(item2))) {
				actual = false;
				break;
			}
		}
		return actual;
	}

	public String getAlertText(WebDriver driver) {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public boolean verifyStringListText(List<String> list, String text) {
		boolean actual = true;
		for (String str : list) {
			if (!str.equals(text)) {
				actual = false;
				break;
			}
		}
		return actual;
	}

	public void addScrolling(WebDriver driver, String parameter) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(parameter);
	}

	public void clearElement(WebElement element) {
		element.clear();
	}

	public boolean verifyStringComparisonList(List<String> list, String text) {
		boolean actual = false;
		for (String str : list) {
			if (str.equals(text)) {
				actual = true;
				break;
			}
		}
		return actual;
	}
}
