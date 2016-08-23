package br.jus.trtsp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the Object database table.
 * 
 */


@Entity
@Table(name="Object")
public class Object implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="asset_no", columnDefinition="char(64)")
	private String assetNo;

	@Column(columnDefinition="text")
	private String comment;

	@Column(name="has_problems", nullable=false, columnDefinition="enum(1)")
	private String hasProblems;

	@Column(columnDefinition="char(255)")
	private String label;

	@Column(columnDefinition="char(255)")
	private String name;

	@Column(name="objtype_id", unique=true, nullable=false)
	private int objtypeId;

	
	//bi-directional many-to-one association to AttributeValue
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="object_id")
	private List<AttributeValue> atributos;
	
	
	//bi-directional many-to-one association to AttributeValue
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="entity_id")
	private List<TagStorage> tags;
		
	
	/*
	
	//bi-directional many-to-one association to Atom
	@OneToMany(mappedBy="object")
	private List<Atom> atoms;

	//bi-directional many-to-one association to CachedPVM
	@OneToMany(mappedBy="object")
	private List<CachedPVM> cachedPvms;

	//bi-directional many-to-one association to CactiGraph
	@OneToMany(mappedBy="object")
	private List<CactiGraph> cactiGraphs;

	//bi-directional many-to-one association to IPv4Allocation
	@OneToMany(mappedBy="object")
	private List<IPv4Allocation> ipv4allocations;

	//bi-directional many-to-one association to IPv4LB
	@OneToMany(mappedBy="object")
	private List<IPv4LB> ipv4lbs;

	//bi-directional many-to-one association to IPv4NAT
	@OneToMany(mappedBy="object")
	private List<IPv4NAT> ipv4nats;

	//bi-directional many-to-one association to IPv6Allocation
	@OneToMany(mappedBy="object")
	private List<IPv6Allocation> ipv6allocations;

	//bi-directional many-to-one association to MountOperation
	@OneToMany(mappedBy="object")
	private List<MountOperation> mountOperations;

	//bi-directional many-to-one association to MuninGraph
	@OneToMany(mappedBy="object")
	private List<MuninGraph> muninGraphs;

	

	//bi-directional many-to-one association to ObjectHistory
	@OneToMany(mappedBy="object")
	private List<ObjectHistory> objectHistories;

	//bi-directional many-to-one association to ObjectLog
	
	*/
	@OneToMany(mappedBy="object")
	private List<ObjectLog> objectLogs;
	
	//bi-directional many-to-one association to RackSpace
	@OneToMany
	@JoinColumn(name="object_id")
	private List<RackSpace> rackSpaces;
/*
	//bi-directional many-to-one association to RackSpace
	@OneToMany(mappedBy="object2")
	private List<RackSpace> rackSpaces2;

	//bi-directional many-to-one association to RackThumbnail
	@OneToMany(mappedBy="object")
	private List<RackThumbnail> rackThumbnails;

	//bi-directional many-to-one association to VLANSwitch
	@OneToMany(mappedBy="object")
	private List<VLANSwitch> vlanswitches;

	//bi-directional many-to-one association to VSEnabledIP
	@OneToMany(mappedBy="object")
	private List<VSEnabledIP> vsenabledIps;

	//bi-directional many-to-one association to VSEnabledPort
	@OneToMany(mappedBy="object")
	private List<VSEnabledPort> vsenabledPorts;

	*/

	
	
	
	public Object() {
		this.atributos = new ArrayList<AttributeValue>();
	}

	@Override
	public String toString() {
		return "Object [id=" + id + ", assetNo=" + assetNo + ", comment=" + comment + ", hasProblems=" + hasProblems
				+ ", label=" + label + ", name=" + name + ", objtypeId=" + objtypeId + ", atributos=" + atributos
				+ ", tags=" + tags + ", objectLogs=" + objectLogs + ", rackSpaces=" + rackSpaces + "]";
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssetNo() {
		return this.assetNo;
	}

	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
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

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getObjtypeId() {
		return this.objtypeId;
	}

	public void setObjtypeId(int objtypeId) {
		this.objtypeId = objtypeId;
	}

	/*
	
	public List<Atom> getAtoms() {
		return this.atoms;
	}

	public void setAtoms(List<Atom> atoms) {
		this.atoms = atoms;
	}

	public Atom addAtom(Atom atom) {
		getAtoms().add(atom);
		atom.setObject(this);

		return atom;
	}

	public Atom removeAtom(Atom atom) {
		getAtoms().remove(atom);
		atom.setObject(null);

		return atom;
	}

	public List<CachedPVM> getCachedPvms() {
		return this.cachedPvms;
	}

	public void setCachedPvms(List<CachedPVM> cachedPvms) {
		this.cachedPvms = cachedPvms;
	}

	public CachedPVM addCachedPvm(CachedPVM cachedPvm) {
		getCachedPvms().add(cachedPvm);
		cachedPvm.setObject(this);

		return cachedPvm;
	}

	public CachedPVM removeCachedPvm(CachedPVM cachedPvm) {
		getCachedPvms().remove(cachedPvm);
		cachedPvm.setObject(null);

		return cachedPvm;
	}

	public List<CactiGraph> getCactiGraphs() {
		return this.cactiGraphs;
	}

	public void setCactiGraphs(List<CactiGraph> cactiGraphs) {
		this.cactiGraphs = cactiGraphs;
	}

	public CactiGraph addCactiGraph(CactiGraph cactiGraph) {
		getCactiGraphs().add(cactiGraph);
		cactiGraph.setObject(this);

		return cactiGraph;
	}

	public CactiGraph removeCactiGraph(CactiGraph cactiGraph) {
		getCactiGraphs().remove(cactiGraph);
		cactiGraph.setObject(null);

		return cactiGraph;
	}

	public List<IPv4Allocation> getIpv4allocations() {
		return this.ipv4allocations;
	}

	public void setIpv4allocations(List<IPv4Allocation> ipv4allocations) {
		this.ipv4allocations = ipv4allocations;
	}

	public IPv4Allocation addIpv4allocation(IPv4Allocation ipv4allocation) {
		getIpv4allocations().add(ipv4allocation);
		ipv4allocation.setObject(this);

		return ipv4allocation;
	}

	public IPv4Allocation removeIpv4allocation(IPv4Allocation ipv4allocation) {
		getIpv4allocations().remove(ipv4allocation);
		ipv4allocation.setObject(null);

		return ipv4allocation;
	}

	public List<IPv4LB> getIpv4lbs() {
		return this.ipv4lbs;
	}

	public void setIpv4lbs(List<IPv4LB> ipv4lbs) {
		this.ipv4lbs = ipv4lbs;
	}

	public IPv4LB addIpv4lb(IPv4LB ipv4lb) {
		getIpv4lbs().add(ipv4lb);
		ipv4lb.setObject(this);

		return ipv4lb;
	}

	public IPv4LB removeIpv4lb(IPv4LB ipv4lb) {
		getIpv4lbs().remove(ipv4lb);
		ipv4lb.setObject(null);

		return ipv4lb;
	}

	public List<IPv4NAT> getIpv4nats() {
		return this.ipv4nats;
	}

	public void setIpv4nats(List<IPv4NAT> ipv4nats) {
		this.ipv4nats = ipv4nats;
	}

	public IPv4NAT addIpv4nat(IPv4NAT ipv4nat) {
		getIpv4nats().add(ipv4nat);
		ipv4nat.setObject(this);

		return ipv4nat;
	}

	public IPv4NAT removeIpv4nat(IPv4NAT ipv4nat) {
		getIpv4nats().remove(ipv4nat);
		ipv4nat.setObject(null);

		return ipv4nat;
	}

	public List<IPv6Allocation> getIpv6allocations() {
		return this.ipv6allocations;
	}

	public void setIpv6allocations(List<IPv6Allocation> ipv6allocations) {
		this.ipv6allocations = ipv6allocations;
	}

	public IPv6Allocation addIpv6allocation(IPv6Allocation ipv6allocation) {
		getIpv6allocations().add(ipv6allocation);
		ipv6allocation.setObject(this);

		return ipv6allocation;
	}

	public IPv6Allocation removeIpv6allocation(IPv6Allocation ipv6allocation) {
		getIpv6allocations().remove(ipv6allocation);
		ipv6allocation.setObject(null);

		return ipv6allocation;
	}

	public List<MountOperation> getMountOperations() {
		return this.mountOperations;
	}

	public void setMountOperations(List<MountOperation> mountOperations) {
		this.mountOperations = mountOperations;
	}

	public MountOperation addMountOperation(MountOperation mountOperation) {
		getMountOperations().add(mountOperation);
		mountOperation.setObject(this);

		return mountOperation;
	}

	public MountOperation removeMountOperation(MountOperation mountOperation) {
		getMountOperations().remove(mountOperation);
		mountOperation.setObject(null);

		return mountOperation;
	}

	public List<MuninGraph> getMuninGraphs() {
		return this.muninGraphs;
	}

	public void setMuninGraphs(List<MuninGraph> muninGraphs) {
		this.muninGraphs = muninGraphs;
	}

	public MuninGraph addMuninGraph(MuninGraph muninGraph) {
		getMuninGraphs().add(muninGraph);
		muninGraph.setObject(this);

		return muninGraph;
	}

	public MuninGraph removeMuninGraph(MuninGraph muninGraph) {
		getMuninGraphs().remove(muninGraph);
		muninGraph.setObject(null);

		return muninGraph;
	}
	
	public List<ObjectHistory> getObjectHistories() {
		return this.objectHistories;
	}

	public void setObjectHistories(List<ObjectHistory> objectHistories) {
		this.objectHistories = objectHistories;
	}
	
	public void addObjectHistory(ObjectHistory objectHistory){
		this.objectHistories.add(objectHistory);
	}
	 */
	public List<ObjectLog> getObjectLogs() {
		return this.objectLogs;
	}

	public void setObjectLogs(List<ObjectLog> objectLogs) {
		this.objectLogs = objectLogs;
	}

	public ObjectLog addObjectLog(ObjectLog objectLog) {
		getObjectLogs().add(objectLog);
		objectLog.setObject(this);

		return objectLog;
	}

	public ObjectLog removeObjectLog(ObjectLog objectLog) {
		getObjectLogs().remove(objectLog);
		objectLog.setObject(null);

		return objectLog;
	}

	public List<AttributeValue> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<AttributeValue> atributos) {
		this.atributos = atributos;
	}
	
	public void addAtributo(AttributeValue atributo){
		this.atributos.add(atributo);
	}

	public List<TagStorage> getTags() {
		return tags;
	}

	public void setTags(List<TagStorage> tags) {
		this.tags = tags;
	}
	
	public List<RackSpace> getRackSpaces() {
		return this.rackSpaces;
	}

	public void setRackSpaces(List<RackSpace> rackSpaces) {
		this.rackSpaces = rackSpaces;
	}

	public void addRackSpaces(RackSpace rackspace) {
		getRackSpaces().add(rackspace);
	}

	public void removeRackSpaces(RackSpace rackSpaces) {
		getRackSpaces().remove(rackSpaces);
	}
/*
	public List<RackSpace> getRackSpaces2() {
		return this.rackSpaces2;
	}

	public void setRackSpaces2(List<RackSpace> rackSpaces2) {
		this.rackSpaces2 = rackSpaces2;
	}

	public RackSpace addRackSpaces2(RackSpace rackSpaces2) {
		getRackSpaces2().add(rackSpaces2);
		rackSpaces2.setObject2(this);

		return rackSpaces2;
	}

	public RackSpace removeRackSpaces2(RackSpace rackSpaces2) {
		getRackSpaces2().remove(rackSpaces2);
		rackSpaces2.setObject2(null);

		return rackSpaces2;
	}

	public List<RackThumbnail> getRackThumbnails() {
		return this.rackThumbnails;
	}

	public void setRackThumbnails(List<RackThumbnail> rackThumbnails) {
		this.rackThumbnails = rackThumbnails;
	}

	public RackThumbnail addRackThumbnail(RackThumbnail rackThumbnail) {
		getRackThumbnails().add(rackThumbnail);
		rackThumbnail.setObject(this);

		return rackThumbnail;
	}

	public RackThumbnail removeRackThumbnail(RackThumbnail rackThumbnail) {
		getRackThumbnails().remove(rackThumbnail);
		rackThumbnail.setObject(null);

		return rackThumbnail;
	}

	public List<VLANSwitch> getVlanswitches() {
		return this.vlanswitches;
	}

	public void setVlanswitches(List<VLANSwitch> vlanswitches) {
		this.vlanswitches = vlanswitches;
	}

	public VLANSwitch addVlanswitch(VLANSwitch vlanswitch) {
		getVlanswitches().add(vlanswitch);
		vlanswitch.setObject(this);

		return vlanswitch;
	}

	public VLANSwitch removeVlanswitch(VLANSwitch vlanswitch) {
		getVlanswitches().remove(vlanswitch);
		vlanswitch.setObject(null);

		return vlanswitch;
	}

	public List<VSEnabledIP> getVsenabledIps() {
		return this.vsenabledIps;
	}

	public void setVsenabledIps(List<VSEnabledIP> vsenabledIps) {
		this.vsenabledIps = vsenabledIps;
	}

	public VSEnabledIP addVsenabledIp(VSEnabledIP vsenabledIp) {
		getVsenabledIps().add(vsenabledIp);
		vsenabledIp.setObject(this);

		return vsenabledIp;
	}

	public VSEnabledIP removeVsenabledIp(VSEnabledIP vsenabledIp) {
		getVsenabledIps().remove(vsenabledIp);
		vsenabledIp.setObject(null);

		return vsenabledIp;
	}

	public List<VSEnabledPort> getVsenabledPorts() {
		return this.vsenabledPorts;
	}

	public void setVsenabledPorts(List<VSEnabledPort> vsenabledPorts) {
		this.vsenabledPorts = vsenabledPorts;
	}

	public VSEnabledPort addVsenabledPort(VSEnabledPort vsenabledPort) {
		getVsenabledPorts().add(vsenabledPort);
		vsenabledPort.setObject(this);

		return vsenabledPort;
	}

	public VSEnabledPort removeVsenabledPort(VSEnabledPort vsenabledPort) {
		getVsenabledPorts().remove(vsenabledPort);
		vsenabledPort.setObject(null);

		return vsenabledPort;
	}
*/
}
	