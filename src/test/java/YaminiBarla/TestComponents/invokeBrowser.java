package YaminiBarla.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import YaminiBarla.pageObjectModel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class invokeBrowser {
	
	public WebDriver driver;
	public LandingPage LP;
	
	public WebDriver InitializeBrowser() throws IOException {
		
		Properties pro = new Properties();
		FileInputStream FIS = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\YaminiBarla\\resourses\\GlobalData.properties");
		pro.load(FIS);
		
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : pro.getProperty("browser");
		//String browserName=pro.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			 driver= new ChromeDriver(options);
			 driver.manage().window().setSize(new Dimension(1400,900));
			
			
		}
		
		else if(browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ajayp\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
			
			 driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
	
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
		});
		return data;
		
}
	
	public String TakeScreenshot(String testCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot Ts= (TakesScreenshot)driver;
		File source =Ts.getScreenshotAs(OutputType.FILE);
		File destinaton = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, destinaton);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
				
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchapplication() throws IOException {
		
		driver =InitializeBrowser();
		LP = new LandingPage(driver);
		LP.url();
		return LP;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		
		driver.close();
		
	}

}
