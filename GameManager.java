package com.pratik.teenpatti;
import java.util.ArrayList;

public class GameManager {

	ArrayList<Player> playersList = new ArrayList<Player>();
	Deck deck = new Deck();
	Pot pot = new Pot();
	GameOverCondition gameOverCondition = new GameOverCondition();

	void startTeenPattiGame() {

		deck.initCard();

		int numberOfPlayer = Utility.getInt("Enter num of player");
		int amount;
		String playerName;
		for (int i = 0; i < numberOfPlayer; i++) {
			playerName = Utility.getString("Enter player Name");
			amount = Utility.getInt(playerName + " Enter your ($)amount");
			Player player = new Player(playerName, amount);
			playersList.add(player);
		}

		deck.suffleCard();
		deck.distributeCard(playersList);
		collectPotAmount();
		startGamePlay();
	}

	void collectPotAmount() {
		for (Player player : playersList) {
			pot.setPotAmount(pot.getPotAmount() + 100);
			player.setAmount(player.getAmount() - 100);
		}
	}

	void startGamePlay() {
		while (gameOverCondition.isPotLimitExist(playersList, pot) && playersList.size() > 1) {

			for (int i = 0; i < playersList.size();) {
				Player curruntPlayer = playersList.get(i);

				if (playersList.size() == 1)
					break;

				if (!curruntPlayer.isCardOpen()) {
					char x = Utility.getChar(curruntPlayer.getName() + " you like two open card (Y/N)");
					if (x == 'y' || x == 'Y') {
						curruntPlayer.setCardOpen(true);
					}
				}

				deck.printPlayerScreen(curruntPlayer, pot);
				int choise = Utility.getInt("1.pack   2.blind/chal   3.show");
				switch (choise) {
				case 1:
					playersList.remove(i);
					break;
				case 2:
					if (curruntPlayer.isCardOpen()) {
						curruntPlayer.playChal(pot);

					} else {
						curruntPlayer.playBlind(pot);
					}
					i++;
					break;
				case 3:
					if (playersList.size() == 2) {
						gameOverCondition.show(playersList);
					} else {
						Utility.printLine("U can't show when more than two player exist in game...");
					}
					break;
				default:
					Utility.printLine("Invalid Choise");
				}
			}
		}
		declarResult();
	}

	void declarResult() {
		Utility.printLine(playersList.get(0).getName() + " Congratulations you won " + pot.getPotAmount() + " ($)");
		Utility.printLine("Thank you for playing...see you soon again");
	}
}
