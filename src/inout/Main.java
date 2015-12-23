package inout;

import java.io.IOException;
import java.nio.file.FileSystems;

import film.Image;

public class Main {

	public static void main(String[] args) throws IOException {

		/*Affichage affichage = new Affichage();
		affichage.graduer();*/
		Import imp = new Import(FileSystems.getDefault().getPath("src", "inout", "rsrc", "image1.txt"));

		Affichage.afficher(imp.getTableau());
		Image image = new Image(imp);
		Export exp = new Export(image);
		exp.exporter();
		

	}

}
