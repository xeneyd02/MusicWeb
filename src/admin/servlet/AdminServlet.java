package admin.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminDAO;
import admin.dao.AdminDAOJdbcImpl;
import admin.domain.Admin;
import admin.domain.CriteriaAdmin;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private AdminDAO adminDAO=new AdminDAOJdbcImpl();
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath=request.getServletPath();
		String methodName=servletPath.substring(1);
		methodName=methodName.substring(0,methodName.length()-3);
		try{
			Method method=getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		method.invoke(this, request,response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr=request.getParameter("id");
		Admin admin=adminDAO.get(Integer.parseInt(idStr));
	if(admin!=null){
		request.setAttribute("admin", admin);
		request.getRequestDispatcher("updatecustomer.jsp").forward(request, response);
		
	}
	
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id=0;
		id=Integer.parseInt(idStr);
		adminDAO.delete(id);
		response.sendRedirect("query.do");
	}
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name=request.getParameter("name");
//		String pass=request.getParameter("password");
//		CriteriaAdmin cc=new CriteriaAdmin(name,pass);
	
		
		
		List<Admin> admins=adminDAO.getAll();
		request.setAttribute("admins", admins);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
		
	}
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		long count = adminDAO.getCountWithName(name);
		if(count>0){
			request.setAttribute("message","管理员用户名"+name+"已经注册啦");
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
			return;
		}
		Admin admin=new Admin(name,pass);
		adminDAO.save(admin);
		response.sendRedirect("success.jsp");
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		String oldName=request.getParameter("oldName");
		if(!oldName.equalsIgnoreCase(name)){
			long count=adminDAO.getCountWithName(name);
			if(count>0){
				request.setAttribute("message", "管理员用户名"+name+"已经注册啦");
				request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
				return;
			}
		}
		Admin admin=new Admin(name,pass);
		admin.setAdminid(Integer.parseInt(id));
		adminDAO.update(admin);
		response.sendRedirect("query.do");
		
	}
}
