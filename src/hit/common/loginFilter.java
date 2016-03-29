package hit.common;
/**
 * 登录过滤器
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class loginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String path = request.getRequestURI();
		/*
		User user = (User)session.getAttribute("user");
		
		if (path.toLowerCase().indexOf(".swf") > 0 || path.toLowerCase().indexOf(".html") > 0 || path.toLowerCase().indexOf(".jpg") > 0 || path.toLowerCase().indexOf(".bmp") > 0 || path.toLowerCase().indexOf(".gif") > 0 || path.toLowerCase().indexOf(".png") > 0 || path.toLowerCase().indexOf(".css") > 0 || path.toLowerCase().indexOf(".js") > 0 || path.toLowerCase().indexOf("login") > 0) {
			chain.doFilter(request, response);
			return;
		}
		if (user == null || "".equals(user.getUSER_ID())) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {*/
			chain.doFilter(request, response);
		//}
	}

	public void destroy() {
		
	}

}
