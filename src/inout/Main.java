package inout;

import java.io.IOException;
import java.nio.file.FileSystems;

import film.Film;
import film.Image;

public class Main {

	public static void main(String[] args) throws IOException {
		Film film = new Film();
		Affichage affichage = new Affichage();
		affichage.graduer();
		Import imp = new Import(FileSystems.getDefault().getPath("src", "inout", "rsrc", "image1.txt"));

		Affichage.afficher(imp.getTableau());
		Image image1 = new Image(imp);
		film.ajouterImage(image1);
		Image image2 = new Image(imp);
		film.ajouterImage(image2);
		
		
		
		
		ExportFilm exp = new ExportFilm(film);
		exp.exporter();
		

	}

}
