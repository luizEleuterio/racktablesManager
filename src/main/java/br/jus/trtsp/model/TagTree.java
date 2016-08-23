package br.jus.trtsp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TagTree database table.
 * 
 */


@Entity
@Table(name="TagTree")
public class TagTree implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="is_assignable", unique=true, nullable=false,columnDefinition="enum(1)")
	private String isAssignable;

	@Column(columnDefinition="char(255)")
	private String tag;

	//bi-directional many-to-one association to TagTree
	@ManyToOne
	@JoinColumn(name="parent_id")
	private TagTree tagTree;

	//bi-directional many-to-one association to TagTree
	@OneToMany(mappedBy="tagTree")
	private List<TagTree> tagTrees;
	

	public TagTree() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsAssignable() {
		return this.isAssignable;
	}

	public void setIsAssignable(String isAssignable) {
		this.isAssignable = isAssignable;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public TagTree getTagTree() {
		return this.tagTree;
	}

	public void setTagTree(TagTree tagTree) {
		this.tagTree = tagTree;
	}

	public List<TagTree> getTagTrees() {
		return this.tagTrees;
	}

	public void setTagTrees(List<TagTree> tagTrees) {
		this.tagTrees = tagTrees;
	}

	public TagTree addTagTree(TagTree tagTree) {
		getTagTrees().add(tagTree);
		tagTree.setTagTree(this);

		return tagTree;
	}

	public TagTree removeTagTree(TagTree tagTree) {
		getTagTrees().remove(tagTree);
		tagTree.setTagTree(null);

		return tagTree;
	}
}
