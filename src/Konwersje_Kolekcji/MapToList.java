/*
On this page we will provide java 8 Stream map() example. It returns a Stream
instance processed by a given Function. map() returns the stream of objects and 
to get the stream of primitive data type such as IntStream, LongStream and DoubleStream, java 8
Stream provides the method as mapToInt(), mapToLong() and mapToDouble() respectively.
 */
package Konwersje_Kolekcji;

/**
Stream map() with Function
The syntax of Stream.map() method is as follows. 
map(Function mapper)
We need to pass Function instance as lambda expression.
* This method returns Stream instance that has the result processed by given Function.
* This is an intermediate operation.
Convert Map to List using Stream map()
 */
import MAP.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class MapToList {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(111, "Lalkrishna");
		map.put(154, "Atal");		
		map.put(30, "Narendra");
		map.put(200, "Amit");
		
		List<User> list = map.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
				.map(e -> new User(e.getKey(), e.getValue())).collect(Collectors.toList());

		list.forEach(l -> System.out.println("Id: "+ l.getId()+", Name: "+ l.getName()));		
	}
}
class User {
	private int id;
	private String name;
	public User(int id, String name) {
		this.id = id; 
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
} 