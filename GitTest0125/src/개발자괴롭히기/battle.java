package 개발자괴롭히기;

import java.util.Random;

public class battle {

	
	Random ran = new Random();

	public double attack() {

		int luck = ran.nextInt(100) + god; // 치명타 확률

		int damage = ran.nextInt(100) + iq * 3; // 데미지에 지능수 만큼 추가 데미지

		if (luck > 90) {
			damage = (int) (damage * (1 + (0.1 * ma))); // 치명타 데미지
		}

		double attack = damage; // 최종 데미지

		return attack;
	}
	

}

	public double heal() {
		
	}
