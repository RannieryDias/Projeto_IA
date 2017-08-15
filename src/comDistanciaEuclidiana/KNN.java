package comDistanciaEuclidiana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
		int[] numerosAleatorios = new int[7944];
		int indTreino = 0;
		int indTest = 0;

		
		//divisão de avião
		for (int aviaoTreino = 0; aviaoTreino < 817; aviaoTreino++) {
			Random rand = new Random();
			
			int flag = 0;
			int parada = 0;
			int tamanhoVet = 0;
			
			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 0; i < 817; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada < 1) {
				int temp = rand.nextInt(817);

				//verifica se o numero sorteado já aconteceu antes
				for(int i = 0; i < 817; i++) {
					if (numerosAleatorios[i] == temp) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 0; i < 817; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = temp;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = 1;
				}
				//seta a flag para 0 novamente
				flag = 0;
			}
			
		}
		
		//preenche o vetor de treino com os numeros sorteados
		for(int i = 0; i < 545; i++) {
			System.out.println(indTreino );
			treino[indTreino] = imgs[numerosAleatorios[i]];
			indTreino++;
		}
		for(int i = 545; i < 817; i++) {
			test[indTest] = imgs[numerosAleatorios[i]];
			test[indTest].setClasse(null);
			indTest++;
		}
		
		//CARRO
		for (int carroTreino = 817; carroTreino < 1717; carroTreino++) {
			Random rand = new Random();
			int flag = 0;
			int parada = 0;
			int tamanhoVet = 0;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 817; i < 1717; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada < 1) {
				int temp = rand.nextInt(1717 - 817 + 1) + 817;
				
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 817; i < 1717; i++) {
					if (numerosAleatorios[i] == temp) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 817; i < 1717; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = temp;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = 1;
				}
				//seta a flag para 0 novamente
				flag = 0;
				
			}
			

		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 817; i < 1417; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
			}
			for(int i = 1417; i < 1717; i++) {
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}
		}
		
		//PASSARO
		for (int passaroTreino = 1717; passaroTreino < 2610; passaroTreino++) {
			Random rand = new Random();
			int flag = 0;
			int parada = 0;
			int tamanhoVet = 1717;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 1717; i < 2610; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada < 1) {
				int temp = rand.nextInt(2610 - 1717 + 1) + 1717;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 1717; i < 2610; i++) {
					if (numerosAleatorios[i] == temp) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 1717; i < 2610; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = temp;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = 1;
				}
				//seta a flag para 0 novamente
				flag = 0;
				
			}
			

		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 1717; i < 2312; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
			}
			for(int i = 2312; i < 2610; i++) {
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}
		}

		//GATO

		for (int gatoTreino = 2610; gatoTreino < 3329; gatoTreino++) {
			Random rand = new Random();
			int flag = 0;
			int parada = 0;
			int tamanhoVet = 2610;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 2610; i < 3329; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada < 1) {
				int temp = rand.nextInt(3329 - 2610 + 1) + 2610;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 2610; i < 3329; i++) {
					if (numerosAleatorios[i] == temp) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 2610; i < 3329; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = temp;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = 1;
				}
				//seta a flag para 0 novamente
				flag = 0;
				
			}
			

		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 2610; i < 3089; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
			}
			for(int i = 3089; i < 3329; i++) {
				System.out.println("aseaese");
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}
		}

		//VEADO
		for (int veadoTreino = 3329; veadoTreino < 4031; veadoTreino++) {
			Random rand = new Random();
			int flag = 0;
			int parada = 0;
			int tamanhoVet = 3329;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 3329; i < 4031; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada < 1) {
				int temp = rand.nextInt(4031 - 3329+ 1) + 3329;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 3329; i < 4031; i++) {
					if (numerosAleatorios[i] == temp) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 3329; i < 4031; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = temp;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = 1;
				}
				//seta a flag para 0 novamente
				flag = 0;
				
			}
			

		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 3329; i < 3797; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
			}
			for(int i = 3797; i < 4031; i++) {
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}
		}
		
		//CACHORRO
		for (int cachorroTreino = 4031; cachorroTreino < 4788; cachorroTreino++) {
			Random rand = new Random();
			int flag = 0;
			int parada = 0;
			int tamanhoVet = 4031;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 4031; i < 4788; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada < 1) {
				int temp = rand.nextInt(4788 - 4031+ 1) + 4031;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 4031; i < 4788; i++) {
					if (numerosAleatorios[i] == temp) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 4031; i < 4788; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = temp;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = 1;
				}
				//seta a flag para 0 novamente
				flag = 0;
				
			}
			

		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 4031; i < 4536; i++) {
				treino[i] = imgs[numerosAleatorios[i]];
				//System.out.println("testando " + treino[i].equals(imgs[i]));
			}
			for(int i = 4536; i < 4788; i++) {
				test[i] = imgs[numerosAleatorios[i]];
				test[i].setClasse(null);
			}
		}

		//SAPO
		for (int sapoTreino = 4788; sapoTreino < 5595; sapoTreino++) {
			Random rand = new Random();
			int flag = 0;
			int parada = 0;
			int tamanhoVet = 4788;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 4788; i < 5595; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada < 1) {
				int temp = rand.nextInt(5595 - 4788 + 1) + 4788;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 4788; i < 5595; i++) {
					if (numerosAleatorios[i] == temp) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 4788; i < 5595; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = temp;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = 1;
				}
				//seta a flag para 0 novamente
				flag = 0;
				
			}
			

		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 4788; i < 5326; i++) {
				treino[i] = imgs[numerosAleatorios[i]];
				//System.out.println("testando " + treino[i].equals(imgs[i]));
			}
			for(int i = 5326; i < 5595; i++) {
				test[i] = imgs[numerosAleatorios[i]];
				test[i].setClasse(null);
			}
		}

		//CAVALO
		for (int cavaloTreino = 5595; cavaloTreino < 6262; cavaloTreino++) {
			Random rand = new Random();
			int flag = 0;
			int parada = 0;
			int tamanhoVet = 5595;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 5595; i < 6262; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada < 1) {
				int temp = rand.nextInt(6262 - 5595 + 1) + 5595;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 5595; i < 6262; i++) {
					if (numerosAleatorios[i] == temp) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 5595; i < 6262; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = temp;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = 1;
				}
				//seta a flag para 0 novamente
				flag = 0;
				
			}
			

		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 5595; i < 6040; i++) {
				treino[i] = imgs[numerosAleatorios[i]];
				//System.out.println("testando " + treino[i].equals(imgs[i]));
			}
			for(int i = 6040; i < 6262; i++) {
				test[i] = imgs[numerosAleatorios[i]];
				test[i].setClasse(null);
			}
		}
		
		//NAVIO
		for (int navioTreino = 6262; navioTreino < 7114; navioTreino++) {
			Random rand = new Random();
			int flag = 0;
			int parada = 0;
			int tamanhoVet = 6262;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 6262; i < 7114; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada < 1) {
				int temp = rand.nextInt(7114 - 6262 + 1) + 6262;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 6262; i < 7114; i++) {
					if (numerosAleatorios[i] == temp) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 6262; i < 7114; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = temp;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = 1;
				}
				//seta a flag para 0 novamente
				flag = 0;
				
			}
			

		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 6262; i < 6830; i++) {
				treino[i] = imgs[numerosAleatorios[i]];
				//System.out.println("testando " + treino[i].equals(imgs[i]));
			}
			for(int i = 6830; i < 7114; i++) {
				test[i] = imgs[numerosAleatorios[i]];
				test[i].setClasse(null);
			}
		}

		//CAMINHÃO
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
	
	
	// Calcula a distancia Euclidiana Ponderada entre duas imagens
	public double distanciaEuclidianaPonderada(Imagem imgA, Imagem imgB) {
		double soma = 0;
		double sub = 0;
		double resultado = 0;
		double ponderado = 0;

		// somat�rio da distancia euclidiana
		for (int i = 0; i < 256; i++) {
			sub = imgA.getHistograma()[i] - imgB.getHistograma()[i];
			soma += Math.pow(sub, 2);
			sub = 0;
		}

		// raiz do somat�rio
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

		// somat�rio da distancia euclidiana aplicando o peso
		for (int i = 0; i < 256; i++) {
			temp += (w * (Math.pow((imgA.getHistograma()[i] - imgB.getHistograma()[i]), 2)));
		}

		// raiz do ponderamento
		resultadoPonderado = Math.sqrt(temp);
		return resultadoPonderado;
	}//*/

	// Metodo para classifica��o das imagens - OBS USAR UM NUMERO IMPAR PARA O K
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

		// verifica se o k � par, caso seja, passa a ser impar
		if (k % 2 == 0)
			k++;

		// faz o calculo da distancia euclidiana ponderada
//		for (int i = 0; i < treinamento; i++) {
//			double d = this.distanciaEuclidianaPonderada(imagemTreinamento[i], img);
//			dist[i] = d;
//			menoresdist[i] = d;
//		}
		
		//faz o calculo da distancia de manhattan
		for (int i = 0; i < treinamento; i++) {
			double d = this.distanciaManhattanPonderada(imagemTreinamento[i], img);
			dist[i] = d;
			menoresdist[i] = d;
		}

		
		
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
