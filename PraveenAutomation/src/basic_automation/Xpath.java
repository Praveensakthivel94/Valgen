package basic_automation;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
public class Xpath {

	public static void main(String[] args) {
		
	 WebDriver driver=new EdgeDriver();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	 
	 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	 driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
	 //Xpath declaration
	 driver.findElement(By.xpath("//label[contains(@for,'honda')]")).click();
	 //Xpath regx
	 driver.findElement(By.xpath("//label[@for=\"bmw\"]/input[@type=\"checkbox\"]")).click();
	 //parent
	}
}
