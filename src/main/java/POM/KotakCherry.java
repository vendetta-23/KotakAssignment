package POM;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class KotakCherry {
	WebDriver driver;
	@FindBy(xpath ="//div[@style=\\\\\\\"color: rgb(161, 194, 230);\\\\\\\"][4]" ) public WebElement deposit;
	@FindBy(xpath = "//mat-card[@class=\\\"mat-card mat-focus-indicator ieco-example-card ieco-mar-bot-16 ieco-cursor-pointer\\\"][1]") public WebElement Fixed;

	public void page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void deposits() {
		deposit.click();
	}
	

	public void fixedDeposit() {
		Fixed.click();
	
	}
}
