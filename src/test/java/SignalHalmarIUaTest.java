import org.testng.annotations.Test;

public class SignalHalmarIUaTest extends BaseTest {

    @Test
    public void parseItem01() throws Exception{
        SignalHalmarInUa site = new SignalHalmarInUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem01);
        halmarItem01.put(Sites.site01,price);
    }

    @Test
    public void parseItem02() throws Exception{
        SignalHalmarInUa site = new SignalHalmarInUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem02);
        halmarItem02.put(Sites.site01,price);
    }

    @Test
    public void parseItem03() throws Exception{
        SignalHalmarInUa site = new SignalHalmarInUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem03);
        halmarItem03.put(Sites.site01,price);
    }

    @Test
    public void parseItem04() throws Exception{
        SignalHalmarInUa site = new SignalHalmarInUa(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem04);
        halmarItem04.put(Sites.site01,price);
    }
}

