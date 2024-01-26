package 개발자괴롭히기;

import java.util.ArrayList;
import model.MemberDAO;
import model.MemberDTO;

public class MemberController {

	private MemberDAO dao = new MemberDAO();

	public int join(MemberDTO dto) {
		return dao.join(dto);
	}

	public MemberDTO login(String id, String pw) {
		return dao.login(id, pw);
	}

	public ArrayList<MemberDTO> memberList() {
		return dao.memberList();

	}

	public int delete(String id) {
		return dao.delete(id);
	}

	public int update(MemberDTO dto) {
		
		return dao.update(dto);
	}
	
	
	

}
