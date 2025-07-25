package basic_automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutoSuggestionBox {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
	EdgeDriver driver=new EdgeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("ind");
	List<WebElement> opts=driver.findElements(By.cssSelector("input[id='autocomplete']"));
	
	for(WebElement filt:opts) {
		if (filt.getText().equalsIgnoreCase("india")){
        	filt.click();
        	break;
		}
	}
	}
}
