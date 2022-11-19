package com.xworkz.goldjewellery.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;

public interface GoldJewelleryService {
	
	boolean saveAndValidate(GoldJewelleryEntity entity);
	
	void validateAndSave(List<GoldJewelleryEntity> list);
	
	Optional<GoldJewelleryEntity> findByShopNameAndId(int id,String shopName);
	
	Optional<String> findShopNameById(int id);
	
	Optional<Double> findMakingChargesByShopName(String shopName);
	
	Optional<Object[]> findWastageChargesAndMakingChargesByShopName(String shopName);
	
	Optional<Double> findTotalPriceByGramAndShopName(double gram,String shopName);
	
	Collection<GoldJewelleryEntity> findAll();
	
	Collection<String> getAllShopName();

	Collection<Object[]> getAllShopNameAndType();
	
	Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges);
	
	Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesLesserThan(double charges);
	
	Optional<Collection<GoldJewelleryEntity>> findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(double charges,double makingCharges);
	
}