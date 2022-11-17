package com.xworkz.goldjewellery.repo;

import java.util.List;
import java.util.Optional;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;

public interface GoldJewelleryRepo {

	boolean save(GoldJewelleryEntity entity);

	void save(List<GoldJewelleryEntity> list);

	Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName);

	Optional<String> findShopNameById(int id);

	Optional<Double> findMakingChargesByShopName(String shopName);

	Optional<Object[]> findWastageChargesAndMakingChargesByShopName(String shopName);

	Optional<GoldJewelleryEntity> findTotalPriceByGramAndShopName(double gram, String shopName);

}
