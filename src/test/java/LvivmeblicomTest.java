import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LvivmeblicomTest extends BaseTest{

    static WebDriver driver;

    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-proxy-server");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
    }

    @Test
    public void parseItem01(){
        Lvivmeblicom site = new Lvivmeblicom(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem01);
        halmarItem01.put(Sites.lvivmebli,price);
    }

    @Test
    public void parseItem02(){
        Lvivmeblicom site = new Lvivmeblicom(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem02);
        halmarItem02.put(Sites.lvivmebli,price);
    }

    @Test
    public void parseItem03(){
        Lvivmeblicom site = new Lvivmeblicom(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem03);
        halmarItem03.put(Sites.lvivmebli,price);
    }

    @Test
    public void parseItem04(){
        Lvivmeblicom site = new Lvivmeblicom(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem04);
        halmarItem04.put(Sites.lvivmebli,price);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
