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

	public int update(DeveloperDTO dto) {

		return dao.update(dto);
	}

	public ArrayList<CharcterDTO> memberlist() {
		
		return null;
	}


}
