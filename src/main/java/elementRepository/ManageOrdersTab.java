package elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ManageOrdersTab {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageOrdersTab(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Order/details?details=651&page_ad=1']")
	WebElement viewBtn;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order'])[2]")
	WebElement backBtn;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Order/delete?del=651&page_ad=1']")
	WebElement deleteBtn;

	@FindBy(xpath = "(//a[text()='Change Status'])[1]")
	WebElement changeStatusBtn;

	@FindBy(xpath = "//span[text()='Unpaid']") // label appears on clicking changeStatusButton
	WebElement statusLabel;

	@FindBy(xpath = "//select[@onchange='show_cancel(651)']")
	WebElement statusDropDown;

	@FindBy(xpath = "(//button[@name='Update_st'])[1]")
	WebElement updateBtn;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchBtnTop;

	@FindBy(xpath = "//select[@id='pt']")
	WebElement paymentmodeDropDown;

	@FindBy(xpath = "//table[@class ='table table-bordered table-hover table-sm']//tbody//tr//td[5]")
	WebElement paymentmodetablecolumnvalue;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchBtnBottom;

	@FindBy(xpath = "(//a[text()='Assign Delivery Boy'])[1]")
	WebElement assignDeliveryBoyBtn;

	@FindBy(xpath = "(//select[@id='delivery_boy_id'])[1]")
	WebElement selectDeliveryBoyDropDown;

	@FindBy(xpath = "(//button[@name='assign_del'])[1]")
	WebElement deliveryBoyupdateBtn;

	@FindBy(xpath = "//span[text()='Test Delivery Boy']")
	WebElement deliveryBoyLabel;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Order/details?details=650&page_ad=1']")
	WebElement actionViewButton;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement pageLabel;

	public void clickViewButton() {
		gu.clickOnElement(viewBtn);
	}

	public void clickbackButton() {
		gu.clickOnElement(backBtn);
	}

	public String getCurrentPageUrl() {
		return gu.getCurrentUrl(driver);
	}

	public void clickDeleteButton() {
		gu.clickOnElement(deleteBtn);
	}

	public String getDeleteButtonAlertText() {
		return gu.getAlertText(driver);
	}

	public void dismissDeleteBtnAlert() {
		gu.dismissAlert(driver);
	}

	public void clickChangeStatusButton() {
		gu.clickOnElement(changeStatusBtn);
	}

	public String getStatusLabelText() {
		return gu.getElementText(statusLabel);
	}

	public String selectStatusDropDown(String text) {
		return gu.selectDropDownValue(statusDropDown, text);
	}

	public void clickUpdateButton() {
		gu.clickOnElement(updateBtn);
	}

	public void clickSearchButtonTop() {
		gu.clickOnElement(searchBtnTop);
	}

	public String selectPaymentModeDropDown(String value) {
		return gu.selectDropDownValue(paymentmodeDropDown, value);
	}

	public void clickSearchButtonBottom() {
		gu.clickOnElement(searchBtnBottom);
	}

	public String getStatusDropDownSelectedText(String txt) {
		return gu.selectDropDownValue(statusDropDown, txt);
	}

	public List<String> getPaymentModeListText() {
		// System.out.println( gu.selectedItems(driver,"//table[@class ='table
		// table-bordered table-hover table-sm']//tbody//tr//td[5]"));
		return gu.selectedItems(driver,
				"//table[@class ='table table-bordered table-hover table-sm']//tbody//tr//td[5]");
	}

	public boolean compareSelectedItems(List<String> list, String text) {
		return gu.verifyStringListText(list, text);
	}

	public void clickAssignDeliveryBoyBtn() {
		gu.clickOnElement(assignDeliveryBoyBtn);
	}

	public String selectDeliveryBoyDropDown(String value) {
		return gu.selectDropDownValue(selectDeliveryBoyDropDown, value);
	}

	public void clickDeliveryBoyupdateBtn() {
		gu.clickOnElement(deliveryBoyupdateBtn);
	}

	public String getDeliveryBoyLabelText() {
		return gu.getElementText(deliveryBoyLabel);
	}

	public void clickViewActionButton() {
		gu.clickOnElement(actionViewButton);
	}

	public String getPagelabelText() {
		return gu.getElementText(pageLabel);
	}

}
