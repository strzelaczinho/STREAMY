/*

 */
package Streamy_z_Plikiem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Read_File_01_Stream {
    	public static void main(String args[]) {

		String fileName = "C:\\Users\\adam\\Documents\\NetBeansProjects\\STREAMY2\\lines.txt";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName)))
                {
			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
