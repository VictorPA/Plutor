package inout;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;

import film.Film;
import film.Image;

/**
 * Prépare un fichier image au format char[][] pour l'exportation.
 * 
 * @author user
 *
 */
public class ExportFilm {
	String entête;
	String[][] tableauDeTableauChaînes;

	public ExportFilm(Film filmObject) {
		ArrayList<Image> film = filmObject.getFilm();
		entête =""+ filmObject.getFirstImage().getNombresLignes() + " " + filmObject.getFirstImage().getNombresColonnes();
		tableauDeTableauChaînes = new String[film.size()][];

		for (Image g : film) {
			g.getImage();
			char[][] tableau = g.getImage();
			tableauDeTableauChaînes[film.indexOf(g)] = new String[tableau.length];
			for (int i = 0; i < tableau.length; ++i) {
				tableauDeTableauChaînes[film.indexOf(g)][i] = new String(tableau[i]);
				// System.out.println(tableauChaînes[i]);
			}
		}

	}

	public void exporter() {

		List<String> lines = new ArrayList<String>();
		lines.add(entête);
		for (String[] ts : tableauDeTableauChaînes) {
			for (String s : ts) {
				lines.add(s);
				
			}
			lines.add("/newframe");
		}

		// List<String[]> lines = Arrays.asList(tableauDeTableauChaînes);
		// List<String> lines = Arrays.asList(tableauChaînes);
		Path file = Paths.get("sortierendu.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
