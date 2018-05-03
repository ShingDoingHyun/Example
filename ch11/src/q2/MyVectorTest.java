package q2;

class MyVector {
	// 1. ��ü�� ������ �迭�� size�� ������ ���� ����
	Object[] objArr; // �������� ��ü�迭 ������ �Ѵ�.
	int size = 0;

	// 2. capqacity�� �Ű������� �޴� ������ ����
	public MyVector(int capacity) {
		objArr = new Object[capacity]; // �����ڷ� ���� �޾Ƽ� �迭�� ũ�⸦ �����ϰ� �����Ѵ�.
	}

	public MyVector() { // ������ �����ε�
		this(16); // �ٸ� �����ڸ� �ҷ��´�.
	}

	int size() {
		// size ������ ���� ��ȯ�ϴ� �޼���
		return this.size;
	}

	int capacity() {
		// objArr�� ���̸� ��ȯ
		return objArr.length;
	}

	void setCapacity(int capacity) {
		// ��ü�迭�� ũ�� ����
		Object[] tmpObjArr = objArr; // ���� ��ü�迭�� �ӽ÷� ��Ƶ�
		objArr = new Object[capacity]; // ���ο� ��ü�迭 ����
		for (int i = 0; i < size; i++) { // ���� ������ ���� ����ش�.
			try {
				objArr[i] = tmpObjArr[i];
			} catch (Exception e) { // ������� ���� ���� ������ ����� ���̰� ��ġ�� ���� ���ش�.
				this.size = i;
				break; // ���� Ż��
			}
		}
	}

	boolean isEmpty() {
		// ��ü�迭�� ������� ��ȯ
		// return objArr[0] == null ? true : false; // ù��° �迤�� ���� ������ �ڵ� ��� ���� ����.
		return size == 0; // ����� ��ü�� ���� size�� 0�̸� �ƹ� ���� ���� ��.

	}

	void clear() {
		// ��ü �迭 null
		for (int i = 0; i < size; i++) // size���� �����
			objArr[i] = null; // �� ���ֱ�
		size = 0; // ��ü�迭 ��ġ �ʱ�ȭ
	}

	void add(Object obj) {
		// objArr�� ��ü�� �߰��ϴ� �޼���
		if (!(size < objArr.length))
			setCapacity(objArr.length + 1); // �������� ũ�� ���� �������� 1 ������Ű�� ���� �־��ش�.
		objArr[size++] = obj; // ���� ���� �־��ְ� size�� ������Ų��.

	}

	Object get(int index) {
		// ����� ��ü�� ��ȯ
		return objArr[index];
	}

	public String toString() {
		// objArr�� ����� ��� ��ÿ�� ���ڿ��� �̾ ��ȯ
		String tmp = "";
		for (int i = 0; i < size; i++)
			tmp = tmp + objArr[i]; // �ݺ������� ���������� ��ġ��
		return tmp;
	}

	int indexOf(Object obj) {
		// ������ ��ü�� ����Ǿ� �ִ� ��ġ ��ȯ
		for (int i = 0; i < size; i++) {
			if (objArr[i].equals(obj)) // �´� �迭�� ������ Ż��
				return i;
		}
		return -1;
	}

	boolean remove(Object obj) {
		// indexOf()�� �̿��ؼ� ������ ��ü ����

		int index = indexOf(obj); // ���� ���� ��ġ�� ���Ѵ�. ������ -1�̶� �Ʒ��� ������ ���� ����
		if (index >= 0) {
			// objArr[index] = null; //�ε����� ���� null�� �ٲ۴�. null�� ���� �ʿ� ����
			for (int i = index; i < size; i++) {
				try {
					objArr[i] = objArr[i + 1];// ��ĭ�� �մ�ܼ� ���� �����Ѵ�. ������ ���������� �������
				} catch (Exception e) { // �ε����� �迭���� ũ�� Ż��
					break;
				}
			}

			objArr[size - 1] = null; // size�� ������ ���� null��
			size = size > 0 ? size - 1 : size; // ����� 0���� ũ�� 1��ŭ ���δ�.
			return true;
		} else
			return false; // 0���� ������ Ż��(���� ��ü��������);

	}

}

class Test { // �׽�Ʈ�� Ŭ����
	String test = "";

	Test(String test) {
		this.test = test;
	}

	Test() {
		this("test ");
	}

	public String toString() {
		return test;
	}
}

public class MyVectorTest {

	public static void main(String[] args) {

		MyVector my = new MyVector();

		Test t1 = new Test();
		Test t2 = new Test("2���׽�Ʈ2 ");
		Test t3 = new Test("test3 ");
		Test t4 = new Test("�׹�°�׽�Ʈ4 ");
		Test t5 = new Test("��5����5 ");
		Test t6 = new Test("test3 ");

		System.out.println("�迭�� ����°�? = " + my.isEmpty());
		my.add(t6);
		my.add("123 ");
		my.add(t2);
		my.add(t3);
		my.add(t4);
		my.add(t5);
		my.add("���ڿ� ");
		System.out.println("�� ���� = " + my);
		System.out.println("capacity = " + my.capacity());
		System.out.println("size = " + my.size());
		System.out.println("�迭�� ����°�? = " + my.isEmpty());
		System.out.println("t3�� ��ġ = " + my.indexOf(t3));
		System.out.println("�������� = " + my.remove(t3));
		System.out.println("�� ���� �� = " + my);

		System.out.println("size = " + my.size());
		System.out.println("2�� �ε����� �� = " + my.get(2));
		my.add(t1);
		System.out.println("�� �߰� �� = " + my);
		my.setCapacity(4);
		System.out.println("capacity = " + my.capacity());
		System.out.println("ũ�� ���� �� = " + my);
		my.add(t5);
		my.add(t5);
		my.add(t5);
		System.out.println("capacity = " + my.capacity());
		System.out.println("ũ�� ���� �� = " + my);
		System.out.println("�������� = " + my.remove(t5));
		System.out.println("�� ���� �� = " + my);
		my.clear();
		System.out.println("��ü �� ���� �� = " + my);
	}

}
