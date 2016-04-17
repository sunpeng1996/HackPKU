package hit.service.impl;
/**
 *service实现类
 *@author sunpeng123
 */
import hit.common.BaseDao;
import hit.common.JavaMailUtils;
import hit.mapper.SchoolMapper;
import hit.mapper.UserCustomMapper;
import hit.mapper.UserMapper;
import hit.po.School;
import hit.po.User;
import hit.service.SchoolService;
import hit.service.UserService;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class UserServiceImpl extends BaseDao implements UserService {
	
	@Autowired 
	private UserMapper userMapper;
	@Autowired
	private UserCustomMapper userCustomMapper;
	@Autowired
	private SchoolMapper schoolMapper;
	@Autowired
	private SchoolService schoolService;
	
	@Override
	/**
	 * @author sunyiyou
	 * todo：根据email查询User对象
	 */
	public User selectByEmail(String email) {
		return userCustomMapper.selectUserByEmail(email);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String addUser(User user) {
		try {
			getSqlMapClientTemplate().insert("addUser", user);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	@Override
	public User getUserById(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
/**
 * @author sunpeng123
 * 更新用户
 */
	@SuppressWarnings("deprecation")
	public void updateUser(User user) {
		try {
			System.out.println("我想看看id，fuck"+user.getUserId());
		
			userMapper.updateByPrimaryKeySelective(user);
			System.out.println("正在更新用户："+user.getUsername());
			System.out.println(user.getUsername() + " 和  "+ user.getEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User login(String password, String email){
		Map map = new HashMap();
		map.put("email", email);
		map.put("password", password);
		List list = getSqlMapClientTemplate().queryForList("login", map);
		if (list.size() == 0 || list == null) {
			return null;
		} else {
			return (User)list.get(0);
		}
		
	}

	@Override
	/**
	 * @author sunpeng123
	 * todo:根据学校名称查询学习对象
	 */
	public School findSchoolBySchoolName(String schoolname) {
		try {
			List<School> schools = getSqlMapClientTemplate().queryForList("findSchoolBySchoolName", schoolname);
			if (schools.size()>0) {
				return (School)schools.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}
	public String findname(String face_id){
		return userMapper.getface(face_id);
	}

	/**
	 * @author sunpeng123
	 * 这是业务层处理用户完善数据的方法
	 */
	@Override
	public User update(HttpServletRequest request,User user, String username, String schoolname,
			String institute, String major, String time, String phone,
			String sex, String province, MultipartFile image,String scholar) {
		Integer id = user.getUserId();//获取当前用户id
		System.out.println("获取当前用户的id"+id);
		String email = user.getEmail();
		String password = user.getPassword();
		user.setEmail(email);
		user.setUserId(id);
		user.setPassword(password);
		user.setPhone(phone);
		user.setProvince(province);
		user.setUsername(username);
		user.setScholar(scholar);
		System.out.println("我想看看学历是===========================："+ scholar);
		System.out.println(user);
		//通过schoolname得到school对象
		School school = findSchoolBySchoolName(schoolname);	
		Integer schid = schoolService.selectSchidBySchoolName(schoolname);
		if(school==null){
			//说明school在数据库中没有，那么我们new一个就好了
			School temp = new School();
					
			temp.setSchoolname(schoolname);			
			schoolMapper.insert(temp);//持久化到数据库中	
			Integer tempid = schoolService.selectSchidBySchoolName(temp.getSchoolname());
			
			user.setSchId(tempid);
			user.setSchoolname(schoolname);
		}		else {
			user.setSchoolname(schoolname);
			user.setSchId(schid);
		}
		user.setMajor(major);
		user.setInstitute(institute);
		user.setTime(time);
		user.setSex(sex);
		user.setValidationstate(1);//设置用户的验证状态，1表示完善信息完毕，但未实名认证
		//以下为处理上传文件的代码
		if (!image.isEmpty()) {  
            try {  
            	String pathRoot = request.getSession().getServletContext().getContextPath();//获取物理路径webapp所在路径
            	String path="";  
            	String savepath  = request.getSession().getServletContext().getRealPath("/");
            	if(!image.isEmpty()){
            		//生成uuid作为文件名称
            		String uuid = UUID.randomUUID().toString().replace("-", "");
            		 
            		//获得文件类型，用于过滤和判断，现在先不做了
            	    String contentType=image.getContentType();  
            	    String imageName=contentType.substring(contentType.indexOf("/")+1); 
            	    path="/fileupload/"+uuid+"."+imageName;  
            		String imagePath = uuid+"."+imageName;  //这是用于显示到前台的名称
            	    image.transferTo(new File(savepath+path));  
            		user.setImage(imagePath);//入库
            		request.getSession().setAttribute("imagePath", imagePath);
            		System.out.println("老子想看看图片的路径：："+pathRoot + "  名称： "+ path);
            	}
            	
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
		return user;  
		
	}

	/**
	 * @author sunpeng123
	 * 这是业务层通过user的email更新用户的方法
	 */
	@Override
	public void updateUserByEmail(User user) {
		userCustomMapper.updateUserByEmail(user);
	}

	
	
	@SuppressWarnings("deprecation")
	@Override
	/**
	 * @author sunpeng123
	 * 这是用户加入俱乐部方法
	 */
	public void joinClub(Integer user_id, Integer clubId) {
			Map map = new HashMap();
			map.put("user_id", user_id);
			map.put("club_id", clubId);
			int requestType = 0;//这个字段在数据库中存在，为了以后扩充使用
			map.put("requestType", 0);
			try {
				getSqlMapClientTemplate().insert("insertIntoClubRequest",map);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
	}

	/**
	 * @author sunpeng123
	 * 判断用户是否已经提交过请求
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Boolean judgeRequest(Integer user_id, Integer clubId) {
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("club_id", clubId);
		List list = getSqlMapClientTemplate().queryForList("judgeRequest",map);
		if(list!=null){
			if(!list.isEmpty()){
				return true;//证明已经提交过一次
			}else {
				return false;//证明没有请求过
			}
		}else {
			return false;
		}
	}

	
	/**
	 * @author sunpeng123
	 * 这是用户找回密码的方法
	 */
	@Override
	public Boolean findPasswordByEmail(String email) {
	    User temp =  this.selectByEmail(email);
	    if (temp==null) {
			return false;
		}else {
			String password = temp.getPassword();
			JavaMailUtils.sendMail(email, "您的社团登录密码已经找回：请尝试登录", 
					"您好, "+ temp.getUsername()+"。您的密码是："+ password +"。请登录进行尝试，或及时登录修改密码。"
							+ "如果有任何疑问，请回复此邮件与开发人员进行联系");
			return true;
		}
		
	}
}

	



	

	

