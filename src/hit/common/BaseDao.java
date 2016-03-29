package hit.common;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDao extends SqlMapClientDaoSupport{
	 
	@Resource(name = "SqlServerClient")
    private SqlMapClient sqlMapClient;



	@PostConstruct
    public void initSqlMapClient(){
        super.setSqlMapClient(sqlMapClient);
    } 
	
	
	
    
    

	
}
