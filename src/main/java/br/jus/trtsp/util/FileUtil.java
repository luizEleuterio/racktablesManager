package br.jus.trtsp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;
import java.util.List;

public class FileUtil {

	private static File nomeArquivo;
	private static File nomeDestino;

	
	public void exportarListaParaArquivo(List<String> lista){
		
	}
	
	public FileUtil(String nomeArquivo){
		FileUtil.nomeArquivo = new File(nomeArquivo);
	}
	
	public FileUtil(String nomeArquivo, String nomeDestino){
		FileUtil.nomeArquivo = new File(nomeArquivo);
		FileUtil.nomeDestino = new File(nomeDestino);
	}
	
	public Double getEspacoLivre(){
		return new Double(nomeArquivo.getFreeSpace());
	}
	
	public Double getEspacoUtilizado(){
		return new Double(nomeArquivo.getTotalSpace() - nomeArquivo.getFreeSpace());
	}
	
	public Double getEspacoTotal(){
		return new Double(nomeArquivo.getTotalSpace());
	}
	
	public Integer getPercentualEspacoUtilizado(){
		BigInteger percentUtilizado = new BigInteger("0");
		if(this.existe()){
			percentUtilizado = new BigDecimal((this.getEspacoUtilizado() / this.getEspacoLivre()) * 100).setScale(0,
					RoundingMode.HALF_EVEN).toBigInteger();
		}
		return percentUtilizado.intValue();
	}
	
	@SuppressWarnings("resource")
	public static void copyFile() throws IOException {
        if (nomeDestino != null && nomeDestino.exists()){
        	nomeDestino.delete();
        }
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(nomeArquivo).getChannel();
            destinationChannel = new FileOutputStream(nomeDestino).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
       }
   }
	
	
	public Boolean existe(){
		return nomeArquivo.exists();
	}
	
	public boolean criar(){
		boolean sucesso = false;
		try {
			sucesso = nomeArquivo.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sucesso;
	}
	
	public void escreverNoArquivoDeTexto(String texto){
		PrintWriter writer;
		try {
			writer = new PrintWriter(nomeArquivo.getAbsolutePath(), "UTF-8");
			writer.println(texto);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void escreverNoArquivoBinario(byte[] dados){
			FileOutputStream out = null;
			try {
				out = new FileOutputStream(nomeArquivo.getAbsolutePath());
				out.write(dados);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
}
