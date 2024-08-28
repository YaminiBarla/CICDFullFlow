package YaminiBarla.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import YaminiBarla.AbstractComponents.Wait;

public class LandingPage extends Wait {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement UserId = driver.findElement(By.id("userEmail"));
	//the above step can be modified using pagefactor
	
	@FindBy(id="userEmail")
	WebElement UserId;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*=flyInOut")
	WebElement errorMsg;
	
	public void url() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public productCatelogue login(String email,String pw) {
		
		UserId.sendKeys(email);
		password.sendKeys(pw);
		submit.click();
		productCatelogue PC = new productCatelogue(driver);
		return PC;
	}
	
	public String getErrorMsg() {
		
		waitforWebElementToAppear(errorMsg);
		String msg =errorMsg.getText();
		return msg;
		
	}
	
	
	
	
	
}
