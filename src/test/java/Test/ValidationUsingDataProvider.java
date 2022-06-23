package Test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POJO.Browser;

public class ValidationUsingDataProvider {
WebDriver driver;
	
	@BeforeMethod
	public void callBrowser() throws InterruptedException {
		driver = Browser.OpenBrowser("https://www.kotakcherry.com/deposits/fixed-deposit");
	}
	
	
	@Test(dataProvider="getData")
	public void validations(String amount, String interest) throws IOException, InterruptedException{
		//String s=String.valueOf(amount);  
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']/input")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']/input")).sendKeys(amount);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']/input")).sendKeys(Keys.TAB);
		Thread.sleep(5000);

		String text = driver.findElement(By.xpath("//div[@class='ieco-fd-highlight-amount']/div/div[2]")).getText();
	    System.out.println(text);
		Assert.assertEquals(text, interest);
	    
		
		
	}
	@DataProvider
    public Object[][] getData()
    {
    Object[][] data= new Object [2][2];
    
    data[0][0]="15000";
    data[0][1]="₹8,806";
    
    data[1][0]="25000";
    data[1][1]="₹14,677";
    
   
    return data;		
    }
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
