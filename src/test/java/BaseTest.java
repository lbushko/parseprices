import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    static HashMap<String, Double> halmarItem01 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem02 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem03 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem04 = new HashMap<String, Double>();


    public double calcuteAvrg(HashMap<String, Double> map, String brand, String item){
        double sum=0;
        int count=0;
        double price_lvivmebli=0;
        double percent=0;
        for (Map.Entry<String, Double> pair: map.entrySet()
                ) {
            if(!(pair.getKey().equals(Sites.lvivmebli))) {
                sum += pair.getValue();
                count++;
            }
            else if(pair.getKey().equals(Sites.lvivmebli)){
                price_lvivmebli = pair.getValue();
            }
        }
        double avrg = (sum / count);
        avrg = (Math.round(avrg * 100)) / 100;
        if (avrg !=0 && price_lvivmebli !=0) {
            if (price_lvivmebli > avrg) {
                System.out.println("Наша ціна на товар: " + brand + " - " + item + " більша ніж у конукрентів в середньому на " + (price_lvivmebli - avrg) + " грн +++");
            } else if (price_lvivmebli < avrg) {
                System.out.println("Наша ціна на товар: " + brand + " - " + item + " нижче ніж у конукрентів в середньому на " + (avrg - price_lvivmebli) + " грн ---");
            }
            percent = (100 - (price_lvivmebli/avrg) * 100);
            percent = (Math.round(percent * 100)) / 100;
        }
        return percent;
    }

    public void recommendation(double item01, double item02, double item03, double item04, String brand){
        double avrg = (item01+item02+item03+item04) / 4;
        String recommendation = "";
        if (avrg >= 0){
            if (avrg >0){
                recommendation = "Наші ціни на бренд - "+brand+" нижчі на "+avrg+" %"+" ---";
            }
            else {
                recommendation = "Наші ціни на бренд - "+brand+" однакові "+avrg+" %"+" ;)";
            }
        }
        else if (avrg <0){
            recommendation = "Наші ціни на бренд - "+brand+" більші на "+(avrg*(-1))+" %";
        }
        System.out.println(recommendation);
    }

    public void print(HashMap<String, Double> map, String item){
        for (Map.Entry<String, Double> pair: map.entrySet()
                ) {
            System.out.println("Halmar - "+item+" ("+pair.getKey()+")"+" ціна: "+ pair.getValue());
        }
    }

    @AfterSuite
    public void mapsPrint(){
        print(halmarItem01,Items.halmarItem01);
        print(halmarItem02,Items.halmarItem02);
        print(halmarItem03,Items.halmarItem03);
        print(halmarItem04,Items.halmarItem04);

        recommendation(calcuteAvrg(halmarItem01,Brands.halmar,Items.halmarItem01),
                calcuteAvrg(halmarItem02,Brands.halmar,Items.halmarItem02),
                calcuteAvrg(halmarItem03,Brands.halmar,Items.halmarItem03),
                calcuteAvrg(halmarItem04,Brands.halmar,Items.halmarItem04),
                Brands.halmar);
    }
}
