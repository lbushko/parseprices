import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;

public class BaseTest extends DataCollect {

    /*Рахуємо % відхилення ціни по конкретному товару */
    public Double calcuteAvrg(HashMap<String, Double> map, String brand, String item, double stDeviation){
        double sum = 0;
        int count = 0;
        Double price_lvivmebli = map.get(Sites.lvivmebli);
        Double percent = null;

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

        if (avrg !=0.0 && price_lvivmebli != null) {
            if (price_lvivmebli > avrg) {
                System.out.println("Наша ціна на товар: " + brand + " - " + item + " більша ніж у конукрентів в середньому на " + (price_lvivmebli - avrg) + " грн +++");
            } else if (price_lvivmebli < avrg) {
                System.out.println("Наша ціна на товар: " + brand + " - " + item + " нижче ніж у конукрентів в середньому на " + (avrg - price_lvivmebli) + " грн ---");
            } else if (price_lvivmebli == avrg){
                System.out.println("Наша ціна на товар: " + brand + " - " + item + " така ж як середня ціна у конкурентів <<<");
            }
            percent = ((avrg/price_lvivmebli) * 100) - 100;
        }
        System.out.println("Відхилення: "+percent+" %");
        return percent;
    }

    /*Даємо висновок на основі нашого аналізу*/
    public void recommendation(double avrg, String brand){
        String recommendation = "";

        double roundAvrg = ((Math.round(avrg * 100.0)) / 100.0);

        if (avrg >= 0.00){
            if (avrg >0.00){
                recommendation = ">>> Наші ціни на бренд - "+brand+" нижчі на "+roundAvrg+" %"+" ніж середні на ринку"+" ---";
            } else {
                recommendation = ">>> Наші ціни на бренд - "+brand+" такі ж як "+" середні на ринку"+roundAvrg+" %";
            }
        } else if (avrg <0.00){
            recommendation = ">>> Наші ціни на бренд - "+brand+" більші на "+Math.abs(roundAvrg)+" %"+" ніж середні на ринку"+" +++";
        }
        System.out.println(recommendation);
    }

    /*Друкуємо всі ціни на товар з масиву*/
    public void print(HashMap<String, Double> map, String item, String brandName){
        for (Map.Entry<String, Double> pair: map.entrySet()
                ) {
            System.out.println(brandName+" - "+item+" ("+pair.getKey()+")"+" ціна: "+ pair.getValue());
        }
    }

    /*Розраховуємо середнє відхилення по групі товарів (бренд)*/
    public void analyze(HashMap<HashMap<String, Double>, String> brandMap, String brandName, double stDeviation){
        double sumPercent = 0;
        int count = 0;

        for (Map.Entry<HashMap<String, Double>, String> entry : brandMap.entrySet()
                ) {
            print(entry.getKey(),entry.getValue(),brandName);
            Double avrg = calcuteAvrg(entry.getKey(), brandName, entry.getValue(), stDeviation);
            if (avrg != null){
                sumPercent += avrg;
                count++;
            }
        }

        System.out.println("");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        recommendation((sumPercent/count), brandName);
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
