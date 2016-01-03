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
		this.nombreLignes = Math.abs(ligneInf - ligneSup);
		this.nombreColonnes = Math.abs(colonneDroite - colonneGauche);

		copierTableau(image, ligneSup, ligneInf, colonneGauche, colonneDroite);
	}
/*
	public Element(int nombreLignes, int nombreColonnes) {
		this.nombreLignes = nombreLignes;
		this.nombreColonnes = nombreColonnes;
		tableauElement = new char[nombreLignes][nombreColonnes];
	}
*/
	public Element(int nombreLignes, int nombreColonnes, char signe) {
		this.nombreLignes = nombreLignes;
		this.nombreColonnes = nombreColonnes;
		tableauElement = new char[nombreLignes][nombreColonnes];
		for (int i = 0; i < nombreLignes; ++i) {
			for (int c = 0; c < nombreColonnes; ++c) {
				tableauElement[i][c] = signe;
			}
		}
	}

	public Element(char signe, Point pointA, Point pointB) {
		if (pointA.getColonne() == pointB.getColonne() && pointA.getLigne() == pointB.getLigne())
			throw new IllegalArgumentException("Coordonnés identiques");
		this.nombreLignes = Math.abs(pointA.getLigne() - pointB.getLigne()) + 1;
		this.nombreColonnes = Math.abs(pointA.getColonne() - pointB.getColonne()) + 1;
		tableauElement = new char[nombreLignes][nombreColonnes];

		Point pointM;
		if(pointA.getLigne() > pointB.getLigne())
			pointM = pointB;
		else
			pointM = pointA;
		for (int i = 0; i < nombreLignes; ++i) {
			for (int c = 0; c < nombreColonnes; ++c) {
				tableauElement[i][c] = ' ';
			}
		}
		double penteCourbe = ((double)(pointB.getLigne() - pointA.getLigne() - 1))/((double)(pointB.getColonne() - pointA.getColonne() + 1));
		{
			int l;
			double c;
		
		for(l = 0, c = (double)this.nombreColonnes-1; l < nombreLignes - 1; ++l, c += (1.00/penteCourbe)){
			tableauElement[l][Math.abs((int)c)] = signe;
		System.out.println("OK");
		}

		}

	}

	private void copierTableau(Image image, int ligneSup, int ligneInf, int colonneGauche, int colonneDroite) {
		tableauElement = new char[this.nombreLignes][this.nombreColonnes];
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
