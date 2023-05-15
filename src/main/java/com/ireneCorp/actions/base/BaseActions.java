package com.ireneCorp.actions.base;

import com.ireneCorp.common.core.Shell;
import com.ireneCorp.pages.pageObjects.HomePage;
import com.ireneCorp.pages.pageObjects.LoginPage;

public class BaseActions extends Shell {
    // Create objects of all page classes. As this class ('BaseActions'), is the parent, these objects
    // can be called from its child classes (LoginActions, HomeActions etc.)

    public LoginPage loginPage = new LoginPage();
    public HomePage homePage =  new HomePage();

}
