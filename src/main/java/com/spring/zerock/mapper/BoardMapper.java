package com.spring.zerock.mapper;

import java.util.List;

import com.spring.zerock.domain.BoardVO;
import com.spring.zerock.domain.Criteria;

public interface BoardMapper {

	// 게시글 등록 
	public void register(BoardVO board);

	// 게시판 목록
	public List<BoardVO> getList();
	
	// 게시글 상세조회
	public BoardVO getRead(int bno);
	
	// 게시글 수정
	public int modify(BoardVO board);

	// 게시글 삭제
	public int remove(int bno);
	
	// 게시판 목록(페이징 적용)
	public List<BoardVO> getListPaging(Criteria cri);
	
	// 게시판 총 개수
	// 페이징까지 구현했을 당시에는 getTotal메서드 쿼리에 추가 데이터가 필요 없었기 때문에 파라미터가 없었다.
	// 검색 기능 구현에는 keyword 데이터를 전달할 수 있도록 파라미터를 추가해야 한다.
	public int getTotal(Criteria cri);
}
