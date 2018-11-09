
package Streamy_Agregacyjne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class Operacje4 {
    public static void main(String[] args) {
         String[] alphabet = new String[]{"A", "B", "C"};
         List<String> list = Arrays.asList(alphabet);
         if(list.contains("A")){
            System.out.println("Hello A");   
    }
          
       // lub alternatywanie 
       boolean result = Arrays.stream(alphabet).anyMatch(p-> "A".equals(p));
       if (result) System.out.println("A zawiera sie "); 
       if (list.contains("A") && list.contains("B") && list.containsAll(Arrays.asList("A","B")))
       {
           System.out.println("zawiera sie");
       }
       long[] lNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       boolean result2 = LongStream.of(lNumber).anyMatch(x -> x == 10);
}
}