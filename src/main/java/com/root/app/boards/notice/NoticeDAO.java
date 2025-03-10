package com.root.app.boards.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.root.app.boards.BoardDAO;
import com.root.app.boards.BoardDTO;
import com.root.app.boards.BoardFileDTO;
import com.root.app.pages.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPCAE = "com.root.app.boards.notice.NoticeDAO.";
	
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPCAE+"getTotalCount", pager);
	}
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPCAE+"getList", pager);
	}
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPCAE+"getDetail", boardDTO);
	}
	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPCAE+"add", boardDTO);
	}
	public int addFile(BoardFileDTO boardFileDTO)throws Exception{
		return sqlSession.insert(NAMESPCAE+"addFile", boardFileDTO);
	}
	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPCAE+"update", boardDTO);
	}
	@Override
	public int updateHit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPCAE+"updateHit", boardDTO);
	}
	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPCAE+"delete", boardDTO);
	}
	
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPCAE+"getFileDetail", boardFileDTO);
	}
	
	public int fileDelete(BoardFileDTO boardFileDTO) throws Exception{
		return sqlSession.delete(NAMESPCAE+"fileDelete", boardFileDTO);
	}
 
}
