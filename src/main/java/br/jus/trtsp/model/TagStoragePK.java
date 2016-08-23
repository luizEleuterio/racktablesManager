package br.jus.trtsp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TagStoragePK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="entity_id")
	private int entityId;
	
	@Column(name="tag_id")
	private int tagId;

	@Column(name="entity_realm", columnDefinition="enum(1)")
	private String entityRealm;
	
	
	public TagStoragePK(){
	}

	

	public TagStoragePK(int entityId, int tagId) {
		super();
		this.entityId = entityId;
		this.tagId = tagId;
		this.entityRealm = "object";
	}

	public TagStoragePK(int entityId, int tagId, String entityRealm) {
		super();
		this.entityId = entityId;
		this.tagId = tagId;
		this.entityRealm = entityRealm;
	}

	@Override
	public String toString() {
		return "TagStoragePK [entityId=" + entityId + ", tagId=" + tagId + ", entityRealm=" + entityRealm + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + entityId;
		result = prime * result + ((entityRealm == null) ? 0 : entityRealm.hashCode());
		result = prime * result + tagId;
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
		TagStoragePK other = (TagStoragePK) obj;
		if (entityId != other.entityId)
			return false;
		if (entityRealm == null) {
			if (other.entityRealm != null)
				return false;
		} else if (!entityRealm.equals(other.entityRealm))
			return false;
		if (tagId != other.tagId)
			return false;
		return true;
	}


	public int getEntityId() {
		return entityId;
	}


	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}


	public int getTagId() {
		return tagId;
	}


	public void setTagId(int tagId) {
		this.tagId = tagId;
	}


	public String getEntityRealm() {
		return entityRealm;
	}


	public void setEntityRealm(String entityRealm) {
		this.entityRealm = entityRealm;
	};

	
	
	
	
}
