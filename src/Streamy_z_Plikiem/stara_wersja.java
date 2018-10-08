/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Streamy_z_Plikiem;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author adam
 */
public class stara_wersja {
    public static void main(String args[]) {

		String fileName = "C:\\Users\\adam\\Documents\\NetBeansProjects\\STREAMY2\\lines.txt";

		try (Scanner scanner = new Scanner(new File(fileName))) {

			while (scanner.hasNext()){
				System.out.println(scanner.nextLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
