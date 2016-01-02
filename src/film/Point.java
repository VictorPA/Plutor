package film;

public final class Point {

	private int ligne;
	private int colonne;
	
	public Point(int ligne,int colonne){
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public int getLigne(){
		return this.ligne;
	}
	
	public int getColonne(){
		return this.colonne;
	}
	
	
}
