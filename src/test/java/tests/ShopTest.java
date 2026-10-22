package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utils.*;


public class ShopTest extends BaseTest {

	@DataProvider(name = "cd")
	public Object[][] data() throws Exception {
		return ExcelUtil.read("src/test/resources/logindata.xlsx", "Checkout");
	}

	@Test(dataProvider = "cd")
	public void order(String f, String l, String z) {
		LoginPage lp = new LoginPage(d);
		InventoryPage ip = new InventoryPage(d);
		CheckoutPage cp = new CheckoutPage(d);

		lp.login(PropUtil.get("user"), PropUtil.get("pass"));
		ip.addBag();
		Assert.assertEquals(ip.count(), "1");
		ip.openCart();
		cp.start();
		cp.info(f, l, z);
		cp.finish();
		Assert.assertEquals(cp.text(), "Thank you for your order!");
	}

}
