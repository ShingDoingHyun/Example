package equalsEx2;


class Person{
	long id;
	public boolean equals(Object obj) {
		if(obj instanceof Person)
			return id == ((Person)obj).id;
		
		return false;
	}
	public Person(long id) {
		this.id = id;
	}
}
public class EqualaEx2 {

	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);
	
		if(p1==p2)	//�ּҰ��� �ٸ���.
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		else
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
		
		if(p1.equals(p2))	//id�� ����.
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		else
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
	
	}

}

