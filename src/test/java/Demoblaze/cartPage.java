package Demoblaze;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartPage
{
	WebDriver driver;
	Wait<WebDriver> wait;
	
	public cartPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void waitListProductVisible()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"success\"]")));
	}
	
	public void clickPlaceOrder()
	{
		driver.findElement(By.cssSelector("[class=\"btn btn-success\"]")).click();
	}
	
	public void waitFormVisible()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("year")));
		
	}
	
	public void completeForm(String[] data)
	{
		driver.findElement(By.id("name")).sendKeys(data[0]);
		driver.findElement(By.id("country")).sendKeys(data[1]);
		driver.findElement(By.id("city")).sendKeys(data[2]);
		driver.findElement(By.id("card")).sendKeys(data[3]);
		driver.findElement(By.id("month")).sendKeys(data[4]);
		driver.findElement(By.id("year")).sendKeys(data[5]);
	}
	
	public void clickPurchase()
	{
		driver.findElement(By.cssSelector("[onclick=\"purchaseOrder()\"]")).click();
	}
	
	public void waitComfirmationmessage()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"lead text-muted \"]")));
		String datos[] = driver.findElement(By.cssSelector("[class=\"lead text-muted \"]")).getText().split("\n");
		for (String line : datos)
		{
		}
	}
}
