package com.ireneCorp.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ireneCorp.actions.pageActions.HomeActions;
import com.ireneCorp.actions.pageActions.LoginActions;
import com.ireneCorp.common.core.Shell;
import com.ireneCorp.pages.pageObjects.*;
import com.ireneCorp.common.util.TestUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseTest extends Shell {
    // Create objects of all page action classes. As 'BaseTest' is the parent, these objects can be
    // called from its child classes (LoginTest, HomeTest etc.)
    public HomeActions homeActions = new HomeActions();
    public LoginActions loginActions = new LoginActions();


    // For reporting :- initialised variables; 1 for engine(extentReports) and others for its boggies.
    ExtentReports extentReports;
    ExtentSparkReporter extentSparkReporter;


    // Methods are directly called from 'TestUtil' class, as static function used there.
    // Eg: TestUtil.loadProp()
    @BeforeClass
    public void runBeforeTest() {
        TestUtil.loadProp();
        TestUtil.setBrowser();
        TestUtil.manageBrowserSettings();
        TestUtil.launchWebApplication();
    }
    @AfterClass
    public void runAfterTest() {
        TestUtil.tearDownBrowser();
    }

    //Reporting codes : Before Test

    /*    extentReports = new ExtentReports();
        String path = "C:\\Users\\IRENE\\Desktop\\IT\\Java Training\\AutomatedTestFW\\src" +
                "\\test\\resources\\reportsDir\\ireneReport.html";
        extentSparkReporter = new ExtentSparkReporter(path);
        extentReports.attachReporter(extentSparkReporter);

        extentReports.createTest("Test 1").pass("This is passed.");

        extentReports.createTest("Test 2").log(Status.FAIL,"This is failed.");

        extentReports.createTest("Test 3").skip("This is skipped.");*/

   // After Test:
        /*extentReports.flush();
        File file = new File("C:\\Users\\IRENE\\Desktop\\IT\\Java Training\\AutomatedTestFW\\src" +
                "\\test\\resources\\reportsDir\\ireneReport.html");
        try {
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            System.out.println("Report not generated.");
        }*/

}
