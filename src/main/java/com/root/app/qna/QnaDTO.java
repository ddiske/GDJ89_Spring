package com.root.app.qna;

import java.sql.Date;

public class QnaDTO {
	
	
	private long boardNum;
	private String userName;
	private String boardTitle;
	private String boardContents;
	private Date boardDate;
	private long boardHit;
	private long boardRef;
	private long boardStep;
	private long boardDepth;
	
	
	
	
	
	public long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(long boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public long getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(long boardHit) {
		this.boardHit = boardHit;
	}
	public long getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(long boardRef) {
		this.boardRef = boardRef;
	}
	public long getBoardStep() {
		return boardStep;
	}
	public void setBoardStep(long boardStep) {
		this.boardStep = boardStep;
	}
	public long getBoardDepth() {
		return boardDepth;
	}
	public void setBoardDepth(long boardDepth) {
		this.boardDepth = boardDepth;
	}
	
}
