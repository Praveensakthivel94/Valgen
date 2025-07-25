package basic_automation;

import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {
	static WebDriver driver=new EdgeDriver(); //global Variable
	public static void main(String[] args) {
		  url();
		  login();
		
	}
	public static void url() {
	    driver.get("https://rahulshettyacademy.com/locatorspractice/"); 
	    driver.manage().window().maximize();
	  
	}
	public static void login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    String homeTitle=driver.findElement(By.xpath("//h1[text()='Sign in']")).getText();
	    driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("a");
	    driver.findElement(By.xpath("(//input[@name='inputPassword'])")).sendKeys("a");
	    driver.findElement(By.cssSelector("input#chkboxTwo")).click();
	    driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
	    String errormsg=driver.findElement(By.cssSelector("p.error")).getText();
	    String compare="* Incorrect username or password";
	    if (errormsg.contains(compare))
	    {
	    	System.out.println("Login Failed" +errormsg);
	    	forgotpwd();
	    	
	    }
	}
	 public static void forgotpwd() {
		 driver.findElement(By.partialLinkText("Forgot your passwor")).click();
		 driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("ram");
		 driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ram@dubakur.com");
		 driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("898897878");
		 driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		 String templogin=driver.findElement(By.cssSelector("p.infoMsg")).getText();
		 String[] temppassword=templogin.trim().split("'"); 
		 String tepassword=temppassword[1];
		 System.out.println(tepassword);
		 driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		 retrylogin(tepassword);
	 }
	 public static void retrylogin(String tepassword) {
		 driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
		    driver.findElement(By.xpath("(//input[@name='inputPassword'])")).sendKeys(tepassword);
		    driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		    driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		    validate();
	 }
	 public static boolean validate() {
		 WebElement welcomeMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]"));
	        if (welcomeMessage.isDisplayed()) {
	            System.out.println("Login successful! Home screen validated.");
	            return true;
	        } else {
	            System.out.println("Home screen validation failed.");
	            return false;
	        }
	 }
}
