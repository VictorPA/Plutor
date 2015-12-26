package film;

import inout.Import;
import static java.lang.Math.*;

public class Image {

	private int lignes;
	private int colonnes;
	private char[][] tableauDeCaract�res;

	public Image(int lignes, int colonnes) {
		this.lignes = lignes;
		this.colonnes = colonnes;
		char[][] tableau = new char[lignes][colonnes];
	}

	/**
	 * 
	 * @param imp
	 */
	public Image(Import imp) {

		tableauDeCaract�res = new char[imp.getTableau().length][];
		copier(imp);
		this.lignes = imp.getNombresLignes();
		this.colonnes = imp.getNombresColonnes();

	}

	public Image(Image image) {

		tableauDeCaract�res = new char[image.tableauDeCaract�res.length][];
		copier(image);
		this.lignes = image.getNombresLignes();
		this.colonnes = image.getNombresColonnes();

	}

	private void copier(Import imp) {
		for (int i = 0; i < imp.getTableau().length; ++i) {
			tableauDeCaract�res[i] = imp.getTableau()[i].clone();
		}

	}

	private void copier(Image image) {
		for (int i = 0; i < image.tableauDeCaract�res.length; ++i) {
			tableauDeCaract�res[i] = image.tableauDeCaract�res[i].clone();
		}

	}

	public void effacerImage() {
		tableauDeCaract�res = new char[lignes][colonnes];
	}

	public int getNombresLignes() {
		return lignes;
	}

	public int getNombresColonnes() {
		return colonnes;
	}

	public char[][] getImage() {
		return tableauDeCaract�res;
	}

	public void setImage(char[][] tableau) {
		this.tableauDeCaract�res = tableau;
	}

	/**
	 * 
	 * @param element
	 * @param x
	 *            ligne du coin en haut � gauche
	 * @param y
	 *            colonne du coin en haut � gauche
	 */
	public void ajouterElement(Element element, int x, int y) {
		char[][] tableauElement = element.getTableauElement();
		try {
			for (int ligne = 0; ligne < tableauElement.length; ++ligne) {
				for (int colonne = 0; colonne < tableauElement[ligne].length; ++colonne) {
					tableauDeCaract�res[x + ligne][y + colonne] = tableauElement[ligne][colonne];
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e + " POURQUOI 22 NANIIIIIIIIIIIIII");
			return;
		}
	}

	public void ajouterElementNoScrrrtch(Element element, int x, int y) {
		char[][] tableauElement = element.getTableauElement();
		try {
			for (int ligne = 0; ligne < tableauElement.length; ++ligne) {
				for (int colonne = 0; colonne < tableauElement[ligne].length; ++colonne) {
					if (tableauDeCaract�res[x + ligne][y + colonne] == '\0'
							|| tableauDeCaract�res[x + ligne][y + colonne] == ' ')
						tableauDeCaract�res[x + ligne][y + colonne] = tableauElement[ligne][colonne];
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e + " POURQUOI 22 NANIIIIIIIIIIIIII");
			return;
		}
	}

}