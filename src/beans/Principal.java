package beans;

import java.io.IOException;
import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Imagem[] imgs = KNN.LerArquivo();
		KNN knn = new KNN (imgs);
		knn.dividirImagens(imgs);
		
		for(int i = 0; i < knn.getImagensTreinamento().length; i++) {
			System.out.println(knn.getImagensTreinamento()[i].getClasse());
		}
		
		
		for (int i = 0; i < knn.getImagensTest().length; i++) {
			if(!(knn.getImagensTest()[i].getClasse() == null)){
				System.out.print("tem classe:");
				System.out.println(knn.getImagensTest()[i].getClasse());
			}
		}
		
		System.out.println("done");
		
	}
}
	
