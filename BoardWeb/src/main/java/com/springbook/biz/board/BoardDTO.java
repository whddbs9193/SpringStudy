package com.springbook.biz.board;

import java.sql.Timestamp;

public class BoardDTO {
	// property
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Timestamp regdate;
	private int cnt;

	// 검색기능 property

	private String searchCondition;
	private String searchKeyword;

	public int getSeq() {
		return seq;
	}

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regdate=" + regdate + ", cnt=" + cnt + ", searchCondition=" + searchCondition + ", searchKeyword="
				+ searchKeyword + "]";
	}

}
