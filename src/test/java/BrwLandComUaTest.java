import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.util.HashMap;
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

    @Test(dataProvider = "items")
    public void parseItem(String itemName, HashMap<String, Double> itemMap){
        BrwLandComUa site = new BrwLandComUa(driver);
        site.getPage();
        Double price = site.getPrice(itemName);
        itemMap.put(Sites.site03,price);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
