package com.xworkz.goldjewellery.main;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.goldjewellery.credentials.JewelleryCredential;
import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;
import com.xworkz.goldjewellery.repo.GoldJewelleryRepo;
import com.xworkz.goldjewellery.repo.GoldJewelleryRepoImpl;
import com.xworkz.goldjewellery.service.GoldJewelleryService;
import com.xworkz.goldjewellery.service.GoldJewelleryServiceImpl;
import com.xworkz.goldjewellery.util.GoldJewelleryUtil;

public class GoldJewelleryMain {

	public static void main(String[] args) {

		GoldJewelleryEntity entity = new GoldJewelleryEntity("Mahalakshmi", JewelleryCredential.BANGLE, 70000, 0.03, 15,
				10000, 5000, true);
		GoldJewelleryEntity entity1 = new GoldJewelleryEntity("Kalyan Jewellery", JewelleryCredential.ANKLET, 25000,
				0.03, 5, 15000, 5500, true);
		GoldJewelleryEntity entity2 = new GoldJewelleryEntity("Lalitha Jewellery", JewelleryCredential.BRACELET, 100000,
				0.02, 20, 14000, 8000, true);
		GoldJewelleryEntity entity3 = new GoldJewelleryEntity("Bhima Jewellery", JewelleryCredential.EARRING, 75000,
				0.04, 15, 11000, 4000, false);
		GoldJewelleryEntity entity4 = new GoldJewelleryEntity("Malabar Jewellery", JewelleryCredential.NOSEPIN, 125000,
				0.04, 25, 12000, 8500, false);
		GoldJewelleryEntity entity5 = new GoldJewelleryEntity("Joyalukkas", JewelleryCredential.CHAIN, 70000, 0.05, 21,
				13000, 6000, false);
		GoldJewelleryEntity entity6 = new GoldJewelleryEntity("GRT Jewellers", JewelleryCredential.NOSEPIERCHING, 15000,
				0.03, 3, 5000, 3000, true);
		GoldJewelleryEntity entity7 = new GoldJewelleryEntity("Prince Jewellery", JewelleryCredential.RING, 50000, 0.05,
				10, 11500, 7500, true);
		GoldJewelleryEntity entity8 = new GoldJewelleryEntity("PC Chandra Jewellers", JewelleryCredential.NECKLACE,
				150000, 0.03, 30, 14500, 7000, false);
		GoldJewelleryEntity entity9 = new GoldJewelleryEntity("Reliance Jewels", JewelleryCredential.PENDENT, 29000,
				0.02, 5, 6000, 2500, true);
		GoldJewelleryEntity entity10 = new GoldJewelleryEntity("Shubh Jewellers", JewelleryCredential.BANGLES, 150000,
				0.04, 25, 2000, 3600, true);
		try {
			List<GoldJewelleryEntity> list = Arrays.asList(entity, entity1, entity2, entity3, entity4, entity5, entity6,
					entity7, entity8, entity9, entity10);
			// System.out.println(list);

			GoldJewelleryRepo jewelleryRepo = new GoldJewelleryRepoImpl();
			jewelleryRepo.save(list);

			GoldJewelleryService jewelleryService = new GoldJewelleryServiceImpl();
			jewelleryService.validateAndSave(list);
			Optional<GoldJewelleryEntity> findByShopNameAndId = jewelleryService.findByShopNameAndId(4,
					"Bhima Jewellery");
			if (findByShopNameAndId.isPresent()) {
				GoldJewelleryEntity goldJewelleryEntity = findByShopNameAndId.get();
				System.out.println(goldJewelleryEntity);
			}
			System.out.println("==============findShopNameById===============");

			Optional<String> findShopNameById = jewelleryService.findShopNameById(10);
			if (findShopNameById.isPresent()) {
				String string = findShopNameById.get();
				System.out.println(string);
			}
			System.out.println("==============findMakingChargesByShopName===============");

			Optional<Double> findMakingChargesByShopName = jewelleryService.findMakingChargesByShopName("Joyalukkas");
			if (findMakingChargesByShopName.isPresent()) {
				Double doub = findMakingChargesByShopName.get();
				System.out.println(doub);
			}

			System.out.println("==============findWastageChargesAndMakingChargesByShopName===============");

			Optional<Object[]> findWastageChargesAndMakingChargesByShopName = jewelleryService
					.findWastageChargesAndMakingChargesByShopName("Joyalukkas");
			if (findWastageChargesAndMakingChargesByShopName.isPresent()) {
				Object[] array = findWastageChargesAndMakingChargesByShopName.get();
				for (Object object : array) {
					System.out.println(object);
				}
			}

			System.out.println("==============findTotalPriceByGramAndShopName===============");

			Optional<Double> findTotalPriceByGramAndShopName = jewelleryService.findTotalPriceByGramAndShopName(3,
					"GRT Jewellers");
			if (findTotalPriceByGramAndShopName.isPresent()) {
				Double goldEntity = findTotalPriceByGramAndShopName.get();
				System.out.println(goldEntity);
			}

			System.out.println("====================findAll========================");
			Collection<GoldJewelleryEntity> collect = jewelleryService.findAll();
			collect.forEach(all -> System.out.println(all));

			System.out.println("=====================findAllShopName==========================");
			Collection<String> str = jewelleryService.getAllShopName();
			str.forEach(shop -> System.out.println(shop));

			System.out.println("===========================findAllShopNameAndType===============================");
			Collection<Object[]> objType = jewelleryService.getAllShopNameAndType();
			for (Object[] objects : objType) {
				for (int array = 0; array < objects.length; array++) {
					System.out.println(objects[array]);
				}
			}
			System.out.println("===============findAllByMakingChargesGreaterThan====================");
			Optional<Collection<GoldJewelleryEntity>> opt = jewelleryService.findAllByMakingChargesGreaterThan(4000);
			if (opt.isPresent()) {
				Collection<GoldJewelleryEntity> coll = opt.get();
				System.out.println(coll);
			}

			System.out.println(
					"=========================findAllByMakingChargesLesserThan===============================");
			Optional<Collection<GoldJewelleryEntity>> optional = jewelleryService
					.findAllByMakingChargesLesserThan(1000);
			if (optional.isPresent()) {
				Collection<GoldJewelleryEntity> colGold = optional.get();
				System.out.println(colGold);
			}

			System.out.println("============findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan===========");
			Optional<Collection<GoldJewelleryEntity>> waste = jewelleryService
					.findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(500, 4000);
			if (waste.isPresent()) {
				Collection<GoldJewelleryEntity> jewe = waste.get();
				System.out.println(jewe);
			}
		} finally {
			GoldJewelleryUtil.getFactory().close();
		}

	}

}
