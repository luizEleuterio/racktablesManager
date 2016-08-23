package br.jus.trtsp.view;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.jus.trtsp.control.DictionaryControl;
import br.jus.trtsp.control.SwitchPlanilhaControl;
import br.jus.trtsp.model.Dictionary;
import br.jus.trtsp.model.SwitchPlanilha;
import br.jus.trtsp.util.OdfUtil;

@ManagedBean
@SessionScoped
public class SwitchPlanilhaView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int linhaInicial = 1;
	private SwitchPlanilha camposSwitch;
	private List<SwitchPlanilha> switches;
	private OdfUtil odf;
	private UploadedFile file;
	private String nomeTabela;
	private List<Dictionary> modelosSwitch; 
	private List<String> nomesCamposSwitch;
	private List<String> nomesColunasPlanilha;
	private Float contador;
	
	public SwitchPlanilhaView(){
		carregaCamposClasse();
	}
	
	public void carregaCamposClasse(){
		camposSwitch = new SwitchPlanilha();
		nomesCamposSwitch = new ArrayList<String>();
		DictionaryControl dctrl = new DictionaryControl();
		modelosSwitch = dctrl.getModelosNetworkSwitch();
		Field[] fields = camposSwitch.getClass().getDeclaredFields();
    	for(Field field:fields){
    		nomesCamposSwitch.add(field.getName());
    	}
		
	}
	
	public void handleFileUpload(FileUploadEvent event) {
    	if(event.getFile() != null) {
        	file = event.getFile();
        	//Carrega a planilha e a primeira tabela.
            try {
				odf = new OdfUtil(file.getInputstream());
	            nomeTabela = odf.getNomesTabelas().get(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
            nomesColunasPlanilha = new ArrayList<String>();
            int i = 0;
            //preenche a lista correspondente com os nomes das colunas da planilha aberta, conforme a linha indicada.
            while(!"".equals(odf.getValorCelula(nomeTabela, i, linhaInicial-1))){
            	nomesColunasPlanilha.add(odf.getValorCelula(nomeTabela, i,linhaInicial-1));
            	i++;
            }
        }else{
        	//dispensável
            FacesMessage message = new FacesMessage("Erro ao carregar o arquivo.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
	
	public void visualizar(ActionEvent actionEvent){
		int colunaSerie = nomesColunasPlanilha.indexOf(camposSwitch.getSerie());
		int colunaTombo = nomesColunasPlanilha.indexOf(camposSwitch.getTombo());
		int colunaLocal = nomesColunasPlanilha.indexOf(camposSwitch.getLocalizacao());
		int colunaObs = nomesColunasPlanilha.indexOf(camposSwitch.getObservacoes());
		
		
		int i = linhaInicial;
		SwitchPlanilha sp;
		switches = new ArrayList<SwitchPlanilha>();
		
		for(Dictionary modelo: modelosSwitch){
			if(camposSwitch.getModeloId().equals(modelo.getDictKey())){
				camposSwitch.setModelo(modelo.getDictValue());
			}
		}
		
		int contador = 1;
		while(!"".equals(odf.getValorCelula(nomeTabela, colunaSerie,i))){
			
			sp = new SwitchPlanilha();
			
			//Contador
			sp.setOrdem(contador);
			
			//Modelo / ModeloId
			sp.setModeloId(camposSwitch.getModeloId());
			sp.setModelo(camposSwitch.getModelo());
						
			//campos estáticos, escritos no forumlário
			sp.setContratoTrt(camposSwitch.getContratoTrt());
			sp.setPg_ct_pa(camposSwitch.getPg_ct_pa());
			sp.setFornecedor(camposSwitch.getFornecedor());
			
			//campos da planilha
			sp.setSerie(odf.getValorCelula(nomeTabela, colunaSerie,i));
			sp.setTombo(odf.getValorCelula(nomeTabela, colunaTombo,i));
			sp.setLocalizacao(odf.getValorCelula(nomeTabela, colunaLocal,i));
			sp.setObservacoes(odf.getValorCelula(nomeTabela, colunaObs,i));
			
			switches.add(sp);
			contador ++;
			i++;
		}
	}

	
	public void importar(ActionEvent actionEvent){
		contador = 0f;

		SwitchPlanilhaControl control = new SwitchPlanilhaControl();
		for(SwitchPlanilha sw : switches){
			if(!control.switchExiste(sw.getSerie())){
				control.gravaSwitchPlanilha(sw);
			}
			contador += new BigDecimal(100f/(switches.size()))
				    .setScale(4, BigDecimal.ROUND_HALF_UP)
				    .floatValue();
		}
		if(contador < 100){
			contador = 100f;
		}
	
	}
	

	public OdfUtil getOdf() {
		return odf;
	}
	
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }

	public int getLinhaIncial() {
		return linhaInicial;
	}

	public void setLinhaIncial(int linhaIncial) {
		this.linhaInicial = linhaIncial;
	}

	public SwitchPlanilha getCamposSwitch() {
		return camposSwitch;
	}

	public void setCamposSwitch(SwitchPlanilha camposSwitch) {
		this.camposSwitch = camposSwitch;
	}

	public List<SwitchPlanilha> getSwitches() {
		return switches;
	}

	public void setSwitches(List<SwitchPlanilha> switches) {
		this.switches = switches;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public List<String> getNomesCamposSwitch() {
		return nomesCamposSwitch;
	}

	public void setNomesCamposSwitch(List<String> nomesCamposSwitch) {
		this.nomesCamposSwitch = nomesCamposSwitch;
	}

	public List<String> getNomesColunasPlanilha() {
		return nomesColunasPlanilha;
	}

	public void setNomesColunasPlanilha(List<String> nomesColunasPlanilha) {
		this.nomesColunasPlanilha = nomesColunasPlanilha;
	}

	public int getLinhaInicial() {
		return linhaInicial;
	}

	public void setLinhaInicial(int linhaInicial) {
		this.linhaInicial = linhaInicial;
	}

	public List<Dictionary> getModelosSwitch() {
		return modelosSwitch;
	}

	public void setModelosSwitch(List<Dictionary> modelosSwitch) {
		this.modelosSwitch = modelosSwitch;
	}

	public Float getContador() {
		return contador;
	}

	public void setContador(Float contador) {
		this.contador = contador;
	}
	
	
}
