package Week4.day2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameClass {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		
		//find the size or count of the frame in web page
		int size_frame = driver.findElementsByTagName("iframe").size();
		// print the size or count of the frame
		System.out.println("The no.of.frame in web page is : "+size_frame);
		
		
		int count=0;
		
		//frame 3
				driver.switchTo().frame(2);
					
					
				// Let's us consider the count is zero so that we add the size+count
				
				for (int i = 1; i < size_frame; i++) 
				{
					driver.switchTo().frame(i);				
					count=count+driver.findElementsByTagName("iframe").size();
					
					driver.switchTo().defaultContent();	
					
				}
				int tot_no_frame=count+size_frame;
				
				System.out.println("the total number of frame Nested Frame is : "+tot_no_frame);
				
		
		
		
		//Logic for Frame
		
		driver.switchTo().frame(0);
		WebElement frameone_clickme = driver.findElementByXPath("//button[@id='Click']");
		frameone_clickme.click();
		String text = frameone_clickme.getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		
		//Nested Frame frame2 inside another Nested Frame2.1
		//Frame2
		driver.switchTo().frame(1);
		//frame2.1
		driver.switchTo().frame("frame2");
		WebElement secondframe_nested = driver.findElementById("Click1");
		secondframe_nested.click(); String text2 = secondframe_nested.getText();
		System.out.println(text2);
		//switch to main frame
		driver.switchTo().defaultContent();
		
		
		
		}

	
}
