package YaminiBarla.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ecomerseTestBasic {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("yamini@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("$Bynsunanda$410");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement product= products.stream().filter(p->
		p.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		List<WebElement> list = driver.findElements(By.cssSelector(".cartSection h3"));
		
		//This step is anymatch returns true if the list of elememts has zaracoat or return false
		boolean match = list.stream().anyMatch(l->l.getText().equals("ZARA COAT 3"));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".subtotal button")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Ind");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-results']")));
		List<WebElement> countries = driver.findElements(By.cssSelector("button[class*='ta-item']"));
		
		WebElement country =countries.stream().filter(c->
		c.getText().equals("India")).findFirst().orElse(null);
		country.click();
		
		driver.findElement(By.cssSelector("a[class*='submit']")).click();
		
		Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"THANKYOU FOR THE ORDER.");
		
		driver.close();
	}

}
