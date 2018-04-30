package Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCastTestTestTestTest {
	// 기수정렬 카운팅
	@Test
	public void test1() {
		Card[] cArr = { new Card(1, 1), new Card(1, 2), new Card(1, 3), new Card(1, 4), new Card(1, 5) };

		assertTrue(pokerRank(cArr).equals("straight flush"));
	}

	@Test
	public void test2() {
		Card[] cArr = { new Card(2, 1), new Card(1, 1), new Card(1, 3), new Card(2, 4), new Card(1, 5) };

		assertTrue(pokerRank(cArr).equals("One pair"));
	}

	@Test
	public void test3() {
		Card[] cArr = { new Card(3, 1), new Card(1, 1), new Card(1, 2), new Card(1, 2), new Card(3, 5) };

		assertTrue(pokerRank(cArr).equals("Two pair"));
	}

	@Test
	public void test4() {
		Card[] cArr = { new Card(1, 1), new Card(2, 1), new Card(3, 1), new Card(1, 2), new Card(1, 5) };

		assertTrue(pokerRank(cArr).equals("Three of a Kind"));
	}

	@Test
	public void test5() {
		Card[] cArr = { new Card(2, 3), new Card(2, 3), new Card(3, 3), new Card(2, 3), new Card(3, 7) };

		assertTrue(pokerRank(cArr).equals("Four Card"));
	}

	@Test
	public void test6() {
		Card[] cArr = { new Card(2, 3), new Card(2, 3), new Card(3, 3), new Card(2, 7), new Card(3, 7) };

		assertTrue(pokerRank(cArr).equals("Full house"));
	}

	@Test
	public void test7() {
		Card[] cArr = { new Card(1, 3), new Card(1, 3), new Card(1, 2), new Card(1, 7), new Card(1, 7) };

		assertTrue(pokerRank(cArr).equals("Flush"));
	}

	@Test
	public void test8() {
		Card[] cArr = { new Card(2, 1), new Card(2, 2), new Card(1, 3), new Card(1, 4), new Card(1, 5) };

		assertTrue(pokerRank(cArr).equals("straight"));
	}

	@Test
	public void test9() {
		Card[] cArr = { new Card(2, 1), new Card(2, 2), new Card(1, 8), new Card(1, 4), new Card(1, 12) };

		assertTrue(pokerRank(cArr).equals("No rank"));
	}
	
	@Test
	public void test10() {
		Card[] cArr = { new Card(2, 0), new Card(2, 9), new Card(1, 10), new Card(1, 11), new Card(1, 12) };

		assertTrue(pokerRank(cArr).equals("mountain"));
	}
	@Test
	public void test11() {
		Card[] cArr = { new Card(1, 0), new Card(1, 9), new Card(1, 10), new Card(1, 11), new Card(1, 12) };

		assertTrue(pokerRank(cArr).equals("Royal straight flush"));
	}

	String pokerRank(Card[] cArr) {
 
		int[] number = new int[Card.NUM_MAX];	//카드번호별로 몇개씩 가지고 있는지 체크 하기위해 사용
		//int[] kind = new int[Card.KIND_MAX];	//모양별로 몇개씩 가지고 있는지 체크 하기위해 사용 
		//(5개가 무엇인지 체크만 하면 되기때문에 모양은 배열로 만들 필요가 없다.)

		int pair = 0;	//한쌍을 이루는 카드가 몇개인지 체크
		int sameCard = 0;	//같은번호 카드가 몊개인지 체크
//		int sameKind = 0;	//같은모양 카드가 몇개인지 체크
		int straightCnt = 0;	//5까지 쌓일시 스트레이트
		int mountain=0;
		
		int kind = cArr[0].kind;	//모양체크
		boolean kindCnt=true;		//true면 플러쉬
		
		for (int i = 0; i < 5; i++) {
			number[cArr[i].num]++;
		//	kind[cArr[i].kind]++;

		}
		

		for(int i = 0; i< Card.KIND_MAX; i++) {	//한 모양인지 체크해서 중간에 아닌 모양이 나오면 반복문 탈출
			if(!(cArr[i].kind == kind)) {
				kindCnt=false;
				break;
			}
		}
		for (int i = 0; i < Card.NUM_MAX; i++) {		//카드번호당 몇개씩인지 체크
			if (number[i] == 2)
				pair++;
			if (sameCard < number[i])		//현재 검사한 카드중 제일 많은 갯수를 가진 번호를 체크, 현재 체크량보다 들어로는 체크량이 크면 변경
				sameCard = number[i];
			if (number[i] == 1) { 			//1일때 straight수를 높임
				straightCnt++;
				if(i==0||i==9||i==10||i==11||i==12) {	//이 범위이면 마운틴 증가
					mountain++;
				}
				
			}
			else if(straightCnt<5)	//연속적으로 1이 아닌 중간에 1이 나오면 0으로 초기화
				straightCnt = 0;

		}
//		for (int i = 0; i < Card.KIND_MAX; i++) {		//카드모양당 몇개인지 체크
//			if (sameKind < kind[i])		//위와 마찬가지로 많이 보유한 모양 체크, 실질적으론 5개가 무엇인지만 체크하면 된다.
//				sameKind = kind[i];
//		}
		//검출된 값을 통해 물자열을 리턴
		if (mountain==5 && kindCnt)	
			return "Royal straight flush";
		if (straightCnt==5 && kindCnt)	
			return "straight flush";
		if (mountain==5 )	
			return "mountain";
		if (sameCard >= 4)
			return "Four Card";
		if (pair == 1 && sameCard == 3)
			return "Full house";
		if (kindCnt)
			return "Flush";
		if (straightCnt ==5)
			return "straight";
		if (sameCard == 3)
			return "Three of a Kind";
		if (pair == 2)
			return "Two pair";
		if (pair == 1)
			return "One pair";

		return "No rank";
	}

}

class Card {
	static final int KIND_MAX = 4;//모양캣수
	static final int NUM_MAX = 13;//숫자갯수

	int kind;
	int num;

	public Card() {
		this(1, 1);
	}

	public Card(int kind, int num) {
		this.kind = kind;
		this.num = num;

	}
	
}	
class Player{
	Card[] cards;
	int money;
	String name;
	
	
}

class Dealer{
	Deck d;
	
}
class Deck{
	static final int CARD_MAX = 51;//모양캣수
	Card[] cards = new Card[CARD_MAX];
	
	void cardSet() {
		int i=0;
		for(int cardNum=0; cardNum < Card.NUM_MAX; cardNum++) {
			for(int cardKind=0; cardKind < Card.KIND_MAX; cardKind++) {
				cards[i].kind=cardKind;
				cards[i].num=cardNum;
				i++;
				
			}
		}
		for(int num=0; num< cards.length; num++) {
			System.out.println(cards[num].kind+","+cards[num].num);
		}
		
	}
	
	
	
	
	
	
}
