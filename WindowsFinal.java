package Week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsFinal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Window.html");
		//click first button to home page
		driver.findElementByXPath("//button[text()='Open Home Page']").click();
		Set<String> noOfWindows = driver.getWindowHandles();
		List<String> noOfWindowsList = new ArrayList<String>(noOfWindows);
		
		int size = noOfWindowsList.size();
		System.out.println("Number of open windows:"+size);
		
		  for (int i = 1; i < size; i++) {
		  
		  driver.switchTo().window(noOfWindowsList.get(i)); driver.close(); }
		  driver.switchTo().window(noOfWindowsList.get(0));
		  
			
			  driver.findElementByXPath("//button[text()='Wait for 5 seconds']").click();
			  
			  Thread.sleep(5000);
			  
			  driver.quit();
			 
		 
	}

}
