/*

Stream sorted() with Set
Here we are sorting the Set of objects of Student class.
This class must override equals() and hashCode() methods to identify unique elements. 
For natural ordering Student class needs to implement Comparable interface. In our 
example we will sort our Set using natural ordering as well as ordering provided by Comparator. 
 */
package Sortowanie;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;


public class SortSet {
	public static void main(String[] args) {
		Set<Student> set = new HashSet<Student>();
		set.add(new Student(1, "Mahesh", 12));
		set.add(new Student(2, "Suresh", 15));
		set.add(new Student(3, "Nilesh", 10));
		
		System.out.println("---Naturalne sortwanie imion wynikajace z comparatora");
		set.stream().sorted().forEach(e -> System.out.println("Id:"
		          + e.getId()+", Imie: "+e.getName()+", wiek:"+e.getAge()));
		
		System.out.println("---Naturalne sortowanie imion reverse order wynikajace z comparatora---");
		set.stream().sorted(Comparator.reverseOrder()).forEach(e -> System.out.println("Id:"
		          + e.getId()+", Imie: "+e.getName()+", Wiek:"+e.getAge()));		
		
		System.out.println("---Naturalne sortowanie przez wiek---");
		set.stream().sorted(Comparator.comparing(Student::getAge))
		  .forEach(e -> System.out.println("Id:"+ e.getId()+", imie: "+e.getName()+", wiek:"+e.getAge()));
		
		System.out.println("---Naturalne sortowanie przez wiek reverse---");
		set.stream().sorted(Comparator.comparing(Student::getAge).reversed())
		  .forEach(e -> System.out.println("Id:"+ e.getId()+", Imie: "+e.getName()+", wiek:"+e.getAge()));
	}
} 
