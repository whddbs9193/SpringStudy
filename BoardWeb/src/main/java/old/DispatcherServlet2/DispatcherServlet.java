package old.DispatcherServlet2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		// Controller 요소들을 초기 등록
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 1. 클라이언트의 요청 정보를 통해 *.do를 추출
		String uri = request.getRequestURI();
		// "/"를 기준으로 경로를 추출함
		String path = uri.substring(uri.lastIndexOf("/"));
		
		// 2. HandlerMapping에서 path에 해당하는 Controller를 검색
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색한 Controller를 실행
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver를 통해서 완전한 view를 생성
		String view = null;		
		//.do를 포함하지 않으면 viewName뒤에 .jsp를 붙이고 사용
		if(!viewName.contains(".do")) {	
			view = viewResolver.getView(viewName);
		} else { // .do를 포함한다면 그대로 viewName 사용
			view = viewName;
		}
		
		// 5. 화면 이동
		response.sendRedirect(view);
		
	}
	
}
