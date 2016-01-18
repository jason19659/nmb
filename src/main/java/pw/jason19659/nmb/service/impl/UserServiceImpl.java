/**
 * 
 */
package pw.jason19659.nmb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pw.jason19659.nmb.dao.UserMapper;
import pw.jason19659.nmb.model.User;
import pw.jason19659.nmb.service.UserService;

/**
 * @author <a href="mailto:ziywang@cisco.com">Jason</a>
 *
 * pw.jason19659.nmb.service.impl
 *
 * 2016年1月15日
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper UserMapper;
	/* 
	 * @see pw.jason19659.nmb.service.UserService#deleteByPrimaryKey(java.lang.String)
	 */
	public int deleteByPrimaryKey(String id) {
		return UserMapper.deleteByPrimaryKey(id);
	}

	/* 
	 * @see pw.jason19659.nmb.service.UserService#insert(pw.jason19659.nmb.model.User)
	 */
	public int insert(User record) {
		return UserMapper.insert(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.UserService#insertSelective(pw.jason19659.nmb.model.User)
	 */
	public int insertSelective(User record) {
		return UserMapper.insertSelective(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.UserService#selectByPrimaryKey(java.lang.String)
	 */
	public User selectByPrimaryKey(String id) {
		return UserMapper.selectByPrimaryKey(id);
	}


	/* 
	 * @see pw.jason19659.nmb.service.UserService#updateByPrimaryKeySelective(pw.jason19659.nmb.model.User)
	 */
	public int updateByPrimaryKeySelective(User record) {
		return UserMapper.updateByPrimaryKey(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.UserService#updateByPrimaryKey(pw.jason19659.nmb.model.User)
	 */
	public int updateByPrimaryKey(User record) {
		return UserMapper.updateByPrimaryKey(record);
	}

	/* 
	 * @see pw.jason19659.nmb.service.UserService#getNewUser()
	 */
	public User getNewUser() {
		User u = new User().generateUser();
		System.err.println(u.getId());
		System.err.println(u.getPassword());
		System.err.println(u.getPubDate());
		insert(u);
		return u;
	}

	/* 
	 * @see pw.jason19659.nmb.service.UserService#isUserValidate(java.lang.String)
	 */
	public boolean isUserValidate(String userId) {
		boolean flag = false;
		try {
			String id = userId.split(";")[0];
			String key = userId.split(";")[1];
			if (key.equals(selectByPrimaryKey(id).getPassword())) {
				flag = true;
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

}
