package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.PropUtil;

public class BaseTest {

	WebDriver d;

	@BeforeMethod
	public void st() {
		d = new ChromeDriver();
		d.manage().window().maximize();
		int w = Integer.parseInt(PropUtil.get("wait").trim());
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(w));
		d.get(PropUtil.get("url"));
	}

	@AfterMethod
	public void en() {
		d.quit();
	}
}
