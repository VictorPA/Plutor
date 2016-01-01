package inout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Path;
import java.util.Scanner;

public class Import {

	private int lignes;
	private int colonnes;
	char[][] tableau2D;

	// à faire : importer un fichier txt et séparer les images avec les
	// \newframe
	public Import(Path path) throws IOException {
		lignes = 0;
		colonnes = 0;
		importer(path);
	}
	/*
	 * public void importer(Path path) throws IOException { LineNumberReader lnr
	 * = new LineNumberReader(new FileReader(new
	 * File("src\\inout\\rsrc\\image1.txt"))); lnr.skip(Long.MAX_VALUE); //
	 * http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-
	 * java lignes = lnr.getLineNumber(); lnr.close(); Scanner scanner = new
	 * Scanner(path);
	 * 
	 * String[] tableauDeLignes = new String[lignes]; int positionLigne = 0;
	 * while (scanner.hasNextLine()) { tableauDeLignes[positionLigne] =
	 * scanner.nextLine(); if (tableauDeLignes[positionLigne].length() >
	 * colonnes) { colonnes = tableauDeLignes[positionLigne].length(); }
	 * 
	 * ++positionLigne; } colonnes = colonnes + 1; tableau2D = new
	 * char[lignes][colonnes]; for (positionLigne = 0; positionLigne < lignes;
	 * ++positionLigne) { tableau2D[positionLigne] =
	 * tableauDeLignes[positionLigne].toCharArray();
	 * 
	 * } enleverNull(); scanner.close(); }
	 */

	public void importer(Path path) throws IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader(new File("src\\inout\\rsrc\\image1.txt")));
		lnr.skip(Long.MAX_VALUE); // http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
		lignes = lnr.getLineNumber();
		lnr.close();
		try {
			Scanner scanner = new Scanner(path);

			String[] tableauDeLignes = new String[lignes];
			int positionLigne = 0;
			while (scanner.hasNextLine()) {
				tableauDeLignes[positionLigne] = scanner.nextLine();
				if (tableauDeLignes[positionLigne].length() > colonnes) {
					colonnes = tableauDeLignes[positionLigne].length();
				}

				++positionLigne;
			}
			colonnes += 1;
			tableau2D = new char[lignes][colonnes];

			for (positionLigne = 0; positionLigne < lignes; ++positionLigne) {
				int c = 0;
				for (; c < tableauDeLignes[positionLigne].length(); ++c) {
					tableau2D[positionLigne][c] = tableauDeLignes[positionLigne].charAt(c);
				}
				for (c = tableauDeLignes[positionLigne].length(); c < colonnes; ++c) {
					tableau2D[positionLigne][c] = ' ';
				}
			}
			// enleverNull();
			scanner.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public char[][] getTableau() {
		return tableau2D;
	}

	public int getNombresLignes() {
		return lignes;
	}

	public int getNombresColonnes() {
		return colonnes;
	}

}
