import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HalmarComUa {

    protected static WebDriver driver;

    public HalmarComUa(WebDriver driver) {
        this.driver = driver;
    }

    private static String URL = "http://halmar.com.ua/";

    private WebElement search;

    private By searchLocator = By.xpath("//*[@id=\"search\"]/input");

    private WebElement livesearch;

    private By livesearchLocator = By.xpath("/html/body/div[@id='container']/div[@id='header']/div[@id='search']/ul[@id='livesearch_search_results']/li[1]");

    //"/html/body/div[@id='container']/div[@id='header']/div[@id='search']/ul[@id='livesearch_search_results']/li[1]/a"

    private WebElement price;

    private By priceLocator = By.xpath("/html/body/div[@id='container']/div[@id='content']/div[@class='product-info']/div[@class='right']/div[@class='price']/div[@id='obvodka-buy']/span");

    //WebDriverWait wait = new WebDriverWait(driver,10);

    public void getPage(){
        driver.get(URL);
    }

    public Double getPrice(String item){
        search = driver.findElement(searchLocator);
        //search.click();
        search.sendKeys(item);
        //livesearch = wait.until(ExpectedConditions.elementToBeClickable(livesearchLocator));
        livesearch = driver.findElement(livesearchLocator);
        livesearch.click();
        try {
            price = driver.findElement(priceLocator);
        }
        catch (NoSuchElementException e){
            System.out.println("No such element: "+item+" ("+URL+")");
        }
        String ss = price.getAttribute("innerText")
                .replace(",",".")
                .replace("грн", "")
                .replaceAll("\\s+","");
        return Double.parseDouble(ss);
    }
}
