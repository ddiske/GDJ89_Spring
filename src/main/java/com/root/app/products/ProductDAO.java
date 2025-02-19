package com.root.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestAttributes;

import com.root.app.utils.DBConnection;

@Repository

public class ProductDAO {
	
//	list
	public List<ProductDTO> getList()throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("productnum"));
			productDTO.setProductName(rs.getString("productname"));
			productDTO.setProductRate(rs.getDouble("productrate"));
			productDTO.setProductDetail(rs.getString("productdetail"));
			
			ar.add(productDTO);
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1, productDTO.getProductNum());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO.setProductNum(rs.getLong("productnum"));
			productDTO.setProductName(rs.getString("productname"));
			productDTO.setProductRate(rs.getDouble("productrate"));
			productDTO.setProductDate(rs.getDate("productdate"));
			productDTO.setProductDetail(rs.getString("productdetail"));
		}else {
			productDTO = null;
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return productDTO;
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTS"
				+ " VALUES (PDT_NUM_SEQ.NEXTVAL, ?, ?, SYSDATE, ?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, productDTO.getProductName());
		st.setDouble(2, productDTO.getProductRate());
		st.setString(3, productDTO.getProductDetail());
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;		
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE PRODUCTS SET PRODUCTNAME = ?, PRODUCTRATE = ?, PRODUCTDATE = ?, PRODUCTDETAIL = ?"
				+ " WHERE PRODUCTNUM = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, productDTO.getProductName());
		st.setDouble(2, productDTO.getProductRate());
		st.setDate(3, productDTO.getProductDate());
		st.setString(4, productDTO.getProductDetail());
		st.setLong(5, productDTO.getProductNum());
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, connection);
		
		return result;
	}

}
