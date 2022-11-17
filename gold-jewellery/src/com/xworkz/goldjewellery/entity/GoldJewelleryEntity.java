package com.xworkz.goldjewellery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.xworkz.goldjewellery.credentials.JewelleryCredential;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="jewellery")

@NamedQuery(name="findByShopNameAndId", 
query="select jewellery from GoldJewelleryEntity jewellery where jewellery.shopName=:sh and jewellery.id=:i")
@NamedQuery(name="findShopNameById", query="select jewellery.shopName from GoldJewelleryEntity jewellery where jewellery.id=:id")
@NamedQuery(name="findMakingChargesByShopName", 
query="select jewellery.makingCharges from GoldJewelleryEntity jewellery where jewellery.shopName=:shop")
@NamedQuery(name="findWastageChargesAndMakingChargesByShopName", 
query="select jewellery.wastageCharges, jewellery.makingCharges from GoldJewelleryEntity jewellery where jewellery.shopName=:sp")
@NamedQuery(name="findTotalPriceByGramAndShopName", 
query="select sum(goldPrice+gstPrice+makingCharges+wastageCharges) from GoldJewelleryEntity jewellery where jewellery.shopName=:sn and jewellery.gram=:gr")

public class GoldJewelleryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotBlank
	private int id;
	@NotNull
	@NotEmpty
	@Size(min=1 , max=90, message="ship name is vallid")
	private String shopName;
	@NotNull
	@NotEmpty
	@Length(min=1 , max=50, message="type is valid")
	private JewelleryCredential type;
	@Min (value=1 , message="goldPrice is valid")
	private double goldPrice;
	private double gstPrice;
	private double gram;
	private double makingCharges;
	private double wastageCharges;
	private boolean copper;
	
	
	public GoldJewelleryEntity(String shopName, JewelleryCredential type, double goldPrice, double gstPrice,
			double gram, double makingCharges, double wastageCharges, boolean copper) {
		super();
		this.shopName = shopName;
		this.type = type;
		this.goldPrice = goldPrice;
		this.gstPrice = gstPrice;
		this.gram = gram;
		this.makingCharges = makingCharges;
		this.wastageCharges = wastageCharges;
		this.copper = copper;
	}
	
	

}
