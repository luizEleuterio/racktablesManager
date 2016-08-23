package br.jus.trtsp.control;

import br.jus.trtsp.dao.TagStorageDAO;
import br.jus.trtsp.model.TagStorage;
import br.jus.trtsp.model.TagStoragePK;
import br.jus.trtsp.model.TagTree;


public class TagStorageControl {

	public TagStorage incluirNovaTagStorage(int ttid, int objid, String tipoEntidade) {
		TagStorageDAO tsdao = new TagStorageDAO();
		TagStorage ts = new TagStorage(new TagStoragePK(objid,ttid, tipoEntidade),"l166049");
		ts = (TagStorage) tsdao.incluir(ts);
		tsdao.close();
		return ts;
	}

	public void incluirNovaTagStorageSwitchModelo(String modelo, int objectId){
		TagTreeControl ttctrl = new TagTreeControl();
		TagTree tt = ttctrl.consultaTagTreePorDescricao(modelo);
		if(tt != null){
			incluirNovaTagStorage(tt.getId(), objectId, "object");
		}else{
			incluirNovaTagStorageSwitch(objectId);
		}
	}
	
	
	public void incluirNovaTagStorageSwitch(int objectId) {
		TagTreeControl ttctrl = new TagTreeControl();
		TagTree tt = ttctrl.consultaTagTreePorDescricaoSemEspaco("switch");
		if(tt != null){
			incluirNovaTagStorage(tt.getId(), objectId, "object");
		}
	}

	public void incluirNovaTagStorageLocalizacao(int objectId, String locationDescricao, String tipoEntidade) {
		TagTreeControl ttctrl = new TagTreeControl();
		TagTree tt = ttctrl.consultaTagTreePorDescricaoSemEspaco(locationDescricao);
		if(tt != null){
			incluirNovaTagStorage(tt.getId(), objectId, tipoEntidade);
		}
	}

}
