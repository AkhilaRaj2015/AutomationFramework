package testCases;

import java.awt.AWTException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.CategoriesTab;
import elementRepository.DashBoardPage;
import elementRepository.ListCategories;
import elementRepository.LoginPage;
import elementRepository.ManageProductTab;
import utilities.ExcelRead;

public class CategoriesTestCases extends BaseClass {

	LoginPage obj;
	DashBoardPage dp;
	ManageProductTab mp;
	ExcelRead read;
	ListCategories lc;
	CategoriesTab ct;

	@Test(groups= {"critical"})
	public void testcase01VerifySelectedItemsList() {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickCategoriesTab();

		lc = new ListCategories(driver);
		lc.clickNewBtn();

		ct = new CategoriesTab(driver);

		// Select 2 or values --> click();
		// List --> For --> if -->boolean

		ct.selectItem1SelectGroups();
		ct.selectItem2SelectGroups();
		String item1 = ct.getItem1SelectedText();
		String item2 = ct.getItem2SelectedText();

		List<String> list = ct.selectedList();
		boolean actual = ct.compareSelectedItems(list, item1, item2);

		Assert.assertTrue(actual, Constant.groupItemsAssertion);
	}

	@Test(groups= {"low"})
	public void testcase02VerifyCancelButtonFunctionality() throws InterruptedException {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickCategoriesTab();

		lc = new ListCategories(driver);
		lc.clickNewBtn();

		ct = new CategoriesTab(driver);
		ct.clickCancelButton("window.scrollBy(0,3800)");
		String actual = ct.getCurrentpageTitle();
		String expected = "List Categories | 7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.cancelButtonAssertion);
	}

	@Test(groups= {"critical"})
	public void testcase03VerifySaveButtonFunctionality() throws InterruptedException, AWTException {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickCategoriesTab();

		lc = new ListCategories(driver);
		lc.clickNewBtn();

		ct = new CategoriesTab(driver);
		ct.inputCategory("pedigree");
		ct.selectItem2SelectGroups();

		ct.fileUploadCategory(System.getProperty("user.dir") + ps.getProperty("ImagePath"));
		ct.selectYesShowOnTopMenuRadioBtn("window.scrollBy(0,3800)");
		ct.selectNoShowOnLeftMenuRadioBtn("window.scrollBy(0,3800)");
		ct.clickSaveButton("window.scrollBy(0,3800)");

		String text = ct.getCategoryFieldText();
		List<String> listtext = ct.getCategoriesListText();
		boolean actual = ct.compareCategoryListItems(listtext, text);
		Assert.assertTrue(actual,Constant.groupItemsAssertion);

	}

	@Test(groups= {"medium"})// real failure
	public void testcase04VerifyAddCategoryAlertTextUsingMandatoryFields() throws InterruptedException {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickCategoriesTab();

		lc = new ListCategories(driver);
		lc.clickNewBtn();

		ct = new CategoriesTab(driver);
		ct.inputCategory("pedigree");
		ct.selectYesShowOnTopMenuRadioBtn("window.scrollBy(0,3800)");
		ct.selectNoShowOnLeftMenuRadioBtn("window.scrollBy(0,3800)");
		ct.clickSaveButton("window.scrollBy(0,3800)");

		String actual = ct.getCategorySaveAlertText();
		String expected = Constant.saveCategoryDetailsButtonAssertion;
		// ct.dismissActionSaveButtonAlert();
		Assert.assertEquals(actual, expected,Constant.alertWorkingAssertion);

	}
}
