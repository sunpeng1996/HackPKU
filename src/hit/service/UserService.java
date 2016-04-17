package hit.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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

		
		public User getUserById(Integer userId);
		
		//在第一次注册后自动调用的方法
		public User update(HttpServletRequest request, User user,
				String username, String schoolname, String institute,
				String major, String time, String phone, String sex,
				String province, MultipartFile image, String scholar);

		public void updateUserByEmail(User user);

		/**
		 * @author 作者: 如今我已·剑指天涯
		 *创建时间:2016年4月16日下午8:46:07
		 */
		public void joinClub(Integer user_id, Integer clubId);

		/**
		 * 
		 * @author 作者: 如今我已·剑指天涯
		 * @Description:判断用户是否已经提交请求的方法
		 *创建时间:2016年4月16日下午9:58:34
		 */
		public Boolean judgeRequest(Integer user_id, Integer clubId);

		public Boolean findPasswordByEmail(String email);
}
