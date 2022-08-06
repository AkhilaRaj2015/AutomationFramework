package testCases;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.ManageOrdersTab;
import elementRepository.ManageProductTab;
import utilities.ExcelRead;
import utilities.ExplicitWait;

public class ManageProductTestCases extends BaseClass {

	LoginPage obj;
	DashBoardPage dp;
	ManageProductTab mp;
	ExcelRead read;

	@Test
	public void testcase01VerifyTitleTextfieldAttributeValue() {

		obj = new LoginPage(driver);
		obj.inputUsername("admin");
		obj.inputPassword("admin");
		obj.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		mp.clickNewBtn();
		String actual = mp.getTitleTextfieldAttributeValue("placeholder");
		String expected = "Enter the Title";
		Assert.assertEquals(actual, expected, Constant.attributevalueAssertion);
	}

	@Test
	public void testcase02VerifyNonVegRadioButton() {

		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.inputUsername(read.readData(1, 0));
		obj.inputPassword(read.readData(1, 1));
		obj.clickSignInButton();

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		mp.clickNewBtn();
		mp.clicknonVegRadioButton();

		boolean actual = mp.isSelectedNonVegRadioButton();
		Assert.assertTrue(actual, Constant.errorMessageNonVegRadioButton);
	}

	@Test
	public void testcase03VerifyCategoryDropDownValueSelected() throws InterruptedException {

		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		mp.clickNewBtn();

		String actual = mp.selectCategoryDropDown("Diary & Bakery");
		String expected = "Diary & Bakery";
		Assert.assertEquals(actual, expected, Constant.errorMessageCategoryDropDown);
	}

	@Test
	public void testcase04VerifySubCategoryDropDownValueSelected() throws InterruptedException {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		mp.clickNewBtn();
		mp.selectCategoryDropDown("Diary & Bakery");

		String actual = mp.selectSubCategoryDropDown("Milk & Butter");
		String expected = "Milk & Butter";
		Assert.assertEquals(actual, expected, Constant.errorMessageSubCategoryDropDown);
	}

	@Test
	public void testcase05VerifyLabel1ToolTipValue() {

		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		mp.clickNewBtn();

		String actual = mp.getDesLabel1ToolTipValue();
		String expected = Constant.expectedDescriptionLabel1ToolTipValue;
		Assert.assertEquals(actual, expected,Constant.toolTipAssertion);
	}

	@Test
	public void testcase06VerifyUnlimitedStockCheckbox() throws InterruptedException {

		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		mp.clickNewBtn();

		// mp.clickUnlimitedStockCheckbox("window.scrollBy(0,3500)");
		boolean actual = mp.isSelectedUnlimitedStockCheckbox();
		Assert.assertTrue(actual, Constant.errorMsgUnlimitedStockChkbox);
	}

	@Test
	public void testcase07VerifyBackGroundColorNewBtn() {

		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		String actual = mp.getBackGroundColorNewBtn("background-color");
		System.out.println(actual);
		String expected = "rgba(220, 53, 69, 1)";
		Assert.assertEquals(actual, expected,Constant.cssValueAssertion);
	}

	@Test
	public void testcase08VerifyMRPAttribute() {

		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		mp.clickNewBtn();
		String actual = mp.getMRPTextfieldAttributeValue("name");
		String expected = "w_mrp";
		Assert.assertEquals(actual, expected,Constant.attributevalueAssertion);
	}

	@Test
	public void testcase09VerifyUnlimitedStockButtonFontSize() {

		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);

		String actual = mp.getUnlimitedStockButtonFontSize("font-size");
		String expected = "12px";
		Assert.assertEquals(actual, expected,Constant.attributevalueAssertion);
	}

	@Test
	public void testcase10VerifyActionDeleteButtonAlertTextInListProductsPage() {
		
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		mp.clickActionDeleteButton();

		String actual = mp.getActionDeleteButtonAlertText();
		String expected = "Do you want to delete this Product?";
		mp.dismissActionDeleteBtnAlert();
		Assert.assertEquals(actual, expected, Constant.alertWorkingAssertion);
	}

	@Test
	public void testcase11VerifySaveButtonFunctionalityUsingMandatoryFields()
			throws AWTException, InterruptedException {
		
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageProductTab();

		mp = new ManageProductTab(driver);
		mp.clickNewBtn();

		mp.inputTitle("Elite Cup Cake");
		mp.clicknonVegRadioButton();
		mp.selectCategoryDropDown("Snacks & Branded Foods");
		mp.selectSubCategoryDropDown("Snacks");
		mp.clickPieceRadioButton();
		mp.selectMinimumPieceDropDown("10 Piece");
		mp.inputMaxQtyCanOrder("100");
		mp.inputPrice("50");
		mp.inputStockAvailability("100");
		mp.clickStockRadioButton("window.scrollBy(0,3500)");
		mp.chooseImage1(System.getProperty("user.dir") + ps.getProperty("ImagePathAddProductPage"),
				"window.scrollBy(0,3500)");
		mp.clickfeaturedRadioButton("window.scrollBy(0,3500)");
		mp.clickcomboPackRadioButton("window.scrollBy(0,3500)");
		mp.clickSaveButton("window.scrollBy(0,3500)");
		String text = "Elite Cup Cake";
		List<String> listtext = mp.getListProductsText();
		boolean actual = mp.compareProductsListItems(listtext, text);
		Assert.assertTrue(actual,Constant.groupItemsAssertion);

	}

}
