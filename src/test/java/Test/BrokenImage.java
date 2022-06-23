package Test;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import POJO.Browser;


public class BrokenImage extends Browser {
	
	WebDriver driver  ;
	
	@Test
	public void test() throws InterruptedException {
		driver =Browser.OpenBrowser("https://www.kotakcherry.com/deposits");
		
		List <WebElement> elementList = driver.findElements(By.tagName("img"));
		
		System.out.println("total no. of images in the webpage " +elementList.size());

		for(WebElement img:elementList) {
			if(img.getAttribute("width").equalsIgnoreCase("0")) {
				System.out.println("image is broken-->" + img.getAttribute("src"));
				
			}
			
		}
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{

	if(ITestResult.FAILURE == result.getStatus())
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			String name = result.getName();
			FileUtils.copyFile(source,new File("D:\\automation testing\\KotakAssignment\\screenshots\\" + name + ".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	driver.quit();
	}
}


