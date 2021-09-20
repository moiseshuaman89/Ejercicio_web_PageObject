package util;

import java.util.concurrent.TimeUnit;

import hitoriaDeUsuario.page.DemoBlazeHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Driver {

    public static WebDriver driver;
    public static DemoBlazeHomePage demoBlazeHomePage;

    public WebDriver getDriver() {
        try {

            if (null == driver) {
                String ruta = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", ruta);
                // CHROME OPTIONS
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

        } catch (Exception e){
            System.out.println("Unable to load browser: " + e.getMessage());
        } finally {
            driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
            demoBlazeHomePage= PageFactory.initElements(driver, DemoBlazeHomePage.class);
        }
        return driver;
    }

}
