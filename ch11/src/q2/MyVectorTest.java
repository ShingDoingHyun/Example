package q2;

class MyVector {
	// 1. 객체를 저장할 배열과 size를 저장할 변수 선언
	Object[] objArr; // 참조변수 객체배열 선언만을 한다.
	int size = 0;

	// 2. capqacity를 매개변수로 받는 생성자 선언
	public MyVector(int capacity) {
		objArr = new Object[capacity]; // 생성자로 값을 받아서 배열의 크기를 설정하고 생성한다.
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
		// 객체배열의 크기 증가
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
		return size == 0; // 저장된 객체의 갯수 size가 0이면 아무 값도 없는 것.

	}

	void clear() {
		// 전체 배열 null
		for (int i = 0; i < size; i++) // size까지 지우기
			objArr[i] = null; // 값 없애기
		size = 0; // 객체배열 위치 초기화
	}

	void add(Object obj) {
		// objArr에 객체를 추가하는 메서드
		if (!(size < objArr.length))
			setCapacity(objArr.length + 1); // 범위보다 크면 현재 범위보다 1 증가시키고 값을 넣어준다.
		objArr[size++] = obj; // 들어온 값을 넣어주고 size를 증가시킨다.

	}

	Object get(int index) {
		// 저장된 객체를 반환
		return objArr[index];
	}

	public String toString() {
		// objArr에 저장된 모든 객첼ㄹ 문자열로 이어서 반환
		String tmp = "";
		for (int i = 0; i < size; i++)
			tmp = tmp + objArr[i]; // 반복문으로 순차적으로 합치기
		return tmp;
	}

	int indexOf(Object obj) {
		// 지정된 객체가 저장되어 있는 위치 반환
		for (int i = 0; i < size; i++) {
			if (objArr[i].equals(obj)) // 맞는 배열이 나오면 탈출
				return i;
		}
		return -1;
	}

	boolean remove(Object obj) {
		// indexOf()를 이용해서 지정된 객체 삭제

		int index = indexOf(obj); // 받은 값의 위치르 구한다. 없으면 -1이라 아래의 포문을 돌지 않음
		if (index >= 0) {
			// objArr[index] = null; //인덱스의 값을 null로 바꾼다. null로 해줄 필요 없음
			for (int i = index; i < size; i++) {
				try {
					objArr[i] = objArr[i + 1];// 한칸씩 앞댕겨서 값을 복사한다. 어차피 마지막값은 사라진다
				} catch (Exception e) { // 인덱스가 배열보다 크면 탈출
					break;
				}
			}

			objArr[size - 1] = null; // size의 마지막 값을 null로
			size = size > 0 ? size - 1 : size; // 사이즈가 0보다 크면 1만큼 출인다.
			return true;
		} else
			return false; // 0보다 작으면 탈출(같은 객체가없으면);

	}

}

class Test { // 테스트용 클래스
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
		Test t2 = new Test("2번테스트2 ");
		Test t3 = new Test("test3 ");
		Test t4 = new Test("네번째테스트4 ");
		Test t5 = new Test("오5오오5 ");
		Test t6 = new Test("test3 ");

		System.out.println("배열이 비었는가? = " + my.isEmpty());
		my.add(t6);
		my.add("123 ");
		my.add(t2);
		my.add(t3);
		my.add(t4);
		my.add(t5);
		my.add("문자열 ");
		System.out.println("값 보기 = " + my);
		System.out.println("capacity = " + my.capacity());
		System.out.println("size = " + my.size());
		System.out.println("배열이 비었는가? = " + my.isEmpty());
		System.out.println("t3의 위치 = " + my.indexOf(t3));
		System.out.println("삭제여부 = " + my.remove(t3));
		System.out.println("값 삭제 후 = " + my);

		System.out.println("size = " + my.size());
		System.out.println("2번 인덱스의 값 = " + my.get(2));
		my.add(t1);
		System.out.println("값 추가 후 = " + my);
		my.setCapacity(4);
		System.out.println("capacity = " + my.capacity());
		System.out.println("크기 변경 후 = " + my);
		my.add(t5);
		my.add(t5);
		my.add(t5);
		System.out.println("capacity = " + my.capacity());
		System.out.println("크기 변경 후 = " + my);
		System.out.println("삭제여부 = " + my.remove(t5));
		System.out.println("값 삭제 후 = " + my);
		my.clear();
		System.out.println("전체 값 삭제 후 = " + my);
	}

}
