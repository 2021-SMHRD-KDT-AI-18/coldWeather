package 개발자괴롭히기;

import java.util.Random;

public class battle {

	int hp = 1; // 체력 = 생명력 관여
	int iq = 1; // 지능 = 데미지 관여 1p당 3데미지 추가
	int god = 1; // 신앙력 = 치명타 확률 기본 치명타 확률 10% + 1당 1% 90p 찍으면 100퍼 치명타
	int ma = 1; // 마력 = 치명타 데미지 1p 10%
	int madi = 1; // 정신력 = 회피율
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
