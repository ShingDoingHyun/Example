package Q1; //������ �̸�

public class PointTest { // publicŬ������ 1�� �־�� �ϰ� �ҽ����� �̸��� ���ƾ��Ѵ�.

	public static void main(String[] args) {
		Point point1 = new Point(3, 5);
		Point point2 = new Point(); // �ٸ� �����ڷ� ȣ��

		System.out.println(point1); // println���� ��ü�� ����ϸ� toStringȣ��
		System.out.println(point2);

		double value = Point.getDistance(point1, point2);
		System.out.println("�� �� ������ �Ÿ��� : " + value);

		double value2 = point1.getDistance(point2);
		System.out.println("�� �� ������ �Ÿ��� : " + value2);

		System.out.println("x�� y�� ���� ������ : " + point1.equals(point1)); // equals�� �������̵��Ͽ� x�� y�� ���� ������ üũ�ϵ��� ������
		System.out.println(point1.compareTo(point2));

		Point3D point3D1 = new Point3D();
		Point3D point3D2 = new Point3D(1, 3, 5);

		System.out.println(point3D1);
		System.out.println(point3D2);

	}

}

class Point {
	private int x; // �������� ��ȣ, ������ ���� ���������� private�� ���
	private int y;

	Point() {
		this(12, 10); // �ڵ� �ּ�ȭ�� ���� Ŭ������ �ٸ� �����ڸ� ȣ��
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return x + "," + y;
	}

	static double getDistance(Point p1, Point p2) {

		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y)); // ������ �Ÿ��� ���ϴ� ����
	}

	double getDistance(Point p) { // ���� �����ε� �Ǿ� �ڽ��� �ƴ� ���� �θ�
		return getDistance(this, p); // �ڵ� �ּ�ȭ this�� ��ü �ڽ��� ����.
	}

	public boolean equals(Object o) {

		// if ( o instanceof Point) { // �Ű������� ���� ��ü o�� PointŬ������ ��ü���� üũ
		// Point p = (Point) o;
		// if (this.x == p.x && this.y == p.y)
		// return true;
		// }
		// return false;

		if (o instanceof Point)
			return false;
		Point p = (Point) o;

		return this.x == p.x && this.y == p.y; // ���⼭ �˻� ��,���� �˻�
	}

	public int compareTo(Object o) {
		if (o instanceof Point) { // �Ű������� ���� ��ü o�� PointŬ������ ��ü���� üũ
			Point p = (Point) o;
			int point = (x + y) - (p.x + p.y);
			return point >= 0 ? point : -point;
		}
		return -999999;
	}

	public int getX() { // get, set�� �̿��ؼ� private�� ����
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

class Point3D extends Point { // extends ���
	private int z;

	public Point3D() {
		this(1, 1, 1); // �ٸ� �����ڸ� this�� ȣ���Ͽ� �ڵ� �ߺ��� �ּ�ȭ.
	}

	public Point3D(int x, int y, int z) {
		super(x, y); // �θ�Ŭ���� ������
		this.z = z;
	}

	public String toString() {
		return super.toString() + "," + z; // �θ� ���ǵ� toString�� �����ͼ� �߰��� ������ �������̵� ��.
		// return x+","+y+","+z;
	}

}
