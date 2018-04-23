package Exercise6_21;

public class MyTv {

	boolean isPowerOn;
	public int channel;
	public int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	
	public void channelDown() {
		if(this.channel > this.MIN_CHANNEL)
			this.channel--;
		else
			this.channel = this.MAX_CHANNEL;
		
	}
	public void volumeDown() {
		if(this.volume > this.MIN_VOLUME)
			this.volume--;
		
	}
	public void channelUp() {
		if(this.channel < this.MAX_CHANNEL)
			this.channel++;
		else
			this.channel = this.MIN_CHANNEL;
		
	}
	public void volumeUp() {
		if(this.volume < this.MAX_VOLUME)
			this.volume++;
		
	}

}
