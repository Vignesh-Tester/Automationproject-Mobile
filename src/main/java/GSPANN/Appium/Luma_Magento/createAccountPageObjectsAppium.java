package GSPANN.Appium.Luma_Magento;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class createAccountPageObjectsAppium {
	
	 AndroidDriver driver;
	
	public createAccountPageObjectsAppium(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	public void goTo() {

		driver.get("https://magento.softwaretestingboard.com/");
	}

	@AndroidFindBy(xpath="//span[@class='action nav-toggle']")
	WebElement clickOnMenuLink;
	
	@AndroidFindBy(xpath="//div[@class='section-item-title nav-sections-item-title']")
	WebElement clickOnAccountLink;
	
	@AndroidFindBy(xpath="//div[@id='store.links']//a[normalize-space()='Create an Account']")
	WebElement clickOnCreateAccountLink;
	
	public void getCreateAccount() {
		clickOnMenuLink.click();
		clickOnAccountLink.click();
		clickOnCreateAccountLink.click();
	}
	
	

	
	
}
