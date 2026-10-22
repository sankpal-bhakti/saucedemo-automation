package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	  @FindBy(id = "user-name") WebElement u;
	  @FindBy(id = "password") WebElement p;
	  @FindBy(id = "login-button") WebElement b;
	  @FindBy(css = "[data-test='error']") WebElement e;

	  public LoginPage(WebDriver d) {
	    PageFactory.initElements(d, this);
	  }

	  public void login(String un, String pw) {
	    u.sendKeys(un);
	    p.sendKeys(pw);
	    b.click();
	  }

	  public String err() {
	    return e.getText();
	  }

}
