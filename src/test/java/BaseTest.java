import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    static HashMap<String, Double> halmarItem01 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem02 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem03 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem04 = new HashMap<String, Double>();

    @BeforeSuite
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-proxy-server");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    @AfterSuite
    public void mapsPrint(){
        for (Map.Entry<String, Double> pair: halmarItem01.entrySet()
                ) {
            System.out.println("Halmar - "+Items.halmarItem01+" ("+pair.getKey()+")"+" ціна: "+ pair.getValue());
        }
        for (Map.Entry<String, Double> pair: halmarItem02.entrySet()
                ) {
            System.out.println("Halmar - "+Items.halmarItem02+" ("+pair.getKey()+")"+" ціна: "+ pair.getValue());
        }
        for (Map.Entry<String, Double> pair: halmarItem03.entrySet()
                ) {
            System.out.println("Halmar - "+Items.halmarItem03+" ("+pair.getKey()+")"+" ціна: "+ pair.getValue());
        }
        for (Map.Entry<String, Double> pair: halmarItem04.entrySet()
                ) {
            System.out.println("Halmar - "+Items.halmarItem04+" ("+pair.getKey()+")"+" ціна: "+ pair.getValue());
        }
    }
}
