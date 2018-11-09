/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author adam
 */
public class NewClass {
    public static void main(String[] args) {
        
        int[] tablica = new int[100];
        
        for (int i = 0;i<tablica.length;i++)
        {
            tablica[i] = i;
        }
        List<Integer> list = Arrays.stream(tablica).boxed().collect(Collectors.toList());
      
        list.stream().filter(x-> x % 2 == 0).forEach(x->System.out.print("fiz"));
        
        
    }
}
