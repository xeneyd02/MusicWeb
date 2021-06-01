package Login.src.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Login.src.dao.CriteriaUser;
import Login.src.dao.UserDAO;
import Login.src.dao.UserDAOJdbcImpl;
import Login.src.domain.User;





public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO=new UserDAOJdbcImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
	    
		String validateCode=request.getParameter("validateCode");
		String validate_code=(String) request.getSession().getAttribute("validate_code");
		
		CriteriaUser cc=new CriteriaUser(name,password);
		
		
		List<User> users=userDAO.getForListWithCriteriaUser(cc);
		for(User user:users){
			if(user.getName().equals(name)&&user.getPassword().equals(password)){
				request.getSession().setAttribute("users", users);
				
			}else {
			//System.out.println("ÕËºÅÃÜÂë´íÎó£¬ÇëÖØĞÂÌîĞ´");
			request.setAttribute("message", "ÕËºÅÃÜÂë´íÎó£¬ÇëÖØĞÂÌîĞ´");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			
			}
			if(validateCode.equalsIgnoreCase(validate_code)){
				System.out.println("ÑéÖ¤ÂëÕıÈ·");
				response.sendRedirect("homePage/homePage.jsp");
				//request.getRequestDispatcher("/homePage/homePage.jsp").forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/homePage/homePage.jsp");
			}else{
				//System.out.println("ÑéÖ¤Âë´íÎó");
		
				request.setAttribute("message", "ÑéÖ¤Âë´íÎó");
				request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			}	
			
			
		
			
			}
		
	}

	



	



}
