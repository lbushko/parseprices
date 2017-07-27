import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SignalHalmarIUaTest extends BaseTest {

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

    @Test(dataProvider = "items")
    public void parseItem(String itemName, HashMap<String, Double> itemMap) throws Exception{
        SignalHalmarInUa site = new SignalHalmarInUa(driver);
        site.getPage();
        Double price = site.getPrice(itemName);
        itemMap.put(Sites.site01,price);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

