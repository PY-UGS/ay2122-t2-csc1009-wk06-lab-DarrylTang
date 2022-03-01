import java.util.*;

public class HashMap01 {
    public static void main(String args[]) {
        HashMap hashM = new HashMap();

        // key, value
        hashM.put("apple", "fruit");
        hashM.put("pear" , "fruit");
        hashM.put("cabbage", "vege");
        hashM.put("onion", "vege");
        hashM.put("cabbage", "green");

        System.out.println(hashM);
        System.out.println("Inserting a new key value pair");

        hashM.put("tomato", "fruit");
        System.out.println(hashM);

        System.out.println("Does the hashmap contain the value green? " + hashM.containsValue("green"));
        System.out.println("Does the hashmap contain the value red? " + hashM.containsValue("red"));
    }
}

