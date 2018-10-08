package Filtry_operacje;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class filter_nulli {

    public static void main(String[] args) {

        Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");// po wykonaniu stream sie zamyka . Trzeba go stwrzoyc powtornie
        List<String> result = language.collect(Collectors.toList());
        result.forEach(n->System.out.print(n+" "));
        
        // tu filtruje nulle
        System.out.println();
        language = Stream.of("java", "python", "node", null, "ruby", null, "php");
        List<String> result2 = language.filter(x -> x!=null).collect(Collectors.toList());
        result2.forEach(n->System.out.print(n+" "));
         System.out.println();
        // alternatywa do x!=null
        language = Stream.of("java", "python", "node", null, "ruby", null, "php"); 
        List<String> result3 = language.filter(Objects::nonNull).collect(Collectors.toList());
        result3.forEach(n->System.out.print(n+" "));
        
    }
}