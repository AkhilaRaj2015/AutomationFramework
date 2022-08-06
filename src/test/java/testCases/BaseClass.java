package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import utilities.CaptureScreenshot;

public class BaseClass {
	WebDriver driver;
	CaptureScreenshot cs;
	public static Properties ps;

	public static void testBasic() throws IOException {
		ps = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		ps.load(file);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browsername) throws IOException {
		testBasic();
		if (browsername.equals("chrome")) {
			System.setProperty(ps.getProperty("ChromeDriver"),
					System.getProperty("user.dir") + ps.getProperty("ChromeDriverPath"));

			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {
			System.setProperty(ps.getProperty("GeckoDriver"),
					System.getProperty("user.dir") + ps.getProperty("GeckoDriverPath"));

			driver = new FirefoxDriver();

		}

		else if (browsername.equals("edge")) {
			System.setProperty(ps.getProperty("EdgeDriver"),
					System.getProperty("user.dir") + ps.getProperty("EdgeDriverPath"));

			driver = new EdgeDriver();

		}

		driver.get(ps.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itr) throws IOException { // Listener,basically used to handle events
																	// (ITestResult)

		if (itr.getStatus() == ITestResult.FAILURE)// if test is failure,then screenshot is captured
		{
			cs = new CaptureScreenshot();
			cs.captureScnshot(driver, itr.getName());// returning particular testcasename for identification
		}

		driver.close();

	}
}
