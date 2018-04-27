package Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {
	int[] arr1 = {};
	int[] arr2 = {};

	@Test // 이케 붙어있어야 테스트를 한다. 테스트 대상에 @Test를 붙인다.
	public void test1() { // 이 메서드가 메인 메서드 같은 느낌같은 느낌 main()
		assertTrue(cmpArr(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }) == true); // assert로 시작하는 메서드 실행
	}

	@Test
	public void test2() {
		assertTrue(cmpArr(new int[] { 1, 2, 3 }, new int[] { 1, 2, 4 }) == false);
	}

	@Test
	public void test3() {
		assertTrue(cmpArr(null, null) == true);
	}

	
	//두 int 배열을 비교해서 같으면 true 다르면 false를 반환
	boolean cmpArr(int[] arr1, int[] arr2) {
		// 두 배열의 길이가 같거나 내용이 같으면 true, 아니면 false
		
		if (arr1 == null && arr2 == null)	//둘다 null인경우 true리턴
			return true;
				
		if (arr1 == null || arr2 == null || arr1.length != arr2.length) 
			// 배열들의 값이 없거나(배열이null일경우 length에서 에러발생) 둘의 길이가 다를경울 false를 리턴
			return false;

		for (int i = 0; i < arr1.length; i++) {
			if (!(arr1[i] == arr2[i])) // 순서대로 0~배열의 끝까지 값을 비교해서 다른값이 나오면 false를 리턴 if(!(arr1[1] == arr2[1]))
				return false;
		}
		return true;	//배열의 값이 같은경우 true를 리턴
	}

}
