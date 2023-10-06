package POM_Demoblaze;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

	WebDriver driver;
	Wait<WebDriver> wait;
	
	public homePage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	public void waitHomeBannerVisible(WebElement banner)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(banner));
	}
	
	public void checkHomeBannerVisible(WebElement banner)
	{
		if(!banner.isDisplayed())
        {
        	driver.quit();
        }
	}
	
	public void waitSectionClickeableAndClick(WebElement section)
	{
		wait.until(ExpectedConditions.elementToBeClickable(section));
        section.click();
	}
	
	public void clickProduct(String product)
	{
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(product)));
        WebElement item = driver.findElement(By.linkText(product));
        item.click();
	}
	
	public void waitProductVisible(String product)
	{
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(product)));
	}
	
}

