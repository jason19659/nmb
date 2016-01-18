package pw.jason19659.nmb.service;

import java.util.List;

import pw.jason19659.nmb.model.Post;
import pw.jason19659.nmb.model.PostDto;

public interface PostService {
    int deleteByPrimaryKey(String id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(String id);
    
    List<Post> selectByPid(String pid);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
    
    public List<PostDto> getWithSubPosts(List<Post> posts) throws Exception;
    
    public PostDto getWithSubPost(Post p) throws Exception;

	List<Post> selectAll();
}