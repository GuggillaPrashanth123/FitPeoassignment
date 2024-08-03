package aug3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



public class FitPeo {

	public static void main(String[] args) throws InterruptedException {
		//Launch Browser
		WebDriver driver = new ChromeDriver();
		//Maximize window
		driver.manage().window().maximize();
		//Delete All Cookies
		driver.manage().deleteAllCookies();
		//Wait for Element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Launch Url fitpeo Homepage
		driver.get("https://www.fitpeo.com/");
		//Click Revenue Calculator page
		driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
		//javascript object Creation
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//wait for 5 secs
		Thread.sleep(5000);
		//scroll to slider section
		js.executeScript("window.scrollBy(0,300)");
		//Adjust the Slider
		WebElement slider = driver.findElement(By.xpath("//span[contains(@data-index,'0')]"));
		Actions move = new Actions(driver);
		//selects randomly vaues until Adjust the slider to set its value to 820
		move.dragAndDropBy(slider, 50, 0).perform();
		move.dragAndDropBy(slider, 25, 0).perform();
		move.dragAndDropBy(slider, 9, 0).perform();
		move.dragAndDropBy(slider, 6, 0).perform();
		move.dragAndDropBy(slider, 6, 0).perform();
		move.sendKeys(Keys.ARROW_LEFT).perform();		
		move.sendKeys(Keys.ARROW_LEFT).perform();
		move.sendKeys(Keys.ARROW_LEFT).perform();	
		move.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		//Clear the text box
		driver.findElement(By.xpath("//input[@type='number']")).clear();
		Thread.sleep(5000);
		//	Update the text field by using javascript
		js.executeScript("document.querySelector(\"input[id=':r0:']\").value='560'");
		Thread.sleep(2000);
		//Validate Slider Value
		String Expectedtext ="560";
		String Actualtext = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");
		Thread.sleep(2000);
		if(Expectedtext.equalsIgnoreCase(Actualtext))
		{
			System.out.println(Expectedtext+"   "+Actualtext+"   "+"value matching");
		}
		else {
			System.out.println(Expectedtext+"   "+Actualtext+"   "+"value is not matching");
		}
		Thread.sleep(2000);
		//select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474.
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
		Thread.sleep(1000);
		//Validate Total Recurring Reimbursement
		String Expected = "$110700";
		String Actual = driver.findElement(By.xpath("(//p[position()=1])[5]")).getText();
		System.out.println(Actual);
		if(Expected.equalsIgnoreCase(Actual))
		{
			System.out.println(Expected+"   "+Actual+"   "+"value matching");
		}
		else {
			System.out.println(Expected+"   "+Actual+"   "+"value is not matching");
		}
		//Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700
		WebElement element = driver.findElement(By.xpath("//p[position()=4]"));
		boolean value = element.isDisplayed();
		System.out.println(value);

		driver.quit();
	}
}



