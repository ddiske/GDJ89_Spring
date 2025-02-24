package com.root.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.root.app.pages.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPCAE = "com.root.app.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPCAE+"getList", pager);
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPCAE+"getDetail", noticeDTO);
	}
	
	public int add(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPCAE+"add", noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPCAE+"update", noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.delete(NAMESPCAE+"delete", noticeDTO);
	}
	
	public int updateHit(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPCAE+"updateHit", noticeDTO);
	}
	
	public Long getTotalCount() throws Exception {
		return sqlSession.selectOne(NAMESPCAE+"totalCount");
	}
 
}
