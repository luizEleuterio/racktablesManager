package br.jus.trtsp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the AttributeValue database table.
 * 
 */


@Entity
@Table(name="AttributeValue")
public class AttributeValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AttributeValuePK id;

	@Column(name="float_value")
	private Float floatValue;

	@Column(name="object_tid", nullable=false)
	private Integer objectTid;

	@Column(name="string_value", columnDefinition="char(255)")
	private String stringValue;

	@Column(name="uint_value")
	private Integer uintValue;

	
	public AttributeValue() {
	}


	public AttributeValuePK getId() {
		return id;
	}


	public void setId(AttributeValuePK id) {
		this.id = id;
	}


	public Float getFloatValue() {
		return floatValue;
	}


	public void setFloatValue(Float floatValue) {
		this.floatValue = floatValue;
	}


	public Integer getObjectTid() {
		return objectTid;
	}


	public void setObjectTid(Integer objectTid) {
		this.objectTid = objectTid;
	}


	public String getStringValue() {
		return stringValue;
	}


	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}


	public Integer getUintValue() {
		return uintValue;
	}


	public void setUintValue(Integer uintValue) {
		this.uintValue = uintValue;
	}


	
}
