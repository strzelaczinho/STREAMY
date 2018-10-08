/*

 */
package Streamy_z_Plikiem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Read_File_04_Stream_BufferedReader_i_Scanner {
    	public static void main(String args[]) {

		String fileName = "C:\\Users\\adam\\Documents\\NetBeansProjects\\STREAMY2\\lines.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
                {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
