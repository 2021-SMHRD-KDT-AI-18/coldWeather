package 개발자괴롭히기;

public class CharacterDTO {

	// 필드
		private int name;
		private int health;
		private int intelligence;
		private int faithPower;
		private int magicPower;
		private int mentality;
       
		
		// 생성자 메소드

		public public CharacterDTO(String id, String pw, String name, int age) {
			super();
			this.id = id;
			this.pw = pw;
			this.name = name;
			this.age = age;
		}

		// getter 메소드

		public DeveloperDTO(String id, String pw) {
			super();
			this.id = id;
			this.pw = pw;
		}

		public String getId() {
			return id;
		}

		public String getPw() {
			return pw;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	
	
	
}
