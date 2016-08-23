package br.jus.trtsp.dao;

import java.util.List;

import br.jus.trtsp.model.Dictionary;

public class DictionaryDAO extends GenericDAO{

	public DictionaryDAO() {
		super("racktables_db");
	}
	
	public List<Dictionary> getModelosNetworkSwitch(){
		String q = "select d from Dictionary d where d.chapter.id = 12 order by 2 desc";
    	List<Dictionary> lista = em.createQuery(q.toString(), Dictionary.class).getResultList();
    	//TODO seria melhor se feita a substituição do GPASS direto na query...
    	for(Dictionary d:lista){
    		String value = d.getDictValue();
    		int indice = value.indexOf("|");
    		if(indice > -1){
    			value = value.substring(0, indice);
    		}
    		value = value.replace("%GPASS%", " ");
    		value = value.replace("[[", "");
    		d.setDictValue(value);

    	}
    	return lista; 
	}

	public Dictionary encontrarPorId(int id) {
		return (Dictionary) encontrarPorId(id, Dictionary.class);
	}
	
}
