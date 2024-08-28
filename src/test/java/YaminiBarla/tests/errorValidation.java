package YaminiBarla.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import YaminiBarla.TestComponents.Retry;
import YaminiBarla.TestComponents.invokeBrowser;
import YaminiBarla.pageObjectModel.CartPage;
import YaminiBarla.pageObjectModel.productCatelogue;

public class errorValidation extends invokeBrowser{
	
	@Test(groups={"errorTest"},retryAnalyzer=Retry.class)
	public void ErrormsgCheck() {
		LP.login("yam@gmail.com", "$Bynsunanda$410");
		Assert.assertEquals("Incorrect email or password.", LP.getErrorMsg());
		
	}
		
		
	

}
