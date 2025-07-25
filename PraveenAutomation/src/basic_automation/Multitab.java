package basic_automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Multitab {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        WebElement footer = driver.findElement(By.cssSelector("div#gf-BIG"));
        List<WebElement> links = footer.findElements(By.tagName("a"));

        System.out.println("Total Links: " + links.size());

        for (WebElement link : links) {
            String openInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            link.sendKeys(openInNewTab);
            Thread.sleep(10000); 
        }
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> titles = new ArrayList<>();

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            titles.add(driver.getTitle());
        }

        System.out.println("Page Titles: " + titles);

        driver.quit();
    }
}
