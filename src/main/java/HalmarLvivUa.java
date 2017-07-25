import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HalmarLvivUa {

    protected static WebDriver driver;

    public HalmarLvivUa(WebDriver driver) {
        this.driver = driver;
    }

    private static String URL = "https://halmar.lviv.ua/";

    private static WebElement search;

    private By searchLocator = By.cssSelector("#quick_find_keyword");

    private static WebElement searchButton;

    private By searchButtonLocator = By.cssSelector("#quick_find > input.button");

    private WebElement price;

    private By priceLocator = By.cssSelector("#mainContent > div:nth-child(3) > div.con-cen > div > div > ul > li.buy > span > em");
    private By priceLocator2 = By.cssSelector("#mainContent > div:nth-child(3) > div.con-cen > div > div:nth-child(1) > ul > li.buy > span > em");

    public Double getPrice(String item){
        WebDriverWait wait = new WebDriverWait(driver,15);

        search = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                d.get(URL);
                return d.findElement(searchLocator);
            }
        });

        search = wait.until(ExpectedConditions.presenceOfElementLocated(searchLocator));
        search.click();
        search.clear();
        search.sendKeys(item);
        searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(searchButtonLocator));
        searchButton.click();
        try {
            price = wait.until(ExpectedConditions.presenceOfElementLocated(priceLocator));
        }
        catch (Exception e){
            try{
                price = wait.until(ExpectedConditions.presenceOfElementLocated(priceLocator2));
            }
            catch (NoSuchElementException z){
                System.out.println("No such element: "+item+" ("+URL+")");
            }
        }
        String ss = price.getAttribute("innerText")
                .replace(",", ".")
                .replace("грн", "")
                .replaceAll("\\s","");
        return Double.parseDouble(ss);
    }
}
