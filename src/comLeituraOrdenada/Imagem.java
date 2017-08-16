package comLeituraOrdenada;

public class Imagem {
	private int[]  histograma;
	private String classe;
	
	public Imagem (int [] hist) {
		this.histograma = hist;
	}

	public int[] getHistograma() {
		return histograma;
	}

	public void setHistograma(int[] histograma) {
		this.histograma = histograma;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public boolean equals(Imagem a) {
		int cont = 0;
		for(int i = 0; i < 256; i++) {
			if(this.getHistograma()[i] == a.getHistograma()[i])
				cont++;
		}
		if(cont == 256)
			return true;
		else
			return false;
	}
	
}
