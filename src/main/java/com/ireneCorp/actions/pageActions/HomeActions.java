package com.ireneCorp.actions.pageActions;

import com.ireneCorp.actions.base.BaseActions;
import org.testng.Assert;

public class HomeActions extends BaseActions {
    public void validateLogout() {
        homePage.button_BurgerMenu().click();
        homePage.link_LogOut().click();
        Assert.assertTrue(loginPage.login_Page().isDisplayed());
    }
}
