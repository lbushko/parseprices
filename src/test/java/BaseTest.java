import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;

public class BaseTest extends DataCollect {

    public double calcuteAvrg(HashMap<String, Double> map, String brand, String item, double stDeviation){
        double sum=0;
        int count=0;
        double price_lvivmebli = map.get(Sites.lvivmebli);
        double percent=0;

        for (Map.Entry<String, Double> pair: map.entrySet()
                ) {
            double deviation = Math.abs((pair.getValue()/price_lvivmebli) * 100 - 100);
            deviation = (Math.round(deviation * 100)) / 100;

            if(!(pair.getKey().equals(Sites.lvivmebli)) && deviation < stDeviation) {
                    sum += pair.getValue();
                    count++;
            }
        }

        double avrg = (sum / count);
        avrg = ((Math.round(avrg * 100)) / 100);

        if (avrg !=0 && price_lvivmebli !=0) {
            if (price_lvivmebli > avrg) {
                System.out.println("Наша ціна на товар: " + brand + " - " + item + " більша ніж у конукрентів в середньому на " + (price_lvivmebli - avrg) + " грн +++");
            } else if (price_lvivmebli < avrg) {
                System.out.println("Наша ціна на товар: " + brand + " - " + item + " нижче ніж у конукрентів в середньому на " + (avrg - price_lvivmebli) + " грн ---");
            }
            else if (price_lvivmebli == avrg){
                System.out.println("Наша ціна на товар: " + brand + " - " + item + " однакова <<<");
            }
            percent = ((avrg/price_lvivmebli) * 100) - 100;
            percent = (Math.round(percent * 100)) / 100;
        }
        return percent;
    }

    public void recommendation(double avrg, String brand){
        String recommendation = "";
        if (avrg >= 0.0){
            if (avrg >0.0){
                recommendation = ">>> Наші ціни на бренд - "+brand+" нижчі на "+avrg+" %"+" ---";
            }
            else {
                recommendation = ">>> Наші ціни на бренд - "+brand+" однакові "+avrg+" %"+" ;)";
            }
        }
        else if (avrg <0.0){
            recommendation = ">>> Наші ціни на бренд - "+brand+" більші на "+Math.abs(avrg)+" %";
        }
        System.out.println(recommendation);
    }

    public void print(HashMap<String, Double> map, String item, String brandName){
        for (Map.Entry<String, Double> pair: map.entrySet()
                ) {
            System.out.println(brandName+" - "+item+" ("+pair.getKey()+")"+" ціна: "+ pair.getValue());
        }
    }

    public void analyze(HashMap<HashMap<String, Double>, String> brandMap, String brandName, double stDeviation){
        double sumPlus=0;
        int plus=0;
        double sumMinus=0;
        int minus=0;

        for (Map.Entry<HashMap<String, Double>, String> entry : brandMap.entrySet()
                ) {
            print(entry.getKey(),entry.getValue(),brandName);
            double avrg = calcuteAvrg(entry.getKey(), brandName, entry.getValue(), stDeviation);
            if (avrg >= 0){
                sumPlus += avrg;
                plus++;
            }
            else if (avrg <0){
                sumMinus += avrg;
                minus++;
            }
        }

        double sumPercent = (sumPlus / plus) + (sumMinus / minus);

        System.out.println("");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        recommendation(sumPercent, brandName);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("");
    }

    @AfterSuite
    public void mapsPrint(){
        convertMaps2D();
        analyze(halmar, Brands.halmar, 40);
        analyze(signal, Brands.signal, 40);
    }
}
