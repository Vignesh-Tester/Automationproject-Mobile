package GSPANN.Appium.Luma_Magento;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddtoWishListPageObjectsAppium {

public AndroidDriver driver;
	
	public AddtoWishListPageObjectsAppium(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
	}
	
	
	
	
	
}
