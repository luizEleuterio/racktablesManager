package br.jus.trtsp.model;

public class LocalidadeTRT {

	private long id;
	private String descricao;
	private String faixaIp;
	private LocalidadeTRT localidadePai;
	private Long locationRacktablesId;
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFaixaIp() {
		return faixaIp;
	}
	public void setFaixaIp(String faixaIp) {
		this.faixaIp = faixaIp;
	}
	public LocalidadeTRT getLocalidadePai() {
		return localidadePai;
	}
	public void setLocalidadePai(LocalidadeTRT localidadePai) {
		this.localidadePai = localidadePai;
	}
	public Long getLocationRacktablesId() {
		return locationRacktablesId;
	}
	public void setLocationRacktablesId(Long locationRacktablesId) {
		this.locationRacktablesId = locationRacktablesId;
	}
	
	
	
}
