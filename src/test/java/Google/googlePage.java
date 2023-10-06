package Google;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googlePage 
{
	WebDriver driver;
	Wait<WebDriver> wait;
	
	public googlePage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void enterWordTextField(String word)
	{
		driver.findElement(By.id("APjFqb")).sendKeys(word);
	}
	
	public void waitAjaxSuggestionBoxVisible()
	{
		WebElement suggestions = driver.findElement(By.id("Alh6id"));
		wait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
		if(!suggestions.isDisplayed())
		{
			driver.quit();
		}
	}

	public List<String> printSuggestions()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("[jsaction=\"click:.CLIENT;mouseover:.CLIENT\"]"))));
		List<WebElement> List = driver.findElements(By.cssSelector("[jsaction=\"click:.CLIENT;mouseover:.CLIENT\"]"));
		List<String> suggestions = new LinkedList<String>();
		for (WebElement element:List)
		{
			String elem = element.findElement(By.cssSelector("[aria-label]")).getAttribute("aria-label");
			suggestions.add(elem);
			System.out.println(elem);
		}
		System.out.println();
		return suggestions;
	}
	
	public void clearTextField()
	{
		driver.findElement(By.id("APjFqb")).clear();
	}
	
	public Boolean compareSuggestion(List<String> List1, List<String> List2)
	{
		Boolean coincidence = false;
		for (String element1 : List1)
		{
			for (String element2 : List2)
			{
				if(element1.equals(element2))
				{
					coincidence = true;
					break;
				}
			}
			if(coincidence)
				break;
		}
		return coincidence;
	}
	
	public void clickImageSuggestion()
	{
		driver.findElement(By.cssSelector("[class=\"sbct sbre\"]")).click();
	}
	
	public boolean checkLinkFirstSuggestion()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("rcnt")));
		String url = driver.findElement(By.cssSelector("[class=\"qLRx3b tjvcx GvPZzd cHaqb\"]")).getText();
		return url.contains("store.steampowered.com");
	}
}
