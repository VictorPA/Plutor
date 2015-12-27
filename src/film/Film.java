package film;

import java.util.ArrayList;

public class Film {

	private ArrayList<Image> film;

	public Film() {
		film = new ArrayList<Image>();
	}

	public void ajouterImage(Image image) { // checker si la nouvelle image est
											// plus grande que l'ancienne et
											// proposer une solution
		this.film.add(image);
	}

	public void removeImage(int index) {
		this.film.remove(index);

	}

	public Image getImageAt(int index) {
		return this.film.get(index);
	}

	public void modifierImage(int index) {

	}

	public Image getFirstImage() {
		return this.film.get(0);
	}

	public Image getLastImage() {
		return this.film.get(film.size() - 1);
	}

	public ArrayList<Image> getFilm() {
		return film;
	}

}
