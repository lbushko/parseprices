import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Lvivmeblicom extends BasePage {

    public Lvivmeblicom(WebDriver driver){
        super(driver);
    }

    private static String URL = "https://lvivmebli.com/ua/";

    private static WebElement search;

    private By searchLocator = By.cssSelector("#search_form > form > input[type=\"text\"]");

    private static WebElement searchButton;

    private By searchButtonLocator = By.cssSelector("#search_form > form > a");

    private WebElement price;

    private By priceLocator = By.xpath("/html/body/section/div/section/section/div/div/div/div[2]/div[3]/div/div/div/div/div[3]/div[1]/b");

    public void getPage(){
        driver.get(URL);
    }

    public Double getPrice(String item){
        search = driver.findElement(searchLocator);
        search.sendKeys(item);
        searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        price = driver.findElement(priceLocator);
        String ss = price.getAttribute("innerText").replace(",",".");
        Double itemPriece = Double.parseDouble(ss.replace(" ",""));
        System.out.println(itemPriece);
        return itemPriece;
    }
}
