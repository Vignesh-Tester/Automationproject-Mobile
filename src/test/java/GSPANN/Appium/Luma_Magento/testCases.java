package GSPANN.Appium.Luma_Magento;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestComponents.Base;
import io.appium.java_client.android.AndroidDriver;

public class testCases extends Base {

	ExtentReports extent;

	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		esr.config().setReportName("Automation results Appium");
		esr.config().setDocumentTitle("Demo Website- Magneto");
		esr.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(esr);
		extent.setSystemInfo("Tested By", "vignesh");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("MobileOS", "Android");
		
	}
	@Test
	public void createAccount() throws IOException, InterruptedException {

		ExtentTest test = extent.createTest("simpletestcase/createAccount");
		test.log(Status.PASS, "simpletestcase/Account is successfully created");
		AndroidDriver driver = initializeDriver();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='action nav-toggle']")).click();
		driver.findElement(By.xpath("//div[@class='section-item-title nav-sections-item-title']")).click();
		driver.findElement(By.xpath("//div[@id='store.links']//a[normalize-space()='Create an Account']")).click();
		// div[id='store.links'] li:nth-child(3) a:nth-child(1)
		driver.findElement(By.id("firstname")).sendKeys("Vignesh");
		driver.findElement(By.id("lastname")).sendKeys("Thangavel");
		// driver.findElement(By.id("is_subscribed")).
		Random random = new Random();
		Integer value = random.nextInt(1000);
		driver.findElement(By.id("email_address")).sendKeys("Vigneshraj" +value+ "123@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Strongpassword@2022");
		driver.findElement(By.id("password-confirmation")).sendKeys("Strongpassword@2022");
		driver.findElement(By.cssSelector("button[title='Create an Account']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector(".message-success.success.message")).isDisplayed();
		extent.flush();
		driver.close();
	}

	@Test
	public void AddToWishList() throws MalformedURLException, InterruptedException {
		
		ExtentTest test = extent.createTest("MediumTestcase/addProductToWishlist");
		test.log(Status.PASS, "MediumTestcase/Product is added and removed successfully from the Wishlist");
		//
		AndroidDriver driver = initializeDriver();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action.nav-toggle")).click();
		driver.findElement(By.xpath("//div[@class='section-item-title nav-sections-item-title']")).click();
		driver.findElement(By.xpath("//div[@id='store.links']//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("email")).sendKeys("vignesh2022@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("January_@2022");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//button[@class='action login primary']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Radiant Tee']")).click();
		driver.findElement(By.xpath("(//div[@id='option-label-size-143-item-168'])[1]")).click();
		driver.findElement(By.xpath("(//div[@id='option-label-color-93-item-56'])[1]")).click();
		driver.findElement(By.id("product-addtocart-button")).click();
		driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='use-ajax action towishlist action-towishlist']")).click();
		driver.findElement(By.xpath("//div[@class='message-success success message']")).isDisplayed();
		driver.findElement(By.cssSelector(".action.nav-toggle")).click();
		driver.findElement(By.xpath("//div[@class='section-item-title nav-sections-item-title']")).click();
		driver.findElement(By.xpath(
				"//div[@id='store.links']//ul[@class='header links']//li[@class='customer-welcome']//div[@class='customer-menu']//ul[@class='header links']//li[@class='link wishlist']//a[@href='https://magento.softwaretestingboard.com/wishlist/']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn-remove action delete']")).click();
		driver.findElement(By.xpath("//div[@class='message-success success message']")).isDisplayed();
		extent.flush();
		driver.close();
	}

	@Test
	public void orderProduct() throws InterruptedException, MalformedURLException {
		ExtentTest test = extent.createTest("ComplexTestcase/OrderProduct");
		test.log(Status.PASS, "ComplexTestcase/Product is ordered successfully");
		AndroidDriver driver = initializeDriver();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='action nav-toggle'])")).click();
		driver.findElement(By.xpath("//div[@class='section-item-title nav-sections-item-title']")).click();
		driver.findElement(By.xpath("//div[@id='store.links']//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("email")).sendKeys("vignesh2022@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("January_@2022");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//button[@class='action login primary']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Hero Hoodie']")).click();
		driver.findElement(By.xpath("(//div[@id='option-label-size-143-item-170'])[1]")).click();
		driver.findElement(By.xpath("(//div[@id='option-label-color-93-item-53'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='qty']")).clear();
		driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("2");
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[normalize-space()='New Address']")).click();
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Logger India Pvt tld");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys("24,Veer Road, Arasur");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Coimbatore");
		driver.findElement(By.xpath("//select[@name='country_id']")).sendKeys("India");
		driver.findElement(By.xpath("//select[@name='region_id']")).sendKeys("Tamil Nadu");
		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("1234567890");
		driver.findElement(By.id("shipping-save-in-address-book")).click();
		driver.findElement(By.xpath("//button[@class='action primary action-save-address']")).click();
		driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("block-discount-heading")).click();
		driver.findElement(By.id("discount-code")).sendKeys("DEAL12");
		driver.findElement(By.xpath("//button[@value='Apply Discount']")).click();
		// message message-error error
		driver.findElement(By.xpath("//div[@class='message message-error error']")).isDisplayed();
		driver.findElement(By.xpath("//button[@title='Place Order']")).click();
		String orderNumbergenearated = driver.findElement(By.xpath("//a[@class='order-number']")).getText();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action.nav-toggle")).click();
		driver.findElement(By.xpath("//div[@class='section-item-title nav-sections-item-title']")).click();
		driver.findElement(By.xpath(
				"//div[@id='store.links']//ul[@class='header links']//li[@class='customer-welcome']//div[@class='customer-menu']//ul[@class='header links']//li//a[normalize-space()='My Account']"))
				.click();
		String orderNumberDisplayed = driver.findElement(By.xpath("//td[@data-th='Order #']")).getText();
		Assert.assertEquals(orderNumbergenearated, orderNumberDisplayed);
		extent.flush();
		driver.close();
		

	}

}
