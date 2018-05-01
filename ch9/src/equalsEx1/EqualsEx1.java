package equalsEx1;

public class EqualsEx1 {

	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2))	//주소값이 다르다.
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
		
		v2 = v1;	//v1의 주소값이 저장된다.
		
		if(v1.equals(v2))	//주소가 같다.
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
	}

}

class Value{
	int value;
	
	public Value(int value) {
		this.value = value;
	}
}
