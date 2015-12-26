package inout;

import java.io.IOException;
import java.nio.file.FileSystems;

import film.Element;
import film.Film;
import film.Image;

public class Main {

	public static void main(String[] args) throws Exception {
		Film film = new Film();
		Affichage affichage = new Affichage();
		affichage.graduer();
		Import imp = new Import(FileSystems.getDefault().getPath("src", "inout", "rsrc", "image1.txt"));

		Affichage.afficher(imp.getTableau());

		Image image1 = new Image(imp);
		film.ajouterImage(image1);
		Image image2 = new Image(imp);
		Element e2 = new Element(image1, 21, 32, 37, 57); //22,33,38,58 => ça prend une case à droite et en bas
		image2.ajouterElementNoScrrrtch(e2, 41, 22);
		Element e3 = new Element(image2,11,40,20,50);
		Image image3 = new Image(image2);
		image3.effacerImage();
		image3.ajouterElement(e3, 10, 10);
		film.ajouterImage(image2);

		film.ajouterImage(image3);

		ExportFilm exp = new ExportFilm(film);
		exp.exporter();

	}

}
