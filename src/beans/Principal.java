package beans;

import java.io.IOException;
import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Imagem[] imgs = KNN.LerArquivo();
		
		KNN knn = new KNN (imgs);
		knn.dividirImagens(imgs);
		
		System.out.println(knn.classificacao(5, knn.getImagensTreinamento(), knn.getImagensTest()[567]));
		
	}
}
	
