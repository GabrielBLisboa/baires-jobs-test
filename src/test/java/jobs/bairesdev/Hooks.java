package jobs.bairesdev;


//import org.junit.Before;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class Hooks {
    static WebDriver driver;
    //    @BeforeEach
//    public void setUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//        driver = WebDriverManager.chromedriver().capabilities(options).create();
//        driver.manage().window().maximize();
//    }

    @AfterAll
    static void tirarScreenshot() throws IOException {
//        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        File DestFile = new File("C:\\Users\\Gabriel\\Documents\\Programação\\Java\\BairesTestes\\target\\cucumber-reports\\DestFile.FILE");
//        FileUtils.copyFile(file, DestFile);
//        WebDriver driver = getDriver();
//        if (scenario.isFailed()){
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//            scenario.attach(src, "image/png", "" + scenario.getUri());
//        }
    }

    public static WebDriver getDriver()  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().window().maximize();
        return driver;
    }
}

