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
 * Pr�pare un fichier image au format char[][] pour l'exportation.
 * 
 * @author user
 *
 */
public class ExportFilm {
	String ent�te;
	String[][] tableauDeTableauCha�nes;

	public ExportFilm(Film filmObject) {
		ArrayList<Image> film = filmObject.getFilm();
		ent�te =""+ filmObject.getFirstImage().getNombresLignes() + " " + filmObject.getFirstImage().getNombresColonnes();
		tableauDeTableauCha�nes = new String[film.size()][];

		for (Image g : film) {
			g.getImage();
			char[][] tableau = g.getImage();
			tableauDeTableauCha�nes[film.indexOf(g)] = new String[tableau.length];
			for (int i = 0; i < tableau.length; ++i) {
				tableauDeTableauCha�nes[film.indexOf(g)][i] = new String(tableau[i]);
				// System.out.println(tableauCha�nes[i]);
			}
		}

	}

	public void exporter() {

		List<String> lines = new ArrayList<String>();
		lines.add(ent�te);
		for (String[] ts : tableauDeTableauCha�nes) {
			for (String s : ts) {
				lines.add(s);
				
			}
			lines.add("/newframe");
		}

		// List<String[]> lines = Arrays.asList(tableauDeTableauCha�nes);
		// List<String> lines = Arrays.asList(tableauCha�nes);
		Path file = Paths.get("sortierendu.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
