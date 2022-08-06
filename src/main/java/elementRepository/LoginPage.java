package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();// obj of utility(common-method)

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInBtn;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement brandIcon;

	public String getSignInBtnText() {
		// String signInBtnText = signInBtn.getText();
		// return signInBtnText;
		return gu.getElementText(signInBtn);
	}

	public boolean isDisplayedBrandIcon() {
		return gu.isElementDisplayed(brandIcon);

	}

	public void inputUsername(String uname) {
		gu.inputDataToTextfield(username, uname);
	}

	public void inputPassword(String pwd) {
		gu.inputDataToTextfield(password, pwd);
	}

	public void clickSignInButton() {
		gu.clickOnElement(signInBtn);
	}

	public String getSignInButtonTagname() {
		return gu.getElementTagname(signInBtn);
	}

	public void performLogin(String uname, String pwd) {
		gu.inputDataToTextfield(username, uname);
		gu.inputDataToTextfield(password, pwd);
		gu.clickOnElement(signInBtn);

	}

}
