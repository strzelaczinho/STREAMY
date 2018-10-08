package Collectors;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class grouping_by_counting_sort {

    public static void main(String[] args) {
        
        //3 apple, 2 banana, inne 1
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // identity liczy input argumenty , counting liczy argumenty z inputu
        System.out.println(result);
        
         Map<String, Long> finalMap = new LinkedHashMap<>();
        //Sortuje i dodaje w tym przypadku do mapy
        result.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);
        
    }
}