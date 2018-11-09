/*
joining() method returns Collector instance. It concatenates the input elements in encounter order.
We can pass delimiter,prefix and suffix too in element concatenation. Find the example.
 */
package Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class JoiningExampleWithListOfString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ram","Shyam","Shiv","Mahesh");
        String result=  list.stream().collect(Collectors.joining());
        System.out.println(result);
        result=  list.stream().collect(Collectors.joining(","));
        System.out.println(result);
        result=  list.stream().collect(Collectors.joining("-","[","]"));
        System.out.println(result);        
    }		
} 
//joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
// It returns the Collector that is used to concatenate the elements with given delimiter, prefix and suffix .
//For our given input elements,
//separator(-), prefix([) and suffix(])the output string will be [A-B-C-D].