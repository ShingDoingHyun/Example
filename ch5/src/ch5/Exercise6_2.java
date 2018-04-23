package ch5;

public class Exercise6_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		System.out.println(card1.info());
		System.out.println(card2.info());
	}

}

class SutdaCard{
	int num;
	boolean isKwang;
	
	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}


	public SutdaCard() {
//		this.num = 1;
//		this.isKwang =  true;
		this(1,true);	//다른 생성자를 불러옴 this
	}
	

	public String info() {
		if(isKwang) 
			return num+"k";
		else
			return num+"";
		
//		return num + "" + (isKwang ? "K" : "");		/삼항연산자로는 1줄 가능
		
	}
	
	
}
