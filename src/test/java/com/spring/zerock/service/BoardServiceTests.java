package com.spring.zerock.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.zerock.domain.BoardVO;
import com.spring.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	
//	@Test
//	public void testExist() {
//		log.info(service);
//		assertNotNull(service);
//	}

//	@Test
//	public void testRegister() {
//		BoardVO vo = new BoardVO();
//		vo.setTitle("서비스 테스트를 위한 제목글 입니다!");
//		vo.setContent("서비스 테스트를 위한 내용글 입니다!");
//		vo.setWriter("테스터");
//		
//		service.register(vo);
//	}
	
	// 게시판 목록 조회 테스트
//	@Test
//	public void testGetList() {
//		service.getList().forEach(board -> log.info("" + board));
//	}

	// 게시글 상세 조회 테스트
//	@Test
//	public void testGetRead() {
//		int bno = 2;
//		log.info("" + service.getRead(bno));
//	}
	
	// 게시글 수정 테스트
//	@Test
//	public void testModify() {
//		BoardVO vo = new BoardVO();
//		vo.setBno(3);
//		vo.setTitle("xxxmodify");
//		vo.setContent("xxxmodifycontent");
//		
//		int result = service.modify(vo);
//		log.info("result : " + result);
//	}
	
	// 게시글 삭제 테스트
//	@Test
//	public void testRemove() {
//		int bno = 26;
//		log.info("" + service.remove(bno));
//	}
	
	// 게시글 목록(페이징 적용) 테스트
	@Test
	public void testGetListPagint() {
		Criteria cri = new Criteria();
		List list = service.getListPaging(cri);
		list.forEach(board -> log.info("" + board));
	}
	
}
