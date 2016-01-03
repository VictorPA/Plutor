package inout;

import java.nio.file.FileSystems;

import static film.Coin.*;

//import film.Coin;
import film.Element;
import film.Film;
import film.Image;
import film.Point;


public class Main {

	public static void main(String[] args) throws Exception {
		
		Film film = new Film();
		Import imp = new Import(FileSystems.getDefault().getPath("src", "inout", "rsrc", "image1.txt"));
		
		Image image1 = new Image(imp);
		
		Image image2 = new Image(image1);
		Element bouclier = new Element(image1, 21, 30, 37, 57);
		Element trait = new Element('O', new Point(19,99), new Point(52,80));
		image2.ajouterElement(bouclier, new Point(41,22), BAS_GAUCHE );

		image2.ajouterElement(trait, new Point(19,99), HAUT_DROITE );
		image2.appliquerElements();
		
		image1.ajouterElement(trait, new Point(19,99), HAUT_DROITE );
		image1.appliquerElements();
		
		
		film.ajouterImage(image1);
		film.ajouterImage(image2);
		

	
		




		for (int i = 0; i < image2.getNombresLignes(); ++i) {
			Element e = new Element(image2, 0, i, 0, image2.getNombresColonnes());
			Image image = new Image(image2.getNombresLignes(), image2.getNombresColonnes());
			image.ajouterElement(e, new Point(0,0), HAUT_GAUCHE);
			image.appliquerElements();
			film.ajouterImage(image);
		}

		for (int i = 0; i < image2.getNombresLignes(); ++i) {
			Element e = new Element(image2, image2.getNombresLignes() - i, image2.getNombresLignes(), 0,
					image2.getNombresColonnes());
			Image image = new Image(image2.getNombresLignes(), image2.getNombresColonnes());
			image.ajouterElement(e, new Point(0,0), HAUT_GAUCHE);
			image.appliquerElements();
			film.ajouterImage(image);
		}
		for (int i = 0; i < image2.getNombresColonnes(); ++i) {
			Element e = new Element(image2, 0, image2.getNombresLignes(), 0, i);
			Image image = new Image(image2.getNombresLignes(), image2.getNombresColonnes());
			image.ajouterElement(e, new Point(0,0), HAUT_GAUCHE);
			image.appliquerElements();
			film.ajouterImage(image);
		}
		for (int i = 0; i < image2.getNombresColonnes(); ++i) {
			Element e = new Element(image2, 0, image2.getNombresLignes(), image2.getNombresColonnes() - i,
					image2.getNombresColonnes());
			Image image = new Image(image2.getNombresLignes(), image2.getNombresColonnes());
			image.ajouterElement(e, new Point(0,0), HAUT_GAUCHE);
			image.appliquerElements();
			film.ajouterImage(image);
		}
		 
	/*	Film film = new Film();
		Image image;
		Element e;
		int maxLignes = 50;
		int maxColonnes = 50;
		int ligneInfMaison = 40;
		int ligneSuppMaison = 10;
		int colonneGaucheMaison = 10;
		int colonneDroiteMaison = 40;
		int hauteurMaison = ligneInfMaison - ligneSuppMaison;
		int largeurMaison = colonneDroiteMaison - colonneGaucheMaison;

		for (int i = 0; i < largeurMaison; ++i) {
			image = new Image(maxLignes, maxColonnes);
			e = new Element(1, 1 + i, 'X');
			image.ajouterElement(e, ligneInfMaison - 1, colonneGaucheMaison);
			image.appliquerElements();
			film.ajouterImage(image);
		}

		for (int i = 0; i < hauteurMaison; ++i) {
			image = new Image(maxLignes, maxColonnes);
			e = new Element(1, largeurMaison, 'X');
			image.ajouterElement(e, ligneInfMaison, colonneGaucheMaison);
			e = new Element(1 + i, 1, 'X');
			image.ajouterElement(e, ligneInfMaison - i - 1, colonneDroiteMaison - 1);
			image.appliquerElements();
			film.ajouterImage(image);
		}

	 */
		
		
		ExportFilm exp = new ExportFilm(film);
		exp.exporter();
	}

}
