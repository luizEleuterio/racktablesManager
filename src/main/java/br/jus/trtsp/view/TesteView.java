package br.jus.trtsp.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class TesteView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double contador = 0.0;
	
	public void teste(ActionEvent event){
		
		System.out.println(FacesContext.getCurrentInstance().getViewRoot());
	}

	public void addMessage(String summary){
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, "Objeto");
		FacesContext.getCurrentInstance().addMessage("Objeto:", message);
	}

	public void setContador(Double contador) {
		this.contador = contador;
	}

	public Double getContador() {
		return contador;
	}

	
	
}
