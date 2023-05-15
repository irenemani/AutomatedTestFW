package com.ireneCorp.testCases;

import com.ireneCorp.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void TitleValidationTest() {
        loginActions.getTitle();
    }

    @Test (priority=1)
    public void validate_ValidLogin() {
        loginActions.SuccessfulLogin();
        homeActions.Logout();
    }

    @Test (priority=2)
    public void validate_InvalidLogin() {
        loginActions.UnSuccessfulLogin();
    }

}

