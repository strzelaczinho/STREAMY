package Streamy_Agregacyjne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
    public class Operacje3
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

//The allMatch()operation answers the question: Do all elements in the stream meet this condition? It returns true if and only if all elements match a provided predicate, otherwise return false.
//This is a short-circuiting terminal operation because the operation stops immediately if any unmatched element is found (just like short-circuit behavior of the AND operator).        

System.out.println("allMatch()");
boolean czyWszystkieOsobySaStarsze = listPersons.stream().allMatch(p-> p.getAge() > 30);
boolean czyWszyscySaFacetami = listPersons.stream().allMatch(p-> p.getGender().equals(Gender.MALE));
boolean czyKazdyMailKonczySieTakSamo = listPersons.stream().allMatch(p-> p.getEmail().endsWith("gmail.com"));
System.out.println("Starsze = "+czyWszystkieOsobySaStarsze+", Sami faceci = "+czyWszyscySaFacetami+", Maile koncza sie na gmail.com = "+czyKazdyMailKonczySieTakSamo);

//The anyMatch() operation returns true if any element in the stream matches a provided predicate. In other words, it answers the following question: Is there any element that meets this condition?
System.out.println("anyMatch()");
boolean czyJestJakasKobieta = listPersons.stream().anyMatch(p -> p.getGender().equals(Gender.FEMALE));
boolean czyJestJakisNastolatek = listPersons.stream().anyMatch(p-> p.getAge() < 15 );
System.out.println("Jest kobieta = "+czyJestJakasKobieta+", Jakis nastolatek ponizej 15 roku =  "+czyJestJakisNastolatek);

//In contrast to the allMatch() operation, the noneMatch() operation returns true if no elements in the stream match a provided predicate. In other words, it answers the question:
System.out.println("noneMatch()");
boolean czyWszyscySaMlodsiNiz40lat = listPersons.stream().noneMatch(p -> p.getAge() > 40); // true jesli nikt nie spelnia warunku
boolean czyMaKtosInnegoMailaNizGmail = listPersons.stream().noneMatch(p-> !"gmail.com".equals(p.getEmail()));
boolean czyMaktosInnegoMailaNizgmail2 = listPersons.stream().noneMatch(p-> p.getEmail().endsWith("gmail.com"));
boolean czyJestKtosZNazwiskiemHill = listPersons.stream().noneMatch(p-> p.getLastName().equals("Hill"));
System.out.println("Wszyscy mlodsi niz 40 = "+czyWszyscySaMlodsiNiz40lat+", Inny majl niz gmail = "+czyMaKtosInnegoMailaNizGmail+", Druga wersjaMaila = "+czyMaktosInnegoMailaNizgmail2+", Ktos z rodziny Hill = "+czyJestKtosZNazwiskiemHill);

//The collect() operation accumulates elements in a stream into a container such as a collection. It performs mutable reduction operation in which the reduced (final) value is a mutable result container such as an ArrayList. This method takes a Collector implementation that provides useful reduction operations. The Collectors class is a common implementation in the JDK. And we are going to see how it is used in the following examples.
List<String> listaMajli = listPersons.stream().map(p -> p.getEmail()).distinct().collect(Collectors.toList());//wszystkie rozne majle
// zamiana kolekcji na TreeSet
Set<String> setMajli = listPersons.stream().map(p->p.getEmail()).collect(Collectors.toCollection(TreeSet::new));// bedzie zachowany order
Map<Gender, List<Person>> byGender = listPersons.stream().collect(Collectors.groupingBy(p -> p.getGender())); // grupuje Person po plci 
Map<Integer,List<Person>> byWiek = listPersons.stream().collect(Collectors.groupingBy(p -> p.getAge()));
Map<String,List<Person>> byEmail = listPersons.stream().collect(Collectors.groupingBy(p -> p.getEmail()));
String firstNames = listPersons.stream().map(p -> p.getFirstName()).collect(Collectors.joining(", "));

System.out.println("Collect()");
System.out.println("Wszystkie rozneMajle "+listaMajli);
System.out.println("Kolekcja majli w TreeSecie "+setMajli);//uporzadkowane sa
System.out.println("Grupowany gender = "+byGender);
System.out.println("Grupowany wiek = "+byWiek);
System.out.println("Grupowanie po majlu  = "+byEmail);
System.out.println("Wszystkie pierwsze imiona "+firstNames);
String wszystkieImionaWStringu = listPersons.stream().map(p->p.getFirstName()).collect(Collectors.joining(", "));
String wszyscyFaceciPowyzej30rokuZycia = listPersons.stream().filter(p->p.getAge() > 30 && p.getGender().equals(Gender.MALE)).map(p->p.getFirstName()).collect(Collectors.joining(", "));

System.out.println(" Wszyscy Faceci powyzej 30 roku zycia "+wszyscyFaceciPowyzej30rokuZycia);


// count , sum etc...
System.out.println("count(),sum(),average()");

long liczbaFacetow = listPersons.stream().filter(p-> p.getGender().equals(Gender.MALE)).count();
long LiczbaMajli = listPersons.stream().filter(p -> p.getEmail().contains("gmail.com")).count(); //count zwraca longa
long sumaLat = listPersons.stream().mapToInt(p -> p.getAge()).sum(); // suma lat
OptionalDouble wynik  = listPersons.stream().mapToInt(p-> p.getAge()).average();// taki obiekt zwraca average
double konwersja = wynik.getAsDouble();
System.out.println("Liczba facetow = "+liczbaFacetow+", Liczba majli "+LiczbaMajli+", Suma lat "+sumaLat+", Srednia lat = "+konwersja);

System.out.println("ForEach()");
listPersons.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).forEach(p->System.out.print(p+" "));

//min()
//The min(comparator) is a special reduction operation that returns the minimum element in the stream according to the provided comparator. It returns an Optional which is a container object that contains the value.
// youngest female
    System.out.println("\nmin()");
  Optional<Person> min = listPersons.stream().filter(p -> p.getGender().equals(Gender.FEMALE)).min((p1, p2) -> p1.getAge() - p2.getAge());
  
  if (min.isPresent()) {
    Person youngestGirl = min.get();
    System.out.println("Najmlodsza kobieta to: "
                + youngestGirl + " (" + youngestGirl.getAge() + ")");
                     }  
    
  
    System.out.println("max()");
    Optional<Person> najstarszy = listPersons.stream().max((p1,p2)->p1.getAge() - p2.getAge());
    Person max = najstarszy.get();
    System.out.println("Najstarsza osoba to "+max+" ("+max.getAge()+")");
    
    Optional<Person> najdluzszyMail = listPersons.stream().filter(p-> p.getEmail().length() > 5).max((p1,p2)-> p1.getEmail().length() - p2.getEmail().length());
    Person p = najdluzszyMail.get();
    System.out.println("Najdluzszy email posiada "+p+" "+p.getEmail());
    
    
    System.out.println("reduce()");
    //The Stream API provides three versions of reduce() methods which are general reduction operations. Let’s look at each version.Version #1: Optional<T> reduce(BinaryOperator<T> accumulator)
    //This method performs a reduction on the elements of the stream, using an associative accumulation function, and returns an Optional object describing the reduced value. For example, the following code accumulates first names of all persons into a String:
     
//    Optional<String> reducedValue = listPersons.stream().map(p -> p.getFirstName()).reduce("",(name1,name2) -> name1+" "+name2);
// 
//if (reducedValue.isPresent()) {
//    String names = reducedValue.get();
//    System.out.println(names);
// do poprawy 

/*
Version #2: T reduce(T identity, BinaryOperator<T> accumulator)
it returns the reduced value of the specified type T. The identity value must be an identity value for the accumulator function, which means it does not affect the result of accumulation. The following example calculates sum of numbers in a stream:
*/
int[] numbers = {123, 456, 789, 246, 135, 802, 791};
int sum = Arrays.stream(numbers).reduce(0, (x, y) -> (x + y));
System.out.println("sum = " + sum);

//Version #3:U reduce(U identity, BiFunction<U,? super T,U> accumulator,BinaryOperator<U> combiner)
/*This is the most general reduction method that performs a reduction on elements of the stream, using the provided identity, accumulator and combiner.
The identity element is both an initial seed value for the reduction and a default result if there are no input elements.
The accumulator function takes a partial result and the next element, and produces a new partial result
The combiner function combines two partial results to produce a new partial result (it is necessary in parallel reductions).
The following example shows how this general reduction operation is used to accumulate numbers to calculate sum of them:*/
//int[] numbers2 = {123, 456, 789, 246, 135, 802, 791};
//int sum2 = Arrays.stream(numbers2).reduce(0, (x, y) -> (x + y), Integer::sum);
//System.out.println("sum = " + sum2);
        }
    }


