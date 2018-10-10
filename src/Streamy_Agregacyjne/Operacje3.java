package Streamy_Agregacyjne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
int sumaLat = listPersons.stream().mapToInt(p -> p.getAge()).sum(); // suma lat
long LiczbaMajli = listPersons.stream().filter(p -> p.getEmail().contains("gmail.com")).count(); //count zwraca longa
System.out.println("Collect()");
System.out.println("Wszystkie rozneMajle "+listaMajli+",Suma lat "+sumaLat+", Liczba mejli z gmail.com = "+LiczbaMajli);



    }
    }


