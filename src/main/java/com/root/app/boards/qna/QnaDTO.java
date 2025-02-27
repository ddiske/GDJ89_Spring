package com.root.app.boards.qna;

import com.root.app.boards.BoardDTO;

public class QnaDTO extends BoardDTO {
	
	private long boardRef;
	private long boardStep;
	private long boardDepth;
	
	
	
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
