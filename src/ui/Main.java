package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import model.LinkedMatrix;

public class Main {

	public static void main(String[] args) {
		System.out.println("Select an option: \n"
							+ "1: Jugar \n"
							+ "0: Salir");
		LinkedMatrix lm = new LinkedMatrix(4,4);
		System.out.println(lm);
	}

}
