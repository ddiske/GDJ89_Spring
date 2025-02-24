package com.root.app.pages;

public class Pager {
	
	private Long startNum;
	private Long endNum;
	
	private Long page;
	
	private Long perPage;
	
	private Long totalPage;
	


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
