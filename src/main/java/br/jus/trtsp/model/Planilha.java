package br.jus.trtsp.model;

import java.util.ArrayList;
import java.util.List;


public class Planilha {

	
	
	private long id;
	private String nomePlanilhaOrigem;
	private String nomePlanilhaDestino;
	private List<Tabela> listaTabelas;
	
	
	public Planilha(){
		this.listaTabelas = new ArrayList<Tabela>();
	}

	public Planilha(long id, String nomePlanilhaOrigem, String nomePlanilhaDestino, List<Tabela> listaTabelas){
		this.id = id;
		this.nomePlanilhaOrigem = nomePlanilhaOrigem;
		this.nomePlanilhaDestino = nomePlanilhaDestino;
		this.listaTabelas = listaTabelas;
	}
	
	public Planilha(long id, String nomePlanilhaOrigem, String nomePlanilhaDestino){
		this.id = id;
		this.nomePlanilhaOrigem = nomePlanilhaOrigem;
		this.nomePlanilhaDestino = nomePlanilhaDestino;
		this.listaTabelas = new ArrayList<Tabela>();
	}
	
	public Tabela getTabelaByName(String nomeTabela){
		Tabela tab = null;
		for(Tabela tabela:listaTabelas){
			if(nomeTabela.equals(tabela.getNome())){
				tab = tabela;
			}
		}
		return tab;
	}
	
	
	public String getNomePlanilhaOrigem() {
		return nomePlanilhaOrigem;
	}

	public void setNomePlanilhaOrigem(String nomePlanilhaOrigem) {
		this.nomePlanilhaOrigem = nomePlanilhaOrigem;
	}

	public String getNomePlanilhaDestino() {
		return nomePlanilhaDestino;
	}

	public void setNomePlanilhaDestino(String nomePlanilhaDestino) {
		this.nomePlanilhaDestino = nomePlanilhaDestino;
	}

	public List<Tabela> getListaTabelas() {
		return listaTabelas;
	}

	public void setListaTabelas(List<Tabela> listaTabelas) {
		this.listaTabelas = listaTabelas;
	}

	public void addTabela(Tabela tabela){
		this.listaTabelas.add(tabela);
	}
	
	public void removeTabela(Tabela tabela){
		this.listaTabelas.remove(tabela);
	}
	
}
