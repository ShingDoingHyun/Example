package TvTest;

public class TvTest {

	public static void main(String[] args) {

		Tv t = new Tv();
//		t.channel = 7;
		t.channelUp();
		System.out.println("���� ä���� " + t.channel + " �Դϴ�.");
		
		t.channelUp();
		t.channelUp();
		t.channelUp();
		t.channelUp();
		System.out.println("���� ä���� " + t.channel + " �Դϴ�.");
	}

}
