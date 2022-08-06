package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ListCategories {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ListCategories(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newBtn;

	public void clickNewBtn() {
		gu.clickOnElement(newBtn);
	}

}
