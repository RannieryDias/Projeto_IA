package beans;

import java.io.IOException;
import java.util.Random;

public class Principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Imagem[] imgs = KNN.LerArquivo();
		KNN knn = new KNN (imgs);
		
		
	}
}
	
