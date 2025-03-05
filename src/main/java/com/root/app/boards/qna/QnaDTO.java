package com.root.app.boards.qna;

import java.util.List;

import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardFileDTO;

public class QnaDTO extends BoardDTO {
	
	private long boardRef;
	private long boardStep;
	private long boardDepth;
	
	private List<BoardFileDTO> boardFileDTOs;
	
	
	
	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}
	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
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
