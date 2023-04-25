package TestComponents;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import GSPANN.Appium.Luma_Magento.createAccountPageObjectsAppium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	AndroidDriver driver;

	public AndroidDriver initializeDriver() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "VigneshPhone1");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("chromedriverExecutable",
				"C:\\Users\\vignesh.thangavel\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	/*public createAccountPageObjectsAppium launchApplication() throws IOException {

		driver = initializeDriver();
		createAccountPageObjectsAppium welcomeScreenObjects = new createAccountPageObjectsAppium(
				driver);
		welcomeScreenObjects.goTo();
		return welcomeScreenObjects;
	}*/

}
