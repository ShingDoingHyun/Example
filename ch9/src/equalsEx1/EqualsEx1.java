package equalsEx1;

public class EqualsEx1 {

	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2))	//�ּҰ��� �ٸ���.
			System.out.println("v1�� v2�� �����ϴ�.");
		else
			System.out.println("v1�� v2�� �ٸ��ϴ�.");
		
		v2 = v1;	//v1�� �ּҰ��� ����ȴ�.
		
		if(v1.equals(v2))	//�ּҰ� ����.
			System.out.println("v1�� v2�� �����ϴ�.");
		else
			System.out.println("v1�� v2�� �ٸ��ϴ�.");
	}

}

class Value{
	int value;
	
	public Value(int value) {
		this.value = value;
	}
}
