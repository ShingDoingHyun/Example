package Exercise6_2;

import java.util.Random;

public class SutdaCard {
	int num;
	boolean isKwang;
	Random random;

	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	public SutdaCard() {
		random = new Random();
		this.num = (int)(Math.random()*10)+1;
		this.isKwang = random.nextBoolean();
	}
	public String info() {
		
		if(isKwang)
			return num +"K";
		else
			return num+"";
	}
	
}
