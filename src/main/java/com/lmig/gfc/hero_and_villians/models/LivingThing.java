package com.lmig.gfc.hero_and_villians.models;

public class LivingThing {
	
	protected String name;
	protected int health;
	
	public LivingThing(String name, int health) {
		this.name = name;
		this.health = health;
	}
	
	public boolean isAlive() {
		if(health > 0) {
			return true;
		}
		return false;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health < 0 ) {
			health = 0;
		}
		this.health = health;
	}

	public String getName() {
		return name;
	}

}
