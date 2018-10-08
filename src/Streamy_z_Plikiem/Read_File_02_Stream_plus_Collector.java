/*

 */
package Streamy_z_Plikiem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Read_File_02_Stream_plus_Collector {
    	public static void main(String args[]) {

		String fileName = "C:\\Users\\adam\\Documents\\NetBeansProjects\\STREAMY2\\lines.txt";
		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			//1. filter line 3
			//2. zamien na duze litery
			//3. dolacz do listy podanej przed try with resources
			list = stream.filter(line -> !line.startsWith("line3")).map(String::toUpperCase).collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);

	}
}
