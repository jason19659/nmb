/**
 * 
 */
package pw.jason19659.nmb.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pw.jason19659.nmb.model.Post;
import pw.jason19659.nmb.model.PostDto;
import pw.jason19659.nmb.service.PostService;

/**
 * @author <a href="mailto:ziywang@cisco.com">Jason</a>
 *
 * pw.jason19659.nmb.controller
 *
 * 2016年1月15日
 */
@RestController
@RequestMapping("/")
public class TestController {
	@Autowired
	private PostService postService;
	
	@RequestMapping("/index2")
	@ResponseBody
	public List<PostDto> getIndex() {
		List<PostDto> lists = new LinkedList<PostDto>();
		PostDto p1 = new PostDto();
		p1.setContent("魅族闹特2今年年中买到现在，各种黑屏卡死假死，有时候严重了信号都要被卡断一会儿。。是不是这个价位的机器都这样？");
		p1.setId("123");
		p1.setPid(0+"");
		p1.setPubdate(new Date());
		p1.setSectionId(1);
		List<Post> posts = new ArrayList<Post>();
		Post p = new Post();
		p.setContent("不，就魅族");
		posts.add(p);
		posts.add(p);
		posts.add(p);
		p1.setSubPosts(posts);
		lists.add(p1);
		lists.add(p1);
		lists.add(p1);
		return lists;
	}
	
	@RequestMapping("/index")
	@ResponseBody
	public List<PostDto> getIndex2() throws IllegalAccessException, InvocationTargetException {
		List<Post> posts = postService.selectByPid(0+"");
		List<PostDto> lists = new LinkedList<PostDto>();
		for (Post p : posts) {
			PostDto postDto = new PostDto();
			BeanUtils.copyProperties(postDto, p);
			postDto.setSubPosts(postService.selectByPid(p.getId()));
			lists.add(postDto);
		}
		return lists;
	}
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().length());
	}
}
