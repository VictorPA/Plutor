package inout;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Path;
import java.util.Scanner;

public class Import {

	private int lignes;
	private int colonnes;
	char[][] tableau2D;

	public Import(Path path) throws IOException {
		lignes = 0;
		colonnes = 0;
		importer(path);
	}

	public void importer(Path path) throws IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader(new File("src\\inout\\rsrc\\image1.txt")));
		lnr.skip(Long.MAX_VALUE); // http://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
		lignes = lnr.getLineNumber();
		lnr.close();
		Scanner scanner = new Scanner(path);

		String[] tableauDeLignes = new String[lignes];
		int positionLigne = 0;
		while (scanner.hasNextLine()) {
			tableauDeLignes[positionLigne] = scanner.nextLine();
			if (tableauDeLignes[positionLigne].length() > colonnes) {
				colonnes = tableauDeLignes[positionLigne].length() + 1;
			}

			++positionLigne;
		}
		tableau2D = new char[lignes][colonnes];
		for (positionLigne = 0; positionLigne < lignes; ++positionLigne) {
			tableau2D[positionLigne] = tableauDeLignes[positionLigne].toCharArray();
		}
		scanner.close();
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
