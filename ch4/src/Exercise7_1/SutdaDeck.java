package Exercise7_1;

public class SutdaDeck {

	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		for(int i = 0; i < cards.length; i++) {
			int num = i%10+1;
			boolean isKwang = (i < 10)&&(num==1||num==3||num==8);
			cards[i] = new SutdaCard(num,isKwang);
			
		}
	
	}
	

	public void shuffle() {
		for(int i = 0 ; i < CARD_NUM; i++) {
			int num = (int)(Math.random()*CARD_NUM); 
			SutdaCard tmp = cards[i];
			cards[i] = cards[num];
			cards[num] = tmp;
		}
		
	}
	
	public String pick(int index) {
		// TODO Auto-generated method stub
		return cards[index]+"";
	}


	public String pick() {
		// TODO Auto-generated method stub
		int num = (int)(Math.random()*CARD_NUM); 
		return cards[num]+"";
	}





}
