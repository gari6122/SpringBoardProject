package com.spring.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.zerock.domain.BoardVO;
import com.spring.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;	
	
	// 게시판 목록 테스트
//	@Test
//	public void testGetList() {
//		
//		List list = mapper.getList();
//		// 일반적 for문
////		for(int i = 0; i < list.size(); i++) {
////			log.info("" + list.get(i));
////		}
//		
//		// foreach문(for문 향상)
////		for(Object a : list) {
////			log.info("" + a);
////		}
//		
//		// foreach문 & 람다식
//		list.forEach(board -> log.info("" + board));
//	}
	
	// 게시글 등록 테스트
//	 @Test
//     public void testRegister() {
//         
//         BoardVO vo = new BoardVO();
//         
//         vo.setTitle("mapper test4");
//         vo.setContent("mapper test4");
//         vo.setWriter("mapper test4");
//         
//         mapper.register(vo);
//         
//     }
	
	// 게시글 상세 조회 테스트
//	@Test
//	public void testGetRead() {
//		
//		int bno = 8;
//		
//		log.info("" + mapper.getRead(bno));
//	}
	
	// 게시글 수정 테스트
//	@Test
//	public void testModify() {
//		
//		BoardVO vo = new BoardVO();
//		
//		vo.setBno(2);
//		vo.setTitle("title modify");
//		vo.setContent("content modify");
//		
//		int result = mapper.modify(vo);
//		log.info("result : " + result);
//		
//	}
	
	// 게시글 삭제 테스트
//	@Test
//	public void testRemove() {
//		
//		int result = mapper.remove(27);
//		log.info("result : " + result);
//		
//	}
	
	// 게시판 목록(페이징 적용) 테스트
	@Test
	public void testGetListPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(100);
		List list = mapper.getListPaging(cri);
		list.forEach(board -> log.info("" + board));
	}

}

