package Collectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Collectors_to_map_03_collect_a_potem_sortowanie {
     public static void main(String[] args) {

        List<Hostingz> list = new ArrayList<>();
        list.add(new Hostingz(1, "liquidweb.com", 80000));
        list.add(new Hostingz(2, "linode.com", 90000));
        list.add(new Hostingz(3, "digitalocean.com", 120000));
        list.add(new Hostingz(4, "aws.amazon.com", 200000));
        list.add(new Hostingz(5, "adam.com", 1));
        list.add(new Hostingz(6, "linode.com", 100000));

        //example 1
        Map result1 = list.stream().sorted(Comparator.comparingLong(Hostingz::getWebsites).reversed())
                .collect(
                        Collectors.toMap(Hostingz::getName, Hostingz::getWebsites, // key = name, value = websites
                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, ktora utrzyma order
                        ));

        System.out.println("Result 1 : " + result1);

    }
}
 class Hostingz {

    private int Id;
    private String name;
    private long websites;

    public Hostingz(int id, String name, long websites) {
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

   
