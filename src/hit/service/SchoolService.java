package hit.service;

import org.springframework.stereotype.Component;

import hit.po.School;
import hit.po.User;

/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:school类的接口
 *创建时间:2016年3月30日下午7:57:27
 */
@Component
public interface SchoolService {
	
		//通过schoolname查询schid
			public int selectSchidBySchoolName(String schoolname);
		
		
}
