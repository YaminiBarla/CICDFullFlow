package YaminiBarla.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import YaminiBarla.AbstractComponents.Wait;

public class productCatelogue extends Wait {
	
	WebDriver driver;
	
	public productCatelogue(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//the above step can be modified using pagefactor
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement element;
	
	By productsVisibility = By.cssSelector(".mb-3");
	By additem= By.cssSelector(".card-body button:last-of-type");
	By toastmsg=By.cssSelector("#toast-container");
	public List<WebElement> getProductsList() {
		
		waitforElementToAppear(productsVisibility);
		return products;
	}
	
	public WebElement getProductName(String ProductName) {
		
		WebElement product= getProductsList().stream().filter(p->
		p.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return product;
	}
	
	public void addToCart(String ProductName) {
		
		WebElement product = getProductName(ProductName);
		product.findElement(additem).click();
		waitforElementToAppear(toastmsg);
		waitforElementToDissapear(element);
		
	}
	
	
	
	
	
	
	
}
