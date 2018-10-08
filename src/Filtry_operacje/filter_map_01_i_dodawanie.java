package Filtry_operacje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
public class filter_map_01_i_dodawanie {

    public static void main(String[] args) {

        List<Persons> persons = Arrays.asList(
                new Persons("Adam", 30),
                new Persons("Jurek", 20),
                new Persons("Marzena", 40)
        );

        String name = persons.stream().filter(x -> "Jurek".equals(x.getName()))
                .map(Persons::getName)                        //convert stream to String
                .findAny()
                .orElse("Nie znalazlem");

        System.out.println("name : " + name);
        System.out.println("A teraz wszystkie obiekty ktore mają getName");
        List<String> collect = persons.stream().map(Persons::getName).collect(Collectors.toList());

        collect.forEach(System.out::println);
        
        System.out.println("Teraz sumuje wszystkie lata ");
        int zmienna = persons.stream().mapToInt(x->x.getAge()).sum(); 
        System.out.println(zmienna) ;
        
        System.out.println("Teraz srednia wszystkich lat ");
        OptionalDouble zmienna2 = persons.stream().mapToInt(x->x.getAge()).average();   
        double wypisz = zmienna2.getAsDouble();
        System.out.println(wypisz);
        
    }                       
    
}
    class Persons {
    private String name;
    private Integer age;
    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }
}
/*
// Collecting to list 
  List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

     // Accumulate names into a TreeSet
     Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

     // Convert elements to strings and concatenate them, separated by commas
     String joined = things.stream()
                           .map(Object::toString)
                           .collect(Collectors.joining(", "));

     // Compute sum of salaries of employee
     int total = employees.stream()
                          .collect(Collectors.summingInt(Employee::getSalary)));

     // Group employees by department
     Map<Department, List<Employee>> byDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));

     // Compute sum of salaries by department
     Map<Department, Integer> totalByDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment,
                                                   Collectors.summingInt(Employee::getSalary)));

     // Partition students into passing and failing
     Map<Boolean, List<Student>> passingFailing =
         students.stream()
                 .collect(Collectors.partitioningBy(s -> s.getGrade(
*/