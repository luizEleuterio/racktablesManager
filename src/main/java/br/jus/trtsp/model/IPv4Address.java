package br.jus.trtsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IPv4Address")
public class IPv4Address {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, columnDefinition="int(10)")
	private int ip;
	
	@Column(nullable=false, columnDefinition="char(255)")
	private String name;
	
	@Column(nullable=false, columnDefinition="char(255)")
	private String comment;
	
	@Column(columnDefinition="enum(1)")
	private String reserved;
	
	
	
	public int getIp() {
		return ip;
	}
	public void setIp(int ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	
	

	
	
}
