package tests;

import base.BaseTests;
import org.example.pages.CartPage;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.example.utils.DataDriven;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class CartTest extends BaseTests {
@Test (priority = 0)
public void testCartIsEmpty() {
    LoginPage login = new LoginPage(driver);
    login.open();
    Map<String, String> creds = DataDriven.getCredentials("valid");
    login.enterUsername(creds.get("username"));
    login.enterPassword(creds.get("password"));
    login.clickLogin();

    InventoryPage inv=new InventoryPage(driver);
    inv.openCart();
    CartPage cart = new CartPage(driver);
    Assert.assertEquals(cart.getCartItemsCount(), 0);
    driver.navigate().back();
}
@Test(priority = 1)
    public void testAddThreeProducts() {
    InventoryPage inv=new InventoryPage(driver);
    inv.addBackpack();
    inv.addBoltShirt();
    inv.addOnesie();

    inv.openCart();
    CartPage cart = new CartPage(driver);

    Assert.assertEquals(cart.getCartItemsCount(), 3);
    driver.navigate().back();
    }
    @Test(priority = 2)
    public void testRemoveOneProduct() {
    InventoryPage inv=new InventoryPage(driver);
    inv.openCart();
    CartPage cart=new CartPage(driver);
    cart.removeBoltShirt();
        cart.clickContinueShopping();
        Assert.assertTrue(inv.backpackIsAdded());
        Assert.assertTrue(inv.onesieIsAdded());
        Assert.assertTrue(inv.boltShirtIsAdded());
    }

}
