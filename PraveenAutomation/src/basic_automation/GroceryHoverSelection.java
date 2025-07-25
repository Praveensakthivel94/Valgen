package basic_automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class GroceryHoverSelection {
    public static void main(String[] args) {
        // Set ChromeDriver path
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jiomart.com/"); // Replace with actual website URL

        try {
            Actions actions = new Actions(driver);

            // Locate 'Groceries' category and hover
            WebElement groceriesMenu = driver.findElement(By.id("nav_cat_2"));
            actions.moveToElement(groceriesMenu).perform();
            System.out.println("Hovered over 'Groceries'");

            // Locate 'Biscuits, Drinks & Packaged Foods' subcategory and hover
            WebElement subCategory = driver.findElement(By.id("nav_sub_cat_28997"));
            actions.moveToElement(subCategory).perform();
            subCategory.click();
            System.out.println("Selected 'Biscuits, Drinks & Packaged Foods'");

            // Get all subcategories
            List<WebElement> subCategories = driver.findElements(By.cssSelector(".header-nav-l3-item a"));

            for (WebElement subCat : subCategories) {
                String subCatName = subCat.getText();
                if (subCatName.equalsIgnoreCase("Biscuits & Cookies") || 
                    subCatName.equalsIgnoreCase("Drinks & Juices") || 
                    subCatName.equalsIgnoreCase("Noodles, Pasta & Vermicelli")) {

                    // Hover over and click on subcategory
                    actions.moveToElement(subCat).perform();
                    subCat.click();
                    System.out.println("Navigated to: " + subCatName);

                    // Find and add products to cart
                    List<WebElement> products = driver.findElements(By.className("product-item-class")); // Update class name

                    for (WebElement product : products) {
                        WebElement productName = product.findElement(By.className("product-title-class")); // Update class name
                        System.out.println("Found Product: " + productName.getText());

                        // Click 'Add to Cart' button
                        WebElement addToCartButton = product.findElement(By.className("add-to-cart-button-class")); // Update class name
                        addToCartButton.click();
                        System.out.println("Added to cart: " + productName.getText());
                    }

                    // Navigate back
                    driver.navigate().back();
                    actions.moveToElement(subCategory).perform();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser after delay
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
            driver.quit();
        }
    }
}
