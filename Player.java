package com.pratik.teenpatti;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> playerCardList = new ArrayList<Card>();
	private String name;
	private int amount;
	private boolean isCardOpen;

	public Player(String playerName, int amount) {
		setName(playerName);
		setAmount(amount);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isCardOpen() {
		return isCardOpen;
	}

	public void setCardOpen(boolean isCardOpen) {
		this.isCardOpen = isCardOpen;
	}

	public void playChal(Pot pot) {
		if (amount <= 400) {
			Utility.printLine(name + " u are out of money u will go in minuse");
		}
		amount -= 200;
		pot.setPotAmount(pot.getPotAmount() + 200);
	}

	public void playBlind(Pot pot) {
		if (amount <= 200) {
			Utility.printLine(name + " u are out of money u will go in minuse");
		}
		amount -= 100;
		pot.setPotAmount(pot.getPotAmount() + 100);
	}
}
