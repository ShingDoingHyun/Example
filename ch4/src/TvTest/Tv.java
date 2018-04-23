package TvTest;

class Tv {
	String color;
	boolean power;
	int channel;
	
	Tv(){
		channel = 1;
	}

	void power() {
		power = !power;
	}

	void channelUp() {
		++channel;
	}

	void channelDown() {
		--channel;
	}
}