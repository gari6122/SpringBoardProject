package com.spring.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.zerock.domain.BoardVO;
import com.spring.zerock.domain.Criteria;
import com.spring.zerock.domain.PageMakerDTO;
import com.spring.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;
import oracle.net.aso.r;

@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardservice;
	
	// 게시물 목록 페이지 접속
//	@GetMapping("/list")
//	public void listGET(Model model) {
//		log.info("게시판 목록 페이지");
//		model.addAttribute("list", boardservice.getList());
//	}
	
	// 게시판 목록(페이징 적용)
	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) {
		log.info("boardListGET");
		model.addAttribute("list", boardservice.getListPaging(cri));
		
		int total = boardservice.getTotal(cri);
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		model.addAttribute("pageMaker", pageMake);
		
	}

	// 게시글 등록 페이지 접속
	@GetMapping("/register")
	public void registerGET() {
		log.info("게시판 등록 페이지");
	}
	
	// 게시글 등록
	@PostMapping("/register")
	public String registerPOST(BoardVO board, RedirectAttributes rttr) {
		// String 리턴 값은 주로 화면이동, 리다이렉트, 뷰 이름반환
		boardservice.register(board);
		rttr.addFlashAttribute("result", "register success");
		return "redirect:/board/list";
	}
	
	// 게시글 상세 조회
	@GetMapping("/get")
	public void boardReadGET(int bno, Model model, Criteria cri) {
		model.addAttribute("pageInfo", boardservice.getRead(bno));
		model.addAttribute("cri", cri);
	}
	
	// 게시글 수정페이지 이동
	@GetMapping("/modify")
	public void ModifyGET(int bno, Model model, Criteria cri) {
		model.addAttribute("pageInfo", boardservice.getRead(bno));
		model.addAttribute("cri", cri);
	}
	
	// 게시글 수정
	@PostMapping("/modify")
	public String ModifyPOST(BoardVO board, RedirectAttributes rttr) {
		boardservice.modify(board);
		rttr.addFlashAttribute("result", "modify success");
		return "redirect:/board/list";
	}
	
	// 게시글 삭제
	@PostMapping("/remove")
	public String RemovePOST(int bno, RedirectAttributes rttr) {
		boardservice.remove(bno);
		rttr.addFlashAttribute("result", "remove success");
		return "redirect:/board/list";
	}
	

	
}
