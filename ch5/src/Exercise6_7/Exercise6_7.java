package Exercise6_7;

public class Exercise6_7 {
	public static void main(String args[]) {
		MyPoint p = new MyPoint(1, 1);
		// p와 (2,2)의 거리를 구한다.
		System.out.println(p.getDistance(2, 2));
	}
}

class MyPoint{
	
	private int num1;
	private int num2;

	MyPoint(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}

	public double getDistance(int num1, int num2) {
		
		return Math.sqrt((this.num1-num1)*(this.num1-num1) +(this.num2-num2)*(this.num2-num2));
	}
}
