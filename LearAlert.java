package Week4.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Alert.html");
		//driver.findElementByXPath("//button[text='Alert box']").click();
		driver.findElementByXPath("//button[text='Prompt box']").click();
		
		Alert alert=driver.switchTo().alert();
		
		/*
		 * alert.getText(); System.out.println(alert.getText()); //alert.accept();
		 * alert.dismiss();
		 */
		
		alert.sendKeys("hi this is praveen testing alert ");
		//Thread.sleep(2000);
		alert.accept();
	}

}
