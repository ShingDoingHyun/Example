package repairableTest;

public class RepairableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();//탱크객체~
		Dropship dropship = new Dropship();//드랍십객체~

		// Marine marine = new Marine();
		SCV scv = new SCV();
		scv.rapair(tank);	//scv의 리페어로 탱크 객체를 보내자~
		scv.rapair(dropship);
		// scv.rapair(marine);
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

class Marine extends GroundUnit{
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
		if (r instanceof Unit) {
			Unit u = (Unit) r;	
			while (u.hitPoint != u.MAX_HP) {
				u.hitPoint++;

			}
			System.out.println(u.toString());
		}
	}
}
