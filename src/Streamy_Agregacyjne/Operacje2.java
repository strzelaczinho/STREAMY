package Streamy_Agregacyjne;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Operacje2 {
    public static void main(String[] args) {
        List<Student> listStudents = new ArrayList<>();
 
listStudents.add(new Student("Alice", 82));
listStudents.add(new Student("Bob", 90));
listStudents.add(new Student("Carol", 67));
listStudents.add(new Student("David", 80));
listStudents.add(new Student("Eric", 55));
listStudents.add(new Student("Frank", 49));
listStudents.add(new Student("Gary", 88));
listStudents.add(new Student("Henry", 98));
listStudents.add(new Student("Ivan", 66));
listStudents.add(new Student("John", 52));

// studenci ktorzy maja wynik wiekszy od 70
System.out.println();
listStudents.stream().filter(p -> p.getScore() >= 70).forEach(x-> System.out.print(x.getName()+" "+x.getScore()+" "));
System.out.println("alternatywa na liste czyli Collectors");

List<Student> listGoodStudents = listStudents.stream().filter(s -> s.getScore() >= 70).collect(Collectors.toList());
listGoodStudents.stream().forEach(x->System.out.print(x+" "));
System.out.println();

List<Student> top3Students = listStudents.stream().filter(s -> s.getScore() >= 70).sorted().limit(3).collect(Collectors.toList());
System.out.println("Top 3 Students by Score:");
top3Students.forEach(x->System.out.print(x+" "));

System.out.println("\nCalculate average score of all students");
double average = listStudents.stream().mapToInt(s -> s.getScore()).average().getAsDouble();
int wszystkieWyniki = listStudents.stream().mapToInt(p ->p.getScore()).sum();

System.out.println("Average score: " + average+"  and sum of all Scores is "+wszystkieWyniki);
/*
An intermediate operation processes over a stream and return a new stream as a response. Then we can execute another intermediate operation on the new stream, and so on, and finally execute the terminal operation.
One interesting point about intermediate operations is that they are lazily executed. That means they are not run until a terminal operation is executed.
The Stream API provides the following common intermediate operations:
map()
filter()
sorted()
limit()
distinct()

4. Terminal Operations
A stream pipeline always ends with a terminal operation, which returns a concrete type or produces a side effect. For instances, the collect operation produces a collection; the forEach operation does not return a concrete type, but allows us to add side effect such as print out each element.
Unlike lazily-executed terminate operations, a terminal operation is always eagerly executed. The common terminal operations provided by the Stream API include:
collect()
reduce()
forEach()

5. Parallel Streams
The powerful feature of streams is that stream pipelines may execute either sequentially or in parallel. All collections support the parallelStream() method that returns a possibly parallel stream:
Stream<Student> parallelStream = listStudents.parallelStream();
When a stream executes in parallel, the Java runtime divides the stream into multiple sub streams. The aggregate operations iterate over and process these sub streams in parallel and then combine the results.
The advantage of parallel streams is performance increase on large amount of input elements, as the operations are executed currently by multiple threads on a multi-core CPU.
For example, the following code may execute stream operations in parallel:
*/
System.out.println();
listStudents.parallelStream().filter(s -> s.getScore() >= 70).sorted().limit(3).forEach(x->System.out.print(x+" "));
System.out.println();
/*
The Collection’s stream() method returns a sequential stream. We can convert a sequential stream to a parallel stream by calling the parallel() method on the current stream. 
The following example shows a stream executes the sorted operation sequentially, and then execute the filter operation in parallel:
*/
listStudents.stream().sorted().parallel().filter(s -> s.getScore() >= 70).forEach(x->System.out.print(x+" "));
//NOTE: Some operations can transform a stream of type A to a stream of type B, such as the map operation in the following example
System.out.println();
listStudents.stream().filter(s -> s.getScore() >= 70).map(s -> s.getName()).sorted().forEach(name -> System.out.println(name));
    }
}
 class Student implements Comparable<Student> {
    private String name;
    private int score;
 
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getName() {
        return this.name;
    }
 
    public void setScore(int score) {
        this.score = score;
    }
 
    public int getScore() {
        return this.score;
    }
 
    public String toString() {
        return this.name + " - " + this.score;
    }
 
    public int compareTo(Student another) {
        return another.getScore() - this.score;
    }
}