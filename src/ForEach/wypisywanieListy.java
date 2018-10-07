
package ForEach;

import java.util.ArrayList;
import java.util.List;


public class wypisywanieListy {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
	items.add("A");
	items.add("B");
	items.add("C");
	items.add("D");
	items.add("E");
        //normalne
//	for(String item : items){
//		System.out.println(item);
//	}
        // lambda
        items.forEach(item->System.out.println(item));
        // if
        items.forEach(item->{if("C".equals(item)){
			System.out.println(item);
		}
	});
        System.out.println("Po filtrze");
	items.stream().filter(s->s.contains("B")).forEach(System.out::println);
        
        System.out.println("Po referencji");
	items.forEach(System.out::println);
        
        
    }
}
