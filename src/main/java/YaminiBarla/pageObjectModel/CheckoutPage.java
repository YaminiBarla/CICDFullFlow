package YaminiBarla.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import YaminiBarla.AbstractComponents.Wait;

public class CheckoutPage extends Wait{
	

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryCkbox;
	
	@FindBy(css="button[class*='ta-item']")
	List<WebElement> countries;
	
	@FindBy(css="a[class*='submit']")
	WebElement submitbtn;
	
	@FindBy(tagName="h1")
	WebElement confirmMsg;
	
	By dropdown = By.cssSelector("section[class*='ta-results']");
	
	public void enterCountry(String country) {
		
		countryCkbox.sendKeys(country);
		waitforElementToAppear(dropdown);
	}
	
	
	public WebElement findCountry() {
		
		WebElement country =countries.stream().filter(c->
		c.getText().equals("India")).findFirst().orElse(null);
		return country;
	}
	
	public void placeOrder() {
		
		WebElement country =findCountry();
		country.click();
		submitbtn.click();
		
		
	}
	
	public String grabsuccessMsg() {
		
		String msg = confirmMsg.getText();
		return msg;
	}

	

	

}
