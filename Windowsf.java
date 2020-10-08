package Week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowsf {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		String parentWindowHandles = driver.getWindowHandle();
		driver.findElementById("home").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> List_of_windows=new ArrayList<String>(windowHandles);
		int size = List_of_windows.size();
		
		System.out.println("the size of the window:"+size);
		driver.switchTo().window(parentWindowHandles);
		//driver.close();
		
		driver.findElementByXPath("//button[text()='Open Multiple Windows']").click();
		Set<String> second_buttonHandles = driver.getWindowHandles();
		List<String> List_of_second=new ArrayList<String>(second_buttonHandles);
		int size2_bttonclick = List_of_second.size();
		System.out.println("the size of the window of second button click is : "+size2_bttonclick);
		driver.switchTo().window(parentWindowHandles);
		
		 
		/*
		 * driver.findElementByXPath("//button[text()='Do not close me']").click();
		 * Set<String> Third_buttonHandles = driver.getWindowHandles(); List<String>
		 * List_of_Third=new ArrayList<String>(Third_buttonHandles); int size2 =
		 * List_of_Third.size(); for (int i = 0; i < size2; i++) {
		 * driver.switchTo().window(List_of_Third.get(i));
		 * 
		 * 
		 * }
		 */
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement waitforsec = driver.findElementByXPath("//button[text()='Wait for 5 seconds']");
		waitforsec.click();
		driver.switchTo().window(parentWindowHandles);
		//driver.quit();
		
		
		
		
		
	}

}
