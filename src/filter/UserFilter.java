package filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */
public class UserFilter extends HttpFilter {

	String userSessionKey;
	String uncheckedUrls;
	String rediretUrl;
	
	protected void init(){
		ServletContext servletContext=getFilterConfig().getServletContext();
		userSessionKey=servletContext.getInitParameter("userSessionKey");
		uncheckedUrls=servletContext.getInitParameter("uncheckedUrls");
		rediretUrl=servletContext.getInitParameter("rediretUrl");
	}
	@Override
	public void doFilter(HttpServletRequest Request, HttpServletResponse Response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String servletPath=Request.getServletPath();
		List<String> urls=Arrays.asList(uncheckedUrls.split(","));
		if(urls.contains(uncheckedUrls)){
			filterChain.doFilter(Request, Response);
			return;
		}
		Object user=Request.getSession().getAttribute(userSessionKey);
		if(user==null){
			Response.sendRedirect(rediretUrl);
		return;
		}
		filterChain.doFilter(Request, Response);
		
	}


}
