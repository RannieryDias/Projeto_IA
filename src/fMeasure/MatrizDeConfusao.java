package fMeasure;

import java.util.*;

public class MatrizDeConfusao {
	
	private int[][] matrix;
	
	public MatrizDeConfusao(int[] verdadeiro, int[] previsao) {
		if(verdadeiro.length != previsao.length){
			 throw new IllegalArgumentException(String.format("The vector sizes don't match: %d != %d.", verdadeiro.length, previsao.length));
		}
		
		Set<Integer> ySet = new HashSet<>();
		
		for(int i = 0; i < verdadeiro.length; i++){
			ySet.add(verdadeiro[i]);
		}
		
		matrix = new int[ySet.size()][ySet.size()];
		
		for(int i = 0; i < verdadeiro.length; i++){
			matrix[verdadeiro[i]][previsao[i]] += 1;
		}
		
		ySet.clear();
	}
	
    public int[][] getMatrix() {
        return matrix;
    }
    
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("ROW=verdadeiro and COL=previsto\n\n");
		
		for(int i = 0; i < matrix.length; i++){
			sb.append("class "+i+"\t: ");
			for(int j = 0; j < matrix.length; j++){
				sb.append(matrix[i][j] +"\t| ");
			}
			sb.append("\n");
 		}
		
		return sb.toString().trim();
	}
}