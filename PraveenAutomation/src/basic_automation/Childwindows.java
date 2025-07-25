package basic_automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Childwindows {

	public static void main(String[] args) throws InterruptedException {
		// Switching Parent to child windows 
		WebDriver driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> swap=driver.getWindowHandles();
		Iterator<String> swapwindow=swap.iterator();
		String parent=swapwindow.next();
		String child=swapwindow.next();
	
		driver.switchTo().window(child);
		String username=driver.findElement(By.cssSelector("a[href='mailto:mentor@rahulshettyacademy.com']")).getText();
        driver.switchTo().window(parent);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#username")).sendKeys(username);     
		
	}

}
