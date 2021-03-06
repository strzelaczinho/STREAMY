package Filtry_operacje;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
public class filter_map_02_ {
public static void main(String[] args) {

        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

        // Przed Java 8
        String result = "";
        for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
            if ("aws.amazon.com".equals(entry.getValue())) {
                result = entry.getValue();
            }
        }
        System.out.println("Przed Java 8 : " + result);

        //Map -> Stream -> Filter -> String
        result = HOSTING.entrySet().stream().filter(map -> "aws.amazon.com".equals(map.getValue())).map(map -> map.getValue()).collect(Collectors.joining());
        System.out.println("Java 8 : " + result);

        // filter more values
        result = HOSTING.entrySet().stream().filter(x -> {if (!x.getValue().contains("amazon") && !x.getValue().contains("digital"))
        {
           return true;
        }
           return false;
         }).map(map -> map.getValue()).collect(Collectors.joining(","));
        System.out.println("Java 8 : " + result);

            
        
        //Map -> Stream -> Filter -> Map
        Map<Integer, String> collect = HOSTING.entrySet().stream().filter(map -> map.getKey() == 2).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        System.out.println(collect); //output : {2=heroku.com}
        Map<Integer, String> collect2 = HOSTING.entrySet().stream().filter(map -> map.getKey() <= 3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect2); //output : {1=linode.com, 2=heroku.com, 3=digitalocean.com}
    }
}
/*

*/