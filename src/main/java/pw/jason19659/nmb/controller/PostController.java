/**
 * 
 */
package pw.jason19659.nmb.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pw.jason19659.nmb.model.Post;
import pw.jason19659.nmb.model.PostDto;
import pw.jason19659.nmb.model.Section;
import pw.jason19659.nmb.model.Status;
import pw.jason19659.nmb.model.User;
import pw.jason19659.nmb.service.PostService;
import pw.jason19659.nmb.service.SectionService;
import pw.jason19659.nmb.service.UserService;

/**
 * @author <a href="mailto:ziywang@cisco.com">Jason</a>
 *
 * pw.jason19659.nmb.controller
 *
 * 2016年1月18日
 */
@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private SectionService sectionService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<PostDto> getAllPost() throws Exception {
		List<Post> posts = postService.selectAll();
		return postService.getWithSubPosts(posts);
	}
	
	@RequestMapping("/get")
	@ResponseBody
	public PostDto getPostById(String id) throws Exception {
		Post p = postService.selectByPrimaryKey(id);
		return postService.getWithSubPost(p);
	}
	
	@RequestMapping("/reply")  
	@ResponseBody
	public Status reply(Post post,@RequestParam(required=false) String postId,@RequestParam(required=false ) Integer sectionId) {
		Status status = null;
		Post p = postService.selectByPrimaryKey(postId);
		if (p == null || !"0".equals(p.getPid()) ) { 
			status = new Status(Status.FAILED_CODE, "只能对主题进行回复");
		} else {
			Section s = sectionService.selectByPrimaryKey(sectionId);
			if(s == null) {
				status = new Status(Status.FAILED_CODE, "板块不存在");
			} else if (post.getContent() == null) {
				status = new Status(Status.FAILED_CODE, "内容不能为空");
			} else {
				String userId = post.getUserId();
				if (StringUtils.isEmpty(userId)) {
					User user = userService.getNewUser();
					post.setUserId(user.getId());
					post.setPid(postId);
					post.setSectionId(sectionId);
					post.setPubdate(new Date());
					post.setId(UUID.randomUUID().toString());
					postService.insert(post);
					status = new Status(Status.NEW_USER_CODE,user.toString()); 
				}else if (userService.isUserValidate(userId)) {
					post.setPid(postId);
					post.setSectionId(sectionId);
					post.setPubdate(new Date());
					post.setId(UUID.randomUUID().toString());
					postService.insert(post);
					status = Status.SUCCESSED;
				} else {
					status = new Status(Status.FAILED_CODE, "用户验证失败");
				}
			}
		}
		return status;
	}
}
