/**
 * 
 */
package pw.jason19659.nmb.model;

import java.util.List;

/**
 * @author <a href="mailto:ziywang@cisco.com">Jason</a>
 *
 * pw.jason19659.nmb.model
 *
 * 2016年1月15日
 */
public class PostDto extends Post{
	List<Post> subPosts;

	public List<Post> getSubPosts() {
		return subPosts;
	}

	public void setSubPosts(List<Post> subPosts) {
		this.subPosts = subPosts;
	}
	
}
