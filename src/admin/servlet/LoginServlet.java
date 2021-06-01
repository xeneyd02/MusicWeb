package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminDAO;
import admin.dao.AdminDAOJdbcImpl;
import admin.domain.Admin;
import admin.domain.CriteriaAdmin;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminDAO adminDAO=new AdminDAOJdbcImpl();
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String name=request.getParameter("name");
	String pass=request.getParameter("password");
	
	CriteriaAdmin cc=new CriteriaAdmin(name,pass);
	List<Admin> admins=adminDAO.getForListWithCriteriaAdmin(cc);
	for(Admin admin:admins){
		if(admin.getAdminname().equals(name)&&admin.getAdminpassword().equals(pass)){
			request.getSession().setAttribute("adminuser", admins);
			System.out.print("SUCCESS");
			response.sendRedirect("main.jsp");
			return;
		}else{
			request.setAttribute("message", "’À∫≈√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ÃÓ–¥");
		   request.getRequestDispatcher("/home.jsp").forward(request, response);
		   
		}
	}
	
	}

}
