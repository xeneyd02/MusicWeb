package admin.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.UsersDAO;
import admin.dao.UsersDAOJdbcImpl;
import admin.domain.Users;
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDAO=new UsersDAOJdbcImpl();
    public UsersServlet() {
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
		Users users=usersDAO.get(Integer.parseInt(idStr));
	if(users!=null){
		request.setAttribute("users", users);
		request.getRequestDispatcher("updatecustomer4.jsp").forward(request, response);
		
	}
	
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id=0;
		id=Integer.parseInt(idStr);
		usersDAO.delete(id);
		response.sendRedirect("query.co");
	}
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name=request.getParameter("name");
//		String pass=request.getParameter("password");
//		CriteriaAdmin cc=new CriteriaAdmin(name,pass);
	
		
		
		List<Users> users=usersDAO.getAll();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
		
	}
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		long count = usersDAO.getCountWithName(name);
		if(count>0){
			request.setAttribute("message","用户名"+name+"已经注册啦");
			request.getRequestDispatcher("/newcustomer4.jsp").forward(request, response);
			return;
		}
		Users users=new Users(name,pass);
		usersDAO.save(users);
		response.sendRedirect("success4.jsp");
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		String oldName=request.getParameter("oldName");
		if(!oldName.equalsIgnoreCase(name)){
			long count=usersDAO.getCountWithName(name);
			if(count>0){
				request.setAttribute("message", "用户名"+name+"已经注册啦");
				request.getRequestDispatcher("/newcustomer4.jsp").forward(request, response);
				return;
			}
		}
		Users users=new Users(name,pass);
		users.setId(Integer.parseInt(id));
		usersDAO.update(users);
		response.sendRedirect("query.co");
		
	}
}
