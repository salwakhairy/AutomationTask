package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernamein= By.id("user-name");
    private By passwordin=By.id("password");
    private By button=By.id("login-button");
    private By errorMessage=By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        driver.findElement(usernamein).clear();
        driver.findElement(usernamein).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordin).clear();
        driver.findElement(passwordin).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(button).click();
    }

    /*public InventoryPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return new InventoryPage(driver);
    }*/

    public String getErrorMessage() {
        WebElement el = driver.findElement(errorMessage);
        return el.getText().trim();
    }
}
