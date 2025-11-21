package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private By title= By.className("title");
    private By cart=By.id("shopping_cart_container");
    private By item=By.cssSelector(".inventory_item");

    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By addBoltShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By addOnesie = By.id("add-to-cart-sauce-labs-onesie");

    private By removeBackpack = By.id("remove-sauce-labs-backpack");
    private By removeBoltShirt = By.id("remove-sauce-labs-bolt-t-shirt");
    private By removeOnesie = By.id("remove-sauce-labs-onesie");

    private By linkedin = By.linkText("LinkedIn");
    private By twitter = By.linkText("Twitter");
    private By facebook = By.linkText("Facebook");


    public InventoryPage(WebDriver driver){
        this.driver=driver;
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public boolean isCartIconDisplayed() {
        return driver.findElement(cart).isDisplayed();
    }

    public int getProductsCount() {
        List<?> items = driver.findElements(item);
        return items.size();
    }

    public void addBackpack() {
        driver.findElement(addBackpack).click();
    }

    public void addBoltShirt() {
        driver.findElement(addBoltShirt).click();
    }

    public void addOnesie() {
        driver.findElement(addOnesie).click();
    }

    public boolean backpackIsAdded() {
        return driver.findElement(removeBackpack).isDisplayed();
    }

    public boolean boltShirtIsAdded() {
        return driver.findElement(addBoltShirt).isDisplayed();
    }

    public boolean onesieIsAdded() {
        return driver.findElement(removeOnesie).isDisplayed();
    }

    public void openCart() {
        driver.findElement(cart).click();
    }

    public void clickLinkedIn() {
        driver.findElement(linkedin).click();
    }

    public void clickTwitter() {
        driver.findElement(twitter).click();
    }

    public void clickFacebook() {
        driver.findElement(facebook).click();
    }

}
