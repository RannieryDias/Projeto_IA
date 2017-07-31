package beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class KNN {
	private Imagem[] imagens;
	private Imagem[] imagensTreinamento;
	private Imagem[] imagensTest;

	public KNN(Imagem[] imagens) {
		this.imagens = imagens;
	}

	public static Imagem[] LerArquivo() throws NumberFormatException, IOException {
		FileReader file = new FileReader("artefatos\\histogramas e classes.txt");
		BufferedReader arq = new BufferedReader(file);

		// Leitura do arquivo de entrada para carregar as imagens no vetor de
		// imagens do KNN
		String linha = "";
		String imagemComClasse[];
		Imagem imgs[] = new Imagem[7944];
		int hist[] = new int[256];
		int j = 0;
		Imagem img = null;
		int aux1 = 0;

		while ((linha = arq.readLine()) != null) {
			imagemComClasse = linha.split(",");
			hist = new int[256];
			for (int i = 0; i < 256; i++) {
				aux1 = Integer.parseInt(imagemComClasse[i]);
				hist[i] = aux1;
			}

			img = new Imagem(hist);
			img.setClasse(imagemComClasse[256]);
			imgs[j] = img;
			j++;
			img = null;
		}
		img = null;

//		for (int i = 0; i < 7944; i++) {
//			img = imgs[i];
//			for (int w = 0; w < 256; w++) {
//				System.out.print(img.getHistograma()[w]);
//			}
//			System.out.println();
//		}
		
		arq.close();
		file.close();
		return imgs;
	}

	public void dividirImagens(Imagem[] imgs) {
		Imagem[] treino = new Imagem[5296];
		Imagem[] test = new Imagem[2648];
		int indTreino = 0;
		int IndTest = 0;

		for (int aviaoTreino = 0; aviaoTreino < 545; aviaoTreino++) {
			treino[indTreino] = imgs[aviaoTreino];
			indTreino++;
		}

		for (int aviaoTest = 545; aviaoTest < 817; aviaoTest++) {
			imgs[aviaoTest].setClasse(null);
			test[IndTest] = imgs[aviaoTest];
			IndTest++;
		}

		for (int carroTreino = 817; carroTreino < 1417; carroTreino++) {
			treino[indTreino] = imgs[carroTreino];
			indTreino++;
		}

		for (int carroTest = 1417; carroTest < 1717; carroTest++) {
			imgs[carroTest].setClasse(null);
			test[IndTest] = imgs[carroTest];
			IndTest++;
		}

		for (int passaroTreino = 1717; passaroTreino < 2312; passaroTreino++) {
			treino[indTreino] = imgs[passaroTreino];
			indTreino++;
		}

		for (int passaroTest = 2312; passaroTest < 2610; passaroTest++) {
			imgs[passaroTest].setClasse(null);
			test[IndTest] = imgs[passaroTest];
			IndTest++;
		}

		for (int gatoTreino = 2610; gatoTreino < 3089; gatoTreino++) {
			treino[indTreino] = imgs[gatoTreino];
			indTreino++;
		}

		for (int gatoTest = 3089; gatoTest < 3329; gatoTest++) {
			imgs[gatoTest].setClasse(null);
			test[IndTest] = imgs[gatoTest];
			IndTest++;
		}

		for (int veadoTreino = 3329; veadoTreino < 3797; veadoTreino++) {
			treino[indTreino] = imgs[veadoTreino];
			indTreino++;
		}

		for (int veadoTest = 3797; veadoTest < 4031; veadoTest++) {
			imgs[veadoTest].setClasse(null);
			test[IndTest] = imgs[veadoTest];
			IndTest++;
		}

		for (int cachorroTreino = 4031; cachorroTreino < 4536; cachorroTreino++) {
			treino[indTreino] = imgs[cachorroTreino];
			indTreino++;
		}

		for (int cachorroTest = 4536; cachorroTest < 4788; cachorroTest++) {
			imgs[cachorroTest].setClasse(null);
			test[IndTest] = imgs[cachorroTest];
			IndTest++;
		}

		for (int sapoTreino = 4788; sapoTreino < 5326; sapoTreino++) {
			treino[indTreino] = imgs[sapoTreino];
			indTreino++;
		}

		for (int sapoTest = 5326; sapoTest < 5595; sapoTest++) {
			imgs[sapoTest].setClasse(null);
			test[IndTest] = imgs[sapoTest];
			IndTest++;
		}

		for (int cavaloTreino = 5595; cavaloTreino < 6040; cavaloTreino++) {
			treino[indTreino] = imgs[cavaloTreino];
			indTreino++;
		}

		for (int cavaloTest = 6040; cavaloTest < 6262; cavaloTest++) {
			imgs[cavaloTest].setClasse(null);
			test[IndTest] = imgs[cavaloTest];
			IndTest++;
		}

		for (int navioTreino = 6262; navioTreino < 6830; navioTreino++) {
			treino[indTreino] = imgs[navioTreino];
			indTreino++;
		}

		for (int navioTest = 6830; navioTest < 7114; navioTest++) {
			imgs[navioTest].setClasse(null);
			test[IndTest] = imgs[navioTest];
			IndTest++;
		}

		for (int caminhaoTreino = 7114; caminhaoTreino < 7667; caminhaoTreino++) {
			treino[indTreino] = imgs[caminhaoTreino];
			indTreino++;
		}

		for (int caminhaoTest = 7667; caminhaoTest < 7944; caminhaoTest++) {
			imgs[caminhaoTest].setClasse(null);
			test[IndTest] = imgs[caminhaoTest];
			IndTest++;
		}

		this.setImagensTreinamento(treino);
		this.setImagensTest(test);

		// PERCENTUAL USADO PARA O TREINO FOI DE 2/3 E PARA O TESTE FOI DE 1/3,
		// DAS IMAGENS
		// 545(treino) 272(test)- aviao (817)
		// 600(treino) 300(test)- carro (900)
		// 595(treino) 298(test)- passaro (893)
		// 479(treino) 240(test)- gato (719)
		// 468(treino) 234(test)- veado (702)
		// 505(treino) 252(test)- cachorro (757)
		// 538(treino) 269(test)- sapo (807)
		// 445(treino) 222(test)- cavalo (667)
		// 568(treino) 284(test)- navio (852)
		// 553(treino) 277(test)- caminhao (830)
	}

	// Calcula a distancia Euclidiana Ponderada entre duas imagens
	public double distanciaEuclidianaPonderada(Imagem imgA, Imagem imgB) {
		double soma = 0;
		double sub = 0;
		double resultado = 0;
		double ponderado = 0;

		// somatório da distancia euclidiana
		for (int i = 0; i < 256; i++) {
			sub = imgA.getHistograma()[i] - imgB.getHistograma()[i];
			soma += Math.pow(sub, 2);
			sub = 0;
		}

		// raiz do somatório
		resultado = Math.sqrt(soma);
		
		// ponderamento
		ponderado = this.ponderamento(resultado, imgA, imgB);
		
		return ponderado;
	}

	// ponderamento da distancia Euclidiana
	private double ponderamento(double resultado, Imagem imgA, Imagem imgB) {
		double w, temp = 0, resultadoPonderado = 0;

		// obtendo o valor do peso
		w = 1 / resultado;

		// somatório da distancia euclidiana aplicando o peso
		for (int i = 0; i < 256; i++) {
			temp += (w * (Math.pow((imgA.getHistograma()[i] - imgB.getHistograma()[i]), 2)));
		}

		// raiz do ponderamento
		resultadoPonderado = Math.sqrt(temp);
		return resultadoPonderado;
	}

	// Metodo para classificação das imagens - OBS USAR UM NUMERO IMPAR PARA O K
	public String classificacao(int k, Imagem[] imagemTreinamento, Imagem img) {

		String retorno = "NAO CLASSIFICADO";
		int maior;
		int treinamento = imagemTreinamento.length;
		double[] dist = new double[treinamento];
		double[] menoresdist = new double[treinamento];
		

		// contador para as possiveis classes
		int aviao = 0;
		int carro = 0;
		int passaro = 0;
		int gato = 0;
		int veado = 0;
		int cachorro = 0;
		int sapo = 0;
		int cavalo = 0;
		int navio = 0;
		int caminhao = 0;

		// verifica se o k é par, caso seja, passa a ser impar
		if (k % 2 == 0)
			k++;

		// calcula a distancia
		for (int i = 0; i < treinamento; i++) {
			double d = this.distanciaEuclidianaPonderada(imagemTreinamento[i], img);
			dist[i] = d;
			menoresdist[i] = d;
		}

		// pega as k menores distancias e verifica qual a classe da imagem para
		// no final classificar
		Arrays.sort(menoresdist);
		
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < dist.length; j++) {
				if (menoresdist[i] == dist[j]) {
					if (imagemTreinamento[j].getClasse().equals("'aviao'")) {
						aviao++;
					} else if (imagemTreinamento[j].getClasse().equals("'carro'")) {
						carro++;
					} else if (imagemTreinamento[j].getClasse().equals("'passaro'")){
						passaro++;
					} else if (imagemTreinamento[j].getClasse().equals("'gato'")) {
						gato++;
					} else if (imagemTreinamento[j].getClasse().equals("'veado'")) {
						veado++;
					} else if (imagemTreinamento[j].getClasse().equals("'cachorro'")) {
						cachorro++;
					} else if (imagemTreinamento[j].getClasse().equals("'sapo'")) {
						sapo++;
					} else if (imagemTreinamento[j].getClasse().equals("'cavalo'")) {
						cavalo++;
					} else if (imagemTreinamento[j].getClasse().equals("'navio'")) {
						navio++;
					} else if (imagemTreinamento[j].getClasse().equals("'caminhao'")) {
						caminhao++;
					}
				}
			}
		}
		
		maior = Integer.MIN_VALUE;
		if(maior < aviao){
			maior = aviao;
			retorno = "'aviao'";
		}
		
		if (maior < carro){
			maior = carro;
			retorno = "'carro'";
		}
		
		if (maior < passaro){
			maior = passaro;
			retorno = "'passaro'";
		}
		
		if (maior < gato){
			maior = gato;
			retorno = "'gato'";
		}
		
		if (maior < veado){
			maior = veado;
			retorno = "'veado'";
		}
		
		if (maior < cachorro){
			maior = cachorro;
			retorno = "'cachorro'";
		}
		
		if (maior < sapo){
			maior = sapo;
			retorno = "'sapo'";
		}
		
		if (maior < cavalo){
			maior = cavalo;
			retorno = "'cavalo'";
		}
		
		if (maior < navio){
			maior = navio;
			retorno = "'navio'";
		}
		if (maior < caminhao){
			maior = caminhao;
			retorno = "'caminhao'";
		}
		
		return retorno;
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
}
