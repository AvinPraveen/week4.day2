package Week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcLearn {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.findElementByXPath("//button[@class='btn btn-primary']").click();
		
		
		
		//to get the reference of current window
		String windowHandle = driver.getWindowHandle();
		System.out.println("The current first window titleis : "+windowHandle);
        System.out.println("the titile of url :"+driver.getTitle());
		
    	
		
		  driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
		   
		  System.out.println("***************************************************************");
		  System.out.println("   ");
		  System.out.println("current window page is :"+driver.getTitle());
		  System.out.println(); System.out.println("****************************************************************");
		  Set<String> setwindowref = driver.getWindowHandles();
		  
		  List<String> listofHandles=new ArrayList<String>(setwindowref); String
		  secondwindow = listofHandles.get(1);
		  
		  //to get the reference of the second windows
		  driver.switchTo().window(secondwindow); String title = driver.getTitle();
		  System.out.println("The title of windows :"+title);
		 //IF I CLOSE THIS ONLY SECOND WINDDOWS GET CLOSE
		  //driver.close();
		  driver.switchTo().window(windowHandle).close();	  

		
		
		
		
	}

}
