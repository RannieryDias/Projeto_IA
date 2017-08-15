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
		String[] classes = new String [5296];
		Imagem[] test = new Imagem[2648];
		int[] numerosAleatorios = new int[7944];
		int indTreino = 0;
		int indTest = 0;
		Random rand = new Random();
		int numeroAleatorioGerado ;
		int flag = 0;
		boolean parada = false;

		//divisão de avião

			flag = 0;
			parada = false;
			int tamanhoVet = 0;
			
			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 0; i < 817; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(817);
				System.out.println("nao saio do while");
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 0; i < 817; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 0; i < 817; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == 817) {
					parada = true;
					
				}
				//seta a flag para 0 novamente
				flag = 0;
				
				
				//preenche o vetor de treino com os numeros sorteados
				if(parada == true) {
					for(int i = 0; i < 545; i++) {
						classes[i] = imgs[numerosAleatorios[i]].getClasse();
						treino[indTreino] = imgs[numerosAleatorios[i]];
						indTreino++;
					}
					for(int i = 545; i < 817; i++) {
						test[indTest] = imgs[numerosAleatorios[i]];
						test[indTest].setClasse(null);
						indTest++;
					}
				}
			}
			
			
			
		
		//CARRO

			flag = 0;
			parada = false;
			tamanhoVet = 817;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 817; i < 1717; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(1717 - 817 + 1) + 817;
				System.out.println("não saio do while");
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 817; i < 1717; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 817; i < 1717; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == 1717) {
					parada = true;
				}

			}
			

			//seta a flag para 0 novamente
			flag = 0;
			
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
		
		
		//PASSARO
			flag = 0;
			parada = false;
			tamanhoVet = 1717;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 1717; i < 2610; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(2610 - 1717 + 1) + 1717;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 1717; i < 2610; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 1717; i < 2610; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == 2610) {
					parada = true;
				}
				
			}
			
			//seta a flag para 0 novamente
			flag = 0;
			
		
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

		//GATO

		
			flag = 0;
			parada = false;
			tamanhoVet = 2610;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 2610; i < 3329; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(3329 - 2610 + 1) + 2610;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 2610; i < 3329; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 2610; i < 3329; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == 3329) {
					parada = true;
				}
				
				
			}
			
			//seta a flag para 0 novamente
			flag = 0;
		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 2610; i < 3089; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
			}
			for(int i = 3089; i < 3329; i++) {
//				System.out.println("aseaese");
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}
		

		//VEADO
		
			flag = 0;
			parada = false;
			tamanhoVet = 3329;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 3329; i < 4031; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(4031 - 3329+ 1) + 3329;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 3329; i < 4031; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 3329; i < 4031; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == 4031) {
					parada = true;
				}
				//seta a flag para 0 novamente
				flag = 0;
				
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
		
			 flag = 0;
			 parada = false;
			 tamanhoVet = 4031;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 4031; i < 4788; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(4788 - 4031+ 1) + 4031;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 4031; i < 4788; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 4031; i < 4788; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == 4788) {
					parada = true;
				}
				
				
			}
			
			//seta a flag para 0 novamente
			flag = 0;
		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 4031; i < 4536; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
				//System.out.println("testando " + treino[i].equals(imgs[i]));
			}
			for(int i = 4536; i < 4788; i++) {
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}
		

		//SAPO
			flag = 0;
			parada = false;
			tamanhoVet = 4788;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 4788; i < 5595; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(5595 - 4788 + 1) + 4788;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 4788; i < 5595; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 4788; i < 5595; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == 5595) {
					parada = true;
				}
				
			}
			
			//seta a flag para 0 novamente
			flag = 0;
			
		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 4788; i < 5326; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
			}
			for(int i = 5326; i < 5595; i++) {
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}

			
		//CAVALO

			flag = 0;
			parada = false;
			tamanhoVet = 5595;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 5595; i < 6262; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(6262 - 5595 + 1) + 5595;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 5595; i < 6262; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 5595; i < 6262; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == 6262) {
					parada = true;
				}
				
				
			}
			
			//seta a flag para 0 novamente
			flag = 0;
		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 5595; i < 6040; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
			}
			for(int i = 6040; i < 6262; i++) {
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}

		
		//NAVIO

			flag = 0;
			parada = false;
			tamanhoVet = 6262;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 6262; i < 7114; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(7114 - 6262 + 1) + 6262;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 6262; i < 7114; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 6262; i < 7114; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == 7114) {
					parada = true;
				}
				
				
			}
			
			//seta a flag para 0 novamente
			flag = 0;
		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 6262; i < 6830; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
			}
			for(int i = 6830; i < 7114; i++) {
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}
		

		//CAMINHÃO
			flag = 0;
			parada = false;
			tamanhoVet = 7114;
			

			//preenche o vetor com -1 para fazer a validação do vetor
			for(int i = 7114; i < 7944; i++) {
				numerosAleatorios[i] = -1;
			}
			
			//pega numeros aleatorios
			while (parada != true) {
				numeroAleatorioGerado = rand.nextInt(7944 - 7114 + 1) + 7114;
				//System.out.println(temp);
				//verifica se o numero sorteado já aconteceu antes
				for(int i = 7114; i < 7944; i++) {
					if (numerosAleatorios[i] == numeroAleatorioGerado) {
						flag = 1;
					}
				}
				
				//se a flag for igual a 0 significa que não houve numero repetido, então o numero é salvo no vetor
				if(flag == 0) {
					for(int i = 7114; i < 7944; i++) {
						if (numerosAleatorios[i] == -1) {
							numerosAleatorios[i] = numeroAleatorioGerado;
							tamanhoVet++;
						}
					}
				}
				
				//checa se o vetor foi preenchido
				if(tamanhoVet == numerosAleatorios.length) {
					parada = true;
				}
				
				
			}
			
			//seta a flag para 0 novamente
			flag = 0;
		
			//preenche o vetor de treino com os numeros sorteados
			for(int i = 7114; i < 7667; i++) {
				treino[indTreino] = imgs[numerosAleatorios[i]];
				indTreino++;
			}
			for(int i = 7667; i < 7944; i++) {
				test[indTest] = imgs[numerosAleatorios[i]];
				test[indTest].setClasse(null);
				indTest++;
			}
			

		this.setImagensTreinamento(treino);
		for (int i = 0; i < this.getImagensTreinamento().length; i++) {
			this.getImagensTreinamento()[i].setClasse(classes[i]);
		}
		for (int i = 0; i < this.getImagensTreinamento().length; i++) {
			System.out.println(this.getImagensTreinamento()[i].getClasse());
		}
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
