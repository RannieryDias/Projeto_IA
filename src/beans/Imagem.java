package beans;

public class Imagem {
	private int [] histograma;
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
	
	
}
