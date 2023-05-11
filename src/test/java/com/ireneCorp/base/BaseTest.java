package com.ireneCorp.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ireneCorp.actions.pageActions.HomeActions;
import com.ireneCorp.actions.pageActions.LoginActions;
import com.ireneCorp.common.core.Shell;
import com.ireneCorp.pages.pageObjects.*;
import com.ireneCorp.common.util.TestUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class BaseTest extends Shell {
    public HomeActions homeActions =  new HomeActions();
    public LoginActions loginActions = new LoginActions();
    ExtentReports extentReports;
    ExtentSparkReporter extentSparkReporter;


    // Methods are directly called from 'TestUtil' class, as static function used there.
    // Eg: TestUtil.loadProp()
    @BeforeTest
    public void runBeforeTest(){
        TestUtil.loadProp();
        TestUtil.setBrowser();
        TestUtil.manageBrowserSettings();
        TestUtil.launchWebApplication();
        extentReports = new ExtentReports();
        //File file = new File("src/test/resources/reportsDir/IreneReport.html");
        String path ="C:\\Users\\IRENE\\Desktop\\IT\\Java Training\\AutomatedTestFW\\src\\test\\resources\\reportsDir\\IreneReport.html";
        extentSparkReporter = new ExtentSparkReporter(path);
        extentReports.attachReporter(extentSparkReporter);
    }

    @AfterTest
    public void runAfterTest(){
        TestUtil.tearDownBrowser();
        extentReports.flush();
    }
}
