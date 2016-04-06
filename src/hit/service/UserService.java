package hit.service;

import org.springframework.stereotype.Component;

import hit.po.School;
import hit.po.User;

/**
 * 用户Service接口
 * @author 作者: 如今我已·剑指天涯
 * @Description:
 *创建时间:2016年3月29日下午11:13:33
 */
@Component
public interface UserService {
		//public User login(String password, String email);

		public User selectByEmail(String email);
		
		public String addUser(User user);

		public void updateUser(User user);

		public User login(String password, String email);

		//通过schoolname得到school对象
		public School findSchoolBySchoolName(String schoolname);

		
	
		
		
}
