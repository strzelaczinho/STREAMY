package Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Collectors_to_map_02_dupikaty {
     public static void main(String[] args) {
        List<Hostings> list = new ArrayList<>();
        list.add(new Hostings(1, "liquidweb.com", 80000));
        list.add(new Hostings(2, "linode.com", 90000));
        list.add(new Hostings(3, "digitalocean.com", 120000));
        list.add(new Hostings(4, "aws.amazon.com", 200000));
        list.add(new Hostings(5, "adam.com", 1));
        list.add(new Hostings(6, "linode.com", 100000)); // new line
/*
                 Map<String, Long> result1 = list.stream().collect(
               Collectors.toMap(Hostings::getName, Hostings::getWebsites));
*/
        // key = name, value - websites , but the key 'linode' is duplicated!?
        //To solve the duplicated key issue above, pass in the third mergeFunction argument like this :
        Map<String, Long> result = list.stream().collect(
                Collectors.toMap(Hostings::getName, Hostings::getWebsites,
                        (oldValue, newValue) -> oldValue
                )
        );
        System.out.println(result);
        // jesli klucz jest duplikatem , preferuje stara wartosc oldvalue czy nowa wartosc newValue tzn 9000 czy 12000
        Map<String, Long> result2 = list.stream().collect(
                Collectors.toMap(Hostings::getName, Hostings::getWebsites,
                        (oldValue, newValue) -> newValue
                )
        );
         System.out.println(result2);
     }
}
 class Hostings {

    private int Id;
    private String name;
    private long websites;

    public Hostings(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWebsites() {
        return websites;
    }

    public void setWebsites(long websites) {
        this.websites = websites;
    }

    @Override
    public String toString() {
        return "Hosting{" + "Id=" + Id + ", name=" + name + ", websites=" + websites + '}';
    }
 }

   
