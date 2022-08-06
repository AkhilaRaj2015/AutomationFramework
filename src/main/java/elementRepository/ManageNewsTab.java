package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageNewsTab {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait wait = new ExplicitWait();

	public ManageNewsTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement actionEditBtn;

	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsTextArea;

	@FindBy(xpath = "//button[@name='update']")
	WebElement updateBtn;
	
	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[1]")
	WebElement actionDeleteBtn;
	
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	WebElement logoutBtn;

	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement brandIcon;

	public void clickactionEditButton() {
		gu.clickOnElement(actionEditBtn);
	}
		
	public void inputNewsTextArea(String txt) {
		gu.inputDataToTextfield(newsTextArea, txt);
	}

	public void clickUpdateButtononEnteringNewsInformation() throws InterruptedException {
		gu.mediumDelay();
		gu.clickOnElement(updateBtn);
	}

	public void clearNewstextArea() {
		gu.clearElement(newsTextArea);
	}

	public List<String> getManageNewsListText() {
		System.out.println( gu.selectedItems(driver,"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		return gu.selectedItems(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]");
	}

	public boolean compareNewsItems(List<String> listtext, String text) {
		return gu.verifyStringComparisonList(listtext, text);
	}
	
	public void clickActionDeleteButton() {
		gu.clickOnElement(actionDeleteBtn);
	}
	
	public String getActionDeleteButtonAlertText() {
		wait.waitAlertElement(driver);
		return gu.getAlertText(driver);
	}
	
	public void acceptNewsDeleteAlert() {
		gu.acceptAlert(driver);
	}
	
	public void clickLogOutButton(String parameter) throws InterruptedException {
		gu.mediumWait();
		gu.addScrolling(driver, parameter);
		gu.clickOnElement(logoutBtn);
	}
	
	public boolean isDisplayedBrandIconLoginPage() {
		return gu.isElementDisplayed(brandIcon);

	}

}
