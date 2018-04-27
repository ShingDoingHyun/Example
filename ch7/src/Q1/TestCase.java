package Q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {
	int[] arr1 = {};
	int[] arr2 = {};

	@Test // ���� �پ��־�� �׽�Ʈ�� �Ѵ�. �׽�Ʈ ��� @Test�� ���δ�.
	public void test1() { // �� �޼��尡 ���� �޼��� ���� �������� ���� main()
		assertTrue(cmpArr(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 }) == true); // assert�� �����ϴ� �޼��� ����
	}

	@Test
	public void test2() {
		assertTrue(cmpArr(new int[] { 1, 2, 3 }, new int[] { 1, 2, 4 }) == false);
	}

	@Test
	public void test3() {
		assertTrue(cmpArr(null, null) == true);
	}

	
	//�� int �迭�� ���ؼ� ������ true �ٸ��� false�� ��ȯ
	boolean cmpArr(int[] arr1, int[] arr2) {
		// �� �迭�� ���̰� ���ų� ������ ������ true, �ƴϸ� false
		
		if (arr1 == null && arr2 == null)	//�Ѵ� null�ΰ�� true����
			return true;
				
		if (arr1 == null || arr2 == null || arr1.length != arr2.length) 
			// �迭���� ���� ���ų�(�迭��null�ϰ�� length���� �����߻�) ���� ���̰� �ٸ���� false�� ����
			return false;

		for (int i = 0; i < arr1.length; i++) {
			if (!(arr1[i] == arr2[i])) // ������� 0~�迭�� ������ ���� ���ؼ� �ٸ����� ������ false�� ���� if(!(arr1[1] == arr2[1]))
				return false;
		}
		return true;	//�迭�� ���� ������� true�� ����
	}

}
