package com.ireneCorp.testCases;

import com.ireneCorp.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void TitleValidationTest() {
        loginActions.getTitle();
    }

    @Test
    public void validateCorrectLogin() {
        loginActions.validateSuccessfulLogin();
        homeActions.validateLogout();
    }

    @Test
    public void validateWrongLogin() {
        loginActions.validateUnSuccessfulLogin();
    }

}

