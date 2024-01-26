package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.MemberController;
import model.MemberDAO;
import model.MemberDTO;

public class MainSystem {

	public static void main(String[] args) {

		// MVC Pattern (Design Pattern 일종 )
		// Model View Controller
		// Model : 데이터를 묶고 데이터베이스에 접근하는 역할(DAO)
		// View : Client 화면에 보여주고 안내하고 입력받는 역할(Main System)
		// Controller : View 와 Model 을 이어주는 역할, 조종역할

		Scanner sc = new Scanner(System.in);
		MemberController controller = new MemberController();
		// 모든 기능에서 사용할 수 있도록 전역변수 dto, dao 생성

		MemberDTO dto = null;

		while (true) {
			// CRUD (create / read / update / delete)
			System.out.print("1.회원등록 2.로그인 3.회원목록 4.회원탈퇴 5.회원정보수정 6.프로그램 종료 >>> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("======회원등록=====");
				System.out.print("ID입력 : ");
				String id = sc.next();
				System.out.print("PW입력 : ");
				String pw = sc.next();
				System.out.print("이름입력 : ");
				String name = sc.next();
				System.out.print("나이입력 : ");
				int age = sc.nextInt();

				dto = new MemberDTO(id, pw, name, age);
				int cnt = controller.join(dto);

				if (cnt > 0) {
					System.out.println("회원 등록 성공");
				} else {
					System.out.println("회원 등록 실패");
				}

			} else if (menu == 2) {
				System.out.println("=====로그인=====");
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();

//				한번에 로그인 하려면 새로운 메소드를 하나 묶어서 만들면 됨
//				new MemberDTO(id, pw);

				MemberDTO info = controller.login(id, pw);

				if (info != null) {
					System.out.println(info.getName() + "님 환영합니다.");
				}

			} else if (menu == 3) {

				System.out.println("===전체 회원 정보 조회===");
				System.out.println("ID\tPW\tNAME\tAGE\t");
				ArrayList<MemberDTO> list = controller.memberList();
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i).getId() + "\t");
					System.out.print(list.get(i).getPw() + "\t");
					System.out.print(list.get(i).getName() + "\t");
					System.out.println(list.get(i).getAge() + "\t");
				}

			} else if (menu == 4) {

				System.out.println("====회원탈퇴====");
				System.out.print("ID 입력 : ");
				String id = sc.next();

				int cnt = controller.delete(id);

				if (cnt > 0) {
					System.out.println("탈퇴성공");
				} else {
					System.out.println("탈퇴실패");

				}

			} else if (menu == 5) {

				System.out.println("======회원정보 수정=====");
				// id 일치하는 회원의 pw,name,age 를 수정
				System.out.print("ID 입력");
				String id = sc.next();
				System.out.print("수정할 PW 입력 : ");
				String pw = sc.next();
				System.out.print("수정할 NAME 입력 : ");
				String name = sc.next();
				System.out.print("수정할 AGE 입력 : ");
				int age = sc.nextInt();

				dto = new MemberDTO(id, pw, name, age);
				int cnt = controller.update(dto);
				
				if (cnt > 0) {
					System.out.println("수정 성공");
				} else {
					System.out.println("수정 실패");
				}

			} else if (menu == 6) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				break;
			} else {
				System.out.println("정확한 숫자를 입력해주세요.");
			}
		}

	}

}
