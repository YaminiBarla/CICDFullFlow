package YaminiBarla.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import YaminiBarla.TestComponents.invokeBrowser;
import YaminiBarla.pageObjectModel.CartPage;
import YaminiBarla.pageObjectModel.CheckoutPage;
import YaminiBarla.pageObjectModel.LandingPage;
import YaminiBarla.pageObjectModel.productCatelogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ecomersePageObjModel_DataProvider extends invokeBrowser{
	
	@Test(dataProvider = "getData",groups= {"purchase"})
	public void submitOrder(String Email,String Password,String ProductName) throws IOException {
	
		
		productCatelogue PC=LP.login(Email, Password);
		
		
		List<WebElement> products = PC.getProductsList();
		PC.addToCart(ProductName);
		CartPage CP=PC.goToCart();
		
	
		Boolean match = CP.VerifyProductsDisplay(ProductName);
		Assert.assertTrue(match);
		CheckoutPage COP=CP.clickCheckout();
		
		COP.enterCountry("Ind");
		COP.placeOrder();
		String msg =COP.grabsuccessMsg();
		
		Assert.assertEquals(msg,"THANKYOU FOR THE ORDER.");
		
		

	}
	
	@Test(dependsOnMethods={"submitOrder"},dataProvider = "getData")
	public void checkOrderHistory(String Email,String Password,String ProductName) throws InterruptedException {
		productCatelogue PC=LP.login(Email, Password);
		YaminiBarla.pageObjectModel.OrderPage OP=PC.goToOrders();
		Boolean match =OP.verifyOrderDisplay(ProductName);
		Assert.assertTrue(match);
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		return new Object[][] {{"yamini@gmail.com", "$Bynsunanda$410","ZARA COAT 3"},{"pranavi@gmail.com", "$Pranavi$410","ADIDAS ORIGINAL"}};
	}
	
	
}
