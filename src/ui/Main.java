package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.LinkedMatrix;

public class Main {

	public static void main(String[] args) throws IOException {
		LinkedMatrix lm;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Select an option: \n"
							+ "1: Play \n"
							+ "0: Exit \n");
		int option=Integer.parseInt(br.readLine());
		if(option==1) {
			System.out.println("\nDigit the number of rows, columns, snakes, ladders, and symbols respectively "
								+ "(the number of symbols determines the number of players).\n"
								+ "here's an example of a game setup done correctly \n"
								+ "\n3 4 2 3 #%* \n"
								+ "3 rows, 4 columns, 2 ladders, 3 snakes and 3 players \n");
			String line=br.readLine();
			String[] parts = line.split(" ");
			String row = parts[0];
			int r = Integer.valueOf(row);
			String col = parts[1];
			int c = Integer.valueOf(col);
			String snake = parts[2];
			int s = Integer.valueOf(snake);
			String ladder = parts[3];
			int l = Integer.valueOf(ladder);
			String players = parts[4];
			
			System.out.println("prueba "+parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[3]+" "+parts[4]);
			lm = new LinkedMatrix(r,c);
			System.out.println(lm);
		} else {
			System.out.println("Program finished.");
		}
	}
}
