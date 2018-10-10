package Streamy_Agregacyjne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
    public class Operacje
    {
public static void main(String[] args) 
        {
List<Person> listPersons = new ArrayList<>();
 
listPersons.add(new Person("Alice", "Brown", "alice@gmail.com", Gender.FEMALE, 26));
listPersons.add(new Person("Bob", "Young", "bob@gmail.com", Gender.MALE, 32));
listPersons.add(new Person("Carol", "Hill", "carol@gmail.com", Gender.FEMALE, 23));
listPersons.add(new Person("David", "Green", "david@gmail.com", Gender.MALE, 39));
listPersons.add(new Person("Eric", "Young", "eric@gmail.com", Gender.MALE, 26));
listPersons.add(new Person("Frank", "Thompson", "frank@gmail.com", Gender.MALE, 33));
listPersons.add(new Person("Gibb", "Brown", "gibb@gmail.com", Gender.MALE, 27));
listPersons.add(new Person("Henry", "Baker", "henry@gmail.com", Gender.MALE, 30));
listPersons.add(new Person("Isabell", "Hill", "isabell@gmail.com", Gender.FEMALE, 22));
listPersons.add(new Person("Jane", "Smith", "jane@gmail.com", Gender.FEMALE, 24));

//For terminal operations, we simple use the forEach operation that print out the current element in the result stream.
//The filter() operation returns a new stream that consists elements matching a given condition which is typically a boolean test in form of a Lambda expression.
// sami faceci 
System.out.println("filter");
listPersons.stream().filter(x -> x.getGender().equals(Gender.MALE)).forEach(x -> System.out.print(x+" "));
System.out.println();
// kobiety ponizej 25 roku zycia 
listPersons.stream().filter(x -> x.getAge() < 25 && x.getGender().equals(Gender.FEMALE)).forEach(x-> System.out.print(x+" "));
/*
The map operation returns a new stream consisting of elements which are the results of applying a given function 
to the elements of the current stream. For example, converting a stream of Objects to a stream of String or a stream of primitive numbers.
The Stream API provides 4 methods for the map operation:
map(): transforms a stream of objects of type T to a stream of objects of type R.
mapToInt(): transforms a stream of objects to a stream of int primitives.
mapToLong(): transforms a stream of objects to a stream of long primitives.
mapToDouble(): transforms a stream of objects to a stream of double primitives.
The following code maps each person to his/her respective email address:
*/
System.out.println("\nmap");
 listPersons.stream().map(p -> p.getEmail()).forEach(x-> System.out.print(x+" "));   // wszystkie maile 
 System.out.println();
 listPersons.stream().mapToInt(p -> p.getAge()).forEach(age -> System.out.print(age + " - "));
 System.out.println();
// mapowanie imienia 
listPersons.stream().map(p -> p.getFirstName().toUpperCase()).forEach(name -> System.out.print(name+" "));
/*
The Stream API provides two overloads of the sorted operation that returns a new stream consisting elements sorted according to natural order or by a specified comparator:
sorted(): sorts by natural order
sorted(comparator): sorts by a comparator
*/
System.out.println("\nsorted");
listPersons.stream().sorted().forEach(p -> System.out.print(p + " = " + p.getAge()+" "));//Look at the compareTo() method in the Person class, we see that the natural ordering is based on age:
System.out.println();
listPersons.stream().sorted((p1, p2) -> p1.getLastName().compareTo(p2.getLastName())).forEach(p-> System.out.print(p+", "));

//The distinct() operation returns a stream consisting of the distinct elements (no duplicates) by comparing objects via their equals() method//
int[] numbers = {23, 58, 12, 23, 17, 29, 99, 98, 29, 12};
System.out.println("\nDistinct");
Arrays.stream(numbers).distinct().forEach(i -> System.out.print(i + " "));
System.out.println("\nLimit");
//The limit() operation returns a stream containing only a specified number of elements. Combining with the sorted() or filter operation, the following example shows top 5 youngest persons:
listPersons.stream().sorted().limit(5).forEach(p-> System.out.print(p+" ")); // 5 youngest
System.out.println();
listPersons.stream().sorted().limit(5).filter(p -> p.getAge() > 30).forEach(p-> System.out.print(p+" ")); // 5 older than 30 if they are five :)

//6. The skip operation The skip() operation returns a stream containing the remaining elements after discarding the first n elements of the stream.Combining with the sorted and map operations, the following example finds the oldest age of the persons above:
System.out.print("Skip czyli po sortowaniu  The oldest age: ");
listPersons.stream().sorted().map(p -> p.getAge()).skip(listPersons.size() - 1).forEach(System.out::println);

    }
    }
enum Gender { MALE, FEMALE }

 class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private int age;// natural ordering of this class is based on age of the person
 
    public Person() {
    }
 
    public Person(String firstName, String lastName,String email, Gender gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
 
    public int compareTo(Person another) {
        return this.age - another.getAge();
    }
 
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
