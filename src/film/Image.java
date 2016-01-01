package film;

import java.util.ArrayList;

import inout.Import;

public class Image {

	private int lignes;
	private int colonnes;
	private char[][] tableauDeCaract�res;
	private ArrayList<Triplet<Element, Integer>> groupeElements; // � voir si on
																	// utilise
	// private HashMap<Integer, Element> mapElements;

	public Image(int lignes, int colonnes) {
		this.lignes = lignes;
		this.colonnes = colonnes;
		tableauDeCaract�res = new char[lignes][colonnes];
		initialiserTableau(' ');
		groupeElements = new ArrayList<Triplet<Element, Integer>>();
	}

	/**
	 * 
	 * @param imp
	 */
	public Image(Import imp) {

		tableauDeCaract�res = new char[imp.getTableau().length][];
		initialiserTableau(' ');
		groupeElements = new ArrayList<Triplet<Element, Integer>>();
		copier(imp);
		this.lignes = imp.getNombresLignes();
		this.colonnes = imp.getNombresColonnes();

	}

	public Image(Image image) {

		tableauDeCaract�res = new char[image.tableauDeCaract�res.length][];
		initialiserTableau(' ');
		this.groupeElements = new ArrayList<Triplet<Element, Integer>>();
		/*
		 * for (Triplet<Element, Integer> triplet : image.groupeElements) {
		 * Triplet<Element, Integer> tripletA = triplet.element.
		 * this.groupeElements.add(triplet); }
		 */

		copier(image);
		this.lignes = image.getNombresLignes();
		this.colonnes = image.getNombresColonnes();

	}

	private void initialiserTableau(char a) {
		for (int l = 0; l < lignes; ++l) {
			for (int c = 0; c < colonnes; ++c) {
				tableauDeCaract�res[l][c] = a;
			}
		}
	}

	private static class Triplet<E, C> {
		private E element;
		private C x, y;

		public Triplet(E element, C x, C y) {
			this.element = element;
			this.x = x;
			this.y = y;
		}
		/*
		 * public Triplet<Element e, int c> copierTriplet(){ Element e = new
		 * Element(); }
		 */

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
		Triplet<Element, Integer> triplet = new Triplet<Element, Integer>(element, x, y);
		// ici on garde les r�f�rences sur l'element, car si on modifie
		// l'�l�ment il faut que celui du triplet soit modifi�
		groupeElements.add(triplet);
	}

	public void appliquerElements() {
		for (Triplet<Element, Integer> triplet : groupeElements) {
			char[][] tableauElement = triplet.element.getTableauElement();
			try {
				for (int ligne = 0; ligne < tableauElement.length; ++ligne) {
					for (int colonne = 0; colonne < tableauElement[ligne].length; ++colonne) {
						tableauDeCaract�res[triplet.x + ligne][triplet.y + colonne] = tableauElement[ligne][colonne];
					}
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e + " POURQUOI 22 NANIIIIIIIIIIIIII");
				return;
			}
		}
	}

	public void appliquerElementsSansEcraser() {
		for (Triplet<Element, Integer> triplet : groupeElements) {
			char[][] tableauElement = triplet.element.getTableauElement();
			try {
				for (int ligne = 0; ligne < tableauElement.length; ++ligne) {
					for (int colonne = 0; colonne < tableauElement[ligne].length; ++colonne) {
						if (tableauDeCaract�res[triplet.x + ligne][triplet.y + colonne] == '\0'
								|| tableauDeCaract�res[triplet.x + ligne][triplet.y + colonne] == ' ')
							tableauDeCaract�res[triplet.x + ligne][triplet.y
									+ colonne] = tableauElement[ligne][colonne];
					}
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e + " POURQUOI 22 NANIIIIIIIIIIIIII");
				return;
			}
		}
	}

	public void insererLigneMonter(int ligne) {

	}

	public void insererLigneDescendre() {

	}

	public void insererColonneDecalerGauche() {

	}

	public void insererLigneDecalerDroite() {

	}
}