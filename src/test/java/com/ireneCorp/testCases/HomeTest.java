package com.ireneCorp.testCases;

import com.ireneCorp.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    @Test (priority=1)
    public void validate_ListItems() {
        loginActions.SuccessfulLogin();
        homeActions.ItemsList();
        homeActions.Logout();
    }
    @Test (priority =2)
    public void validate_ListItems_Price(){
        loginActions.SuccessfulLogin();
        homeActions.Item_PriceCheck();
        homeActions.Logout();
    }

}
