package Konwersje;

public class Konwersja_Stinga_doChara {
      public static void main(String[] args) {

        String password = "password123";
        
        
        // wczesniej
        char[] passwordInCharArray = password.toCharArray();

        for (char temp : passwordInCharArray) {
            System.out.print(temp+" ");
        }
        System.out.println();
        password.chars().mapToObj(x -> (char) x).forEach(x->System.out.print(x+" ")); //IntStream potem  //Stream<Character>

    }
}
