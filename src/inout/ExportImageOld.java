package inout;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import film.Image;

/**
 * Prépare un fichier image au format char[][] pour l'exportation.
 * 
 * @author user
 *
 */
public class ExportImageOld {

	String[] tableauChaînes;

	// public Export(ArrayList <Image> film) {
	public ExportImageOld(Image image) {
		char[][] tableau = image.getImage();
		tableauChaînes = new String[tableau.length];
		for (int i = 0; i < tableau.length; ++i) {
			tableauChaînes[i] = new String(tableau[i]);
			// System.out.println(tableauChaînes[i]);
		}
	}

	public void exporter() {

		List<String> lines = Arrays.asList(tableauChaînes);
		Path file = Paths.get("sortierendu.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
