import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

import java.util.*;

public class DataCollect {

    static HashMap<HashMap<String, Double>, String> halmar = new HashMap<HashMap<String, Double>, String>();

    static HashMap<String, Double> halmarItem01 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem02 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem03 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem04 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem05 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem06 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem07 = new HashMap<String, Double>();
    static HashMap<String, Double> halmarItem08 = new HashMap<String, Double>();

    static HashMap<HashMap<String, Double>, String> signal = new HashMap<HashMap<String, Double>, String>();

    static HashMap<String, Double> signalItem01 = new HashMap<String, Double>();
    static HashMap<String, Double> signalItem02 = new HashMap<String, Double>();
    static HashMap<String, Double> signalItem03 = new HashMap<String, Double>();
    static HashMap<String, Double> signalItem04 = new HashMap<String, Double>();


    public static void convertMaps2D(){
        halmar.put(halmarItem01, Items.halmarItem01);
        halmar.put(halmarItem02, Items.halmarItem02);
        halmar.put(halmarItem03, Items.halmarItem03);
        halmar.put(halmarItem04, Items.halmarItem04);
        halmar.put(halmarItem05, Items.halmarItem05);
        halmar.put(halmarItem06, Items.halmarItem06);
        halmar.put(halmarItem07, Items.halmarItem07);
        halmar.put(halmarItem08, Items.halmarItem08);

        signal.put(signalItem01, Items.signalItem01);
        signal.put(signalItem02, Items.signalItem02);
        signal.put(signalItem03, Items.signalItem03);
        signal.put(signalItem04, Items.signalItem04);
    }


    public static Object[][] halmar(){
        return new Object[][]{
                {Items.halmarItem01, halmarItem01},
                {Items.halmarItem02, halmarItem02},
                {Items.halmarItem03, halmarItem03},
                {Items.halmarItem04, halmarItem04},
                {Items.halmarItem05, halmarItem05},
                {Items.halmarItem06, halmarItem06},
                {Items.halmarItem07, halmarItem07},
                {Items.halmarItem08, halmarItem08}
        };
    }


    public static Object[][] signal(){
        return new Object[][]{
                {Items.signalItem01, signalItem01},
                {Items.signalItem02, signalItem02},
                {Items.signalItem03, signalItem03},
                {Items.signalItem04, signalItem04}
        };
    }

    @DataProvider(name = "items")
    public static Object[][] items(){
        List<Object[]> result = Lists.newArrayList();
        result.addAll(Arrays.asList(halmar()));
        result.addAll(Arrays.asList(signal()));
        return result.toArray(new Object[result.size()][]);
    }
}
