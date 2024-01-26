package 개발자괴롭히기;

import java.util.ArrayList;

public class DeveloperController {

	private DeveloperDAO dao = new DeveloperDAO();

	public int join(DeveloperDTO dto) {
		return dao.join(dto);
	}

	public DeveloperDTO login(String id, String pw) {
		return dao.login(id, pw);
	}

	public ArrayList<DeveloperDTO> memberList() {
		return dao.memberList();

	}

	public int delete(String id) {
		return dao.delete(id);
	}

<<<<<<< HEAD
	public int update(MemberDTO dto) {
=======
	public int update(DeveloperDTO dto) {
>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-AI-18/nameless2.git

		return dao.update(dto);
	}

}
