/**
 * 
 */
package nmb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pw.jason19659.nmb.service.UserService;

/**
 * @author <a href="mailto:ziywang@cisco.com">Jason</a>
 *
 * nmb
 *
 * 2016年1月18日
 */
@ContextConfiguration(locations = { "classpath:spring-base.xml", "classpath:spring-mvc.xml", "classpath:spring-mybatis.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAll {
	@Autowired
	UserService userService;
	   
	   @Test
	   public void test () {
//		   userService.insert(new User().generateUser());
		   System.out.println(userService.selectByPrimaryKey("1299a2a4-2738-4bb1-b15a-2d8d68c5594c").toString());;
	   }
}
