package Collectors;

import java.util.List;
import java.util.stream.Collectors;
public class JoiningExampleWithListOfObject {
    public static void main(String[] args) {
        List<Person> list = Person.getList();
        System.out.println("--Join imie Osoby--");
        String result=  list.stream().map(p -> p.getName()).collect(Collectors.joining());
        System.out.println(result);
        result=  list.stream().map(p -> p.getName()).collect(Collectors.joining("|"));
        System.out.println(result);
        result=  list.stream().map(p -> p.getName()).collect(Collectors.joining("-","[","]"));
        System.out.println(result);
        
        System.out.println("--Join osoby wiek--");
        result=  list.stream().map(p -> String.valueOf(p.getAge())).collect(Collectors.joining());
        System.out.println(result);
        result=  list.stream().map(p -> String.valueOf(p.getAge())).collect(Collectors.joining("|"));
        System.out.println(result);
        result=  list.stream().map(p -> String.valueOf(p.getAge())).collect(Collectors.joining("-","[","]"));
        System.out.println(result);       
        
        System.out.println("--Join person name-age--");
        result=  list.stream().map(p -> p.getName()+"-" + p.getAge()).collect(Collectors.joining("|"));
        System.out.println(result);
        result=  list.stream().map(p -> p.getName()+"-" + p.getAge()).collect(Collectors.joining("|","[","]"));
        System.out.println(result);        
    }		
} 