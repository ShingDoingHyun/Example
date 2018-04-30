package Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCastTestTestTestTest {
	// ������� ī����
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
 
		int[] number = new int[Card.NUM_MAX];	//ī���ȣ���� ��� ������ �ִ��� üũ �ϱ����� ���
		//int[] kind = new int[Card.KIND_MAX];	//��纰�� ��� ������ �ִ��� üũ �ϱ����� ��� 
		//(5���� �������� üũ�� �ϸ� �Ǳ⶧���� ����� �迭�� ���� �ʿ䰡 ����.)

		int pair = 0;	//�ѽ��� �̷�� ī�尡 ����� üũ
		int sameCard = 0;	//������ȣ ī�尡 �s������ üũ
//		int sameKind = 0;	//������� ī�尡 ����� üũ
		int straightCnt = 0;	//5���� ���Ͻ� ��Ʈ����Ʈ
		int mountain=0;
		
		int kind = cArr[0].kind;	//���üũ
		boolean kindCnt=true;		//true�� �÷���
		
		for (int i = 0; i < 5; i++) {
			number[cArr[i].num]++;
		//	kind[cArr[i].kind]++;

		}
		

		for(int i = 0; i< Card.KIND_MAX; i++) {	//�� ������� üũ�ؼ� �߰��� �ƴ� ����� ������ �ݺ��� Ż��
			if(!(cArr[i].kind == kind)) {
				kindCnt=false;
				break;
			}
		}
		for (int i = 0; i < Card.NUM_MAX; i++) {		//ī���ȣ�� ������� üũ
			if (number[i] == 2)
				pair++;
			if (sameCard < number[i])		//���� �˻��� ī���� ���� ���� ������ ���� ��ȣ�� üũ, ���� üũ������ ���δ� üũ���� ũ�� ����
				sameCard = number[i];
			if (number[i] == 1) { 			//1�϶� straight���� ����
				straightCnt++;
				if(i==0||i==9||i==10||i==11||i==12) {	//�� �����̸� ����ƾ ����
					mountain++;
				}
				
			}
			else if(straightCnt<5)	//���������� 1�� �ƴ� �߰��� 1�� ������ 0���� �ʱ�ȭ
				straightCnt = 0;

		}
//		for (int i = 0; i < Card.KIND_MAX; i++) {		//ī����� ����� üũ
//			if (sameKind < kind[i])		//���� ���������� ���� ������ ��� üũ, ���������� 5���� ���������� üũ�ϸ� �ȴ�.
//				sameKind = kind[i];
//		}
		//����� ���� ���� ���ڿ��� ����
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
	static final int KIND_MAX = 4;//���Ĺ��
	static final int NUM_MAX = 13;//���ڰ���

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
	static final int CARD_MAX = 51;//���Ĺ��
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
