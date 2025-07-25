package basic_automation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// 
		
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.bing.com/search?pglt=41&q=google&cvid=f8a434db8af24bc7a495f9512bb657f4&gs_lcrp=EgRlZGdlKgYIABBFGDkyBggAEEUYOTIGCAEQRRg80gEIMTUwOWowajGoAgCwAgE&FORM=ANNAB1&PC=U531");
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\praveen.a.sakthivel\\screenshot.png");
	    FileUtils.copyFile(scr, destination);
	}

}
