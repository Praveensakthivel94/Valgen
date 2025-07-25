package basic_automation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        SoftAssert soft = new SoftAssert();
        
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        for (WebElement link : links) {
            String src = link.getDomAttribute("href");

            if (src == null || src.isEmpty()) {
                System.out.println("Skipping empty link.");
                continue;
            }

            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(src).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                int resp = conn.getResponseCode();

                
                soft.assertTrue(resp < 400, "Broken link: " + src + " with status code " + resp);
            } catch (Exception e) {
                System.out.println("Error checking link: " + src + " - " + e.getMessage());
            }
        }
        soft.assertAll();
        driver.quit();
    }
}
