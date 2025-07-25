package basic_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionstest {
	
	public static void main (String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		Actions a = new Actions(driver); 
		a.moveToElement(driver.findElement(By.xpath("//span[text()='Fashion']"))).build().perform();	
		Thread.sleep(10000);
		driver.get("https://www.amazon.in/ref=nav_logo");
		a.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).
		sendKeys("Shoes").build().perform();
		
	}

}
