package elementRepository;

import java.awt.AWTException;
import java.awt.Color;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageProductTab {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait wait = new ExplicitWait();

	public ManageProductTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newBtn;

	@FindBy(xpath = "//input[@id='title']")
	WebElement titleTxtfield;

	@FindBy(xpath = "//input[@id='w_mrp']")
	WebElement mrpTxtfield;

	@FindBy(xpath = "//input[@value='Nonveg']")
	WebElement nonvegRadioBtn;

	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryDropDown;

	@FindBy(xpath = "//select[@id='sub_id']")
	WebElement subCategoryDropDown;

	@FindBy(xpath = "(//button[@class='note-btn btn btn-light btn-sm dropdown-toggle'])[1]")
	WebElement descriptionLabel1;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement unLtdStockChckBox;

	@FindBy(xpath = "(//span[text()='Unlimited'])[1]")
	WebElement UnlimitedStockBtn;

	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[2]")
	WebElement actionDeleteBtn;

	@FindBy(xpath = "//input[@value='piece']")
	WebElement pieceRadioBtn;

	@FindBy(xpath = "//select[@id='p_minimum']")
	WebElement minimumPieceDrpDown;

	@FindBy(xpath = "//input[@id='p_max']")
	WebElement maxQtyCanOrderTxtField;

	@FindBy(xpath = "//input[@id='p_price']")
	WebElement priceTxtField;

	@FindBy(xpath = "//input[@id='p_stock']")
	WebElement stkAvailabilityTxtField;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefileBtn1;

	@FindBy(xpath = "(//input[@name='stock'])[2]")
	WebElement stockRadioBtn;

	@FindBy(xpath = "(//input[@name='featured'])[2]")
	WebElement featuredRadioBtn;

	@FindBy(xpath = "(//input[@name='combo'])[1]")
	WebElement comboPackRadioBtn;

	@FindBy(xpath = "//button[@name='create']")
	WebElement saveBtn;

	public void clickNewBtn() {
		gu.clickOnElement(newBtn);
	}

	public String getTitleTextfieldAttributeValue(String value) {
		return gu.getElementAttribute(titleTxtfield, value);
	}

	public String getBackGroundColorNewBtn(String attribute) {
		return gu.getElementCssValue(newBtn, attribute);
	}

	public void clicknonVegRadioButton() {
		gu.clickOnElement(nonvegRadioBtn);
	}

	public boolean isSelectedNonVegRadioButton() {
		return gu.isElementSelected(nonvegRadioBtn);
	}

	public String selectCategoryDropDown(String value) throws InterruptedException {
		wait.waitElement(driver, "//select[@id='cat_id']");
		gu.mediumDelay();
		return gu.selectDropDownValue(categoryDropDown, value);
	}

	public String selectSubCategoryDropDown(String value) throws InterruptedException {
		gu.mediumDelay();
		return gu.selectDropDownValue(subCategoryDropDown, value);
	}

	public String getDesLabel1ToolTipValue() {
		return gu.getToolTipValue(descriptionLabel1);
	}

	public boolean isSelectedUnlimitedStockCheckbox() {
		return gu.isElementSelected(unLtdStockChckBox);
	}

	public String getMRPTextfieldAttributeValue(String value) {
		return gu.getElementAttribute(mrpTxtfield, value);
	}

	public void clickUnlimitedStockCheckbox(String parameter) throws InterruptedException {
		wait.waitElementClickable(driver, unLtdStockChckBox);
		gu.mediumDelay();
		gu.addScrolling(driver, parameter);
		gu.clickOnElement(unLtdStockChckBox);
	}

	public String getUnlimitedStockButtonFontSize(String value) {
		return gu.getElementCssValue(UnlimitedStockBtn, value);
	}

	public void clickActionDeleteButton() {
		gu.clickOnElement(actionDeleteBtn);
	}

	public String getActionDeleteButtonAlertText() {
		return gu.getAlertText(driver);
	}

	public void dismissActionDeleteBtnAlert() {
		gu.dismissAlert(driver);
	}

	public void inputTitle(String txt) {
		gu.inputDataToTextfield(titleTxtfield, txt);
	}

	public void clickPieceRadioButton() {
		gu.clickOnElement(pieceRadioBtn);
	}

	public String selectMinimumPieceDropDown(String value) {
		return gu.selectDropDownValue(minimumPieceDrpDown, value);
	}

	public void inputMaxQtyCanOrder(String txt) {
		gu.inputDataToTextfield(maxQtyCanOrderTxtField, txt);
	}

	public void inputPrice(String txt) {
		gu.inputDataToTextfield(priceTxtField, txt);
	}

	public void inputStockAvailability(String txt) {
		gu.inputDataToTextfield(stkAvailabilityTxtField, txt);
	}

	public void chooseImage1(String path, String parameter) throws AWTException, InterruptedException {
		wait.waitElement(driver, "//input[@id='main_img']");
		gu.mediumWait();
		gu.addScrolling(driver, parameter);
		gu.uploadFile(driver, choosefileBtn1, path);
	}

	public void clickStockRadioButton(String parameter) throws InterruptedException {
		wait.waitElement(driver, "(//input[@name='stock'])[2]");
		gu.mediumWait();
		gu.addScrolling(driver, parameter);
		Actions action = new Actions(driver);
		action.moveToElement(stockRadioBtn).click().perform();
		// gu.clickOnElement(stockRadioBtn);
	}

	public void clickfeaturedRadioButton(String parameter) throws InterruptedException {
		wait.waitElementClickable(driver, featuredRadioBtn);
		gu.mediumDelay();
		gu.addScrolling(driver, parameter);
		gu.clickOnElement(featuredRadioBtn);
	}

	public void clickcomboPackRadioButton(String parameter) throws InterruptedException {
		wait.waitElementClickable(driver, comboPackRadioBtn);
		gu.mediumWait();
		gu.addScrolling(driver, parameter);
		gu.clickOnElement(comboPackRadioBtn);
	}

	public void clickSaveButton(String parameter) throws InterruptedException {
		wait.waitElementClickable(driver, saveBtn);
		gu.mediumWait();
		gu.addScrolling(driver, parameter);
		gu.clickOnElement(saveBtn);
	}

	public List<String> getListProductsText() {
		return gu.selectedItems(driver,
				"(//table[@class='table table-bordered table-hover table-sm']//tbody//tr)//td[1]");
	}

	public boolean compareProductsListItems(List<String> list, String text) {
		return gu.verifyStringListText(list, text);
	}

}
