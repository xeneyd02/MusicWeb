package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class AllCharacterFilter extends HttpFilter {

	
	
	@Override
	public void doFilter(HttpServletRequest Request, HttpServletResponse Response, FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String encoding=getFilterConfig().getInitParameter("encoding");
		if(encoding==null){
			encoding="UTF-8";
		}
		Request.setCharacterEncoding(encoding);
		Response.setCharacterEncoding(encoding);
		Response.setContentType("text/html; charset="+encoding);
		MyHttpServletRequest myRequest=new MyHttpServletRequest(Request);
		filterChain.doFilter(myRequest,Response);
		
		
	}

	class MyHttpServletRequest extends HttpServletRequestWrapper{

		public MyHttpServletRequest(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}
		
		public String getParameter(String name){
			String value=super.getParameter(name);
			if(value!=null){
				String method=super.getMethod();
				if("get".equalsIgnoreCase(method)){
					try{
						value=new String(value.getBytes("ISO-8859-1"),super.getCharacterEncoding());
						
					}catch(UnsupportedEncodingException e){
						e.printStackTrace();
					}
				}
			}
			return value;
		}
	}
   

}
