import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class HalmarComUaTest extends BaseTest{

    static WebDriver driver;

    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-proxy-server");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
    }

    @Test(dataProvider = "items")
    public void parseItem(String itemName, HashMap<String, Double> itemMap){
        HalmarComUa site = new HalmarComUa(driver);
        site.getPage();
        Double price = site.getPrice(itemName);
        itemMap.put(Sites.site02,price);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
