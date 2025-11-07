package tests;

import base.BaseTests;
import org.example.pages.LoginPage;
import org.example.utils.DataDriven;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTests {
    @Test
    public void testSuccessfulLogin(){
        LoginPage login=new LoginPage(driver);
        login.open();
        Map<String, String> creds = DataDriven.getCredentials("valid");
        login.enterUsername(creds.get("username"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
    }

    @Test
    public void testInvalidLogin(){
        LoginPage login=new LoginPage(driver);
        login.open();
        Map<String, String> creds = DataDriven.getCredentials("invalid");
        login.enterUsername(creds.get("username"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        String error = login.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match") ||
                        error.toLowerCase().contains("do not match"),
                "Expected invalid credentials message, but got: " + error);
    }

    @Test
    public void testLoginWithoutPassword(){
        LoginPage login=new LoginPage(driver);
        login.open();
        Map<String, String> creds = DataDriven.getCredentials("noPassword");
        login.enterUsername(creds.get("username"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        String error = login.getErrorMessage();
        Assert.assertTrue(error.contains("Password is required") || error.toLowerCase().contains("password is required"),
                "Expected 'Password is required' message, but got: " + error);
    }

}
