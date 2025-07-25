package basic_automation;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CssSelector {

	public static void main(String[] args) {
		
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("test equation");
		driver.findElement(By.cssSelector("label[for=\"radio1\"] input[class=\"radioButton\"]")).click();
		//parent*space*child relation
		Assert.assertTrue(driver.findElement(By.cssSelector("label[for=\"radio1\"] input[class=\"radioButton\"]")).isSelected());
		//tagname.classname
		//tagname#id
		//tagname[label="attributevalue"]
		//tagname[label*="attributevalue"] -> RegX
		String Domvalue=driver.findElement(By.cssSelector("input[value*=\"dio3\"]")).getDomAttribute("value");
		System.out.println(Domvalue);
	}

}
