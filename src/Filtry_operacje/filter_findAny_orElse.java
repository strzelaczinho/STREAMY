package Filtry_operacje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class filter_findAny_orElse {

    public static void main(String[] args) {
     List<Person> persons = Arrays.asList(
                new Person("Adam", 30),
                new Person("coraz", 20),
                new Person("mlodszy", 40),
                new Person("mlodszy",42)
        );

        Person result = getStudentByName(persons, "coraz");
        System.out.println(result);
        
        
        Person result1 = persons.stream()                        // Zamieinam na stream
                .filter(x -> "mlodszy".equals(x.getName()))        // tylko mlodszego
                .findAny()                                      // szuka jakiegokolwiek Wypisze pierwszego
                .orElse(null); 
        System.out.println(result1);
        
        Person result2 = persons.stream()
                .filter(x -> "inny".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result2);
        
        
        Person result3 = persons.stream()
                .filter((p) -> "Adam".equals(p.getName()) && 30 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println(result3);
        
        
        Person result4 = persons.stream()
                .filter(p -> {
                    if ("mlodszy".equals(p.getName()) && 40 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);// mozna dac napis Stringa w przypadku gdy nie ma zamiast nulla

        System.out.println(result4);
        
    }

    private static Person getStudentByName(List<Person> persons, String name) {

        Person result = null;
        for (Person temp : persons) {
            if (name.equals(temp.getName())) {
                result = temp;
            }
        }
        return result;
        
    }
}
    class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }
}