/*
Steps to sort a Map in Java 8.

Convert a Map into a Stream
Sort it
Collect and return a new LinkedHashMap (keep the order)
Map result = map.entrySet().stream()
	.sorted(Map.Entry.comparingByKey()) 			
	.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	(oldValue, newValue) -> oldValue, LinkedHashMap::new));
 */
package Sortowanie;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortowanieMapyPoKluczach {
    public static void main(String[] argv) {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("Przed sortowaniem...");
        System.out.println(unsortMap);

        // sort by keys, a,b,c..., and return a new LinkedHashMap
        // toMap() zwroci HashMap domyslnie, potrzebujemy  LinkedHashMap ktore  utrzyma kolejnosc.
        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        // Not Recommend, but it works.
        //Alternative way to sort a Map by keys, and put it into the "result" map
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        System.out.println("Po sortowaniu dwoma metodami...");
        System.out.println(result);
        System.out.println(result2);

    }
}
