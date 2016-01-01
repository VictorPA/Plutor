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
	String[][] tableauImages;

	public ExportFilm(Film filmObject) {
		ArrayList<Image> film = filmObject.getFilm();
		entête = "" + filmObject.getFirstImage().getNombresColonnes() + " "
				+ filmObject.getFirstImage().getNombresLignes();
		tableauImages = new String[film.size()][];

		for (Image g : film) {
			char[][] tableau = g.getImage();
			tableauImages[film.indexOf(g)] = new String[tableau.length]; //tableau.length = nbr de lignes de l'image g
			for (int i = 0; i < tableau.length; ++i) {
				int espacesDeFin = compterEspaces(tableau,i);
				tableauImages[film.indexOf(g)][i] = new String(tableau[i],0,tableau[i].length-espacesDeFin);
				
				
			}

		}

	}
	
	private int compterEspaces(char[][] tableau,int ligne){
		int i = tableau[ligne].length - 1;
		int compteur = 0;
		while(tableau[ligne][i] == ' ' && i > 0){
			tableau[ligne][i] = 'a';
			--i;
			compteur++;
		}
		if(compteur == tableau[ligne].length - 1)
			return compteur+1;
		return compteur;
	}
	
	public void exporter() {

		List<String> lines = toStringList();
		Path file = Paths.get("sortierendu.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private List<String> toStringList(){
		// List<String[]> lines = Arrays.asList(tableauDeTableauChaînes);
		// List<String> lines = Arrays.asList(tableauChaînes);
		List<String> lines = new ArrayList<String>();
		lines.add(entête);
		for (int i = 0; i < tableauImages.length; ++i) {
			for (String s : tableauImages[i]) {
				lines.add(s);
			}
			if (i < tableauImages.length - 1)
				lines.add("\\newframe");
		}
		return lines;
	}
}
