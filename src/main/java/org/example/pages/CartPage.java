package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By cartItems = By.className("cart_item");
    private By removeBackpack = By.id("remove-sauce-labs-backpack");
    private By removeBoltShirt = By.id("remove-sauce-labs-bolt-t-shirt");
    private By removeOnesie = By.id("remove-sauce-labs-onesie");
    private By continueShoppingBtn = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeBoltShirt() {
        driver.findElement(removeBoltShirt).click();
    }

    public void clickContinueShopping() {
        driver.findElement(continueShoppingBtn).click();
    }

}
