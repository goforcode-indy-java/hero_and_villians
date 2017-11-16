package com.lmig.gfc.hero_and_villians.models;

public class Monster extends LivingThing {
	
	private String classification;

	public Monster(String name, int health, String classification) {
		super(name, health);
		this.classification = classification;
	}

	public String getClassification() {
		return classification;
	}

}
