package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.ManageNewsTab;
import elementRepository.ManageOrdersTab;
import utilities.ExcelRead;

public class ManageNewsTestCases extends BaseClass {

	LoginPage obj;
	ExcelRead read;
	DashBoardPage dp;
	ManageNewsTab mn;

	@Test(enabled = true)
	public void testcase01VerifyWorkingOfUpdateButton() throws InterruptedException {
		
		obj = new LoginPage(driver);
		read = new ExcelRead();
		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageNewsTab("window.scrollBy(0,3800)");

		mn = new ManageNewsTab(driver);
		mn.clickactionEditButton();
		mn.clearNewstextArea();
		mn.inputNewsTextArea("NewTestDetails Added");
		mn.clickUpdateButtononEnteringNewsInformation();
		String text="NewTestDetails Added";
		List<String> managenewsList = mn.getManageNewsListText();
		boolean actual = mn.compareNewsItems(managenewsList, text);
		Assert.assertTrue(actual,Constant.newsItemsListAssertion);

	}
	
	@Test(enabled = false)
	public void testcase02VerifyActionDeleteAlert() throws InterruptedException {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageNewsTab("window.scrollBy(0,3800)");

		mn = new ManageNewsTab(driver);
		mn.clickActionDeleteButton();
		String actual = mn.getActionDeleteButtonAlertText();
		String expected = Constant.deleteNewsButtonAlert;
		mn.acceptNewsDeleteAlert();
		Assert.assertEquals(actual, expected, Constant.alertWorkingAssertion);
	}
	
	@Test(enabled = false)
	public void testcase03VerifyLogoutFunctionality() throws InterruptedException {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageNewsTab("window.scrollBy(0,3500)");

		mn = new ManageNewsTab(driver);
		mn.clickLogOutButton("window.scrollBy(0,-3500)");
		boolean actual = obj.isDisplayedBrandIcon();
		Assert.assertTrue(actual,Constant.logOutWorkingAssertion);
		
	}
}
