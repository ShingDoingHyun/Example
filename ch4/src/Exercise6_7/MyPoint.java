package Exercise6_7;

public class MyPoint {
	int i;
	int j;
	
	MyPoint(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public double getDistance(int i, int j) {
		return Math.sqrt((this.i-i)*(this.i-i) + (this.j-j)*(this.j-j));
	}

}
