package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;

public class LoginTestCases extends BaseClass {
	LoginPage obj;

	@Test(priority = 1)
	public void testcase01VerifySignInBtnText() {

		obj = new LoginPage(driver);

		String actual = obj.getSignInBtnText();
		String expected = Constant.expectedSignInButtonName;
		Assert.assertEquals(actual, expected, " Not expected");
	}

	@Test
	public void testcase02VerifyBrandIcon() {

		obj = new LoginPage(driver);

		boolean actual = obj.isDisplayedBrandIcon();
		Assert.assertTrue(actual, Constant.errorMessageBrandIcon);
	}

	@Test(priority = 2)
	public void testcase03VerifySignInButtonTagname() {

		obj = new LoginPage(driver);

		String actual = obj.getSignInButtonTagname();
		String expected = Constant.expectedSignInButtonTagname;
		Assert.assertEquals(actual, expected, " Not expected");

	}
}
