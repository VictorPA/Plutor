package film;

public class Element {

	private int ligneHaut;
	private int ligneBas;
	private int colonneGauche;
	private int colonneDroite;

	private char[][] tableauElement;

	public Element(Image image, int ligneHaut, int ligneBas, int colonneGauche, int colonneDroite) throws Exception {
		if (image == null)
			throw new Exception("Image non définie");
		if (ligneHaut < 0 || ligneBas < 0 || colonneDroite < 0 || colonneGauche < 0) {
			throw new Exception("Valeur négatives incorrectes");
		}
		if (ligneHaut > image.getNombresLignes() || ligneBas > image.getNombresLignes()
				|| colonneDroite > image.getNombresColonnes() || colonneGauche > image.getNombresColonnes()) {
			throw new Exception("Trop grosses valeurs");
		}
		if (ligneHaut > ligneBas || colonneDroite < colonneGauche) {
			throw new Exception("Méchant");
		}
		this.ligneHaut = ligneHaut - 1;
		this.ligneBas = ligneBas - 1;
		this.colonneGauche = colonneGauche - 1;
		this.colonneDroite = colonneDroite - 1;
		copierTableau(image);

	}

	private void copierTableau(Image image) {
		tableauElement = new char[Math.abs(ligneBas - ligneHaut)][Math.abs(colonneDroite - colonneGauche)];
		for (int ligne = 0; ligne < ligneBas - ligneHaut; ++ligne) {
			for (int colonne = 0; colonne < colonneDroite - colonneGauche; ++colonne) {
				tableauElement[ligne][colonne] = image.getImage()[ligneHaut + ligne][colonneGauche + colonne];
			}
		}
	}

	public void rotation(int angle) {

	}

	public char[][] getTableauElement() {
		return this.tableauElement;
	}
}
