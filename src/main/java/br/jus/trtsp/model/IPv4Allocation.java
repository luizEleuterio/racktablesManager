package br.jus.trtsp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="IPv4Allocation")
public class IPv4Allocation {
	
	@EmbeddedId
	private IPv4AllocationPK id;

	@Column(name="name", columnDefinition="char(255)", nullable=false)
	private String name;
	
	@Column(name="type", columnDefinition="enum(1)", nullable=false)
	private String type;

	
	public IPv4AllocationPK getId() {
		return id;
	}

	public void setId(IPv4AllocationPK id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
