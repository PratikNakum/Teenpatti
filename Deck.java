package com.pratik.teenpatti;

import java.util.ArrayList;

public class Deck {

	Card cardStack[] = new Card[52];

	void initCard() {
		int i = 0;
		for (CardSymbol symbol : CardSymbol.values()) {
			for (CardFace face : CardFace.values()) {
				cardStack[i] = new Card(symbol, face);
				i++;
			}
		}
	}

	void suffleCard() {
		for (int i = cardStack.length - 1; i > 0; i--) {
			int index = Utility.randomNumber(i);
			Card card = cardStack[i];
			cardStack[i] = cardStack[index];
			cardStack[index] = card;
		}
	}

	void distributeCard(ArrayList<Player> playersList) {
		int numberOfPlayer = playersList.size();

		for (int i = 0; i < numberOfPlayer; i++) {
			Player player = playersList.get(i);
			player.playerCardList.add(cardStack[i]);
			player.playerCardList.add(cardStack[i + numberOfPlayer]);
			player.playerCardList.add(cardStack[i + numberOfPlayer * 2]);
		}
	}

	void printPlayerScreen(Player player, Pot pot) {
		Utility.printLine("");
		Utility.printLine("");
		Utility.printLine("------------------------------------------------------------------------------");
		Utility.printLine("");
		Utility.print("|Player Online|                                               |Player Online|");
		Utility.printLine("");
		Utility.printLine("");
		Utility.print("                                |_" + pot.getPotAmount() + "_|");
		Utility.printLine("");
		Utility.printLine("");
		Utility.print("|Player Online|                                               |Player Online|");
		Utility.printLine("");
		Utility.printLine("");
		Utility.printLine("");
		Utility.printLine("                               |__" + player.getName() + "__|");
		Utility.printLine("                                $ " + player.getAmount());
		if (player.isCardOpen()) {
			for (int i = 0; i < player.playerCardList.size(); i++) {
				Utility.print(player.playerCardList.get(i).getSymbol() + "_"
						+ player.playerCardList.get(i).getCardface() + "|");
			}
		}
		Utility.printLine("");
		Utility.printLine("------------------------------------------------------------------------------");

	}

}
