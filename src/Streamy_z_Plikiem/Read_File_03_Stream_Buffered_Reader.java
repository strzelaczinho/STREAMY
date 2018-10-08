/*

 */
package Streamy_z_Plikiem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Read_File_03_Stream_Buffered_Reader {
    	public static void main(String args[]) {

		String fileName = "C:\\Users\\adam\\Documents\\NetBeansProjects\\STREAMY2\\lines.txt";
		List<String> list = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			//BufferedReader zwraca stream i skonwertuje go na liste
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		list.forEach(System.out::println);

	}
}
