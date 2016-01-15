/**
 * 
 */
package pw.jason19659.nmb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pw.jason19659.nmb.dao.PostMapper;
import pw.jason19659.nmb.model.Post;
import pw.jason19659.nmb.service.PostService;

/**
 * @author <a href="mailto:ziywang@cisco.com">Jason</a>
 *
 * pw.jason19659.nmb.service.impl
 *
 * 2016年1月15日
 */
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostMapper postMapper;
	/* 
	 * @see pw.jason19659.nmb.service.PostService#deleteByPrimaryKey(java.lang.String)
	 */
	public int deleteByPrimaryKey(String id) {
		return postMapper.deleteByPrimaryKey(id);
	}

	/* 
	 * @see pw.jason19659.nmb.service.PostService#insert(pw.jason19659.nmb.model.Post)
	 */
	public int insert(Post record) {
		return postMapper.insert(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.PostService#insertSelective(pw.jason19659.nmb.model.Post)
	 */
	public int insertSelective(Post record) {
		return postMapper.insertSelective(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.PostService#selectByPrimaryKey(java.lang.String)
	 */
	public Post selectByPrimaryKey(String id) {
		return postMapper.selectByPrimaryKey(id);
	}

	/* 
	 * @see pw.jason19659.nmb.service.PostService#selectByPid(java.lang.String)
	 */
	public List<Post> selectByPid(String pid) {
		return postMapper.selectByPid(pid);
	}

	/* 
	 * @see pw.jason19659.nmb.service.PostService#updateByPrimaryKeySelective(pw.jason19659.nmb.model.Post)
	 */
	public int updateByPrimaryKeySelective(Post record) {
		return postMapper.updateByPrimaryKey(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.PostService#updateByPrimaryKey(pw.jason19659.nmb.model.Post)
	 */
	public int updateByPrimaryKey(Post record) {
		return postMapper.updateByPrimaryKey(record);
	}

}
