package br.jus.trtsp.control;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.jus.trtsp.model.Location;
import br.jus.trtsp.model.Object;
import br.jus.trtsp.model.Rack;
import br.jus.trtsp.model.SwitchPlanilha;

public class SwitchPlanilhaControl {

	public void gravaSwitchPlanilha(SwitchPlanilha sp){
		//instancia Controls
		LocationControl lctrl = new LocationControl();
		ObjectControl octrl = new ObjectControl();		
		TagStorageControl tsctrl = new TagStorageControl();
		AttributeValueControl avctrl = new AttributeValueControl();
		RackControl rctrl = new RackControl();
		RackSpaceControl rsctrl = new RackSpaceControl();
		Object obj = new Object();
		
		//Localização
		Location l = lctrl.pesquisarPorString("Almoxarifado");
		
		//Prepara objeto
		obj.setAssetNo(sp.getTombo());
		obj.setComment(sp.getObservacoes());
		obj.setName("SW-Almoxarifado-"+new SimpleDateFormat("dd_MM_yyyy").format(new Date())+"-"+sp.getModelo()+"-"+sp.getOrdem());
		obj.setHasProblems("no");
		obj.setObjtypeId(8);
		//Persiste objeto
		octrl.incluirSwitch(obj);

		//prepara atributo - ModeloSwitch
		avctrl.incluirModeloSwitch(obj.getId(), sp.getModeloId());
		
		
		//prepara atributo - Série
		avctrl.incluirSerie(obj.getId(), sp.getSerie());
		
		
		if(sp.getContratoTrt() != null && !"".equals(sp.getContratoTrt())){
			avctrl.incluirContratoTRT(obj.getId(), sp.getContratoTrt());
		}
		
		if(sp.getPg_ct_pa() != null && !"".equals(sp.getPg_ct_pa())){
			avctrl.incluirPgCtPa(obj.getId(), sp.getPg_ct_pa());
		}

		if(sp.getFornecedor() != null && !"".equals(sp.getFornecedor())){
			avctrl.incluirFornecedor(obj.getId(), sp.getFornecedor());
		}
	
		
		//cria a tag do modelo do Switch. Se não houver tag de modelo, atribuir a tag "Switch"
		tsctrl.incluirNovaTagStorageSwitchModelo(sp.getModelo(), obj.getId());
		
		
		//cria a tag de localidadde
		tsctrl.incluirNovaTagStorageLocalizacao(obj.getId(), l.getName(), "object");
		
		//Rack
		Rack rack = rctrl.encontrarRackPorLocationIdDescricao(l.getId(),"switches");
		if(rack != null){
			rsctrl.adicionarObjetoRackSpacesRack(obj.getId(), rack.getId(), rack.getHeight());
		}
	}

	public boolean switchExiste(String serie) {
		ObjectControl objctl = new ObjectControl();
		Object obj = objctl.encontrarPorSerie(serie);
		return obj != null;
		
	}
	
}

