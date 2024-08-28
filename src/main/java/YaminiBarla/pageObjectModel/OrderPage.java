package YaminiBarla.pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import YaminiBarla.AbstractComponents.Wait;

public class OrderPage extends Wait{
	
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> list;

	public boolean verifyOrderDisplay(String ProductName) {
		
		boolean match = list.stream().anyMatch(l->l.getText().equals(ProductName));
		return match;

	}

	
	
		
		
		
	

}
