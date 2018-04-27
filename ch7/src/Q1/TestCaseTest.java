package Q1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCaseTest {

	@Test
	public void test1() {
		assertTrue(baseBall("123", "321").equals( "S1B2")); 
	}
	
	@Test
	public void test2() {
		assertTrue(baseBall("123", "123").equals( "S3B0")); 
	}
	
	@Test
	public void test3() {
		assertTrue(baseBall("", "").equals( "0S0B")); 
	}
	
	@Test
	public void test4() {
		assertTrue(baseBall(null, null).equals( "0S0B")); 
	}

	@Test
	public void test5() {
		assertTrue(baseBall("1231", null).equals( "0S0B")); 
	}

	

	String baseBall(String s1, String s2) {
		int strike = 0;
		int ball = 0;
		
		if(s1==null || s2==null) return "0S0B";		//���� ������ 
		if(s1.length()!=3 || s2.length() !=3) return "0S0B";	//3ĭ�� �ƴϸ�
	
//		char[] s1Arr = s1.toCharArray();	//���ڿ� ���ڹ迭�� ����
//		char[] s2Arr = s2.toCharArray();
//
//		for(int i = 0; i< s1Arr.length; i++) {
//			for(int j=0; j< s2Arr.length;j++){
//	
//				if(s1Arr[i]==s2Arr[i]) {	//�ڸ��� �´� ���� ������ strike�� ���� �迭Ż��
//					strike++;
//					break;	
//				}else if(s1Arr[i]==s2Arr[j]) {	//�ڸ��� �´� ���� ������ ball�� ���� �迭Ż��
//					ball++;
//					break;
//				}	
//
//			}
//		}
		
		for(int i = 0; i< s1.length(); i++) {
			for(int j=0; j< s2.length();j++){
	
				if(s1.charAt(i)==s2.charAt(j)) {	//�ڸ��� �´� ���� ������ ball�� ���� �迭Ż��
					if(i==j)
						strike++;	
					else
						ball++;
					break;
				}	

			}
		}
				
		return "S"+strike+"B"+ball;
		
	}

}
