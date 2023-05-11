package com.ireneCorp.pages.pageObjects;

import com.ireneCorp.pages.base.BasePage;
import com.ireneCorp.common.core.Shell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private String homePage = "inventory_container";
    private String buttonBurgerMenu = "react-burger-menu-btn";
    private String linkLogOut = "//a[text()='Logout']";
    public WebElement link_LogOut() {
        return Shell.driver.findElement(By.xpath(linkLogOut));
    }

    public WebElement button_BurgerMenu() {
        return Shell.driver.findElement(By.id(buttonBurgerMenu));
    }

    public WebElement home_Page() {
        return Shell.driver.findElement(By.id(homePage));
    }

}
