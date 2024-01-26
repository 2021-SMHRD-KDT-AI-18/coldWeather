package 개발자괴롭히기;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class BattleDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	Random ran = new Random();

	public double attack(CharacterDTO cdto) {

		int it = cdto.getIntell(); // 지능 ( 데미지관련 스텟)
		int fp = cdto.getFp(); // 신앙력 ( 치명타확률 관련 스텟)
		int mp = cdto.getMp(); // 마력 ( 치명타 데미지 관련 스텟)

		int luck = ran.nextInt(100) + fp; // 치명타 확률
		int damage = ran.nextInt(100) + it * 3; // 데미지에 지능수 만큼 추가 데미지

		if (luck > 90) {
			damage = (int) (damage * (1 + (0.1 * mp))); // 치명타 데미지
		}
		double attack = damage; // 최종 데미지
		return attack;
		
		
	}

//	public double heal(CharacterDTO cdto) { // 현재 체력을 받아와야 하고 힐계수를 받는 스텟을 받아와야함
//		int Hp = cdto.getHealth(); // 체력 
//		
//		heal =
//		
//		
//		return heal;
//	}
	
	public boolean dodge(CharacterDTO cdto) {
		int mt = cdto.getMent(); // 정신력
		
		int dodge = ran.nextInt(100)+mt;
		
		if (dodge>95) {
			return true; // 회피성공
		}else {
			return false; // 회피실패
		}
		
	}

}