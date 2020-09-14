package com.pratik.teenpatti;

import java.util.ArrayList;

public class GameOverCondition {

	GameRules gameRules = new GameRules();

	boolean isPotLimitExist(ArrayList<Player> playersList, Pot pot) {
		if (pot.getPotAmount() >= pot.getPOT_LIMIT()) {
			show(playersList);
			return false;
		}
		return true;
	}

	Player show(ArrayList<Player> playersList) {
		Player winnerPlayer = null;
		while (playersList.size() != 1) {
			winnerPlayer = findWinnerAmongTwoPlayers(playersList.get(0), playersList.get(1));
			if (winnerPlayer.equals(playersList.get(0))) {
				playersList.remove(1);
			} else {
				playersList.remove(0);
			}
		}
		return winnerPlayer;
	}

	Player findWinnerAmongTwoPlayers(Player player1, Player player2) {
		int playerOneCardPriority = gameRules.checkCardPriority(player1.playerCardList);
		int playerTwoCardPriority = gameRules.checkCardPriority(player2.playerCardList);

		if (playerOneCardPriority > playerTwoCardPriority) {
			return player1;
		}
		if (playerOneCardPriority == playerTwoCardPriority) {
			return gameRules.checkWinnerForHighCard(player1, player2);
		}
		return player2;
	}
}
