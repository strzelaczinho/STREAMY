package Comparator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_01_SortowanieLambda {

	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();
                System.out.println("Przed sortowaniem");
		listDevs.forEach(e-> System.out.println(e));
                
                listDevs = sortowaniePrzezWiek(getDevelopers());
		System.out.println("Po sortowaniu przez wiek");
		listDevs.forEach(e-> System.out.println(e));
                
                listDevs = sortowaniePrzezNazwe(getDevelopers());
                System.out.println("Po sortowaniu przez nazwe");
                listDevs.forEach(e-> System.out.println(e));
                
                listDevs = sortowaniePrzezZarobki(getDevelopers());
                 System.out.println("Po sortowaniu przez zarobki");
                listDevs.forEach(e-> System.out.println(e));
                 
                // BEZ klasy COLLECTIONS oraz metod
                System.out.println("SORTOWANIE LAMBDA PO WIEKU");
                listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge()); 
                listDevs.forEach((developer)->System.out.println(developer));
                
                System.out.println("SORTOWANIE LAMBDA PO NAZWIE");
                listDevs.sort((Developer o1,Developer o2) -> o1.getNazwa().compareTo(o2.getNazwa()));
                listDevs.forEach((developer)->System.out.println(developer));
                
                
                System.out.println("JESZCZE KROTSZA LAMBDA WIEK ");
                listDevs.sort((o1,o2)-> o1.getAge() - o2.getAge());
                listDevs.forEach(e-> System.out.println(e));
                
                
	}
	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("Adam", new BigDecimal("70000"), 33));
		result.add(new Developer("Jurek", new BigDecimal("80000"), 20));
		result.add(new Developer("Zdzisiek", new BigDecimal("100000"), 10));
		result.add(new Developer("Krystek", new BigDecimal("170000"), 55));
		
		return result;
	}
        
        private static List<Developer> sortowaniePrzezWiek(List<Developer> lista)
        {
            // by age
		Collections.sort(lista, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		});
                return lista;
        }
         private static List<Developer> sortowaniePrzezNazwe(List<Developer> lista)
        {
		Collections.sort(lista, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getNazwa().compareTo(o2.getNazwa());
			}
		});
                return lista;
        }
         private static List<Developer> sortowaniePrzezZarobki(List<Developer> lista)
         {
             Collections.sort(lista, new Comparator<Developer>() {
		@Override
		public int compare(Developer o1, Developer o2) {
			return o1.getLiczba().compareTo(o2.getLiczba());
		}
	});	
             return lista;
         }
}
 class Developer
{
    private String nazwa;
    private BigDecimal liczba;
    private int age;

    public Developer(String nazwa, BigDecimal liczba, int age) {
        this.nazwa = nazwa;
        this.liczba = liczba;
        this.age = age;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BigDecimal getLiczba() {
        return liczba;
    }

    public void setLiczba(BigDecimal liczba) {
        this.liczba = liczba;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Developer{" + "nazwa=" + nazwa + ", liczba=" + liczba + ", age=" + age + '}';
    }
    
}