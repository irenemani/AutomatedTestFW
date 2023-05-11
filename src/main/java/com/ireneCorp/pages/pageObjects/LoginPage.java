package com.ireneCorp.pages.pageObjects;

import com.ireneCorp.pages.base.BasePage;
import com.ireneCorp.common.core.Shell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Initialising variables
    private String textUserName = "user-name";
    private String textPassword = "password";

    private String buttonLogin = "login-button";
    private String loginPage = "login_credentials";
    private String errorInvalidInput = "error-button";

    // Create elements' repository
    public WebElement error_InvalidInput() {
        return Shell.driver.findElement(By.id(errorInvalidInput));
    }

    public WebElement login_Page() {
        return Shell.driver.findElement(By.id(loginPage));
    }

    public WebElement button_Login() {
        return Shell.driver.findElement(By.id(buttonLogin));
    }

    public WebElement text_password() {
        return Shell.driver.findElement(By.id(textPassword));
    }

    public WebElement text_UserName() {
        return Shell.driver.findElement(By.id(textUserName));
    }

}
