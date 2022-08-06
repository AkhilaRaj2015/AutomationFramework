package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

	public void captureScnshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;// creating obj of interface TakesScreenshot,Capture
															// Screenshot
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);// Store Screenshot

		File f1 = new File(System.getProperty("user.dir") + "\\OutputScreenshot");
		if (!f1.exists()) {
			f1.mkdirs();// java cmd to create folder,Make Directory
		}

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// current systm date

		File finalDestination = new File(
				System.getProperty("user.dir") + "\\OutputScreenshot\\" + name + timeStamp + ".png");// defining path
		FileHandler.copy(screenShot, finalDestination);

	}

}
