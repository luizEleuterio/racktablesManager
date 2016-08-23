package br.jus.trtsp.bd;

public class Teste {

	public static Float contador;
	public static void main(String[]args){
		contador = 0.0f;
		for(int i = 0; i < 149; i++){
			
			contador += (float)(100f/148);
			System.out.println(contador);
		}
	}
	
}
