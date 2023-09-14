package com.spring.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	// 게시글 번호
	private int bno;
	
	// 게시글 제목
	private String title;
	
	// 게시글 내용
	private String content;
	
	// 게시글 작성자
	private String writer;
	
	// 게시글 등록 날짜
	private Date regDate;
	
	// 게시글 수정 날짜
	private Date updateDate;
	
	
}
