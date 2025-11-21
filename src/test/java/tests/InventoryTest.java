package tests;

import base.BaseTests;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.example.utils.DataDriven;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class InventoryTest extends BaseTests {
    @Test(priority = 0)
    public void inventorytest(){
        LoginPage login=new LoginPage(driver);
        login.open();
        InventoryPage inventory=new InventoryPage(driver);
        Map<String, String> creds = DataDriven.getCredentials("valid");
        login.enterUsername(creds.get("username"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        String title = inventory.getTitleText();
        Assert.assertEquals(title, "Products", "Expected page title 'Products' (Swag Labs shows 'Products' heading).");

        // Cart Icon
        Assert.assertTrue(inventory.isCartIconDisplayed(), "Cart icon should be displayed.");

        // Number of products (should be 6)
        int count = inventory.getProductsCount();
        Assert.assertEquals(count, 6, "Expected 6 products on the inventory page.");
    }
    @Test(priority = 1)
    public void testlinckedin() {
        InventoryPage inv = new InventoryPage(driver);
        inv.clickLinkedIn();
        switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }
@Test(priority = 2)
    public void testfacbook() {
        InventoryPage inv = new InventoryPage(driver);
        inv.clickFacebook();
        switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
    driver.close();
    driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }
    @Test(priority = 3)
        public void testtwitter(){
        InventoryPage inv = new InventoryPage(driver);
        inv.clickTwitter();
        switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("twitter") ||
                driver.getCurrentUrl().contains("x.com"));
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
    }

}

