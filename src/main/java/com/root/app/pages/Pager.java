package com.root.app.pages;

public class Pager {
	
	private Long startNum;
	private Long endNum;
	
	private Long page;
	
	private Long perPage;
	
	private Long totalPage;
	
	private Long startBlock;
	private Long endBlock;
	
	private boolean endCheck;
	
	private String kind;
	private String search;


	public void make(Long totalCount) {
		
		// TotalPage 계산
		Long totalPage = totalCount/10;
		if(totalCount % 10 != 0) {
			totalPage++;
		}
		
		// TotalBlock
		Long totalBlock = totalPage / 5;
		if(totalPage/5 != 0) {
			totalBlock++;
		}
		
		// Page 번호로 Block 계산
		Long curBlock = (this.getPage() + 4) / 5;
		
		// curBlock으로 시작번호와 끝번호 계산
		Long startBlock = (curBlock-1)*5 + 1;
		Long endBlock = curBlock*5;
		
		this.setTotalPage(totalPage);
		this.setStartBlock(startBlock);
		this.setEndBlock(endBlock);
		this.makeNum();
		
		if(totalBlock == curBlock) {
			this.setEndBlock(totalPage);
			this.setEndCheck(true);
		}
	}
	
	
	public void makeNum() {
		startNum = (getPage()-1) * getPerPage() + 1;
		endNum = getPage() * getPerPage();
	}
	
	public Long getPage() {
		if(this.page == null || page < 1) {
			this.page = 1L;
		}
		return page;
	}
	
	public String getKind() {
		if(this.kind == null) {
			this.kind = "k1";
		}
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}


	public boolean isEndCheck() {
		return endCheck;
	}
	
	public void setEndCheck(boolean endCheck) {
		this.endCheck = endCheck;
	}
	
	public Long getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(Long startBlock) {
		this.startBlock = startBlock;
	}

	public Long getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(Long endBlock) {
		this.endBlock = endBlock;
	}
	
	public Long getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getEndNum() {
		return endNum;
	}
	public void setEndNum(Long endNum) {
		this.endNum = endNum;
	}
	
	
}
