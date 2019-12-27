package automacao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAutomacao {
	private static WebDriver driver;

	@BeforeClass
	public static void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "D://automacao//drivers//chromedriver_win32//chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://www.google.com/");

	}

	@Test
	public void Executa() {
		driver.get("http://www.google.com/");

		// Thread.sleep(5000); // Let the user actually see something!
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("ChromeDriver");
		searchBox.submit();
		// Thread.sleep(5000); // Let the user actually see something!

		//assertEquals("Google", driver.getTitle());
		driver.close();	
	}
	@Test
	public void Executa2() {
		driver.get("http://www.google.com/");

	
	}

	
	@Test	
	public void Executa3() {
		driver.get("http://www.google.com/");

		// Thread.sleep(5000); // Let the user actually see something!
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("HONDA HRV");
		searchBox.submit();
		// Thread.sleep(5000); // Let the user actually see something!

	}

	@Test	
	public void Executa4() {
	}
	
	@AfterClass
	public static void tearDownTest() {
		{
			driver.close();

			driver.quit();
			System.out.println("Será");
		}
	}



}
