/*
Here we are sorting a map whose values are custom objects. 
SortMapOfCustomObject.java
 */
package Sortowanie;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
public class SortMapOfCustomObject {
	public static void main(String[] args) {
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student(1, "Mahesh", 12));
		map.put(2, new Student(2, "Suresh", 15));
		map.put(3, new Student(3, "Nilesh", 10));
                //Map Sorting by Value i.e student's natural ordering i.e by name
	        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
	    	.forEach(e -> {
				Integer key = (Integer)e.getKey();
				Student std = (Student)e.getValue();
	    		System.out.println("Key: " + key +", value: ("+ std.getId() +", "+ std.getName()+", "+ std.getAge()+")"); 
	    	});
	}
} 
//Please let me know how to collect the sorted set back in another set ??
//Thanks

//Collectors.toSet()