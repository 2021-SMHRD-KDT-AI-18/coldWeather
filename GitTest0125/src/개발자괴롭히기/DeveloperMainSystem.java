package 개발자괴롭히기;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import oracle.net.aso.s;

public class DeveloperMainSystem {

	public static void main(String[] args) {

		// MVC Pattern (Design Pattern 일종 )
		// Model View Controller
		// Model : 데이터를 묶고 데이터베이스에 접근하는 역할(DAO)
		// View : Client 화면에 보여주고 안내하고 입력받는 역할(Main System)
		// Controller : View 와 Model 을 이어주는 역할, 조종역할

		Scanner sc = new Scanner(System.in);
		DeveloperController controller = new DeveloperController();
		// 모든 기능에서 사용할 수 있도록 전역변수 dto, dao 생성

		DeveloperDTO dto = null;
		CharacterDTO cdto = null;

		while (true) {
			// CRUD (create / read / update / delete)
			System.out.println(
					"                                                 ;~                 -~,                             \n"
							+ "                                                 ,@;   $@@#         @@#                             \n"
							+ "                                         .!      .#@  -@@@@.       :@@@                             \n"
							+ "                 -                       ;@@#      ,#, ~@@@@;        @@@           -@;               \n"
							+ "                                        @@@@,       @.#@@@@;       ~@@.          -@@@#        .     \n"
							+ "                              .        ,@@@@@       ;*@@@;;       -#@$           ~@@@.        ;#@*  \n"
							+ "                            .@@@.      $@@##~       .@@@@.        #@@@.          ~@@@.        =@#!  \n"
							+ "                           -@@@@!     $@#@-         .@@@@=     .  $@@@!          !@@$         @@$!  \n"
							+ "                          ;@@@@@;     =#@@@         !@@@@@.       #@@@!         $@@$~        -$=@!  \n"
							+ "                         @@@@@@@#     $@@@@         .@@@@@.       #@@@!        .@@@@@-       *=@@!  \n"
							+ "                        #@@@@!,~,    !@@@@@!        .@@@@@.       *@@@!      !~;@@@@@@~      *@@@!  \n"
							+ "                       $@@@@@        *@@@@@          @@@@@.        @@@@-     $=@@@@@@@;      *$@@!  \n"
							+ "   .        $         ,@@@@@.        *@@@@@          =@@@@.        @@@@@.    $@@@@@@@@@         $!  \n"
							+ "          !@@#;       *@@@@@         *@@@$@!         $@@@@@;      #@@@=;$~   $@@@@@@##@@@!!-! ~!#$  \n"
							+ "        ,@@@@@*      .@@@@@#         *@@@@=@-       -@@@@#@!     .@@@@! .$-  $@@@@@@=-$@@@@@@@@@@@@;\n"
							+ "       *@@@@@@@,     $@@@@@#         *@@@@,;@       @@@@@=.@     .@@@@!   ,  $@@@@@@=  @@@@@@@@@@@@@\n"
							+ "     -@@@@@@@@@.    -@@@@@##@:       @@@@#  *:      !@@@@$ ;#     ;@@@!      *@@@@@@=         ;@@@  \n"
							+ "    -@@@@@@@@;      ;@@@@@-.$@$      $@@@$   #       =@@@@. #~     @@@@      *@@@@@@$..       ;@@@  \n"
							+ "   =@@@@@@@@@;       @@@#@!  *@.     .@@@#   @       *@@@@. .@     @@@@=    .@@@@@@@@@@$$!    ;@@@  \n"
							+ "  ;@@@@@@@@@@;       !@##@@  ~       .@@@#. !=       =@@@@.       -@@@@@.    #!$@@@@@@@@@@=   ;@@@  \n"
							+ "  @@@@@@$@@@@;       ;@@@@@,         !@@@@@          *@@@@.       #@@-@@~    $!.@@@@@@@@@@@   ;@@@  \n"
							+ " !@@@@@;  =@@@!       @@@@@#         *@@@@@!         .@@@@.       !@# #@$    #$@@@@@@@@@@@@   ;@@@  \n"
							+ "  @@@@@;  !@@@@*,     ;@@@@@         *@@ =@=         ;@@@@.       #@$ :@@    $@*=#@@***=@@@   ;@@@  \n"
							+ "  !@@@@@.  @@@@@@     #$=@@@         @@@ .@@        @@@@@@.      -@@. :@@        :@@   .@@@   ;@@@  \n"
							+ "  ,@@@@@*  .#@#~@@,  :@@~@@@       ,@@#  .@@       *#@$ @@.      @@*  ~@@         @@   .@@@   ;@@@  \n"
							+ "  *@@:.@#    #@--##  !@# =@=       ;@#   .@@      ,@@=  @@.      @@    @@         $@   .@@@   ;@@@  \n"
							+ " $@@- .@#     @# @#  !@- .$*       @@     $@      #@-   @$      :@~    @@.        ~@   .@@@   ;@@@  \n"
							+ "*@@~  ~@=     !#     !#. .@!      ~@      :@-    *@!    @$      *@.     @*      :;*@;;..@@@   ;@@@  \n"
							+ "-@;   #@*     !@!    @@,  @@      $@       #@.   ~@!    #=      *@.     *=... @@@#$#@@@@@@@:. ;@@@  \n"
							+ " $@   @@#=    #@!   !@@$= @@$,    -@$.     :@#=.  $@*   @$$=    @@$     *@@@,*@,@.  ,#*@@@@@#.!@@@  \n"
							+ "  ~:  !$@!,   .!~      ;!;!!!!;    .!~     -!!!!   :!.  !!!!;   ~!!!    .!    ! !~  .!-    -- !!*!, ");
			System.out.println();
			System.out.println(
					"                                                                                                    \n"
							+ "                              .              .                .                                     \n"
							+ "                         .** .=*,           .:*:              ~=;      ;**********,                 \n"
							+ "                  ,-----..$@, @@-      ---   ;@!     ------,  ~@$      !========@@-                 \n"
							+ "                  :!!!$@~ ~@= @@- ,::, *@@   ;@!     !!!#@=~  ~@$      -::::::::@@-                 \n"
							+ "                      !@~ ~@= @@- -#@*-:@@   ;@!        *@-   ~@$      :!@@!!!!!!!,                 \n"
							+ "                      !@~ ~@= @@-  *@@##@@   ;@*...    .=#-   ~@$       .@#.......                  \n"
							+ "                     ,*#- ~@$-@@-  *@; ,@@   ;@#**!    @@-    ~@$-,,    .*********,                 \n"
							+ "                     *@!  ~@@#@@-  *@; ,@@   ;@!       @@-    ~@@###-                               \n"
							+ "                    .$#:  ~@= @@-  !######   ;@!     .$#-=~.  ~@$     ~#############;               \n"
							+ "                    ;@~   ~@= @@-  .......   ;@!     .$. =#;  ~@$      .............                \n"
							+ "                   @@-    ~@= @@-            ;-      $,   !!  ~@$       .@@@@@@@@@-                 \n"
							+ "                  !..     ~@= @@-    ~=======#$:   .=.    !!  ~@$        .......@@-                 \n"
							+ "                  -       ~@= @@-    .~~~~~~~*@!    -     ,,  ~@$       .*******@@-                 \n"
							+ "                          ~@= @@-    :#######@@!              ~@$        ;@$                        \n"
							+ "                          ~@: @@-    -!@@!!!!!!~              ~@$        ;@$                        \n"
							+ "                          .,  @-       :@$=====;              ~@,        .-@======-                 \n"
							+ "                              $        ,$######;              -$           #######-                 \n"
							+ "                                                                                                    \n"
							+ "                                                                                                    \n"
							+ "                                                                                                    \n"
							+ "                                     -!~               !;.             :!-                          \n"
							+ "                                     ;@$               @@-             =@;                          \n"
							+ "                          .-@==@;    ;@$    ====$@$    @@-  ;=====@@-  =@;                          \n"
							+ "                          ;@=  @@    ;@$        ;@$    @@-        @@-  =@;                          \n"
							+ "                         ,@@    =@;  ;@$        ;@$-#@@@@-       .@@-  =@;                          \n"
							+ "                         ,@@    =@;  ;@$        ;@$    @@-  *@@@@@@@-  =@;                          \n"
							+ "                         ,@@    =@;  ;@$       :#!,    @@-  .~@@,,,,   =@#$$!                       \n"
							+ "                          ;@*  #@.   ;@$       ;@: -$##@@-   ,@#       =@!..                        \n"
							+ "                          -;#;;@*    ;@$      ~==, .;;;@@-   ,@#     ;-=@;                          \n"
							+ "                            ,,,,     ;@$     ;@!.      @@-    !@=====,.=@;                          \n"
							+ "                                     ;@$    -!=~       @@-    ~======  =@;                          \n"
							+ "                                     ;@$    :.         @@-             =@;                          \n"
							+ "                                     ;@$               @@-             =@;                          \n"
							+ "                                     ;@$               @@-             =@;                          \n"
							+ "                                     ;@=               @@-             =@;                          \n"
							+ "                                     :=                #.              **                           \n"
							+ "                                                                                                    \n"
							+ "                                                                                                    ");

			System.out.println("===================== 1.회원등록====================");
			System.out.println("===================== 2.로그인=====================");
			System.out.print(" >>> ");
			int menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("======회원등록=====");
				System.out.print("ID입력 : ");
				String id = sc.next();
				System.out.print("PW입력 : ");
				String pw = sc.next();

				dto = new DeveloperDTO(id, pw);
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

				DeveloperDTO info = controller.login(id, pw);

				if (info != null) {
					System.out.println(info.getId() + "님 환영합니다.");
					break;
				} else {
					System.out.println("정확한 정보를 입력해주세요.");

				}
			}
		}

		while (true) {
			System.out.println("=======1.게임시작======");
			System.out.println("=======2.랭킹확인======");
			int menu = sc.nextInt();

			// 1. 게임시작
			if (menu == 1) {
				break;
			}
			// 2. 랭킹

			else if (menu == 2) {
				System.out.println("====랭킹 조회====");
				ArrayList<CharacterDTO> list = controller.CharacterList();// 나중에 characterDTO로 변경
				for (int i = 0; i < list.size(); i++) {
					System.out.print((i+1) +"위>>" + list.get(i).getName() + "\t");

				}
				System.out.println();
				System.out.println();
			}

		}
		// 캐릭터 생성 및 능력치 분배

		while (true) {

			System.out.println("캐릭터를 생성합니다.");
			System.out.print("이름을 입력해주세요 :");
			String name = sc.next();
			System.out.println("능력치를 분배해주세요");
			System.out.println("1.체력 2.지능 3.신앙력 4.마력 5.정신력");
			System.out.print("체력 : ");
			int health = sc.nextInt();
			System.out.print("지능 : ");
			int intelligence = sc.nextInt();
			System.out.print("신앙력 : ");
			int faithPower = sc.nextInt();
			System.out.print("마력 : ");
			int magicPower = sc.nextInt();
			System.out.print("정신력 : ");
			int mentality = sc.nextInt();
			int salary = 0;

			cdto = new CharacterDTO(name, health, intelligence, faithPower, magicPower, mentality, salary);
			// CharacterDTO 만들어지면 컨트롤러에 입력해서 받아오면 됨
			int cnt = controller.inputStats(cdto);

			if (cnt > 0) {
				System.out.println("분배가 완료되었습니다 게임을 시작합니다");
				break;
			} else {
				System.out.println("능력치 분배 실패");
			}

		}
		
 		//배틀 시스템
		
		
		
		System.out.println("대결을 시작합니다");
		
		int stage = 1;
		while(true) {
		if(stage == 1) {
			enemy e1 = new enemy("pbkMK1", 50, 50, 50, 50, 50); 
		}else if (stage==2) {
			enemy e1 = new enemy("pbkMK2", 60, 60, 60, 60, 60);
		}else if (stage==3) {
			enemy e1 = new enemy("pbkMK3", 70, 70, 70, 70, 70);
		}
		
		System.out.println("Round "+stage+" 그 ~ 상대는 : " + e1.name); // 상대이름 출력
	
		while(true) {
			System.out.println("행동을 선택하시오 1.공격 2.회복 3.회피");
			int menu = sc.nextInt();
			if(menu == 1) { // 공격
				controller.battle.attack();   //플레이어 공격
			}
			else if(menu == 2) { // 회복
				controller.battle.heal();
			}
			else if(menu == 3) { // 회피
				controller.battle.dodge();
			}
			if (e1.hp =< 0) { // 적체력 0이하 일떄
				break; 
				stage++; // 다음스테이지
			}else if ( CharacterDTO.hp =<0) { //플레이어 체력 0이하 일때
				delet.name; // 캐삭
				break;
				
			}
		}

		// 승리시

		// 실패시

		// 3단계 클리어시
	}
}