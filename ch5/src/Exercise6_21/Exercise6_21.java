package Exercise6_21;

public class Exercise6_21 {
	public static void main(String args[]) {
		MyTv t = new MyTv();
		t.channel = 1000;
		t.volume = 0;
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
		t.channelDown();
		t.volumeDown();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
	}
}

class MyTv{

	public int volume;
	public int channel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public void channelDown() {
		if(channel>MIN_CHANNEL)
			channel--;
		else
			channel = MAX_CHANNEL;
		
	}
	public void volumeUp() {
		if(volume<MAX_VOLUME)
			volume++;
	}
	public void channelUp() {
		if(channel<MAX_CHANNEL)
			channel++;
		else
			channel = MIN_CHANNEL;
		
	}
	public void volumeDown() {
		if(volume>MIN_VOLUME)
			volume--;	
	}
	
}
