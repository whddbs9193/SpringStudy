package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.BoardService;
/*
RequestMapping - 클라이언트의 요청경로를 컨트롤러에서 찾도록 하는 역할
ModelAttribute - RequestMapping 이전에 동작하며, 해당 내용을 모델(객체)로 만들어주는 역할
SessionAttributes - 객체를 세션으로 등록하여 사용하도록 하는 역할
*/

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertMethod() {
		System.out.println("=> BoardController - 글등록 화면이동");
		return "insertBoard.jsp";
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertMethod(BoardDTO dto) {
		System.out.println("=> BoardController - 글등록 처리(DB)");
		boardService.insertBoard(dto);
		return "redirect:getBoardList.do";
	}
	// SessionAttributes 와 ModelAttribute 애노테이션을 사용하여 update할 때 발생하는 null 업데이트를 방지할 수 있음.
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardDTO dto) {
		System.out.println("=> BoardController - 글수정 처리");
//		System.out.println("번호: " + dto.getSeq());
//		System.out.println("제목: " + dto.getTitle());
//		System.out.println("작성자: " + dto.getWriter());
//		System.out.println("내용: " + dto.getContent());
//		System.out.println("등록일: " + dto.getRegdate());
//		System.out.println("조회수: " + dto.getCnt());
		boardService.updateBoard(dto);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardDTO dto) {
		System.out.println("=> BoardController - 글삭제 처리");
		boardService.deleteBoard(dto);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardDTO dto, Model model) { //model 모델만 넘기는 클래스
		System.out.println("=> BoardController - 글상세 조회");
		model.addAttribute("board", boardService.getBoard(dto));
		return "getBoard.jsp";
	}
	
	// 검색 목록 설정
	@ModelAttribute("conditionMap") // RequestMapping 이전에 실행
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("작성자", "WRITER");
		return conditionMap;
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardDTO dto, Model model){
		System.out.println("=> BoardController - 글목록 조회");
		// 검색 확인 - searchCondition, searchKeyword가 null일 때의 처리
		if(dto.getSearchCondition() == null) dto.setSearchCondition("TITLE");
		if(dto.getSearchKeyword() == null) dto.setSearchKeyword("");
		
		
		model.addAttribute("boardList", boardService.getBoardList(dto));
		return "getBoardList.jsp";
	}
	
}

