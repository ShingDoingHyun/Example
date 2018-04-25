package exercise7_1;


public class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		for (int i = 0; i < CARD_NUM; i++) {
			boolean isKwang = false;
			int num = i % 10;
			if (i < 10 && (i == 0 || i == 2 || i == 7))
				isKwang = true;
			cards[i] = new SutdaCard(num + 1, isKwang);
		}
	}

	public String pick(int i) {
		String isKwang = cards[i].isKwang ? "K" : "";
		return cards[i].num + isKwang;
	}

	public String pick() {
		int num = (int)( Math.random() * CARD_NUM);
		return pick(num);
	}

	public void shuffle() {
		for (int i = 0; i < CARD_NUM; i++) {
			int num = (int) (Math.random() * CARD_NUM);
			SutdaCard tmp = cards[i];
			cards[i] = cards[num];
			cards[num] = tmp;
		}

	}
}
