package YaminiBarla.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import YaminiBarla.pageObjectModel.CartPage;
import YaminiBarla.pageObjectModel.OrderPage;

public class Wait {
	
WebDriver driver;
	
	
	
	public Wait(WebDriver driver) {
		this.driver=driver;
}

	@FindBy(css="button[routerlink*='cart']")
	WebElement Cart;
	
	@FindBy(css="[routerlink*=myorders]")
	WebElement Orders;

	public void waitforElementToAppear(By element) {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	
	}
	
	public void waitforElementToDissapear(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitforWebElementToAppear(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public CartPage goToCart() {
		
		Cart.click();
		CartPage CP = new CartPage(driver);
		return CP;
		
	}
	
	public OrderPage goToOrders() {
		
		Orders.click();
		OrderPage OP =new OrderPage(driver);
		return OP;
			
	}

}
