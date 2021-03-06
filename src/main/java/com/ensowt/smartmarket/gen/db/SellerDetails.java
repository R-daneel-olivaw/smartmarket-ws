package com.ensowt.smartmarket.gen.db;

// Generated Apr 10, 2014 12:56:12 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SellerDetails generated by hbm2java
 */
@Entity
@Table(name = "seller_details", catalog = "smt_db")
public class SellerDetails implements java.io.Serializable {

	private int sellerDetailsId;
	private String sellerName;
	private String sellerAddress;
	private String sellerImagePath;
	private Set<Seller> sellers = new HashSet<Seller>(0);

	public SellerDetails() {
	}

	public SellerDetails(int sellerDetailsId, String sellerName,
			String sellerAddress) {
		this.sellerDetailsId = sellerDetailsId;
		this.sellerName = sellerName;
		this.sellerAddress = sellerAddress;
	}

	public SellerDetails(int sellerDetailsId, String sellerName,
			String sellerAddress, String sellerImagePath, Set<Seller> sellers) {
		this.sellerDetailsId = sellerDetailsId;
		this.sellerName = sellerName;
		this.sellerAddress = sellerAddress;
		this.sellerImagePath = sellerImagePath;
		this.sellers = sellers;
	}

	@Id
	@Column(name = "seller_details_id", unique = true, nullable = false)
	public int getSellerDetailsId() {
		return this.sellerDetailsId;
	}

	public void setSellerDetailsId(int sellerDetailsId) {
		this.sellerDetailsId = sellerDetailsId;
	}

	@Column(name = "seller_name", nullable = false, length = 45)
	public String getSellerName() {
		return this.sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	@Column(name = "seller_address", nullable = false, length = 45)
	public String getSellerAddress() {
		return this.sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	@Column(name = "seller_image_path", length = 75)
	public String getSellerImagePath() {
		return this.sellerImagePath;
	}

	public void setSellerImagePath(String sellerImagePath) {
		this.sellerImagePath = sellerImagePath;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sellerDetails")
	public Set<Seller> getSellers() {
		return this.sellers;
	}

	public void setSellers(Set<Seller> sellers) {
		this.sellers = sellers;
	}

}
