package com.xworkz.goldjewellery.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;
import com.xworkz.goldjewellery.repo.GoldJewelleryRepo;
import com.xworkz.goldjewellery.repo.GoldJewelleryRepoImpl;

public class GoldJewelleryServiceImpl implements GoldJewelleryService {

	private GoldJewelleryRepo repo = new GoldJewelleryRepoImpl();

	@Override
	public boolean saveAndValidate(GoldJewelleryEntity entity) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<GoldJewelleryEntity>> valid = validator.validate(entity);
		if (valid.size() > 0) {
			System.out.println("size is fixed");
		} else {
			System.out.println("validated");
		}
		return this.repo.save(entity);
	}

	@Override
	public void validateAndSave(List<GoldJewelleryEntity> list) {
		ValidatorFactory fact = Validation.buildDefaultValidatorFactory();
		Validator validator = fact.getValidator();
		for (GoldJewelleryEntity goldJewelleryEntity : list) {
			Set<ConstraintViolation<GoldJewelleryEntity>> constraint = validator.validate(goldJewelleryEntity);
			if (constraint.size() > 0) {
				System.out.println("Error");
			}
			System.out.println(list);
		}
		this.repo.save(list);
	}

	@Override
	public Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName) {

		return this.repo.findByShopNameAndId(id, shopName);
	}

	@Override
	public Optional<String> findShopNameById(int id) {
		if (id > 0) {
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
	public Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName) {

		return repo.findTotalPriceByGramAndShopName(gram, shopName);
	}

}
