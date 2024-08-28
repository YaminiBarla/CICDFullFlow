package YaminiBarla.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import YaminiBarla.TestComponents.invokeBrowser;
import YaminiBarla.pageObjectModel.CartPage;
import YaminiBarla.pageObjectModel.CheckoutPage;
import YaminiBarla.pageObjectModel.LandingPage;
import YaminiBarla.pageObjectModel.productCatelogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepDefinition extends invokeBrowser{
	
	public LandingPage LP;
	public productCatelogue PC;
	public CartPage CP;
	public CheckoutPage COP;
	@Given("I landed on ecommere page")
	public void i_landed_on_ecommere_page() throws IOException {
		
		LP = launchapplication();
		
	   
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password) {
	   
		 PC=LP.login(username,password);
	}

	@When("^I add the product name (.+) to cart$")
	public void i_add_the_product_name_to_cart(String ProductName) {
		
		List<WebElement> products = PC.getProductsList();
		PC.addToCart(ProductName);
	}
	   

	@When("^Checkout (.+) and submit$")
	public void checkout_and_submit(String product) {
		
		 CP=PC.goToCart();
		
		
		Boolean match = CP.VerifyProductsDisplay(product);
		Assert.assertTrue(match);
		 COP=CP.clickCheckout();
		
		COP.enterCountry("Ind");
		COP.placeOrder();
	   
	}

	@Then("{string} message is displayed.")
	public void message_is_displayed(String string) {
		
		String msg =COP.grabsuccessMsg();
		
		Assert.assertEquals(msg,string);
		driver.close();
	    
	}

	@Then("{string} message is displayed on that page.")
	public void message_is_displayed_on_that_page(String string) {
		
		
		Assert.assertEquals("Incorrect email or password.", LP.getErrorMsg());
		driver.close();
	    
	}

}
