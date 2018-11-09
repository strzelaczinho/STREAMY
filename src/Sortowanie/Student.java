/*
Stream sorted() with List
Here we are sorting a List of objects of Student class.
First we will sort by natural ordering and then using Comparator. We will reverse
both ordering natural ordering as well as ordering provided by Comparator in our example. 
 */
package Sortowanie;

public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private int age;
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public int compareTo(Student ob) {
		return name.compareTo(ob.getName());
	}
        @Override
        public boolean equals(final Object obj) {
          if (obj == null) {
             return false;
          }
          final Student std = (Student) obj;
          if (this == std) {
             return true;
          } else {
             return (this.name.equals(std.name) && (this.age == std.age));
          }
        }
        @Override
        public int hashCode()
        {
          int hashno = 7;
          hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
          return hashno;
        }	
} 
/*
Stream sorted() using Natural Ordering, Comparator and Reverse Ordering
Find the syntax of sorted() method. 

1. sorted(): It sorts the elements of stream using natural ordering. The element class must implement Comparable interface. 

2. sorted(Comparator<? super T> comparator): Here we create an instance of Comparator using lambda expression. We can sort the stream elements in ascending and descending order. 

The following line of code will sort the list in natural ordering.
list.stream().sorted() To reverse the natural ordering Comparator provides reverseOrder() method. We use it as follows.
list.stream().sorted(Comparator.reverseOrder()) The following line of code is using Comparator to sort the list.
list.stream().sorted(Comparator.comparing(Student::getAge)) To reverse the ordering, Comparator provides reversed() method. We use this method as follows.
list.stream().sorted(Comparator.comparing(Student::getAge).reversed()) 
*/