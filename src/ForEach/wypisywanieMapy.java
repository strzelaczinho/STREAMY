
package ForEach;

import java.util.HashMap;
import java.util.Map;

public class wypisywanieMapy {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
	items.put("A", 10);
	items.put("B", 20);
	items.put("C", 30);
	items.put("D", 40);
	items.put("E", 50);
	items.put("F", 60);
            System.out.println("Wypisanie normalne");
            for (Map.Entry<String, Integer> entry : items.entrySet()) {
		System.out.println("Item : " + entry.getKey() + " Wartosc : " + entry.getValue());
	}
            System.out.println("Wypisanie LAMBDA");
         items.forEach((k,v)->System.out.println("Item : " + k + " Wartosc : " + v));  
         
         System.out.println("Szukanie wartosci");
         // jakas logika tutaj 
         items.forEach((k,v)->{System.out.println("Item : " + k + " Count : " + v);
		if("E".equals(k)){
			System.out.println("Hello E");
		}
	});    
    }
}
