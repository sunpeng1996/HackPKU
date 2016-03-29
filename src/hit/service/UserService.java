package hit.service;

import org.springframework.stereotype.Component;

import hit.po.User;

/**
 * 用户Service接口
 * @author 作者: 如今我已·剑指天涯
 * @Description:
 *创建时间:2016年3月29日下午11:13:33
 */
@Component
public interface UserService {
		public User login();

		public User selectByEmail(String email);
		
		
}
