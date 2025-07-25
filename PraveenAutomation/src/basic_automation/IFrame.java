package basic_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrame {

	public static void main(String[] args) {
		// Handling iFrame
		WebDriver driver=new EdgeDriver();
		driver.navigate().to("https://jqueryui.com/");
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//a[normalize-space()='Draggable']")));
				
		
	}

}
