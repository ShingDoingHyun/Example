package Exercise7_1;

public class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	// info() Object toString() . ��� Ŭ������ �� �������̵��ߴ�
	public String toString() {
		return num + (isKwang ? "K" : "");
	}

}
