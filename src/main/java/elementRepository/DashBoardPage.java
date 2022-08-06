package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class DashBoardPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait wait = new ExplicitWait();

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[1]")
	WebElement manageProduct;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]")
	WebElement category;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order'])[1]")
	WebElement manageOrders;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")
	WebElement manageNews;

	public void clickManageProductTab() {
		gu.clickOnElement(manageProduct);
	}

	public void clickCategoriesTab() {
		gu.clickOnElement(category);
	}

	public void clickManageOrdersTab() {
		gu.clickOnElement(manageOrders);
	}

	public void clickManageNewsTab(String parameter) throws InterruptedException {
		wait.waitElementClickable(driver, manageNews);

		gu.addScrolling(driver, parameter);
		gu.mediumWait();
		gu.clickOnElement(manageNews);
	}
}
