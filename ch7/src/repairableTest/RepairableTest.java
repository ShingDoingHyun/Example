package repairableTest;

public class RepairableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();//��ũ��ü~
		Dropship dropship = new Dropship();//����ʰ�ü~

		// Marine marine = new Marine();
		SCV scv = new SCV();	
		scv.rapair(tank);	//scv�� ������ ��ũ ��ü�� ������~
		scv.rapair(dropship);
		// scv.rapair(marine);	//������ ������ �������̽����� ������� �ʾƼ� ���� �Ұ�����
	}

}

interface Repairable {
}

class Unit {
	int hitPoint;
	final int MAX_HP;

	Unit(int hp) {
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit {

	GroundUnit(int hp) {
		super(hp);

	}

}



class AirUnit extends Unit {

	AirUnit(int hp) {
		super(hp);

	}

}

class Tank extends GroundUnit implements Repairable {
	public Tank() {
		super(150);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "tank";
	}

}

class Dropship extends GroundUnit implements Repairable {
	public Dropship() {
		super(125);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Dropship";
	}

}

class Marine extends GroundUnit{	//��� ȸ�� �ȵ� �������̽��� ������
	public Marine() {
		super(40);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Marine";
	}

}

class SCV extends GroundUnit implements Repairable {
	public SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	public void rapair(Repairable r) {	//������ �������̽��� ����� �ֵ�
		if (r instanceof Unit) {	//���� ��ü�� ���ֿ��� �󵶵Ǿ����� üũ/��������
			Unit u = (Unit) r;		//�������� ����ȯ
			while (u.hitPoint != u.MAX_HP) {	//�Ǹ������� ȸ��
				u.hitPoint++;

			}
			System.out.println(u.toString());
		}
	}
}
