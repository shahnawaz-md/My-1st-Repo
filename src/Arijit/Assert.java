package Arijit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assert {
public WebDriver driver;
	
	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shahnawaz\\Desktop\\chromedriver.exe");
		 driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://192.168.10.12:8080/corpmis-ui/admin/home");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void close(){
		driver.close();
		driver.quit();
		
		}
	@Test
	public void verify() throws InterruptedException{
		driver.findElement(By.id("loginId")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("loginSubmit")).click();
		Thread.sleep(2000);
		WebElement companyMenulink=driver.findElement(By.linkText("Company"));
	    WebElement companySubMenulink=driver.findElement(By.xpath(".//*[@id='headerPan']/div[4]/ul/li[1]/ul/li/a"));
	   
	    Actions actions = new Actions(driver);
	    actions.moveToElement(companyMenulink);
	    
	    
	    actions.moveToElement(companySubMenulink);
	    actions.build().perform();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.name("actionbean.queryParam.valueString")).sendKeys("184");
	    driver.findElement(By.xpath(".//*[@id='gridFilterSubmitForm']")).click();
	    Thread.sleep(5000);
	    WebElement companyName = driver.findElement(By.xpath(".//*[@id='184']/td[3]/a/i/u/b"));
	    String a =  companyName.getText();
	    System.out.println("----------------"+a);
	    Assert.assertEquals("Result","sample company",companyName.getText());
	    		
	    
		driver.findElement(By.xpath(".//*[@id='menu']/li[3]/a")).click();
		
	}

	private static void assertEquals(String string, String string2, String text) {
		// TODO Auto-generated method stub
		
	}

}
