package beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KNN {
	private Imagem[] imagens;
	private Imagem[] imagensTreinamento;
	private Imagem[] imagensTest;

	public KNN (Imagem[] imagens){
		this.imagens = imagens;
	}

	public Imagem[] getImagens() {
		return imagens;
	}

	public void setImagens(Imagem[] imagens) {
		this.imagens = imagens;
	}

	public Imagem[] getImagensTreinamento() {
		return imagensTreinamento;
	}

	public void setImagensTreinamento(Imagem[] imagens) {
		this.imagensTreinamento = imagens;
	}

	public Imagem[] getImagensTest() {
		return imagensTest;
	}

	public void setImagensTest(Imagem[] imagens) {
		this.imagensTest = imagens;
	}

	
	public static Imagem[] LerArquivo() throws NumberFormatException, IOException {
		FileReader file = new FileReader("artefatos\\histogramas e classes.txt");
		BufferedReader arq = new BufferedReader(file);

		//Leitura do arquivo de entrada para carregar as imagens no vetor de imagens do KNN
		String linha = "";
		String imagemComClasse[];
		Imagem imgs [] = new Imagem[7944];
		int hist [] = new int[256];
		int j = 0;
		while (arq.ready()) {
			linha = arq.readLine();
			imagemComClasse = linha.split(",");
			for(int i = 0; i < 256; i++) {
				hist[i] = Integer.parseInt(imagemComClasse[i]);
			}
			Imagem img = new Imagem(hist);
			img.setClasse(imagemComClasse[256]);
			imgs[j] = img;
			j++;
		}
		return imgs;
	}
	
	public void dividirImagens (Imagem[] imgs){
		
	}
}


