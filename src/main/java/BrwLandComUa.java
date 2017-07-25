import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrwLandComUa{

    protected static WebDriver driver;

    public BrwLandComUa(WebDriver driver) {
        this.driver = driver;
    }

    private static String URL = "http://www.brwland.com.ua/";

    private static WebElement search;

    private By searchLocator = By.cssSelector("#cse-search-box > div > input[type=\"text\"]:nth-child(3)");

    private static WebElement searchButton;

    private By searchButtonLocator = By.cssSelector("#cse-search-box > div > input[type=\"submit\"]:nth-child(4)");

    private WebElement link;

    private By linkLocator = By.xpath("//*[@id=\"cse\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/table/tbody/tr/td[2]/div[1]");

    private WebElement price;

    private By priceLocator = By.xpath("//*[@id=\"main\"]/div/form/div[2]/div[4]/div[3]/span[2]/span");

    public void getPage() {
        driver.get(URL);
    }

    public Double getPrice(String item) {
        search = driver.findElement(searchLocator);
        search.sendKeys(item);
        searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();

        for (String Child_Window : driver.getWindowHandles()) {
            driver.switchTo().window(Child_Window);
        }

        try {
            link = driver.findElement(linkLocator);
            link.click();
            price = driver.findElement(priceLocator);
        }
        catch (NoSuchElementException e) {
            System.out.println("No such element: " + item + " (" + URL + ")");
        }

        String ss = price.getAttribute("innerText")
                .replace(",", ".")
                .replace("грн", "")
                .replaceAll("\\s", "");
        return Double.parseDouble(ss);
    }
}
