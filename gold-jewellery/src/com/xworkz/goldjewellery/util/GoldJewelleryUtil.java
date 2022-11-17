package com.xworkz.goldjewellery.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GoldJewelleryUtil {
	
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getFactory() {
		return factory;
	}

	static {
		factory=Persistence.createEntityManagerFactory("jewellery");
	}
	

}
