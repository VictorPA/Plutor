package film;

public class Element {

	private int nombreLignes;
	private int nombreColonnes;

	private char[][] tableauElement;

	public Element(Image image, int ligneSup, int ligneInf, int colonneGauche, int colonneDroite) throws Exception {
		if (image == null)
			throw new Exception("Image non définie");
		if (ligneSup < 0 || ligneInf < 0 || colonneDroite < 0 || colonneGauche < 0) {
			throw new Exception("Valeur négatives incorrectes");
		}
		if (ligneSup > image.getNombresLignes() || ligneInf > image.getNombresLignes()
				|| colonneDroite > image.getNombresColonnes() || colonneGauche > image.getNombresColonnes()) {
			throw new Exception("Trop grosses valeurs");
		}
		if (ligneSup > ligneInf || colonneDroite < colonneGauche) {
			throw new Exception("Méchant");
		}
		this.nombreLignes = ligneInf - ligneSup;
		this.nombreColonnes = colonneDroite - colonneGauche;
		
		
		copierTableau(image, ligneSup, ligneInf, colonneGauche, colonneDroite);
	}
	
	public Element(int nombreLignes, int nombreColonnes){
		this.nombreLignes = nombreLignes;
		this.nombreColonnes = nombreColonnes;
		tableauElement = new char[nombreLignes][nombreColonnes];
	}
	

	private void copierTableau(Image image, int ligneSup, int ligneInf, int colonneGauche, int colonneDroite) {
		tableauElement = new char[Math.abs(this.nombreLignes)][Math.abs(this.nombreColonnes)];
		for (int ligne = 0; ligne < nombreLignes; ++ligne) {
			for (int colonne = 0; colonne < nombreColonnes; ++colonne) {
				tableauElement[ligne][colonne] = image.getImage()[ligneSup + ligne][colonneGauche + colonne];
			}
		}
	}

	public void rotation(int angle) {

	}

	public char[][] getTableauElement() {
		return this.tableauElement;
	}
}
