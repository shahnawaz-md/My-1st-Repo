package Arijit;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
	public WebDriver driver;
	
	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shahnawaz\\Desktop\\chromedriver.exe");
		 driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void close(){
		driver.close();
		driver.quit();
		
		}
	
	@Test
	public void facebook() throws InterruptedException{
		driver.findElement(By.id("email")).sendKeys("forloveorix@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("tushardas12");
		driver.findElement(By.id("u_0_n")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("userNavigationLabel")).click();
		driver.findElement(By.xpath(".//*[@id='logoutButton']/input")).click();
		Thread.sleep(2000);
		
		
	}

}
