package inout;

import film.Image;

public class Affichage {

	Image image;

	public Affichage() {
		image = new Image(50, 100);
	}

	public static void afficher(char[][] tableau) {
		for (char[] tc : tableau) {
			for (char c : tc) {
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println();
	}

	public void graduer() {
		for (int colonne = 0; colonne < image.getNombresColonnes(); ++colonne) {
			if (colonne % 5 == 0)
				System.out.print(colonne);
			else
				System.out.print(" ");
		}
		System.out.println();
		for (int ligne = 1; ligne < image.getNombresLignes(); ++ligne)
			System.out.println(ligne);
	}
}
