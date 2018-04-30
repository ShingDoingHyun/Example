package repairableTest;

public class RepairableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();//탱크객체~
		Dropship dropship = new Dropship();//드랍십객체~

		// Marine marine = new Marine();
		SCV scv = new SCV();	
		scv.rapair(tank);	//scv의 리페어로 탱크 객체를 보내자~
		scv.rapair(dropship);
		// scv.rapair(marine);	//마린은 리페어러블 인터페이스에서 궁축되지 않아서 리페어가 불가능함
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

class Marine extends GroundUnit{	//얘는 회복 안됨 인터페이스를 받지않
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

	public void rapair(Repairable r) {	//리페어러블 인터페이스로 구축된 애들
		if (r instanceof Unit) {	//받은 객체가 유닛에게 상독되었는지 체크/유닛인지
			Unit u = (Unit) r;		//유닛으로 형병환
			while (u.hitPoint != u.MAX_HP) {	//피만땅으로 회복
				u.hitPoint++;

			}
			System.out.println(u.toString());
		}
	}
}
