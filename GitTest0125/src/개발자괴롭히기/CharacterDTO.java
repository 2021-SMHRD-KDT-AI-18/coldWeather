package 개발자괴롭히기;

public class CharacterDTO {

	// 필드
		private int name;
		private int health;
		private int intelligence;
		private int faithPower;
		private int magicPower;
		private int mentality;
		private String salary;
       
		
		// 생성자 메소드

		public CharacterDTO(int name, int health, int intelligence, int faithPower, int magicPower, int mentality, String salary) {
			super();
			this.name = name;
			this.health = health;
			this.intelligence = intelligence;
			this.faithPower = faithPower;
			this.magicPower = magicPower;
			this.mentality = mentality;
			this.salary = salary;
		}

		// getter 메소드

		public int getName() {
			return name;
		}

		public int getHealth() {
			return health;
		}

		public int getIntelligence() {
			return intelligence;
		}

		public int getFaithPower() {
			return faithPower;
		}
		
		public int getMagicPower() {
			return magicPower;
		}
		
		public int getMentality() {
			return mentality;
		}
	
		public String getSalary() {
			return salary;
		}
	
	
}
