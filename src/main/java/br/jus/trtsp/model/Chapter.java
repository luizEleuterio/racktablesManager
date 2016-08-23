package br.jus.trtsp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Chapter database table.
 * 
 */


@Entity
@Table(name="Chapter")
public class Chapter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, columnDefinition="char(128)")
	private String name;

	@Column(columnDefinition="enum(1)")
	private String sticky;

/*	//bi-directional many-to-one association to AttributeMap
	@OneToMany(mappedBy="chapter")
	private List<AttributeMap> attributeMaps;*/

	//bi-directional many-to-one association to Dictionary
	@OneToMany(mappedBy="chapter")
	private List<Dictionary> dictionaries;

	public Chapter() {
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

	public String getSticky() {
		return this.sticky;
	}

	public void setSticky(String sticky) {
		this.sticky = sticky;
	}

	/*
	public List<AttributeMap> getAttributeMaps() {
		return this.attributeMaps;
	}

	public void setAttributeMaps(List<AttributeMap> attributeMaps) {
		this.attributeMaps = attributeMaps;
	}

	public AttributeMap addAttributeMap(AttributeMap attributeMap) {
		getAttributeMaps().add(attributeMap);
		attributeMap.setChapter(this);

		return attributeMap;
	}

	public AttributeMap removeAttributeMap(AttributeMap attributeMap) {
		getAttributeMaps().remove(attributeMap);
		attributeMap.setChapter(null);

		return attributeMap;
	}
	*/
	
	public List<Dictionary> getDictionaries() {
		return this.dictionaries;
	}

	public void setDictionaries(List<Dictionary> dictionaries) {
		this.dictionaries = dictionaries;
	}

	public Dictionary addDictionary(Dictionary dictionary) {
		getDictionaries().add(dictionary);
		dictionary.setChapter(this);

		return dictionary;
	}

	public Dictionary removeDictionary(Dictionary dictionary) {
		getDictionaries().remove(dictionary);
		dictionary.setChapter(null);

		return dictionary;
	}

}
