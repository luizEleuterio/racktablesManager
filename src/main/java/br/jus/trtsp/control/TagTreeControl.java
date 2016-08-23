package br.jus.trtsp.control;

import br.jus.trtsp.dao.TagTreeDAO;
import br.jus.trtsp.model.Location;
import br.jus.trtsp.model.TagTree;

public class TagTreeControl {

	
	public TagTree consultaTagTreePorDescricao(String descricao) {
		TagTree tt;
		TagTreeDAO ttdao = new TagTreeDAO();
		tt = ttdao.consultaTagTreePorDescricao(descricao.trim());
		ttdao.close();
		return tt;
	}
	
	
	public TagTree consultaTagTreePorDescricaoSemEspaco(String string) {
		TagTree tt;
		TagTreeDAO ttdao = new TagTreeDAO();
		int index = string.indexOf(" ");
		if(index > -1){
			String localizacao = string.trim().substring(0, string.indexOf(" "));
			tt = ttdao.consultaTagTreePorDescricao(localizacao);
		}else{
			tt = ttdao.consultaTagTreePorDescricao(string.trim());
		}
		ttdao.close();
		return tt;
	}

	public TagTree consultaTagTreePorLocalizacao(Location l) {
		TagTreeDAO ttdao = new TagTreeDAO();
		TagTree tt = ttdao.consultaTagTreePorLocalizacao(l);
		ttdao.close();
		return tt;
	}

	
}
