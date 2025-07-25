package basic_automation;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dropdown {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		selection(driver);
	}

	public static void selection(WebDriver driver) {
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		String title = driver.getTitle();
		if (title.contains("Practice Page")) {
			checkboxvalidation(driver);
		}
	}

	public static void checkboxvalidation(WebDriver driver) {
		WebElement options = driver.findElement(By.cssSelector("select#dropdown-class-example"));
		Select drp = new Select(options);
		drp.selectByIndex(1);
		drp.selectByVisibleText("Option2");

		String validate = drp.getFirstSelectedOption().getText();
		Assert.assertEquals(validate, "Option2");
	}
}
