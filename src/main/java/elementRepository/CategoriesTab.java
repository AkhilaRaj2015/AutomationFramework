package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class CategoriesTab {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();// obj of utility(common-method)
	ExplicitWait wait = new ExplicitWait();

	public CategoriesTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@id='1-selectable']")
	WebElement selGroups;

	@FindBy(xpath = "//div[@class='ms-selection']")
	WebElement selGroupsTextArea;

	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//li[@id='82-selectable']")
	WebElement item1;

	@FindBy(xpath = "//li[@id='95-selectable']")
	WebElement item2;

	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryTextfield;

	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement radiobuttonYesShowOnTopMenu;

	@FindBy(xpath = "(//input[@type='radio'])[4]")
	WebElement radiobuttonNoShowOnLeftMenu;

	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	WebElement CategoryAlert;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileBtn;

	@FindBy(xpath = "(//table[@class ='table table-bordered table-hover table-sm']//tbody//tr)//td[2]")
	WebElement listCategoriesTable;

	public void clickCancelButton(String parameter) throws InterruptedException {
		wait.waitElementClickable(driver, cancelBtn);
		gu.mediumDelay();
		gu.addScrolling(driver, parameter);
		gu.clickOnElement(cancelBtn);
	}

	public List<String> selectedList() {
		// System.out.println(gu.selectedItems(driver,
		// "//div[@class='ms-selection']/ul/li"));
		// System.out.println(gu.selectedItems(driver,
		// "//div[@class='ms-selection']//li//span[text()='GOLDEN VALLY' or
		// text()='PetFoods']"));
		return gu.selectedItems(driver,
				"//div[@class='ms-selection']//li//span[text()='GOLDEN VALLY' or text()='PetFoods']");
	}

	public boolean compareSelectedItems(List<String> list, String item1, String item2) {
		return gu.verifyTextOfStringList(list, item1, item2);
	}

	public void selectItem1SelectGroups() {
		gu.clickOnElement(item1);
	}

	public void selectItem2SelectGroups() {
		gu.clickOnElement(item2);
	}

	public String getItem1SelectedText() {
		return gu.getElementText(item1);
	}

	public String getItem2SelectedText() {
		return gu.getElementText(item2);
	}

	public void inputCategory(String txt) {
		gu.inputDataToTextfield(categoryTextfield, txt);
	}

	public void clickSaveButton(String parameter) throws InterruptedException {
		wait.waitElementClickable(driver, saveButton);
		gu.mediumDelay();
		gu.addScrolling(driver, parameter);
		gu.clickOnElement(saveButton);
	}

	public String getCurrentpageTitle() {
		return gu.getCurrentTitle(driver);
	}

	public void selectYesShowOnTopMenuRadioBtn(String parameter) throws InterruptedException {
		gu.mediumDelay();
		gu.addScrolling(driver, parameter);
		gu.clickOnElement(radiobuttonYesShowOnTopMenu);
	}

	public void selectNoShowOnLeftMenuRadioBtn(String parameter) throws InterruptedException {
		gu.mediumDelay();
		gu.addScrolling(driver, parameter);
		gu.clickOnElement(radiobuttonNoShowOnLeftMenu);
	}

	public String addcategoryAlertText() {
		wait.waitAlertElement(driver);
		return gu.getAlertText(driver);
	}

	public void dismissActionSaveButtonAlert() {
		gu.dismissAlert(driver);
	}

	public String getCategorySaveAlertText() {
		return gu.getElementText(CategoryAlert);
	}

	public void fileUploadCategory(String path) throws AWTException {

		gu.uploadFile(driver, chooseFileBtn, path);
	}

	public String getCategoryFieldText() {
		return gu.getElementText(categoryTextfield);
	}

	public List<String> getCategoriesListText() {
		// System.out.println( gu.selectedItems(driver,"(//table[@class ='table
		// table-bordered table-hover table-sm']//tbody//tr)//td[1]"));
		return gu.selectedItems(driver,
				"(//table[@class ='table table-bordered table-hover table-sm']//tbody//tr)//td[1]");
	}

	public boolean compareCategoryListItems(List<String> list, String text) {
		return gu.verifyStringListText(list, text);
	}

}
