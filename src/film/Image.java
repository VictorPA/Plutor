package film;

import java.util.ArrayList;

import inout.Import;

public class Image {

	private int lignes;
	private int colonnes;
	private char[][] tableauDeCaractères;
	private ArrayList<Triplet> groupeElements; // à voir si on
																	// utilise
	// private HashMap<Integer, Element> mapElements;

	public Image(int lignes, int colonnes) {
		this.lignes = lignes;
		this.colonnes = colonnes;
		tableauDeCaractères = new char[lignes][colonnes];
		initialiserTableau(' ');
		groupeElements = new ArrayList<Triplet>();
	}

	/**
	 * 
	 * @param imp
	 */
	public Image(Import imp) {

		tableauDeCaractères = new char[imp.getTableau().length][];
		initialiserTableau(' ');
		groupeElements = new ArrayList<Triplet>();
		copier(imp);
		this.lignes = imp.getNombresLignes();
		this.colonnes = imp.getNombresColonnes();

	}

	public Image(Image image) {

		tableauDeCaractères = new char[image.tableauDeCaractères.length][];
		initialiserTableau(' ');
		this.groupeElements = new ArrayList<Triplet>();
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
				tableauDeCaractères[l][c] = a;
			}
		}
	}
/*
	private static class Triplet<E, C> {
		private E element;
		private C x, y;

		public Triplet(E element, C x, C y) {
			this.element = element;
			this.x = x;
			this.y = y;
		}
		
		 // public Triplet<Element e, int c> copierTriplet(){ Element e = new
		 // Element(); }
		 

	}
*/
	private static class Triplet { // Faire varier le début avec l'enum et ce
									// au niveau du constructeur de triplets;
		private Element element;
		private Point point;
		private Coin coin;

		public Triplet(Element element, Point point, Coin coin) {
			this.element = element;
			this.point = point;
			this.coin = coin;
			affecterCoin();

		}

		private void affecterCoin() {
			int ligne,colonne,nombreLignesElement,nombreColonnesElement;
			switch (coin) {
			case HAUT_GAUCHE:
				break;
			case HAUT_DROITE:
				ligne = this.point.getLigne();
				colonne = this.point.getColonne();
				nombreColonnesElement = this.element.getTableauElement()[0].length;
				colonne = colonne - nombreColonnesElement;
				this.point = new Point(ligne,colonne);
				break;
			case BAS_GAUCHE:
				ligne = this.point.getLigne();
				nombreLignesElement = this.element.getTableauElement().length;
				ligne = ligne - nombreLignesElement;
				colonne = this.point.getColonne();
				this.point = new Point(ligne,colonne);
				break;
			case BAS_DROITE:
				ligne = this.point.getLigne();
				nombreLignesElement = this.element.getTableauElement().length;
				ligne = ligne - nombreLignesElement;
				colonne = this.point.getColonne();
				nombreColonnesElement = this.element.getTableauElement()[0].length;
				colonne = colonne - nombreColonnesElement;
				this.point = new Point(ligne,colonne);
				break;
			}

		}
	}

	/*
	 * public Triplet<Element e, int c> copierTriplet(){ Element e = new
	 * Element(); }
	 */

	private void copier(Import imp) {
		for (int i = 0; i < imp.getTableau().length; ++i) {
			tableauDeCaractères[i] = imp.getTableau()[i].clone();
		}

	}

	private void copier(Image image) {
		for (int i = 0; i < image.tableauDeCaractères.length; ++i) {
			tableauDeCaractères[i] = image.tableauDeCaractères[i].clone();
		}

	}

	public void effacerImage() {
		tableauDeCaractères = new char[lignes][colonnes];
	}

	public int getNombresLignes() {
		return lignes;
	}

	public int getNombresColonnes() {
		return colonnes;
	}

	public char[][] getImage() {
		return tableauDeCaractères;
	}

	public void setImage(char[][] tableau) {
		this.tableauDeCaractères = tableau;
	}

	/**
	 * 
	 * @param element
	 * @param x
	 *            ligne du coin en haut à gauche
	 * @param y
	 *            colonne du coin en haut à gauche
	 */
/*
	public void ajouterElement(Element element, int x, int y) {
		Triplet<Element, Integer> triplet = new Triplet<Element, Integer>(element, x, y);
		// ici on garde les références sur l'element, car si on modifie
		// l'élément il faut que celui du triplet soit modifié
		//groupeElements.add(triplet);
	}
*/
	public void ajouterElement(Element element, Point point, Coin coin) {

		Triplet triplet = new Triplet(element, point, coin);
		groupeElements.add(triplet);
		
	}

	public void appliquerElements() {
		for (Triplet triplet : groupeElements) {
			char[][] tableauElement = triplet.element.getTableauElement();
			try {
				for (int ligne = 0; ligne < tableauElement.length; ++ligne) {
					for (int colonne = 0; colonne < tableauElement[ligne].length; ++colonne) {
						if(tableauElement[ligne][colonne] != ' '){
							tableauDeCaractères[triplet.point.getLigne() + ligne][triplet.point.getColonne() + colonne] = tableauElement[ligne][colonne];
						}
						
					}
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e + "Dépassement certaines parties d'éléments");
				return;
			}
		}
	}
	
	public void appliquerElementsSansEcraser() {
		for (Triplet triplet : groupeElements) {
			char[][] tableauElement = triplet.element.getTableauElement();
			try {
				for (int ligne = 0; ligne < tableauElement.length; ++ligne) {
					for (int colonne = 0; colonne < tableauElement[ligne].length; ++colonne) {
						if (tableauDeCaractères[triplet.point.getLigne() + ligne][triplet.point.getColonne() + colonne] == '\0'
								|| tableauDeCaractères[triplet.point.getLigne() + ligne][triplet.point.getColonne() + colonne] == ' ')
						tableauDeCaractères[triplet.point.getLigne() + ligne][triplet.point.getColonne() + colonne] = tableauElement[ligne][colonne];
					}
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e + "Dépassement certaines parties d'éléments");
				return;
			}
		}
	}

	/*public void appliquerElementsSansEcraser() {
		for (Triplet<Element, Integer> triplet : groupeElements) {
			char[][] tableauElement = triplet.element.getTableauElement();
			try {
				for (int ligne = 0; ligne < tableauElement.length; ++ligne) {
					for (int colonne = 0; colonne < tableauElement[ligne].length; ++colonne) {
						if (tableauDeCaractères[triplet.x + ligne][triplet.y + colonne] == '\0'
								|| tableauDeCaractères[triplet.x + ligne][triplet.y + colonne] == ' ')
							tableauDeCaractères[triplet.x + ligne][triplet.y
									+ colonne] = tableauElement[ligne][colonne];
					}
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e + " POURQUOI 22 NANIIIIIIIIIIIIII");
				return;
			}
		}
	}
*/
	public void insererLigneMonter(int ligne) {

	}

	public void insererLigneDescendre() {

	}

	public void insererColonneDecalerGauche() {

	}

	public void insererLigneDecalerDroite() {

	}
}