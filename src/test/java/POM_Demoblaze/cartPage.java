package POM_Demoblaze;

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
	
	public String waitListProductVisible()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"success\"]")));
		return driver.findElement(By.id("totalp")).getText();
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
	}
	
	public boolean checkConfimationInformation(String[] information)
	{
		boolean correct = false;
		boolean name = false;
		boolean card = false;
		boolean amount = false;
		String[] l;
		String data[] = driver.findElement(By.cssSelector("[class=\"lead text-muted \"]")).getText().split("\n");
		for (String line : data)
		{
			l = line.split(": ");
			if(l[1].trim().equals(information[0].trim()))
			{
				name = true;
			}
			if(l[1].trim().equals(information[1].trim()))
			{
				card = true;
			}
			if(l[1].trim().equals(information[2].trim()))
			{
				amount = true;
			}
		}
		if(name && card && amount)
			correct = true;
		return correct;
	}
}
