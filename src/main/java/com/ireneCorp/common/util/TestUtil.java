package com.ireneCorp.common.util;

import com.ireneCorp.common.core.Shell;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil extends Shell {

    // Make static methods,so that it can be called in 'BaseTest' class  without creating objects.
    public static void loadProp() {
        try {
            prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/com.ireneCorp.config/config.properties"));
            System.out.println("Property File Loaded successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setBrowser(){
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/com.ireneCorp.drivers/" +
                    "chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Chrome Browser Started successfully");
        }
    }
    public static void manageBrowserSettings(){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        System.out.println("Browser Settings Updated");
    }

    public static void launchWebApplication(){
        String baseUrl = prop.getProperty("url");
        driver.get(baseUrl);
        System.out.println("Application Launched successfully");
    }

    public static void tearDownBrowser(){
        driver.quit();
        System.out.println("Browser closed successfully");
    }
}
