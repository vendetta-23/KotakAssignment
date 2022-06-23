package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import POJO.Browser;




public class FixedDeposit {
WebDriver driver;
	
	@BeforeMethod
	public void callBrowser() throws InterruptedException {
		driver = Browser.OpenBrowser("https://www.kotakcherry.com/deposits/fixed-deposit");
	}
	
	@Test
	public void EnterMinValue() throws IOException, InterruptedException{
		FileInputStream fs = new FileInputStream("D:\\automation testing\\KotakAssignment\\TestDataSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		double value = sheet.getRow(0).getCell(1).getNumericCellValue();
		String s=String.valueOf(value);  
		System.out.println(s);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']/input")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']/input")).sendKeys(s);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']/input")).sendKeys(Keys.TAB);


		String text = driver.findElement(By.xpath("//div[text()='Minimum: 10000']")).getText();
		Assert.assertEquals(text, "Minimum: 10000");
		 workbook.close();
		
	
	}
	@Test
	public void EnterMaxValue() throws IOException, InterruptedException{
		FileInputStream fs = new FileInputStream("D:\\automation testing\\KotakAssignment\\TestDataSheet.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		double value = sheet.getRow(1).getCell(1).getNumericCellValue();
		String s=String.valueOf(value);  
		System.out.println(s);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']/input")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']/input")).sendKeys(s);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ieco-blue-underline']/input")).sendKeys(Keys.TAB);

		String text = driver.findElement(By.xpath("//div[text()='Maximum: 100000']")).getText();
	    Assert.assertEquals(text, "Maximum: 100000");
	    workbook.close();
		
		
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

