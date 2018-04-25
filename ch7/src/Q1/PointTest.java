package Q1; //폴더의 이름

public class PointTest { // public클래스는 1개 있어야 하고 소스파일 이름과 같아야한다.

	public static void main(String[] args) {
		Point point1 = new Point(3, 5);
		Point point2 = new Point(); // 다른 생성자로 호출

		System.out.println(point1); // println으로 객체를 출력하면 toString호출
		System.out.println(point2);

		double value = Point.getDistance(point1, point2);
		System.out.println("두 점 사이의 거리는 : " + value);

		double value2 = point1.getDistance(point2);
		System.out.println("두 점 사이의 거리는 : " + value2);

		System.out.println("x와 y의 값이 같은가 : " + point1.equals(point1)); // equals를 오버라이딩하여 x와 y의 갑이 갗은지 체크하도록 변경함
		System.out.println(point1.compareTo(point2));

		Point3D point3D1 = new Point3D();
		Point3D point3D2 = new Point3D(1, 3, 5);

		System.out.println(point3D1);
		System.out.println(point3D2);

	}

}

class Point {
	private int x; // 데이터의 보호, 은닉을 위해 접근제어자 private를 사용
	private int y;

	Point() {
		this(12, 10); // 코드 최소화를 위해 클래스의 다른 생성자를 호출
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return x + "," + y;
	}

	static double getDistance(Point p1, Point p2) {

		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y)); // 두점의 거리를 구하는 공식
	}

	double getDistance(Point p) { // 위와 오버로딩 되어 자신이 아닌 위를 부름
		return getDistance(this, p); // 코드 최소화 this는 객체 자신을 말함.
	}

	public boolean equals(Object o) {

		// if ( o instanceof Point) { // 매개변수로 받은 객체 o가 Point클래스의 객체인지 체크
		// Point p = (Point) o;
		// if (this.x == p.x && this.y == p.y)
		// return true;
		// }
		// return false;

		if (o instanceof Point)
			return false;
		Point p = (Point) o;

		return this.x == p.x && this.y == p.y; // 여기서 검사 참,거짓 검사
	}

	public int compareTo(Object o) {
		if (o instanceof Point) { // 매개변수로 받은 객체 o가 Point클래스의 객체인지 체크
			Point p = (Point) o;
			int point = (x + y) - (p.x + p.y);
			return point >= 0 ? point : -point;
		}
		return -999999;
	}

	public int getX() { // get, set을 이용해서 private에 접근
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

class Point3D extends Point { // extends 상속
	private int z;

	public Point3D() {
		this(1, 1, 1); // 다른 생성자를 this로 호출하여 코드 중복을 최소화.
	}

	public Point3D(int x, int y, int z) {
		super(x, y); // 부모클래스 생성자
		this.z = z;
	}

	public String toString() {
		return super.toString() + "," + z; // 부모에 정의된 toString을 가져와서 추가된 내용을 오버라이드 함.
		// return x+","+y+","+z;
	}

}
