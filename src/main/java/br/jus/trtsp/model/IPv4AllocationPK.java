package br.jus.trtsp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IPv4AllocationPK implements Serializable{


	private static final long serialVersionUID = 1L;


	@Column(name="object_id", unique=true, nullable=false)
	private int object_id;
	
	@Column(name="ip", unique=true, nullable=false)
	private int ip;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ip;
		result = prime * result + object_id;
		return result;
	}

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IPv4AllocationPK other = (IPv4AllocationPK) obj;
		if (ip != other.ip)
			return false;
		if (object_id != other.object_id)
			return false;
		return true;
	}

	public int getObject_id() {
		return object_id;
	}

	public void setObject_id(int object_id) {
		this.object_id = object_id;
	}

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}
	
}
