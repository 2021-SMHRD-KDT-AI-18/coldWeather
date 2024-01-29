package 개발자괴롭히기;

public class CharacterDTO {

	// 필드
	private String name;
	private int hp;
	private int intell;
	private int fp;
	private int mp;
	private int ment;
	private int salary;

	public CharacterDTO(String name, int hp, int intell, int fp, int mp, int ment, int salary) {
		super();
		this.name = name;
		this.hp = hp;
		this.intell = intell;
		this.fp = fp;
		this.mp = mp;
		this.ment = ment;
		this.salary = salary;
	}

//      name 메소드
	public CharacterDTO(String name) {
		super();
		this.name = name;
	}

	// state 메소드

	public CharacterDTO(int hp, int intell, int fp, int mp, int ment) {
		super();
		this.hp = hp;
		this.intell = intell;
		this.fp = fp;
		this.mp = mp;
		this.ment = ment;

	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getIntell() {
		return intell;
	}

	public int getFp() {
		return fp;
	}

	public int getMp() {
		return mp;
	}

	public int getMent() {
		return ment;
	}

	public int getSalary() {
		return salary;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}