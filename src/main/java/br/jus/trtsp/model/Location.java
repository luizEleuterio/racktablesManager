package br.jus.trtsp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the Location database table.
 * 
 */

@Entity
@Table(name="Location")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="comment", nullable=false, columnDefinition="text")
	private String comment;

	@Column(name="has_problems", nullable=false, columnDefinition="enum(1)")
	private String hasProblems;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private int id;

	@Column(columnDefinition="char(255)")
	private String name;

	@Column(name="parent_id")
	private Integer parentId;

	@Column(name="parent_name", columnDefinition="char(255)")
	private String parentName;

	public Location() {
	}
	
	@Override
	public String toString() {
		return "Location [comment=" + comment + ", hasProblems=" + hasProblems + ", id=" + id + ", name=" + name
				+ ", parentId=" + parentId + ", parentName=" + parentName + "]";
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getHasProblems() {
		return this.hasProblems;
	}

	public void setHasProblems(String hasProblems) {
		this.hasProblems = hasProblems;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
