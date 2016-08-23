package br.jus.trtsp.dao;

import java.util.List;

import br.jus.trtsp.model.Location;
import br.jus.trtsp.model.TagTree;

public class TagTreeDAO extends GenericDAO {

	public TagTreeDAO() {
		super("racktables_db");
	}
	
	public TagTree consultaTagTreePorDescricao(String descricao){
		TagTree tt = null;
		String q = "select tt from TagTree tt where lower(tt.tag) like '%"+descricao.toLowerCase()+"%'";
    	List<TagTree> lista = em.createQuery(q.toString(), TagTree.class).getResultList();
		if(lista.size() == 1){
			tt = lista.get(0);
		}else{
			tt = null;
		}
    	return tt; 
	}

	public TagTree consultaTagTreePorLocalizacao(Location l) {
		TagTree tt = consultaTagTreePorDescricao(l.getName());
		if(tt == null){
			tt = consultaTagTreePorDescricao(l.getParentName());
		}
    	return tt; 
	}

}
