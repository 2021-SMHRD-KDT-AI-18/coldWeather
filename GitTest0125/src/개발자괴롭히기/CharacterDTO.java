package 개발자괴롭히기;

public class CharacterDTO {

	// 필드
		private int name;
		private int hp;
		private int intell;
		private int fp;
		private int mp;
		private int ment;
		private int salary;
       
		
		// 생성자 메소드

		public CharacterDTO(int name, int hp, int intell, int fp, int mp, int ment,0) {
			super();
			this.name = name;
			this.hp = hp;
			this.intell = intell;
			this.fp = fp;
			this.mp = mp;
			this.ment = ment;
			this.salary = 0;
		}

		// getter 메소드
		
		public int getName() {
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
	
		public String getSalary() {
			return salary;
		}
	
	
}
