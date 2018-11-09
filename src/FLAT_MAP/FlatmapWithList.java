
package FLAT_MAP;
// mapuje obiekt na inny obiekt filtrujac najwiekszy, pobierajac dane z dwoch list z Writera
import java.util.Arrays;
import java.util.List;
public class FlatmapWithList {
    public static void main(String[] args) {
    	List<Book> books = Arrays.asList(new Book(10, "AAA"), new Book(20, "BBB"));
    	Writer w1 = new Writer("Mohan", books); // zapisuje ksiazki 
        
    	books = Arrays.asList(new Book(30, "XXX"), new Book(15, "ZZZ"));// tu juz nowe ksiazki , lista wyzerowana
        
    	Writer w2 = new Writer("Sohan", books);    	
    	List<Writer> writers = Arrays.asList(w1, w2);
    	Book book = writers.stream().flatMap(writer -> writer.getBooks().stream())
    			.max(new BookComparator()).get();   //max zwraca maksymalny element ,get zwraca wartosc jesli jest jesli nie ma expcetion
    	System.out.println("Name:"+book.getName()+", Price:"+ book.getPrice() );
        
        
        
        
    }
}  
