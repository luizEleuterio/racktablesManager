package br.jus.trtsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Attribute")
public class Attribute {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, columnDefinition="int(10)")
	private Integer id;
	
	@Column(columnDefinition="enum(1)")
	private String type;
	
	@Column(columnDefinition="char(1)")
	private String name;

	
	
	
	
	@Override
	public String toString() {
		return "Attribute [id=" + id + ", type=" + type + ", name=" + name + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
