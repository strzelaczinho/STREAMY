
package Streamy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Stream_to_List_wybrane_wartosci {
    public static void main(String[] args) {
             Stream<String> language = Stream.of("java", "python", "node");
             //Convert a Stream to List
             List<String> result = language.collect(Collectors.toList());
              result.forEach(x -> System.out.print(x+" "));
             System.out.println();
             
             Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);
             List<Integer> result2 = number.filter(x -> x!= 3 && x > 1 && x != 2).collect(Collectors.toList());
             result2.forEach(x -> System.out.print(x+" "));
             System.out.println();
             
             
             int[] intArray = {1, 2, 3, 4, 5};
             // 1. Arrays.stream -> IntStream 
            IntStream intStream1 = Arrays.stream(intArray);
            intStream1.forEach(x -> System.out.print(x+" "));
        
            // 2. Stream.of -> Stream<int[]>
            Stream<int[]> temp = Stream.of(intArray);
             // Cant print Stream<int[]> directly, convert / flat it to IntStream 
             IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
             intStream2.forEach(x -> System.out.println(x));    // mozna tylko raz wypisac 
             
              
    }
}
