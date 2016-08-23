package br.jus.trtsp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the LDAPCache database table.
 * 
 */
/*@Entity
@Table(name="LDAPCache")
public class LDAPCache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="displayed_name", columnDefinition="char(128)")
	private String displayedName;

	@Column(name="first_success", nullable=false)
	private Timestamp firstSuccess;

	@Column(name="last_retry", nullable=false)
	private Timestamp lastRetry;

	@Lob
	private String memberof;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="presented_username", nullable=false, length=64)
	private String presentedUsername;

	@Column(name="successful_hash", nullable=false, length=40)
	private String successfulHash;

	public LDAPCache() {
	}

	public String getDisplayedName() {
		return this.displayedName;
	}

	public void setDisplayedName(String displayedName) {
		this.displayedName = displayedName;
	}

	public Timestamp getFirstSuccess() {
		return this.firstSuccess;
	}

	public void setFirstSuccess(Timestamp firstSuccess) {
		this.firstSuccess = firstSuccess;
	}

	public Timestamp getLastRetry() {
		return this.lastRetry;
	}

	public void setLastRetry(Timestamp lastRetry) {
		this.lastRetry = lastRetry;
	}

	public String getMemberof() {
		return this.memberof;
	}

	public void setMemberof(String memberof) {
		this.memberof = memberof;
	}

	public String getPresentedUsername() {
		return this.presentedUsername;
	}

	public void setPresentedUsername(String presentedUsername) {
		this.presentedUsername = presentedUsername;
	}

	public String getSuccessfulHash() {
		return this.successfulHash;
	}

	public void setSuccessfulHash(String successfulHash) {
		this.successfulHash = successfulHash;
	}

}
*/