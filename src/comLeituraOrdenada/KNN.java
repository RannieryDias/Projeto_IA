package comLeituraOrdenada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class KNN {
	//private Imagem[] imagens;
	private Imagem[] imagensTreinamento;
	private Imagem[] imagensTest;

	public KNN() {
		
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
		
		arq.close();
		file.close();
		return imgs;
	}

	public void dividirImagens(Imagem[] imgs) {
		Imagem[] treino = new Imagem[5296];
		Imagem[] test = new Imagem[2648];
		int indTreino = 0;
		int indTest = 0;

		for (int aviaoTreino = 0; aviaoTreino < 545; aviaoTreino++) {
			treino[indTreino] = imgs[aviaoTreino];
			indTreino++;
		}
		//FOI
		for (int aviaoTest = 545; aviaoTest < 817; aviaoTest++) {
			test[indTest] = imgs[aviaoTest];
			test[indTest].setClasse(null);
			indTest++;
		}
		
		for (int carroTreino = 817; carroTreino < 1417; carroTreino++) {
			treino[indTreino] = imgs[carroTreino];
			indTreino++;
		}
		//FOI
		for (int carroTest = 1417; carroTest < 1717; carroTest++) {
			test[indTest] = imgs[carroTest];
			test[indTest].setClasse(null);
			indTest++;
		}

		for (int passaroTreino = 1717; passaroTreino < 2312; passaroTreino++) {
			treino[indTreino] = imgs[passaroTreino];
			indTreino++;
		}
		//FOI
		for (int passaroTest = 2312; passaroTest < 2610; passaroTest++) {
			test[indTest] = imgs[passaroTest];
			test[indTest].setClasse(null);
			indTest++;
		}

		for (int gatoTreino = 2610; gatoTreino < 3089; gatoTreino++) {
			treino[indTreino] = imgs[gatoTreino];
			indTreino++;
		}
		//FOI
		for (int gatoTest = 3089; gatoTest < 3329; gatoTest++) {
			test[indTest] = imgs[gatoTest];
			test[indTest].setClasse(null);
			indTest++;
		}

		for (int veadoTreino = 3329; veadoTreino < 3797; veadoTreino++) {
			treino[indTreino] = imgs[veadoTreino];
			indTreino++;
		}
		//FOI
		for (int veadoTest = 3797; veadoTest < 4031; veadoTest++) {
			test[indTest] = imgs[veadoTest];
			test[indTest].setClasse(null);
			indTest++;
		}

		for (int cachorroTreino = 4031; cachorroTreino < 4536; cachorroTreino++) {
			treino[indTreino] = imgs[cachorroTreino];
			indTreino++;
		}
		//FOI
		for (int cachorroTest = 4536; cachorroTest < 4788; cachorroTest++) {
			test[indTest] = imgs[cachorroTest];
			test[indTest].setClasse(null);
			indTest++;
		}

		for (int sapoTreino = 4788; sapoTreino < 5326; sapoTreino++) {
			treino[indTreino] = imgs[sapoTreino];
			indTreino++;
		}
		//FOI
		for (int sapoTest = 5326; sapoTest < 5595; sapoTest++) {
			test[indTest] = imgs[sapoTest];
			test[indTest].setClasse(null);
			indTest++;
		}

		for (int cavaloTreino = 5595; cavaloTreino < 6040; cavaloTreino++) {
			treino[indTreino] = imgs[cavaloTreino];
			indTreino++;
		}
		//FOI
		for (int cavaloTest = 6040; cavaloTest < 6262; cavaloTest++) {
			test[indTest] = imgs[cavaloTest];
			test[indTest].setClasse(null);
			indTest++;
		}

		for (int navioTreino = 6262; navioTreino < 6830; navioTreino++) {
			treino[indTreino] = imgs[navioTreino];
			indTreino++;
		}
		//FOI
		for (int navioTest = 6830; navioTest < 7114; navioTest++) {
			test[indTest] = imgs[navioTest];
			test[indTest].setClasse(null);
			indTest++;
		}

		for (int caminhaoTreino = 7114; caminhaoTreino < 7667; caminhaoTreino++) {
			treino[indTreino] = imgs[caminhaoTreino];
			indTreino++;
		}
		//FOI
		for (int caminhaoTest = 7667; caminhaoTest < 7944; caminhaoTest++) {
			test[indTest] = imgs[caminhaoTest];
			test[indTest].setClasse(null);
			indTest++;
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
	
	// Calcula a distancia de Manhattan
	public double distanciaManhattan(Imagem imgA, Imagem imgB) {
		double soma = 0; 
		double subtracao = 0;
		
		for(int i = 0; i < 256; i++) {
			subtracao = imgA.getHistograma()[i] - imgB.getHistograma()[i];
			soma += subtracao;
		}
		
		return soma;
	}
	
	//Calcula a distancia de Manhattan ponderada
	public double distanciaManhattanPonderada(Imagem imgA, Imagem imgB) {
		double ponderado = 0;
		double dist = 0;
		double w = 0;
		
		dist = distanciaManhattan(imgA, imgB);
		w = 1 / dist;
		
		for (int i = 0; i < 256; i++) {
			ponderado += (w*(imgA.getHistograma()[i]- imgB.getHistograma()[i]));	
		}
		return ponderado;
	}
	
	//DISTANCIA EUCLIDIANA
	public double distanciaEclidiana (Imagem imgA, Imagem imgB) {
		double soma = 0;
		double sub = 0;
		double resultado = 0;
		double ponderado = 0;
		
		//somatorio da distancia euclidiana
		for (int i = 0; i < 256; i++) {
			sub = imgA.getHistograma()[i] - imgB.getHistograma()[i];
			soma += Math.pow(sub, 2);
			sub = 0;
		}
		
		//raiz do somatorio
		resultado = Math.sqrt(soma);
		
		//ponderamento
		//ponderado = this.ponderamento(resultado, imgA, imgB);
		
		return resultado;
	}
	
	// ponderamento da distancia Euclidiana
		private double ponderamento(double resultado, Imagem imgA, Imagem imgB) {
			double w, temp = 0, resultadoPonderado = 0;

			// obtendo o valor do peso
			w = 1 / resultado;

			// somatorio da distancia euclidiana aplicando o peso
			for (int i = 0; i < 256; i++) {
				temp += (w * (Math.pow((imgA.getHistograma()[i] - imgB.getHistograma()[i]), 2)));
			}

			// raiz do ponderamento
			resultadoPonderado = Math.sqrt(temp);
			return resultadoPonderado;
		}//*/
	
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

		//faz calculo da distancia euclidiana ponderada
		for (int i = 0; i < treinamento; i++) {
			double d = this.distanciaEclidiana(imagemTreinamento[i], img);
			dist[i] = d;
			menoresdist[i] = d;
		}
		
		//faz o calculo da distancia de manhattan
//		for (int i = 0; i < treinamento; i++) {
//			double d = this.distanciaManhattanPonderada(imagemTreinamento[i], img);
//			dist[i] = d;
//			menoresdist[i] = d;
//		}

		
		
		// pega as k menores distancias e verifica qual a classe da imagem para
		// no final classificar
		Arrays.sort(menoresdist);
		
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < dist.length; j++) {
				if(Double.compare(menoresdist[i], dist[j]) == 0) {																			//if (menoresdist[i] == dist[j]) {
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
