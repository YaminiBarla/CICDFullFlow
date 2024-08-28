package YaminiBarla.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class ecomersePageObjModel_JsonFile extends invokeBrowser{
	
	@Test(dataProvider = "getData",groups= {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
	
		
		productCatelogue PC=LP.login(input.get("Email"), input.get("Password"));
		
		
		List<WebElement> products = PC.getProductsList();
		PC.addToCart(input.get("ProductName"));
		CartPage CP=PC.goToCart();
		
	
		Boolean match = CP.VerifyProductsDisplay(input.get("ProductName"));
		Assert.assertTrue(match);
		CheckoutPage COP=CP.clickCheckout();
		
		COP.enterCountry("Ind");
		COP.placeOrder();
		String msg =COP.grabsuccessMsg();
		
		Assert.assertEquals(msg,"THANKYOU FOR THE ORDER.");
		
		

	}
	
	@Test(dependsOnMethods={"submitOrder"},dataProvider = "getData")
	public void checkOrderHistory(HashMap<String,String> input) throws InterruptedException {
		productCatelogue PC=LP.login(input.get("Email"), input.get("Password"));
		YaminiBarla.pageObjectModel.OrderPage OP=PC.goToOrders();
		Boolean match =OP.verifyOrderDisplay(input.get("ProductName"));
		Assert.assertTrue(match);
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\YaminiBarla\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
	
}
