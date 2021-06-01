package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpFilter implements Filter{

	private FilterConfig filterConfig;
	
	public void destroy(){
		
	}
	
	public void doFilter(ServletRequest servletRequest,ServletResponse servletResponse,FilterChain filterChain)
	throws IOException , ServletException{
		
		HttpServletRequest request=(HttpServletRequest) servletRequest;
		HttpServletResponse response=(HttpServletResponse) servletResponse;
		doFilter(request,response,filterChain);
	}
	
	public abstract void doFilter(HttpServletRequest Request,HttpServletResponse Response,FilterChain filterChain)throws IOException , ServletException;

	public void init(FilterConfig filterConfig){
		
		this.filterConfig=filterConfig;
		init();
	}
	
	protected void init(){}
	
	public FilterConfig getFilterConfig(){
		return filterConfig;
	}


}
