package beans;

import java.io.IOException;
import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Imagem[] imgs = KNN.LerArquivo();

// 		AINDA COM ERRO NA LEITURA DAS IMAGENS	
//		for(int i =0; i < 256; i++)
//			System.out.print(imgs[0].getHistograma()[i]);
//		
//		KNN knn = new KNN (imgs);
//		knn.dividirImagens(imgs);
//		
//		for(int i = 0; i < 256; i++) {
//			if(knn.getImagensTreinamento()[i].equals(knn.getImagensTest()[i]))
//				System.out.println("IGUAL");
//			else {
//				System.out.println("diferente");
//			}
//		}
//		//double dist = knn.distanciaEuclidianaPonderada(knn.getImagensTreinamento()[651], knn.getImagensTest()[0]);
//		
//		//System.out.println(dist);
//		System.out.println("done");
		
	}
}
	
