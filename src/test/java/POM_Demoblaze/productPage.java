package POM_Demoblaze;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productPage {
	WebDriver driver;
	Wait<WebDriver> wait;
	
	public productPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	
	public void waitAddToCartVisible(String button)
	{
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(button)));
	}
	
	public void clickAddToCart(WebElement cart)
	{
	     cart.click();
	}
	
	public void backHomePage()
	{
		driver.findElement(By.id("nava")).click();
	}
	
	public void aceptButton()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public void cartPage()
	{
		driver.findElement(By.id("cartur")).click();
	}
}

