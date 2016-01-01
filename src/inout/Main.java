package inout;

import java.nio.file.FileSystems;

import film.Element;
import film.Film;
import film.Image;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		 * Film film = new Film(); Import imp = new
		 * Import(FileSystems.getDefault().getPath("src", "inout", "rsrc",
		 * "image1.txt")); Image image1 = new Image(imp); int maxLignes =
		 * image1.getNombresLignes(); int maxColonnes =
		 * image1.getNombresColonnes(); film.ajouterImage(image1); Image image2
		 * = new Image(image1); Element e2 = new Element(image1, 21, 32, 37,
		 * 57); // 22,33,38,58 => ça // prend une case à // droite et en bas //
		 * EDIT: Corrigé image2.ajouterElement(e2, 41, 22);
		 * 
		 * image2.appliquerElementsSansEcraser(); //Element e3 = new
		 * Element(image2, 11, 40, 20, 50); Image image3 = new Image(image2);
		 * Image image4 = new Image(54, 100); image4.ajouterElement(e2, 41, 22);
		 * 
		 * image4.appliquerElements(); film.ajouterImage(image2);
		 * 
		 * film.ajouterImage(image3); film.ajouterImage(image4);
		 * 
		 * for(int i = 0; i < image2.getNombresLignes(); ++i){ Element e = new
		 * Element(image2,0,i,0,image2.getNombresColonnes()); Image image = new
		 * Image(image2.getNombresLignes(),image2.getNombresColonnes());
		 * image.ajouterElement(e, 0, 0); image.appliquerElements();
		 * film.ajouterImage(image); }
		 * 
		 * for(int i = 0; i < image2.getNombresLignes(); ++i){ Element e = new
		 * Element(image2,image2.getNombresLignes()-i,image2.getNombresLignes(),
		 * 0,image2.getNombresColonnes()); Image image = new
		 * Image(image2.getNombresLignes(),image2.getNombresColonnes());
		 * image.ajouterElement(e, 0, 0); image.appliquerElements();
		 * film.ajouterImage(image); } for(int i = 0; i <
		 * image2.getNombresColonnes(); ++i){ Element e = new
		 * Element(image2,0,image2.getNombresLignes(),0,i); Image image = new
		 * Image(image2.getNombresLignes(),image2.getNombresColonnes());
		 * image.ajouterElement(e, 0, 0); image.appliquerElements();
		 * film.ajouterImage(image); } for(int i = 0; i <
		 * image2.getNombresColonnes(); ++i){ Element e = new
		 * Element(image2,0,image2.getNombresLignes(),image2.getNombresColonnes(
		 * ) - i,image2.getNombresColonnes()); Image image = new
		 * Image(image2.getNombresLignes(),image2.getNombresColonnes());
		 * image.ajouterElement(e, 0, 0); image.appliquerElements();
		 * film.ajouterImage(image); }
		 */
		Film film = new Film();
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

		for (int i = 0; i < hauteurMaison + 1; ++i) {
			image = new Image(maxLignes, maxColonnes);
			e = new Element(1, largeurMaison, 'X');
			image.ajouterElement(e, ligneInfMaison, colonneGaucheMaison);
			e = new Element(hauteurMaison, 1, 'X');
			image.ajouterElement(e, ligneSuppMaison, colonneDroiteMaison - 1);
			e = new Element(i + 1, 'X');
			image.ajouterElement(e, ligneSuppMaison - 1, colonneDroiteMaison - 1 - i);
			image.appliquerElementsSansEcraser();
			film.ajouterImage(image);
		}

		
		
		ExportFilm exp = new ExportFilm(film);
		exp.exporter();
	}

}
