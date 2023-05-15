package com.ireneCorp.actions.pageActions;

import com.ireneCorp.actions.base.BaseActions;
import org.testng.Assert;

public class LoginActions extends BaseActions {

    public String getTitle() {
        return driver.getTitle();
    }

    public void login(String username, String password) {
        loginPage.text_UserName().clear();
        loginPage.text_password().clear();
        loginPage.text_UserName().sendKeys(username);
        loginPage.text_password().sendKeys(password);
        loginPage.button_Login().click();
    }

    public void SuccessfulLogin() {
        String username = "standard_user";
        String pass = "secret_sauce";
        login(username, pass);
        Assert.assertTrue(homePage.home_Page().isDisplayed());
    }

    public void UnSuccessfulLogin() {
        String user = "problem user";
        String pass = "lab sauce";
        login(user, pass);
        System.out.println("Invalid Input");
    }
}
