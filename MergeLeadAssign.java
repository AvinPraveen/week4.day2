package Week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeadAssign {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//first page of leaftaps
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		//second page of leaftaps
		driver.findElementByLinkText("CRM/SFA").click();
		
		//third page click on lead link
		driver.findElementByXPath("//a[@href='/crmsfa/control/leadsMain' and text()='Leads']").click();
		//fourth page click Merge Lead Link 
		driver.findElementByXPath("//a[@href='/crmsfa/control/mergeLeadsForm' and text()='Merge Leads']").click();
		
		//click on window consider this a permiary window
		
		//opening the first windows
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		
		//by clicking on window button goto new window now 
		//driver.switchTo().window(windowHandle);

		driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();
		Thread.sleep(1000);
		String stringWindow_Second = getSecondWindowHandle(driver);
		/*
		 * Set<String> handles = driver.getWindowHandles(); List<String> listhand=new
		 * ArrayList<String>(handles); String stringWindow_Second =listhand.get(1);
		 */
		driver.switchTo().window(stringWindow_Second);
		System.out.println(driver.getTitle());
				driver.findElementByXPath("(//a[@class='linktext'])[1]").click();
				
				//to switch the current window
				driver.switchTo().window(windowHandle);
				driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();
				/*
				 * Set<String> handles1 = driver.getWindowHandles(); 
				 * List<String> listhand1=new ArrayList<String>(handles1); 
				 * String stringWindow_Second1 =listhand.get(1);
				 */
				
				String stringWindow_Second1 = getSecondWindowHandle(driver);
				 
				 driver.switchTo().window(stringWindow_Second1);
				 driver.findElementByXPath("(//a[@class='linktext'])[1]").click();
				// driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();
				 driver.switchTo().window(windowHandle);
				 
				 driver.findElementByXPath("//a[@class='buttonDangerous']").click();
				 //String text = driver.findElementByClassName("errorMessageHeader").getText();
				 driver.switchTo().alert().accept();
				 String title = driver.getTitle();
				 System.out.println(title);
				// System.out.println(text);
				 
		
		  
		}
	
	
	public static String getSecondWindowHandle(ChromeDriver driver)
	{
		Set<String> handles = driver.getWindowHandles();
		List<String> listhand=new ArrayList<String>(handles); 
		 String stringWindow =listhand.get(1); 
		 
		 return stringWindow;
	}
		




}
