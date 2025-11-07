package tests;

import base.BaseTests;
import org.example.pages.InventoryPage;
import org.example.pages.LoginPage;
import org.example.utils.DataDriven;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class InventoryTest extends BaseTests {
    @Test
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

}

