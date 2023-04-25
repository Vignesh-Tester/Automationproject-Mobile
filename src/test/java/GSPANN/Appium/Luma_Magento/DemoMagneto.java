package GSPANN.Appium.Luma_Magento;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DemoMagneto {

	@Test
	public void createAccount() throws MalformedURLException {

		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File(
				"C://Users//vignesh.thangavel//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("VigneshPhone1");
		options.setChromedriverExecutable("C://Users//vignesh.thangavel//Downloads//chromedriver_win32 (1)//chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		//options.setCapability(“appPackage”, “com.android.chrome”);
		//options.setCapability(“appActivity”,“com.google.android.apps.chrome.Main”);
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.get("https://www.google.com/");
		
		
		driver.quit();
		service.stop();
		
		
	}
}
