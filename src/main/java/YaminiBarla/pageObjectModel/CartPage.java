package YaminiBarla.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import YaminiBarla.AbstractComponents.Wait;

public class CartPage extends Wait{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".cartSection h3")
	List<WebElement> list;

	@FindBy(css=".subtotal button")
	WebElement ckout;

	public boolean VerifyProductsDisplay(String ProductName) {
		
		boolean match = list.stream().anyMatch(l->l.getText().equals(ProductName));
		return match;

	}
	
	public CheckoutPage clickCheckout() {
		
		ckout.click();
		CheckoutPage COP = new CheckoutPage(driver);
		return COP;
	}
	
}
