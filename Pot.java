package com.pratik.teenpatti;

public class Pot {

	private int potAmount = 0;
	private final int POT_LIMIT = 8000;

	public int getPotAmount() {
		return potAmount;
	}

	public void setPotAmount(int potAmount) {
		this.potAmount += 100 + potAmount;
		this.potAmount = potAmount;
	}

	public int getPOT_LIMIT() {
		return POT_LIMIT;
	}

}
