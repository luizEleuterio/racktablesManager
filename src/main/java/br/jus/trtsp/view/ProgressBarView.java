package br.jus.trtsp.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ProgressBarView implements Serializable {
     
	private static final long serialVersionUID = 1L;
	private Float progress;
	private Float count;
	
    public Float getProgress() {
        if(progress == null) {
            progress = 0f;
        }else{
            //progress = progress + (int)(Math.random() * 35);
        	progress = (float)(progress + (100.0f/count));
        	System.out.println(progress+" - "+(100.0f/count));
            if(progress > 100){
                progress = 100f;
            }    
        }
        return progress;
    }
 
    public void setProgress(Float progress) {
        this.progress = progress;
    }
     
	public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Concluído!"));
    }
     
    public void cancel() {
        progress = null;
    }

	public Float getCount() {
		return count;
	}

	public void setCount(Float count) {
		this.count = count;
	}
    
    
}