package hit.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.BeansException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.ibatis.sqlmap.client.SqlMapClient;

public class Util {
		
	/*
	 * 
	 * ƴ�ӷ�ҳMysqlSql
	 * 
	 */
	public static String getPageSqlForMysql(String sql,int page_size,int currentPage){
		String temlSql ="SELECT u.* FROM ("+sql+") u LIMIT "+(currentPage-1)*page_size+" , "+page_size;
		return temlSql;
	}
	
	
	
	
	/*
	 * 
	 * ƴ�ӷ�ҳOracleSql
	 * 
	 */
	public static String getPageSqlForOracle(String sql,int page_size,int currentPage){
		
		
		
		String temlSql="SELECT * FROM "+
		"( "+
		"SELECT A.*, ROWNUM RN "+
		"FROM (SELECT * FROM (  "+sql+"   )) A "+
		"WHERE ROWNUM<="+currentPage*page_size+
		") "+
		"WHERE RN>"+(currentPage-1)*page_size;
		
		
		return temlSql;
	}
	
	
	/*
	 * 
	 *��װ��ҳ��Ϣ
	 * 
	 */
	public static PageBean getPageBean(int page_size,int currentPage,List list,Map map,int allsize){
		PageBean pageBean = new PageBean();
        pageBean.setPageSize(page_size);    
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allsize);
        pageBean.setTotalPage(PageBean.countTotalPage(page_size, pageBean.getAllRow()));
        pageBean.setList(list);
        pageBean.setParamMap(map);
        pageBean.init();
		return pageBean;
	}
	
	
	 public static String jsonStr(Object str){
	    	
			JSONObject jsonObj = JSONObject.fromObject(str);
			  
			 return jsonObj.toString();
	    	
	    }

	    public static String jsonListStr(List list){
	    	
	    	JSONArray jsonObj = JSONArray.fromObject(list);
			  
			 return jsonObj.toString();
	    	
	    }
	
	public static String getOption(String sql){
		StringBuffer sb=new StringBuffer();
		ResultSet rs=null;
		Connection conn=null;
		java.sql.Statement st=null;
		sb.append("<option value=''>请选择</option>");
		try {
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			SqlMapClient sqlMapClient=(SqlMapClient)wac.getBean("SqlServerClient");
			conn=sqlMapClient.getDataSource().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				sb.append("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");
			}
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				conn.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	 public  String getProperties(String key) throws IOException{
	    	Properties pro = new Properties();
	    	java.io.InputStream in = this.getClass().getClassLoader().getResourceAsStream("conf.properties");
			pro.load(in);
			String regional=pro.getProperty(key);
			String resultName=new String(regional.getBytes("ISO-8859-1"),"utf-8"); 
	    	return resultName;
	    }

}
