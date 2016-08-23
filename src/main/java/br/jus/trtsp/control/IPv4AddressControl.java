package br.jus.trtsp.control;

public class IPv4AddressControl {

	public int getBytesIpv4(String ipv4){
		String octetos[] = ipv4.split("\\.");
		int valorOctetoA = Integer.valueOf(octetos[0]) * ((int) Math.pow(256, 3));
		int valorOctetoB = Integer.valueOf(octetos[1]) * ((int) Math.pow(256, 2));
		int valorOctetoC = Integer.valueOf(octetos[2]) * (256);
		int valorOctetoD = Integer.valueOf(octetos[3]);
		return valorOctetoA + valorOctetoB + valorOctetoC + valorOctetoD;
	}
	
	public String getIpv4Bytes(int bytes){
		int diferenca = bytes;
		
		int octetoA = diferenca / ((int) Math.pow(256, 3));
		diferenca = diferenca % ((int) Math.pow(256, 3));
		int octetoB = diferenca / ((int) Math.pow(256, 2));
		diferenca = diferenca % (int) Math.pow(256, 2);
		int octetoC = diferenca / (256);
		diferenca = diferenca % 256;
		int octetoD = diferenca;
		
		return octetoA+"."+octetoB+"."+octetoC+"."+octetoD;
	}
	
	
	
}
