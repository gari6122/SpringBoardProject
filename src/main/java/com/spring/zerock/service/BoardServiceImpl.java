package com.spring.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.zerock.domain.BoardVO;
import com.spring.zerock.domain.Criteria;
import com.spring.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;

	// 게시글 등록
	@Override
	public void register(BoardVO board) {
		
		mapper.register(board);
		
		log.info("글 등록 테스트" + board);
	}

	// 게시판 목록 조회
	@Override
	public List<BoardVO> getList() {
		
		return mapper.getList();
	}
	
	// 게시글 상세 조회
	@Override
	public BoardVO getRead(int bno) {
		log.info("글 상세 조회 기능 구현" + bno);
		return mapper.getRead(bno);
	}

	// 게시글 수정
	@Override
	public int modify(BoardVO board) {
		log.info("글 수정 처리" + board);
		return mapper.modify(board);
	}
	
	// 게시글 삭제
	@Override
	public int remove(int bno) {
		log.info("글 삭제 처리" + bno);
		return mapper.remove(bno);
	}

	// 게시판 목록(페이지 적용)
	@Override
	public List<BoardVO> getListPaging(Criteria cri) {
		return mapper.getListPaging(cri);
	}

	// 게시물 총 개수
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}
	
}
