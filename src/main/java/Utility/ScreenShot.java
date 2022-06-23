package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenShot {
	public static WebDriver driver;
	public static void takeScreenshot()  {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source,new File("D:\\automation testing\\KotakAssignment\\screenshots\\failedtest.jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}


}
