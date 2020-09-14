package com.pratik.teenpatti;

import java.util.ArrayList;

public class GameRules {
	ArrayList<Card> playerCardList;

	int checkCardPriority(ArrayList<Card> playerCardList) {
		this.playerCardList = playerCardList;
		sortArrayList();

		if (isCardTrial())
			return 6;
		if (isCardPureSequence())
			return 5;
		if (isCardSequence())
			return 4;
		if (isCardColor())
			return 3;
		if (isCardPair())
			return 2;
		return 1;
	}

	boolean isCardTrial() {
		int count = 0;
		for (int i = 0; i < playerCardList.size() - 1; i++) {
			if (playerCardList.get(0).getCardFaceValue() == playerCardList.get(i + 1).getCardFaceValue()) {
				count++;
			}
		}
		if (count == playerCardList.size() - 1)
			return true;
		return false;
	}

	
	boolean isCardPureSequence() {
		int count = 0;
		for (int i = 0; i < playerCardList.size() - 1; i++) {
			if (playerCardList.get(i).getSymbol() == playerCardList.get(i + 1).getSymbol())
				if (playerCardList.get(i).getCardFaceValue() + 1 == playerCardList.get(i + 1).getCardFaceValue())
					count++;
		}
		if (count == playerCardList.size() - 1)
			return true;
		return false;
	}

	boolean isCardSequence() {
		int count = 0;
		for (int i = 0; i < playerCardList.size() - 1; i++) {
			if (playerCardList.get(i).getCardFaceValue() + 1 == playerCardList.get(i + 1).getCardFaceValue()) {
				count++;
			}
		}

		if (count == playerCardList.size() - 1)
			return true;
		return false;
	}

	
	boolean isCardColor() {
		int count = 0;
		for (int i = 0; i < playerCardList.size() - 1; i++) {
			if (playerCardList.get(i).getSymbol() == playerCardList.get(i + 1).getSymbol()) {
				count++;
			}
		}
		if (count == playerCardList.size() - 1)
			return true;
		return false;
	}

	
	
	
	boolean isCardPair() {
		int count = 0;
		for (int i = 0; i < playerCardList.size() - 1; i++) {
			if (playerCardList.get(i).getCardFaceValue() == playerCardList.get(i + 1).getCardFaceValue()) {
				count++;
			}
		}
		if (count >= 1)
			return true;
		return false;
	}

	
	
	void sortArrayList() {
		Card card;
		for (int i = 0; i < playerCardList.size(); i++) {
			for (int j = i; j < playerCardList.size(); j++) {
				if (playerCardList.get(i).getCardFaceValue() > playerCardList.get(j).getCardFaceValue()) {
					card = playerCardList.get(i);
					playerCardList.set(i, playerCardList.get(j));
					playerCardList.set(j, card);
				}
			}
		}
	}

	Player checkWinnerForHighCard(Player player1, Player player2) {
		int count1 = 0, count2 = 0;
		for (int i = player1.playerCardList.size() - 1; i >= 0; i--) {
			if (player1.playerCardList.get(i).getCardFaceValue() > player2.playerCardList.get(i).getCardFaceValue()) {
				count1++;
			}
			if (player1.playerCardList.get(i).getCardFaceValue() < player2.playerCardList.get(i).getCardFaceValue()) {
				count2++;
			}
		}
		if (count1 > count2) {
			return player1;
		}
		return player2;
	}
}
