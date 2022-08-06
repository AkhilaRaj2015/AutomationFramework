package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.ManageOrdersTab;
import elementRepository.ManageProductTab;
import utilities.ExcelRead;

public class ManageOrdersTestCases extends BaseClass {
	LoginPage obj;
	ExcelRead read;
	DashBoardPage dp;
	ManageProductTab mp;
	ManageOrdersTab mot;

	@Test(groups= {"low"})
	public void testcase01VerifyBackBtnFunctionality() {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersTab();

		mot = new ManageOrdersTab(driver);
		mot.clickViewButton();
		mot.clickbackButton();
		String actual = mot.getCurrentPageUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin/list-order";
		Assert.assertEquals(actual, expected, Constant.backButtonFunctionAssertion);
	}

	@Test(groups= {"low"})
	public void testcase02VerifyDeleteButtonAlertText() {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersTab();

		mot = new ManageOrdersTab(driver);
		mot.clickDeleteButton();
		String actual = mot.getDeleteButtonAlertText();
		String expected = Constant.deleteButtonOrderAlert;
		mot.dismissDeleteBtnAlert();
		Assert.assertEquals(actual, expected, Constant.alertWorkingAssertion);
	}
	
	@Test(groups= {"low"})//realfailure
	public void testcase03VerifyFunctionOfChangeStatusButton() {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersTab();

		mot = new ManageOrdersTab(driver);
		
		mot.clickChangeStatusButton();
		mot.selectStatusDropDown("UnPaid");
		mot.clickUpdateButton();
		
		String actual=mot.getStatusLabelText();
		String expected=mot.selectStatusDropDown("UnPaid");
		Assert.assertEquals(actual, expected,Constant.changeStatusButtonAssertion);
	}	
	@Test(groups= {"critical"})
	public void testcase04VerifyFunctionOfSearchBtutton() {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersTab();

		mot = new ManageOrdersTab(driver);
		mot.clickSearchButtonTop();
		
		String text=mot.selectPaymentModeDropDown("Bank");
		mot.clickSearchButtonBottom();
		List<String> listtext = mot.getPaymentModeListText();
		boolean actual = mot.compareSelectedItems(listtext, text);
		Assert.assertTrue(actual,Constant.groupItemsAssertion);
	}
	
	@Test(groups= {"medium"})
		public void testcase05VerifyAssignDeliveryBoyButtonWorking() {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersTab();

		mot = new ManageOrdersTab(driver);
		mot.clickAssignDeliveryBoyBtn();
		
		mot.selectDeliveryBoyDropDown("testdeliveryboy");
		mot.clickDeliveryBoyupdateBtn();
		
		String actual=mot.getDeliveryBoyLabelText();
		String expected=Constant.expectedTestDeliveryBoyLabelName;
		Assert.assertEquals(actual, expected,Constant.deliveryBoyAssignedAlertAssertion );
		
	}
	@Test(groups= {"low"})
	public void testcase06VerifyActionViewButtonWorking() {
		obj = new LoginPage(driver);
		read = new ExcelRead();

		obj.performLogin(read.readData(1, 0), read.readData(1, 1));

		dp = new DashBoardPage(driver);
		dp.clickManageOrdersTab();

		mot = new ManageOrdersTab(driver);
		mot.clickViewActionButton();
		String actual=mot.getPagelabelText();
		String expected=Constant.expectedPageLabelName;
		Assert.assertEquals(actual, expected,Constant.viewButtonWorkingAssertion);
	}
}
