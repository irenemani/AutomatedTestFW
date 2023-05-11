package com.ireneCorp.actions.base;

import com.ireneCorp.common.core.Shell;
import com.ireneCorp.pages.pageObjects.HomePage;
import com.ireneCorp.pages.pageObjects.LoginPage;

public class BaseActions extends Shell {
    public HomePage homePage =  new HomePage();
    public LoginPage loginPage = new LoginPage();
}
