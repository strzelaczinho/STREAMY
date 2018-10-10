package Streamy;
import java.util.ArrayList;
import java.util.Arrays;import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*In Java 8, Stream can hold different data types, for examples:
Stream<String[]>	
Stream<Set<String>>	
Stream<List<String>>	
Stream<List<Object>>
But, the Stream operations (filter, sum, distinct…) and collectors do not support it, so, we need flatMap() to do the following conversion :
Stream<String[]>		-> flatMap ->	Stream<String>
Stream<Set<String>>	-> flatMap ->	Stream<String>
Stream<List<String>>	-> flatMap ->	Stream<String>
Stream<List<Object>>	-> flatMap ->	Stream<Object>  */
public class FlatMap_01 {
    public static void main(String[] args) {

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        //Stream<String[]>
//        Stream<String[]> temp = Arrays.stream(data);
//        //filter a stream of string[], and return a string[]?
//        Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));
//        stream.forEach(System.out::println);
        // EMPTY OUTPUT 
        
        //Stream<String>, GOOD!
        Stream<String[]> temp = Arrays.stream(data);
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
        Stream<String> stream2 = stringStream.filter(x -> "c".equals(x.toString()));
        stream2.forEach(System.out::println);
        
        
        
         int[] intArray = {1, 2, 3, 4, 5, 6};
        //1. Stream<int[]>
        Stream<int[]> streamArray = Stream.of(intArray);
        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x)).filter(x-> x>3);
        intStream.forEach(x -> System.out.println(x));
        
        
        
        Student obj1 = new Student();
        obj1.setName("adam");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        List<String> collect =
                list.stream()
                        .map(x -> x.getBook())      //Stream<Set<String>>
                        .flatMap(x -> x.stream())   //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));
    }

}
 class Student {

    private String name;
    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }
    
   
}