package register;

import java.io.IOException;
import java.lang.reflect.Method;

import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO=new UserDAOJdbcImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean res;
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String password2=request.getParameter("again_pasword");
		long count=userDAO.getCountWithName(name);
		
		
		if(count>0){
		request.setAttribute("message", "用户名"+name+"已经被注册，请重新填写");
	    request.getRequestDispatcher("/register/register.jsp").forward(request, response);
	    
		return;
	
		}else if(!password.equals(password2)){
		//System.out.print("两次输入的密码不一致");
		request.setAttribute("message", "两次输入的密码不一致");
		request.getRequestDispatcher("/register/register.jsp").forward(request, response);
	}else if((res=isAcount(name,password))==true){
	
	
			User user=new User(name,password);
	
			userDAO.save(user);
	
			request.getSession().setAttribute("user", user);
	
			System.out.print("注册成功");
			request.getRequestDispatcher("/home page/home page.jsp").forward(request, response);
	
		}else{
		//System.out.print("注册失败");
		request.setAttribute("message", "注册失败");
		request.getRequestDispatcher("/register/register.jsp").forward(request, response);
		
	}
	}

	





	public boolean isAcount(String name,String password) {
		
		boolean acount=true;
		String manager;
		if(name==null&&name.trim().equals(" ")){
			acount=false;
			manager="用户名不能为空，请重新填写";
		} 
		if(password==null&&password.trim().equals(" ")){
			acount=false;
			manager="密码不能为空，请重新填写";
		}
		
		return acount;
	}
	

}
