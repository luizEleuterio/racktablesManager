package br.jus.trtsp.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import br.jus.trtsp.model.LoginSSH;

public class SSHUtil {

	private Channel channel;
	
	
	public Session abrirSessao(LoginSSH conexao) {
		
		Session session = null;
		JSch jsch = new JSch();
		
		try {
			
			session = jsch.getSession(conexao.getUsuario(),conexao.getHost(), 22);
			session.setUserInfo(conexao);
			session.setPassword(conexao.getPassword());
			
			Properties properties = new Properties();
            properties.put("StrictHostKeyChecking", "no");
            session.setConfig(properties);
            
			session.connect(30000);
		} catch (JSchException e) {
			session = null;
			e.printStackTrace();
		}
		return session;
	}

	
	public void fecharSessao(Session session) {
		session.disconnect();
	}
	
	
	
	
	
//////////////////////////TESTE///////////////////////////////////	
	
	
	public String executaComandoShell(String comando) throws IOException{
		
		String result = null;
		if(channel != null && channel.isConnected() && !channel.isClosed()){
			
			BufferedReader fromServer = new BufferedReader(new InputStreamReader(channel.getInputStream()));  
			OutputStream toServer = channel.getOutputStream();
			toServer.write((comando + "\r\n").getBytes());
			toServer.flush();

			StringBuilder builder = new StringBuilder();  
			String line = "";  

			while(true) {  
			    line = fromServer.readLine();
			    builder.append(line).append("\n");
			    
			    if (line.endsWith("# ") || line.endsWith("$ ") || (line.startsWith("<") && line.endsWith(">"))){
			        break;
			    }
			}  
			result = builder.toString();  
		}else{
			result = "<Erro - Conexão SSH fechada!>";
		}
		return result;
	}

	public void abreCanal(String host, String login, String senha) throws JSchException{
		
		Session session = null;
		JSch jsch = new JSch();
		LoginSSH ssh = new LoginSSH(host, login, senha);
		channel = null;
			session = jsch.getSession(login,host, 22);
			session.setUserInfo(ssh);
			session.setPassword(ssh.getPassword());
			
			Properties properties = new Properties();
            properties.put("StrictHostKeyChecking", "no");
            session.setConfig(properties);
            
			session.connect();
			channel = session.openChannel("shell");
			channel.connect();
		
	}
	
	
	public void fechaCanal() throws JSchException{
		channel.disconnect();
		channel.getSession().disconnect();
	}
	
	public boolean conectado(){
		return channel.isConnected();
	}
}
