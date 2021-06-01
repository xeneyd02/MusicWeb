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
		request.setAttribute("message", "�û���"+name+"�Ѿ���ע�ᣬ��������д");
	    request.getRequestDispatcher("/register/register.jsp").forward(request, response);
	    
		return;
	
		}else if(!password.equals(password2)){
		//System.out.print("������������벻һ��");
		request.setAttribute("message", "������������벻һ��");
		request.getRequestDispatcher("/register/register.jsp").forward(request, response);
	}else if((res=isAcount(name,password))==true){
	
	
			User user=new User(name,password);
	
			userDAO.save(user);
	
			request.getSession().setAttribute("user", user);
	
			System.out.print("ע��ɹ�");
			request.getRequestDispatcher("/home page/home page.jsp").forward(request, response);
	
		}else{
		//System.out.print("ע��ʧ��");
		request.setAttribute("message", "ע��ʧ��");
		request.getRequestDispatcher("/register/register.jsp").forward(request, response);
		
	}
	}

	





	public boolean isAcount(String name,String password) {
		
		boolean acount=true;
		String manager;
		if(name==null&&name.trim().equals(" ")){
			acount=false;
			manager="�û�������Ϊ�գ���������д";
		} 
		if(password==null&&password.trim().equals(" ")){
			acount=false;
			manager="���벻��Ϊ�գ���������д";
		}
		
		return acount;
	}
	

}
