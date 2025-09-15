package com.cms.cores;

public enum ServicePlan {
// Constants
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATIUM(10000);
	int planCost;

// construtor
	private ServicePlan(int planCost) {
		this.planCost = planCost;
	}

//methods
	public String toString() {
		return "Name of  plan -" + name();
	}
}
