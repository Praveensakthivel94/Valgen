package basic_automation;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class Greenkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
	}
	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		int iterateList = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
List itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formattedName))
			{
				iterateList++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (iterateList == itemsNeeded.length)
				{
					break;
				}
			}
		}
	}
}
