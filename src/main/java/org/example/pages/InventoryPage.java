package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private By title= By.className("title");
    private By cart=By.id("shopping_cart_container");
    private By item=By.cssSelector(".inventory_item");


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

  /*  public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }*/
}
