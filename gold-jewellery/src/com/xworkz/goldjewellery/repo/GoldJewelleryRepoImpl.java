package com.xworkz.goldjewellery.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.goldjewellery.entity.GoldJewelleryEntity;
import com.xworkz.goldjewellery.util.GoldJewelleryUtil;

public class GoldJewelleryRepoImpl implements GoldJewelleryRepo {

	EntityManagerFactory factory = GoldJewelleryUtil.getFactory();

	@Override
	public boolean save(GoldJewelleryEntity entity) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trans = manager.getTransaction();
		try {
			trans.begin();
			manager.persist(entity);
			trans.commit();
		} catch (PersistenceException e) {
			e.getStackTrace();
			trans.rollback();
		} finally {
			manager.close();
		}
		return false;
	}

	@Override
	public void save(List<GoldJewelleryEntity> list) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			for (GoldJewelleryEntity goldJewelleryEntity : list) {
				entityManager.persist(goldJewelleryEntity);
			}
			transaction.commit();
		} catch (PersistenceException e) {
			e.getStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}

	}

	@Override
	public Optional<GoldJewelleryEntity> findByShopNameAndId(int id, String shopName) {
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByShopNameAndId");
			query.setParameter("i", id);
			query.setParameter("sh", shopName);
			Object obj = query.getSingleResult();
			if (obj != null) {
				GoldJewelleryEntity ent = (GoldJewelleryEntity) obj;
				return Optional.of(ent);
			}
		} finally {
			manager.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<String> findShopNameById(int id) {
		EntityManager manage = factory.createEntityManager();
		try {
			Query query = manage.createNamedQuery("findShopNameById");
			query.setParameter("id", id);
			Object obj = query.getSingleResult();
			if (obj != null) {
				String ent = (String) obj;
				return Optional.of(ent);
			}
		} finally {
			manage.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Double> findMakingChargesByShopName(String shopName) {
		EntityManager manage = factory.createEntityManager();
		try {
			Query query = manage.createNamedQuery("findMakingChargesByShopName");
			query.setParameter("shop", shopName);
			Object obj = query.getSingleResult();
			if (obj != null) {
				Double ent = (Double) obj;
				return Optional.of(ent);
			}
		} finally {
			manage.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Object[]> findWastageChargesAndMakingChargesByShopName(String shopName) {
		EntityManager manage = factory.createEntityManager();
		try {
			Query query = manage.createNamedQuery("findWastageChargesAndMakingChargesByShopName");
			query.setParameter("sp", shopName);
			Object obj = query.getSingleResult();
			if (obj != null) {
				Object[] ent = (Object[]) obj;
				return Optional.of(ent);
			}
		} finally {
			manage.close();
		}
		return Optional.empty();
	}

	@Override
	public Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName) {
		EntityManager manage = factory.createEntityManager();
		try {
			Query query = manage.createNamedQuery("findTotalPriceByGramAndShopName");
			query.setParameter("gr", gram);
			query.setParameter("sn", shopName);
			Object obj = query.getSingleResult();
			if (obj != null) {
				Double ent = (Double) obj;
				return Optional.of(ent);
			}
		} finally {
			manage.close();
		}
		return Optional.empty();
	}

	@Override
	public Collection<GoldJewelleryEntity> findAll() {

		EntityManager manag = factory.createEntityManager();
		try {
			Query query = manag.createNamedQuery("findAll");
			return query.getResultList();
		} finally {
			manag.close();
		}

	}

	@Override
	public Collection<String> getAllShopName() {
		EntityManager manag = factory.createEntityManager();
		try {
			return manag.createNamedQuery("getAllShopName").getResultList();

		} finally {
			manag.close();
		}
	}

	@Override
	public Collection<Object[]> getAllShopNameAndType() {
		EntityManager manager = factory.createEntityManager();
		try {
			return manager.createNamedQuery("getAllShopNameAndType").getResultList();
		} finally {
			manager.close();
		}

	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesGreaterThan(double charges) {
		EntityManager manager = factory.createEntityManager();
		try {
			return Optional.of(manager.createNamedQuery("findAllByMakingChargesGreaterThan").setParameter("mc", charges)
					.getResultList());
		} finally {
			manager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByMakingChargesLesserThan(double charges) {
		EntityManager manager = factory.createEntityManager();
		try {
			return Optional.of(manager.createNamedQuery("findAllByMakingChargesLesserThan").setParameter("mch", charges)
					.getResultList());
		} finally {
			manager.close();
		}
	}

	@Override
	public Optional<Collection<GoldJewelleryEntity>> findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(
			double charges, double makingCharges) {
		EntityManager manager = factory.createEntityManager();
		try {
			return Optional.of(manager.createNamedQuery("findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan")
					.setParameter("wast", charges).setParameter("mak", makingCharges).getResultList());
		} finally {
			manager.close();
		}	
	}
}
