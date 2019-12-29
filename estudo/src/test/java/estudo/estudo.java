package estudo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class estudo {
	private static WebDriver driver;
	public static String Caminho;

	
	public static void main(String[] args) throws IOException {
		System.out.println("Rafael");
		
	}
	@BeforeClass
	public static void setUpTest() throws IOException  {

		Properties prop = getProp();
		Caminho = prop.getProperty("caminho");
	
		System.setProperty("webdriver.chrome.driver", Caminho);
	}
	
	
	
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/config.properties");
		props.load(file);
		return props;

		
	}

	
	public void printScreen() {

		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
		    // now copy the  screenshot to desired location using copyFile method
		   
		   FileUtils.copyFile(src, new File("C:/temp/Evidencia"+System.currentTimeMillis()+".png"));
		         }
		   
		  catch (IOException e)
		   
		  {
		   
		  System.out.println(e.getMessage());
		   
		      }
		   
		  }

	
	public void printScreen2() throws IOException {
	
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File("C:\\temp\\fullimage.jpg"));

	}		   
		  

	

	@Test
	public  void Executa() throws InterruptedException, IOException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		if(driver.getTitle().equals("Google"))

	
//		printScreen();
		printScreen2();
		Thread.sleep(5000); // Let the user actually see something!
		driver.close();
	}

}
