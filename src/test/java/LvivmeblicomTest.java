import org.testng.annotations.Test;

public class LvivmeblicomTest extends BaseTest{

    @Test
    public void parseItem01(){
        Lvivmeblicom site = new Lvivmeblicom(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem01);
        halmarItem01.put(Sites.lvivmebli,price);
    }

    @Test
    public void parseItem02(){
        Lvivmeblicom site = new Lvivmeblicom(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem02);
        halmarItem02.put(Sites.lvivmebli,price);
    }

    @Test
    public void parseItem03(){
        Lvivmeblicom site = new Lvivmeblicom(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem03);
        halmarItem03.put(Sites.lvivmebli,price);
    }

    @Test
    public void parseItem04(){
        Lvivmeblicom site = new Lvivmeblicom(driver);
        site.getPage();
        Double price = site.getPrice(Items.halmarItem04);
        halmarItem04.put(Sites.lvivmebli,price);
    }
}
