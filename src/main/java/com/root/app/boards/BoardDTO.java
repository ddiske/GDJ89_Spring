package com.root.app.boards;

import java.sql.Date;

public class BoardDTO {

	private long boardNum;
	private String userName;
	private String boardTitle;
	private String boardContents;
	private Date boardDate;
	private long boardHit;
	
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
	
}
