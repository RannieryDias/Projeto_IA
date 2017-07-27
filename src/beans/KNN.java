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
		Imagem [] treino = new Imagem[5296];
		Imagem [] test = new Imagem[2648];
		
		for(int aviaoTreino=0 ; aviaoTreino < 545 ; aviaoTreino++){
			treino[aviaoTreino] = imgs[aviaoTreino];
		}
		for(int aviaoTest=545 ; aviaoTest < 817 ; aviaoTest++){
			test[aviaoTest] = imgs[aviaoTest];
		}
		for(int carroTreino=817 ; carroTreino < 1417 ; carroTreino++){
			treino[carroTreino] = imgs[carroTreino];
		}
		for(int carroTest=1417 ; carroTest < 1717 ; carroTest++){
			test[carroTest] = imgs[carroTest];
		}
		for(int passaroTreino=1717 ; passaroTreino < 2312 ; passaroTreino++){
			treino[passaroTreino] = imgs[passaroTreino];
		}
		for(int passaroTest = 2312 ; passaroTest< 2610 ; passaroTest++){
			test[passaroTest] = imgs [passaroTest];
		}
		for (int gatoTreino = 2610 ; gatoTreino < 3089 ; gatoTreino++){
			treino[gatoTreino] = imgs[gatoTreino];
		}
		for(int gatoTest = 3089 ; gatoTest < 3329 ; gatoTest++){
			test[gatoTest] = imgs[gatoTest];
		}
		for (int veadoTreino = 3329 ; veadoTreino < 3797 ; veadoTreino++){
			treino[veadoTreino] = imgs[veadoTreino];
		}
		for (int veadoTest = 3797 ; veadoTest < 4031 ; veadoTest++){
			test[veadoTest] = imgs[veadoTest];
		}
		for(int cachorroTreino = 4031 ; cachorroTreino < 4536 ; cachorroTreino++){
			treino[cachorroTreino] = imgs[cachorroTreino];
		}
		for (int cachorroTest = 4536 ; cachorroTest < 4788 ; cachorroTest++){
			test[cachorroTest] = imgs[cachorroTest];
		}
		for (int sapoTreino = 4788 ; sapoTreino < 5326 ; sapoTreino++){
			treino[sapoTreino] = imgs[sapoTreino];
		}
		for (int sapoTest = 5326 ; sapoTest < 5595 ; sapoTest++){
			test[sapoTest] = imgs[sapoTest];
		}
		for (int cavaloTreino = 5595 ; cavaloTreino < 6040 ; cavaloTreino++){
			treino[cavaloTreino] = imgs[cavaloTreino];
		}
		for (int cavaloTest = 6040 ; cavaloTest < 6262 ; cavaloTest++){
			test[cavaloTest] = imgs[cavaloTest];
		}
		for (int navioTreino = 6262 ; navioTreino < 6830 ; navioTreino++){
			treino[navioTreino] = imgs[navioTreino];
		}
		for (int navioTest = 6830 ; navioTest < 7114 ; navioTest++){
			test[navioTest] = imgs[navioTest];
		}
		for (int caminhaoTreino = 7114 ; caminhaoTreino < 7667 ; caminhaoTreino++){
			treino[caminhaoTreino] = imgs[caminhaoTreino];
		}
		for (int caminhaoTest = 7667 ; caminhaoTest < 7944 ; caminhaoTest++){
			test[caminhaoTest] = imgs[caminhaoTest];
		}
	}
}

//545(treino) 272(test)- aviao (817) ok
//600(treino) 300(test)- carro (900) ok
//595(treino) 298(test)- passaro (893) ok 
//479(treino) 240(test)- gato (719) ok

//468(treino) 234(test)- veado (702) ok

//505(treino) 252(test)- cachorro (757) ok
//538(treino) 269(test)- sapo (807) ok 
//445(treino) 222(test)- cavalo (667) ok 
//568(treino) 284(test)- navio (852) ok 
//553(treino) 277(test)- caminhao (830)


