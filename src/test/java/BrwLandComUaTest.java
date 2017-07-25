import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BrwLandComUaTest extends BaseTest{

    static WebDriver driver;

    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-proxy-server");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void parseItem01(){
        BrwLandComUa site = new BrwLandComUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem01);
        halmarItem01.put(Sites.site03,price);
    }

    @Test
    public void parseItem02(){
        BrwLandComUa site = new BrwLandComUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem02);
        halmarItem02.put(Sites.site03,price);
    }

    @Test
    public void parseItem03(){
        BrwLandComUa site = new BrwLandComUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem03);
        halmarItem03.put(Sites.site03,price);
    }

    @Test
    public void parseItem04(){
        BrwLandComUa site = new BrwLandComUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem04);
        halmarItem04.put(Sites.site03,price);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
