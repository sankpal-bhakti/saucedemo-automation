package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ExcelUtil;

public class LoginTest extends BaseTest {

	@DataProvider(name = "ld")
	public Object[][] data() throws Exception {
		return ExcelUtil.read("src/test/resources/logindata.xlsx", "Login");
	}

	@Test(dataProvider = "ld")
	public void login(String u, String p, String exp) {
		LoginPage lp = new LoginPage(d);
		lp.login(u, p);
		if (exp.equals("success")) {
			Assert.assertTrue(d.getCurrentUrl().contains("inventory"));
		} else {
			Assert.assertTrue(lp.err().contains(exp));
		}
	}
}
