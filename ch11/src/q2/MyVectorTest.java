package q2;

class MyVector {
	// 1. 객체를 저장할 배열과 size를 저장할 변수 선언
	Object[] objArr; // 배열 생성만을 한다.
	int size = 0;

	// 2. capqacity를 매개변수로 받는 생성자 선언
	public MyVector(int capacity) {
		objArr = new Object[capacity]; // 생성자로 값을 받아서 배열의 크기를 설정한다.
	}

	public MyVector() { // 생성자 오버로딩
		this(16); // 다른 생성자를 불러온다.
	}

	int size() {
		// size 변수의 값을 반환하는 메서드
		return this.size;
	}

	int capacity() {
		// objArr의 길이를 반환
		return objArr.length;
	}

	void setCapacity(int capacity) {
		Object[] tmpObjArr = objArr; // 현재 객체배열을 임시로 담아둠
		objArr = new Object[capacity]; // 새로운 객체배열 생성
		for (int i = 0; i < size; i++) { // 새로 템프의 값을 담아준다.
			try {
				objArr[i] = tmpObjArr[i];
			} catch (Exception e) { // 사이즈보다 적은 값이 들어오면 사이즈를 줄이고 넘치는 값을 없앤다.
				this.size = i;
				break; // 포문 탈출
			}
		}
	}

	boolean isEmpty() {
		// 객체배열이 비었는지 반환
		// return objArr[0] == null ? true : false; // 첫번째 배엘에 값이 없으면 뒤도 모두 값이 없다.
		return size == 0;

	}

	void add(Object obj) {
		// objArr에 객체를 추가하는 메서드
		if (size < objArr.length)
			objArr[size++] = obj; // 들어온 값을 넣어주고 size를 증가시킨다.
		else
			System.out.println("배열의 범위를 넘어섰습니다.");
	}

	Object get(int index) {
		// 저장된 객체를 반환
		return objArr[index];
	}

	public String toString() {
		// objArr에 저장된 모든 객첼ㄹ 문자열로 이어서 반환
		String tmp = "";
		for (int i = 0; i < size; i++)
			tmp = tmp + objArr[i];
		return tmp;
	}

	int indexOf(Object obj) {
		// 지정된 객체가 저장되어 있는 위치 반환
		for (int i = 0; i < objArr.length; i++) {
			if (objArr[i].equals(obj)) // 맞는 배열이 나오면 탈출
				return i;
		}
		return -1;
	}

	boolean remove(Object obj) {
		// indexOf()를 이용해서 지정된 객체 삭제

		int index = indexOf(obj); // 받은 값의 위치르 구한다. 없으면 -1이라 아래의 포문을 돌지 않음
		if (index >= 0) {	
			objArr[index] = null;	//인덱스의 값을 null로 바꾼다

			for (int i = index; i < size; i++) {	//사이즈만큼 반복
				try {
					Object tmp = objArr[i];	//한칸씩 앞댕긴다.
					objArr[i] = objArr[i + 1];
					objArr[i + 1] = tmp;
				} catch (Exception e) { //인덱스가 배열보다 크면 탈출
					break;
				}
			}
			
			size = size > 0 ? size - 1 : size;	//사이즈가 0보다 크면 1만큼 출인다.
			return true;
		} else
			return false;	//0보다 작으면 탈출(같은 객체가없으면);

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
		Test t2 = new Test("2번테스트2 ");
		Test t3 = new Test("test3 ");
		Test t4 = new Test("네번째 테스트4 ");
		Test t5 = new Test("오5오오5 ");
		System.out.println("배열이 비었는가? = " + my.isEmpty());
		my.add(t1);
		my.add(t2);
		my.add(t3);
		my.add(t4);
		my.add(t5);
		System.out.println("capacity = " + my.capacity());
		System.out.println("size = " + my.size());
		System.out.println("배열이 비었는가? = " + my.isEmpty());
		System.out.println("t3의 위치 = " + my.indexOf(t3));
		System.out.println("값 널기 = " + my);
		System.out.println("삭제여부 = " + my.remove(t3));
		System.out.println("값 삭제 후" + my);
		System.out.println("size = " + my.size());
		System.out.println("2번 인덱스의 값 = " + my.get(2));
		my.add(t1);
		System.out.println("값 추가 후 = " + my);
		my.setCapacity(4);
		System.out.println("capacity = " + my.capacity());
		System.out.println("크기 변경 후 = " + my);
		System.out.println("삭제여부 = " + my.remove(t5));
		System.out.println("값 삭제 후 = " + my);
	}

}
