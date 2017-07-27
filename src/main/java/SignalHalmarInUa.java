import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignalHalmarInUa{

    protected static WebDriver driver;

    public SignalHalmarInUa(WebDriver driver) {
        this.driver = driver;
    }

    private static String URL = "http://signal-halmar.in.ua/";

    private static WebElement search;

    private static WebElement searchButton;

    private By searchButtonLocator = By.xpath("/html/body/div[@id='page_bg']/header/div[@id='section-top']/form[@id='search']/input[@class='button_search']");

    private WebElement price;

    private WebElement resultSearch;

    private By resultSearchlocator = By.xpath("//ul[@class='tiny_products']/li[@class='product'][1]");

    private By price_locator = By.xpath("/html/body/div[@id='page_bg']/div[@id='section-main-content']/div[@id='content-right']/div[@class='product page']/div[@class='product_info']/form[@class='cart']/div[@class='price']/span");

   public void getPage(){
       driver.get(URL);
   }

   public Double getPrice(String item) throws Exception{
       search = driver.findElement(By.className("input_search"));
       search.sendKeys(item);
       try {
           price = driver.findElement(price_locator);
       }
       catch (Exception e){
           searchButton = driver.findElement(searchButtonLocator);
           searchButton.click();
           try {
               price = driver.findElement(price_locator);
           }
           catch (Exception z){
               try {
                   resultSearch = driver.findElement(resultSearchlocator);
                   resultSearch.click();
                   try {
                       price = driver.findElement(price_locator);
                   }
                   catch (NoSuchElementException y){
                       System.out.println("No price provided: "+item+" ("+URL+")");
                   }
               }
               catch (NoSuchElementException k){
                   System.out.println("No such element: "+item+" ("+URL+")");
               }
           }
       }
       String ss = price.getAttribute("innerText")
               .replace(",",".")
               .replace("грн", "")
               .replaceAll("\\s","");
       return Double.parseDouble(ss);
   }
}
