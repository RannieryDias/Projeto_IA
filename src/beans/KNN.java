package beans;

import java.util.ArrayList;

public class KNN {
	private Imagem[] imagensTreinamento;
	
	public KNN (Imagem[] imagensTreinamento){
		this.imagensTreinamento = imagensTreinamento;
	}
	
	public Imagem[] getImagensTreinamento() {
		return imagensTreinamento;
	}

	public void setImagensTreinamento(Imagem[] imagensTreinamento) {
		this.imagensTreinamento = imagensTreinamento;
	}

	public static void main(String[] args) {
		

	}
	
}
