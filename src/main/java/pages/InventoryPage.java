package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

	WebDriverWait w;
	@FindBy(id = "add-to-cart-sauce-labs-backpack") WebElement add;
	@FindBy(className = "shopping_cart_badge") WebElement badge;
	@FindBy(className = "shopping_cart_link") WebElement cart;
	@FindBy(id = "react-burger-menu-btn") WebElement menu;
	@FindBy(id = "logout_sidebar_link") WebElement out;

	public InventoryPage(WebDriver d) {
		w = new WebDriverWait(d, Duration.ofSeconds(10));
		PageFactory.initElements(d, this);
	}

	public void addBag() 
	{ 
		add.click();
	}
	public String count() 
	{
		return badge.getText(); 
	}
	public void openCart() 
	{ 
		cart.click(); 
	}

	public void logout() {
		menu.click();
		w.until(ExpectedConditions.elementToBeClickable(out));
		out.click();
	}
}
