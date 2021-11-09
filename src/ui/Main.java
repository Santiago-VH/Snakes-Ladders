package ui;

import model.LinkedMatrix;

public class Main {

	public static void main(String[] args) {
		System.out.println("Seleccione una opción: \n"
							+ "1: Jugar \n"
							+ "0: Salir");
		LinkedMatrix lm = new LinkedMatrix(3,4);
		System.out.println(lm);
	}

}
