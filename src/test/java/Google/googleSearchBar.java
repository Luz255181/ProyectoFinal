package Google;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;

public class googleSearchBar 
{
	WebDriver driver;
	Wait<WebDriver> wait;
	googlePage google;
	
	@BeforeSuite
	public void beforeSuit()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void beforetest()
	{
		// Launch Google Chrome and Open URL - http://www.google.com
		driver.manage().window().maximize();
		driver.get("http://www.google.com\r\n");
        google = new googlePage(driver);
	}
	
	@Test
	public void test()
	{
		// Enter the keyword "auto" in the search bar
		google.enterWordTextField("auto");
		
		// Wait for the Ajax suggestion box to appear
		google.waitAjaxSuggestionBoxVisible();
		
		// Get/store all the options of a suggestion box in a List<WebElement> and Print all the suggestions one by one.
		List<String> autoList = google.printSuggestions();
		
		// Clear the input of the search bar
		google.clearTextField();
		
		// Now enter the keyword “automation” in the search bar
		google.enterWordTextField("automation");
		
		// Wait for the Ajax suggestion box to appear
		google.waitAjaxSuggestionBoxVisible();
		
		// Get/store all the options of a suggestion box in a List<WebElement> and Print all the suggestions one by one
		List<String> automationList = google.printSuggestions();
		
		// Check that there is no coincidence between both lists of suggestions
		System.out.println(""+google.compareSuggestion(autoList, automationList));
		
		// Click on the first suggestion that has an image
		google.clickImageSuggestion();
		
		// Check that the first obtained result is a page from store.steampowered.com
		System.out.println(google.checkLinkFirstSuggestion());
	}
}
