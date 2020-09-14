package com.pratik.teenpatti;

public class Card {

	private CardFace cardface;
	private CardSymbol symbol;

	Card(CardSymbol symbol, CardFace cardface) {
		setSymbol(symbol);
		setCardface(cardface);
	}

	public int getCardFaceValue() {
		return cardface.getCardFaceValue();
	}

	public CardFace getCardface() {
		return cardface;
	}

	public void setCardface(CardFace cardface) {
		this.cardface = cardface;
	}

	public Enum<CardSymbol> getSymbol() {
		return symbol;
	}

	public void setSymbol(CardSymbol symbol) {
		this.symbol = symbol;
	}

}
