package com.xworkz.goldjewellery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name="gold_jewellery")

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
	private int id;
	private String shopName;
	private JewelleryCredential type;
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
