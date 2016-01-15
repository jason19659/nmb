package pw.jason19659.nmb.dao;

import java.util.List;

import pw.jason19659.nmb.model.Post;

public interface PostMapper {
    int deleteByPrimaryKey(String id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(String id);
    
    List<Post> selectByPid(String pid);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}