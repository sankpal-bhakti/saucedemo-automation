package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	@FindBy(id = "checkout") WebElement co;
	@FindBy(id = "first-name") WebElement f;
	@FindBy(id = "last-name") WebElement l;
	@FindBy(id = "postal-code") WebElement z;
	@FindBy(id = "continue") WebElement c;
	@FindBy(id = "finish") WebElement fin;
	@FindBy(className = "complete-header") WebElement m;

	public CheckoutPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void start() { co.click(); }

	public void info(String a, String b, String zip) {
		f.sendKeys(a);
		l.sendKeys(b);
		z.sendKeys(zip);
		c.click();
	}

	public void finish() { fin.click(); }
	public String text() { return m.getText(); }
}

