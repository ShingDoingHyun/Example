package q2;

class MyVector {
	// 1. ��ü�� ������ �迭�� size�� ������ ���� ����
	Object[] objArr; // �迭 �������� �Ѵ�.
	int size = 0;

	// 2. capqacity�� �Ű������� �޴� ������ ����
	public MyVector(int capacity) {
		objArr = new Object[capacity]; // �����ڷ� ���� �޾Ƽ� �迭�� ũ�⸦ �����Ѵ�.
	}

	public MyVector() {	//������ �����ε� 
		this(16);	//�ٸ� �����ڸ� �ҷ��´�.
	}

	int size() {
		// size ������ ���� ��ȯ�ϴ� �޼���
		return this.size;
	}

	int capacity() {
		// objArr�� ���̸� ��ȯ
		return objArr.length;
	}

	boolean isEmpty() {
		// ��ü�迭�� ������� ��ȯ
		//return objArr[0] == null ? true : false; // ù��° �迤�� ���� ������ �ڵ� ��� ���� ����.
		return size==0;

	}

	void add(Object obj) {
		// objArr�� ��ü�� �߰��ϴ� �޼���
		if (size < objArr.length)
			objArr[size++] = obj;	//���� ���� �־��ְ� size�� ������Ų��.
		else
			System.out.println("�迭�� ������ �Ѿ���ϴ�.");
	}

	Object get(int index) {
		// ����� ��ü�� ��ȯ
		return objArr[index];
	}

	public String toString() {
		// objArr�� ����� ��� ��ÿ�� ���ڿ��� �̾ ��ȯ
		String tmp = "";
		for (int i = 0; i < size; i++) 
			tmp = tmp + objArr[i];
		return tmp;
	}

	int indexOf(Object obj) {
		// ������ ��ü�� ����Ǿ� �ִ� ��ġ ��ȯ
		for (int i = 0; i < objArr.length; i++) {
			if (objArr[i].equals(obj) )	//�´� �迭�� ������ Ż��
				return i;
		}
		return 0;
	}

	boolean remove(Object obj) {
		// indexOf()�� �̿��ؼ� ������ ��ü ����
		try {
			if (size >= 0) {
				int index = indexOf(obj);
				objArr[index] = null;
				for (int i = index; i < size; i++) {
					try {
						Object tmp = objArr[i];
						objArr[i] = objArr[i + 1];
						objArr[i + 1] = tmp;
					} catch (Exception e) {
						break;
					}
				}
				size = size > 0 ? size - 1 : size;
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}

	}
}

class Test {
	String test = "";

	Test(String test) {
		this.test = test;
	}

	Test() {
		this("test");
	}

	public String toString() {
		return test;
	}
}

public class MyVectorTest {

	public static void main(String[] args) {

		MyVector my = new MyVector();

		Test t1 = new Test("test3 ");
		Test t2 = new Test("2���׽�Ʈ2 ");
		Test t3 = new Test("test3 ");
		Test t4 = new Test("�׹�° �׽�Ʈ4 ");
		Test t5 = new Test("��5����5 ");
		System.out.println("�迭�� ����°�? = " + my.isEmpty());
		my.add(t1);
		my.add(t2);
		my.add(t3);
		my.add(t4);
		my.add(t5);
		System.out.println("capacity = " + my.capacity());
		System.out.println("size = " + my.size());
		System.out.println("�迭�� ����°�? = " + my.isEmpty());
		System.out.println("t3�� ��ġ = " + my.indexOf(t3));
		System.out.println("�� �α� = " + my);
		System.out.println("�������� = " + my.remove(t3));
		System.out.println("�� ���� ��" + my);
		System.out.println("size = " + my.size());
		System.out.println("2�� �ε����� �� = " + my.get(2));
		my.add(t1);
		System.out.println("�� �߰� �� = " + my);
	}

}
