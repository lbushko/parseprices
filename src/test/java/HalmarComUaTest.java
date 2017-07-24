import org.testng.annotations.Test;

public class HalmarComUaTest extends BaseTest{

    @Test
    public void parseItem01(){
        HalmarComUa site = new HalmarComUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem01);
        halmarItem01.put(Sites.site02,price);
    }

    @Test
    public void parseItem02(){
        HalmarComUa site = new HalmarComUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem02);
        halmarItem02.put(Sites.site02,price);
    }

    @Test
    public void parseItem03(){
        HalmarComUa site = new HalmarComUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem03);
        halmarItem03.put(Sites.site02,price);
    }

    @Test
    public void parseItem04(){
        HalmarComUa site = new HalmarComUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem04);
        halmarItem04.put(Sites.site02,price);
    }
}
