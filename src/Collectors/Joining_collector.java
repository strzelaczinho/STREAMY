/*
1.1 Join String by a delimiter

	StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString(); //aaa,bbb,ccc
Copy
1.2 Join String by a delimiter and starting with a supplied prefix and ending with a supplied suffix.

	StringJoiner sj = new StringJoiner("/", "prefix-", "-suffix");
        sj.add("2016");
        sj.add("02");
        sj.add("26");
        String result = sj.toString(); //prefix-2016/02/26-suffix
 */
package Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Joining_collector {
    public static void main(String[] args) {
           List<Game> list = Arrays.asList(
                new Game("Dragon Blaze", 5),
                new Game("Angry Bird", 5),
                new Game("Candy Crush", 5));
           
       String result = list.stream().map(x -> x.getName())
			.collect(Collectors.joining(", ", "{", "}"));     
       
       System.out.println(result);
       
       
       List<String> list2 = Arrays.asList("java", "python", "nodejs", "ruby");
 	//java, python, nodejs, ruby
	String result2 = String.join(", ", list2);
        System.out.println(list2);
    }
}

class Game{
        String name;
        int ranking;

        public Game(String name, int ranking) {
            this.name = name;
            this.ranking = ranking;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }
    }

/*
2. String.join
StringJoiner is used internally by static String.join().

2.1 Join String by a delimiter.

	//2015-10-31
	String result = String.join("-", "2015", "10", "31" );
Copy
2.2 Join a List by a delimiter.

	List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
 	//java, python, nodejs, ruby
	String result = String.join(", ", list);
*/