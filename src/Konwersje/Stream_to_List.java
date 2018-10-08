
package Konwersje;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Stream_to_List {
    public static void main(String[] args) {
             Stream<String> language = Stream.of("java", "python", "node");
             //Convert a Stream to List
             List<String> result = language.collect(Collectors.toList());
             result.forEach(System.out::println);
             
             
             Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);
             List<Integer> result2 = number.filter(x -> x!= 3 && x > 1 && x != 2).collect(Collectors.toList());
             result2.forEach(x -> System.out.println(x));
             
             
    }
}
