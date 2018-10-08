package Konwersje;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Mapa_na_Liste {
     public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");
        System.out.println("Before collect");
        System.out.println(map);
        
         System.out.println("\n1. Export Map Key to List...");
        List<Integer> result = new ArrayList(map.keySet());
         result.forEach(x->System.out.print(x+" "));
         System.out.println();
        
        System.out.println("\n2. Export Map Value to List...");
        List<String> result2 = new ArrayList(map.values());
         result2.forEach(x->System.out.print(x+" "));
         System.out.println();
        
         System.out.println("\n3. Export Map Key to List...");
         result = map.keySet().stream().collect(Collectors.toList());
         result.forEach(x->System.out.print(x+" "));
         System.out.println();

        System.out.println("\n4. Export Map Value to List...");

        List<String> result3 = map.values().stream().collect(Collectors.toList());
        result3.forEach(x->System.out.print(x+" "));
        System.out.println();

      
    System.out.println("\n5. Export Map Value to List..., say no to apple");
    
     List<String> result5 = map.values().stream().filter(x -> x!="apple" && !"banana".equalsIgnoreCase(x)).collect(Collectors.toList());
      result5.forEach(x->System.out.print(x+" "));
      System.out.println();

 
          // split a map into 2 List
        List<Integer> resultSortedKey = new ArrayList<>();
        List<String> resultValues = map.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(x -> x.getValue())
                // filter banana and return it to resultValues
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
        
         System.out.println();
        System.out.println("Splitted maps ");
        resultSortedKey.forEach(x->System.out.print(x+" "));
        resultValues.forEach(x->System.out.print(x+" "));

        
    
    }
}
/*
Map<String, String> map = new HashMap<>();

// Convert all Map keys to a List
List<String> result = new ArrayList(map.keySet());

// Convert all Map values to a List
List<String> result2 = new ArrayList(map.values());
		
// Java 8, Convert all Map keys to a List
List<String> result3 = map.keySet().stream()
	.collect(Collectors.toList());

// Java 8, Convert all Map values  to a List
List<String> result4 = map.values().stream()
	.collect(Collectors.toList());

// Java 8, seem a bit long, but you can enjoy the Stream features like filter and etc. 
List<String> result5 = map.values().stream()
	.filter(x -> !"apple".equalsIgnoreCase(x))
	.collect(Collectors.toList());
*/