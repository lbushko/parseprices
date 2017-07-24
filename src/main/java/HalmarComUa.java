import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HalmarComUa extends BasePage{

    public HalmarComUa(WebDriver driver){
        super(driver);
    }

    private static String URL = "http://halmar.com.ua/";

    private static WebElement search;

    private By searchLocator = By.xpath("/html/body/div[@id='container']/div[@id='header']/div[@id='search']/input");

    private static WebElement livesearch;

    private By livesearchLocator = By.cssSelector("#livesearch_search_results > li[1] > a");

    //"/html/body/div[@id='container']/div[@id='header']/div[@id='search']/ul[@id='livesearch_search_results']/li[1]/a"

    private WebElement price;

    private By priceLocator = By.xpath("//*[@id=\"obvodka-buy\"]/span/text()");

    public void getPage(){
        driver.get(URL);
    }

    public Double getPrice(String item){
        search = driver.findElement(searchLocator);
        search.click();
        search.sendKeys(item);
        livesearch = driver.findElement(livesearchLocator);
        livesearch.click();
        price = driver.findElement(priceLocator);
        String ss = price.getAttribute("innerText").replace(",",".");
        Double itemPriece = Double.parseDouble(ss.replace(" ",""));
        System.out.println(itemPriece);
        return itemPriece;
    }
}
