package Demoblaze;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class Test
{
	WebDriver driver;
	homePage home;
	productPage product;
	cartPage cart;
	
	@Given("^I am on the web page$")
	public void i_am_on_the_web_page()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
		home = new homePage(driver);
		product = new productPage(driver);
		cart = new cartPage(driver);
	}
	
	@When("^I add two or more items to the cart$")
	public void i_add_two_or_more_items_to_the_cart()
	{
		String macbook = "MacBook Pro";
		String samsung = "Samsung galaxy s7";
		WebElement narvbarx = driver.findElement(By.id("narvbarx"));
		home.waitHomeBannerVisible(narvbarx);
		home.checkHomeBannerVisible(narvbarx);
		WebElement laptops = driver.findElement(By.cssSelector("[onclick=\"byCat('notebook')\"]"));
	    home.waitSectionClickeableAndClick(laptops);
	    home.waitProductVisible(macbook);
	    home.clickProduct(macbook);
	    product.waitAddToCartVisible("[onclick=\"addToCart(15)\"]");
	    WebElement cartButtonMac = driver.findElement(By.cssSelector("[onclick=\"addToCart(15)\"]"));
	    product.clickAddToCart(cartButtonMac);
	    product.aceptButton();
	    product.backHomePage();
	    narvbarx = driver.findElement(By.id("narvbarx"));
	    home.waitHomeBannerVisible(narvbarx);
		home.checkHomeBannerVisible(narvbarx);
		WebElement phones = driver.findElement(By.cssSelector("[onclick=\"byCat('phone')\"]"));
	    home.waitSectionClickeableAndClick(phones);
	    home.waitProductVisible(samsung);
	    home.clickProduct(samsung);
	    product.waitAddToCartVisible("[onclick=\"addToCart(4)\"]");
	    WebElement cartButtonPhone = driver.findElement(By.cssSelector("[onclick=\"addToCart(4)\"]"));
	    product.clickAddToCart(cartButtonPhone);
	    product.aceptButton();
	    product.cartPage();
	}
	
	@And("^I click \"Place Order\" button$")
	public void i_click_Place_Order_button()
	{
		cart.waitListProductVisible();
		cart.clickPlaceOrder();
		cart.waitFormVisible();
	}
	
	@And("^I complete de form$")
	public void i_complete_de_form()
	{
		String data[] = {"Luz", "Argentina", "Bahía Blanca", "1234 5678 9010 1112", "Marzo", "2028"};
		cart.completeForm(data);
		cart.clickPurchase();
	}
	
	@Then("^the page show a confirmation message")
	public void the_page_show_a_confirmation_message()
	{
		cart.waitComfirmationmessage();
	}
	
	@And("^The information in the confirmation message is correct$")
	public void the_information_in_the_confirmation_message_is_correct()
	{
		
	}
}
