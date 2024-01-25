import java.util.Random;
import java.util.Scanner;

public class pdg {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("횟수 입력 : ");
		int num = sc.nextInt();
		Random ran = new Random();

		for (int i = 0; i < num; i++) {
			int goo = ran.nextInt(45) + 1;
			System.out.print(goo + "\t");

		}

	}

}
