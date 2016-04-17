package hit.mapper;

import hit.po.User;
import hit.po.UserCustom;

public interface UserCustomMapper {

	UserCustom selectUserByEmail(String email);
	

	void updateUserByEmail(User user);
}
