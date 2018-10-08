/*
(int)(Math.random() * ((max - min) + 1)) + min

public IntStream ints(int randomNumberOrigin, int randomNumberBound)
public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) 
 */
package Streamy_Random;
import java.util.Random;
public class Losowanie {
    public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomNumberInRange(33, 38));
		}
                
                new Random().ints(10, 33, 38).forEach(x->System.out.print(x+" "));
	}
	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}
}
