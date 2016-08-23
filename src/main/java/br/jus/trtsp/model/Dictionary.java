package br.jus.trtsp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Dictionary database table.
 * 
 */


@Entity
@Table(name="Dictionary")
@NamedQuery(name="Dictionary.findAll", query="SELECT d FROM Dictionary d")
public class Dictionary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dict_key", unique=true, nullable=false)
	private int dictKey;

	@Column(name="dict_sticky", columnDefinition="enum(1)")
	private String dictSticky;

	@Column(name="dict_value", columnDefinition="char(255)")
	private String dictValue;

	//bi-directional many-to-one association to Chapter
	@ManyToOne
	@JoinColumn(name="chapter_id", nullable=false)
	private Chapter chapter;

	public Dictionary() {
	}

	public int getDictKey() {
		return this.dictKey;
	}

	public void setDictKey(int dictKey) {
		this.dictKey = dictKey;
	}

	public String getDictSticky() {
		return this.dictSticky;
	}

	public void setDictSticky(String dictSticky) {
		this.dictSticky = dictSticky;
	}

	public String getDictValue() {
		return this.dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public Chapter getChapter() {
		return this.chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

}
