package film;

import inout.Import;

public class Image {
	
	
	private int lignes;
	private int colonnes;
	private char[][] tableauDeCaractères;

	public Image(int lignes, int colonnes) {
		this.lignes = lignes;
		this.colonnes = colonnes;
	}

	public Image(Import imp) {

		this.tableauDeCaractères = imp.getTableau().clone();
		this.lignes = imp.getNombresLignes();
		this.colonnes = imp.getNombresColonnes();
		
	}

	public void rotation(int x, int y) {

	}

	public char[][] faireTableau() {
		char[][] tableau = new char[lignes][colonnes];

		return tableau;
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

}