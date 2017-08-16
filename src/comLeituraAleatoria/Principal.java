package comLeituraAleatoria;

import java.io.IOException;
import java.util.Random;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long inicio = 0;
		long fim = 0;
		float percentualDeAcerto = 0;
		long tempoDeExec = 0;
		
		Imagem[] imgs = KNN.LerArquivo(); 
		String[] classDasImgs = new String [imgs.length];    //CLASSE DAS IMAGENS, PARA SERVIR DE GABARITO
		for(int i = 0; i < classDasImgs.length; i++)
			classDasImgs[i] = imgs[i].getClasse();
		
		int k = 127; 			 //PARAMETRO DO KNN;
		KNN knn = new KNN ();
		inicio = System.currentTimeMillis();
		knn.dividirImagens(imgs);
		
		String classificacao = "NADA";
		int acertos = 0;
		int imagens = 545;

		for(int i = 0; i < knn.getImagensTest().length; i++){
			classificacao = knn.classificacao(5, knn.getImagensTreinamento(), knn.getImagensTest()[i]);
			System.out.println("CLASSIFICANDO IMAGEM " + i);
			
			if (classificacao.equals(classDasImgs[imagens]))
				acertos++;
			
			imagens++;
			if (imagens == 817)
				imagens = 1417;
			if (imagens == 1717)
				imagens = 2312;
			if (imagens == 2610)
				imagens = 3089;
			if (imagens == 3329)
				imagens = 3797;
			if (imagens == 4031)
				imagens = 4536;
			if (imagens == 4788)
				imagens = 5326;
			if (imagens == 5595)
				imagens = 6040;
			if (imagens == 6262)
				imagens = 6830;
			if (imagens == 7114)
				imagens = 7667;
			if (imagens == 7944)
				System.out.println("FIM DA CLASSIFICACAO");
		}
		fim = System.currentTimeMillis();
		System.out.println("Total de Acertos: " + acertos);
		percentualDeAcerto = (acertos * 100)/(knn.getImagensTest().length);
		System.out.println("Percentual de Acerto: " + percentualDeAcerto + "%");
		tempoDeExec = fim - inicio;
		System.out.println("Tempo de Execucao: " + tempoDeExec + "ms");
		
		
	}
}
	
