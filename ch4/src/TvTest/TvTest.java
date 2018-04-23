package TvTest;

public class TvTest {

	public static void main(String[] args) {

		Tv t = new Tv();
//		t.channel = 7;
		t.channelUp();
		System.out.println("현재 채널은 " + t.channel + " 입니다.");
		
		t.channelUp();
		t.channelUp();
		t.channelUp();
		t.channelUp();
		System.out.println("현재 채널은 " + t.channel + " 입니다.");
	}

}
