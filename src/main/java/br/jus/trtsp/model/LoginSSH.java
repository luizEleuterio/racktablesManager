package br.jus.trtsp.model;

import com.jcraft.jsch.UserInfo;

public class LoginSSH implements UserInfo {
	
	private long id;
	
	private String host;
	
	private String usuario;
	
	private String senha;
	
	public LoginSSH(){}
	
	public LoginSSH(String host, String usuario, String senha){
		this.host = host;
		this.usuario = usuario;
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

		
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String getPassphrase() {
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public boolean promptPassphrase(String arg0) {
		return true;
	}

	@Override
	public boolean promptPassword(String arg0) {
		return true;
	}

	@Override
	public boolean promptYesNo(String arg0) {
		return true;
	}

	@Override
	public void showMessage(String arg0) {
		
	}
	
}
