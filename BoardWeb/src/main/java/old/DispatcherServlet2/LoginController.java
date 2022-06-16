package old.DispatcherServlet2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.member.MemberDTO;
import com.springbook.biz.member.impl.MemberDAO;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		// 1. 클라이언트의 입력정보를 획득
		String memberid = request.getParameter("id");
		String pwd = request.getParameter("password");
		// 2. 객체 생성 및 DB 연동
		MemberDTO dto = new MemberDTO();
		dto.setId(memberid);
		dto.setPassword(pwd);
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO member = memberDAO.getMember(dto);
		// 3. 화면 이동 제어
		// rs에 의해서 결과값이 반환된다면
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberid", member.getId());
			return "getBoardList.do";
		} else {
			return "login";
		}
	
	}
	
}
