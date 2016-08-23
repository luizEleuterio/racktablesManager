package br.jus.trtsp.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.odftoolkit.odfdom.doc.OdfSpreadsheetDocument;
import org.odftoolkit.odfdom.doc.table.OdfTable;

public class OdfUtil {

	private OdfSpreadsheetDocument odfdoc;
	private OdfTable odfTabela;
	
	
	public OdfUtil(String caminhoPlanilha) throws IOException, Exception{
		File f = new File(caminhoPlanilha);
		if(f.exists()){
			odfdoc = OdfSpreadsheetDocument.loadDocument(caminhoPlanilha);
		}else{
			if(f.createNewFile()){
				odfdoc = OdfSpreadsheetDocument.newSpreadsheetDocument();
			}
		}
	}
	
	public OdfUtil(InputStream is) throws Exception{
		odfdoc = OdfSpreadsheetDocument.loadDocument(is);
	}
	
	
	
	public String getMimeType() throws Exception{
		return odfdoc.getMediaTypeString();
	}
	
	
	public void salvarPlanilha(String caminhoDestino) throws Exception{
		odfdoc.save(caminhoDestino);
	}
	
	
	public ByteArrayOutputStream salvarPlanilhaOutputStream() throws Exception {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		odfdoc.save(baos);
		return baos;
	}
	
	public List<String> getNomesTabelas(){
		List<String> nomesTabelas = new ArrayList<String>();
		for(OdfTable tabela:odfdoc.getTableList()){
			nomesTabelas.add(tabela.getTableName());
		}
		return nomesTabelas;
	}

	
	public void abrirTabela(String nomeTabela){
		odfTabela = odfdoc.getTableByName(nomeTabela);
	}
	
	public String getValorCelula(String nomeTabela,int x, int y){
		abrirTabela(nomeTabela);
		String valor = odfTabela.getCellByPosition(x, y).getStringValue();
		
		return valor;
	}
	

	public void setValorCelula(String nomeTabela,int x, int y, String valor){
		abrirTabela(nomeTabela);
		odfTabela.getCellByPosition(x, y).setStringValue(valor);
	}
	
	
	
	public HashMap<String, String> lerTabela(String nomeTabela, int inicioX, int inicioY){
		//representar na chave do Hashmap o x e o y no formato xy
		//extrair para diferentes listas x os conteúdos de y para jogar no Data Table do Primefaces.
		
		abrirTabela(nomeTabela);
		HashMap<String, String> hm = new HashMap<String, String>();
		int x = inicioX;
		int y = inicioY;
		String coordenada = x+"-"+y;
		String conteudo = odfTabela.getCellByPosition(x, y).getStringValue();
		while(!"".equals(conteudo)){
			//valores de X
			while(!"".equals(conteudo)){
				//valores de Y
				hm.put(coordenada, conteudo);
				y ++;
				coordenada = x+"-"+y;
				conteudo = odfTabela.getCellByPosition(x, y).getStringValue();
			}
			y = inicioY;
			x ++;
			coordenada = x+"-"+y;
			conteudo = odfTabela.getCellByPosition(x, y).getStringValue();
		}
		return hm;
	}
	
	
	public HashMap<String, String> lerTabela(String nomeTabela, int inicioX, int inicioY, int fimX, int fimY){

		abrirTabela(nomeTabela);
		HashMap<String, String> hm = new HashMap<String, String>();

		String conteudo;
		String coordenada;
		for(int x = inicioX; x <= fimX; x++){
			for(int y = inicioY; y <= fimY; y++){
				coordenada = x+"-"+y;
				conteudo = odfTabela.getCellByPosition(x, y).getStringValue();
				hm.put(coordenada, conteudo);
			}
		}
		return hm;
	}
	
	
	
}
