package Week4.day2;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Alert.html");
		
		  driver.findElementByXPath("//button[text()='Alert Box']").click(); Alert
		  alert = driver.switchTo().alert(); Thread.sleep(1000); alert.accept();
		 

		
		  driver.findElementByXPath("//button[text()='Confirm Box']").click();
		  
		  
		  driver.switchTo().alert(); alert.accept();
		  
		  
		  WebElement textid = driver.findElementById("result");
		  System.out.println(textid.getText());
		  
		  
		  
		  
		  driver.findElementByXPath("//button[text()='Prompt Box']").click();
		  
		  driver.switchTo().alert(); alert.sendKeys("Praveen"); Thread.sleep(2000);
		  alert.accept(); WebElement textid1 = driver.findElementById("result1");
		  System.out.println(textid1.getText());
		  
		  
		  
		  WebElement Line_break =
		  driver.findElementByXPath("//button[text()='Line Breaks?']");
		  Line_break.click();
		  
		  
		  Thread.sleep(1000); 
		  alert.accept();
		  
		
		  
		  String text = alert.getText(); 
		  System.out.println(text);
		  
		 

		driver.findElementByXPath("//button[text()='Sweet Alert']").click();
		Thread.sleep(1000);
		WebElement alertmsg = driver.findElementByXPath("//button[@class='swal-button swal-button--confirm' ]");
		String sweermsg = alertmsg.getText();
		
		alertmsg.click();
		System.out.println(sweermsg);


	}

}
