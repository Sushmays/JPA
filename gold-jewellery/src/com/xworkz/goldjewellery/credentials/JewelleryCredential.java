package com.xworkz.goldjewellery.credentials;

public enum JewelleryCredential {
	
	NECKLACE("Necklace"),BANGLE("Bangle"),RING("Ring"),BRACELET("Bracelet"),EARRING("Ear-ring"),
	NOSEPIERCHING("Nose-Pierching"),CHAIN("Chain"),ANKLET("Anklet");
	
	private String value;
	
	private JewelleryCredential(String value) {
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	
}
