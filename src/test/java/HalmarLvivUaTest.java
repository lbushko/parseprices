import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HalmarLvivUaTest extends BaseTest{

    static WebDriver driver;

    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-proxy-server");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @Test
    public void parseItem01(){
        HalmarLvivUa site = new HalmarLvivUa(driver);
        Double price = site.getPrice(Items.halmarItem01);
        halmarItem01.put(Sites.site04,price);
    }

    @Test
    public void parseItem02(){
        HalmarLvivUa site = new HalmarLvivUa(driver);
        Double price = site.getPrice(Items.halmarItem02);
        halmarItem02.put(Sites.site04,price);
    }

    @Test
    public void parseItem03(){
        HalmarLvivUa site = new HalmarLvivUa(driver);
        Double price = site.getPrice(Items.halmarItem03);
        halmarItem03.put(Sites.site04,price);
    }

    @Test
    public void parseItem04(){
        HalmarLvivUa site = new HalmarLvivUa(driver);
        Double price = site.getPrice(Items.halmarItem04);
        halmarItem04.put(Sites.site04,price);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
