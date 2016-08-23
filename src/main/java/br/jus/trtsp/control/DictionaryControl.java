package br.jus.trtsp.control;

import java.util.List;

import br.jus.trtsp.dao.DictionaryDAO;
import br.jus.trtsp.model.Dictionary;

public class DictionaryControl {

	
	public List<Dictionary> getModelosNetworkSwitch(){
		DictionaryDAO ddao = new DictionaryDAO();
		List<Dictionary> modelosSwitch = ddao.getModelosNetworkSwitch();
		ddao.close();
		return modelosSwitch;
	}
}
