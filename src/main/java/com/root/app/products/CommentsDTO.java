package com.root.app.products;

import com.root.app.boards.CommentDTO;

public class CommentsDTO extends CommentDTO {
	
	private Long productNum;

	public Long getProductNum() {
		return productNum;
	}

	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	
}
