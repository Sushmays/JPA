package com.xworkz.goldjewellery.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;
import com.xworkz.goldjewellery.repo.GoldJewelleryRepo;
import com.xworkz.goldjewellery.repo.GoldJewelleryRepoImpl;

public class GoldJewelleryServiceImpl implements GoldJewelleryService {

	private GoldJewelleryRepo repo=new GoldJewelleryRepoImpl();
	
	@Override
	public boolean saveAndValidate(GoldJewelleryEntity entity) {
		
		return this.repo.save(entity);
	}

	@Override
	public void validateAndSave(List<GoldJewelleryEntity> list) {
		
		this.repo.save(list);
	}

	@Override
	public Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName) {
		
		return this.repo.findByShopNameAndId(id, shopName);
	}

	@Override
	public Optional<String> findShopNameById(int id) {
		if(id>0) {
			return Optional.empty();
		}
		return this.repo.findShopNameById(id);
	}

	@Override
	public Optional<Double> findMakingChargesByShopName(String shopName) {
		
		return repo.findMakingChargesByShopName(shopName);
	}

	@Override
	public Optional<Object[]> findWastageChargesAndMakingChargesByShopName(String shopName) {
		
		return repo.findWastageChargesAndMakingChargesByShopName(shopName);
	}

	@Override
	public Optional<GoldJewelleryEntity> findTotalPriceByGramAndShopName(double gram, String shopName) {
		
		return repo.findTotalPriceByGramAndShopName(gram, shopName);
	}

	

	
	

	

}
