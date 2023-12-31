package DataDriven_Testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reading_Property_Amazon {

	public static void main(String[] args) throws Throwable {
		 //creating an object for properties
		Properties p =new Properties();
		//creating an object for physical file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.properties");
		//loading this fis
		p.load(fis);
		//reading data from property file
		String URL = p.getProperty("url1");
		String ser = p.getProperty("search");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(ser);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

	}

}
