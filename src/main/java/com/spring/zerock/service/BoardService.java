package com.spring.zerock.service;

import java.util.List;

import com.spring.zerock.domain.BoardVO;
import com.spring.zerock.domain.Criteria;

public interface BoardService {

	// 게시글 등록
	public void register(BoardVO board);
	
	// 게시물 목록 조회
	public List<BoardVO> getList();

	// 특정 게시물 가져오기
	public BoardVO getRead(int bno);
	
	// 게시물 수정
	public int modify(BoardVO board);
	
	// 게시물 삭제
	public int remove(int bno);
	
	// 게시판 목록(페이징 적용)
	public List<BoardVO> getListPaging(Criteria cri);

	// 게시판 총 개수
	public int getTotal(Criteria cri);
}
