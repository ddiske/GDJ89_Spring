package com.root.app.products;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository

public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.root.app.products.ProductDAO.";
	
//	list
	public List<ProductDTO> getList()throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
//		statement => mapper의 id값
		return sqlSession.selectOne(NAMESPACE+"getDetail", productDTO);
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"add", productDTO);
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", productDTO);
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", productDTO);
	}

}
