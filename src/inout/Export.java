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
 * Pr�pare un fichier image au format char[][] pour l'exportation.
 * 
 * @author user
 *
 */
public class Export {

	String[] tableauCha�nes;
	
	
	public Export(Image image) {
		char[][] tableau = image.getImage();
		tableauCha�nes = new String[tableau.length];
		for (int i = 0; i < tableau.length; ++i) {
			tableauCha�nes[i] = new String(tableau[i]);
			//System.out.println(tableauCha�nes[i]);
		}
	}

	public void exporter() {

		List<String> lines = Arrays.asList(tableauCha�nes);
		Path file = Paths.get("sortierendu.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
