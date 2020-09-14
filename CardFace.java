package com.pratik.teenpatti;

public enum CardFace {
	
	ace(14), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9), ten(10), jack(11), queen(12),
	king(13);

	private int cardFaceValue;

	CardFace(int cardFaceValue) {
		setCardFaceValue(cardFaceValue);
	}

	public int getCardFaceValue() {
		return cardFaceValue;
	}

	public void setCardFaceValue(int cardFaceValue) {
		this.cardFaceValue = cardFaceValue;
	}

}
