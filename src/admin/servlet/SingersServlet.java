package admin.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.SingersDAO;
import admin.dao.SingersDAOJdbcImpl;
import admin.domain.Singers;

/**
 * Servlet implementation class SingersServlet
 */
public class SingersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private SingersDAO singersDAO=new SingersDAOJdbcImpl();
	
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
		Singers singers=singersDAO.get(Integer.parseInt(idStr));
	if(singers!=null){
		request.setAttribute("singers", singers);
		request.getRequestDispatcher("updatecustomer3.jsp").forward(request, response);
		
	}
	
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id=0;
		id=Integer.parseInt(idStr);
		singersDAO.delete(id);
		response.sendRedirect("query.bo");
	}
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name=request.getParameter("name");
//		String pass=request.getParameter("password");
//		CriteriaAdmin cc=new CriteriaAdmin(name,pass);
	
		
		
		List<Singers> singers=singersDAO.getAll();
		request.setAttribute("singers", singers);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
		
	}
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String singername=request.getParameter("singername");
		
		long count = singersDAO.getCountWithName(singername);
		if(count>0){
			request.setAttribute("message","管理员用户名"+singername+"已经注册啦");
			request.getRequestDispatcher("/newcustomer3.jsp").forward(request, response);
			return;
		}
		Singers singers=new Singers(singername);
		singersDAO.save(singers);
		response.sendRedirect("success3.jsp");
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String singerid=request.getParameter("singerid");
		String singername=request.getParameter("singername");
		String oldName=request.getParameter("oldName");
		if(!oldName.equalsIgnoreCase(singername)){
			long count=singersDAO.getCountWithName(singername);
			if(count>0){
				request.setAttribute("message", "管理员用户名"+singername+"已经注册啦");
				request.getRequestDispatcher("/newcustomer3.jsp").forward(request, response);
				return;
			}
		}
		Singers singers=new Singers(singername);
		singers.setSingerid(Integer.parseInt(singerid));
		singersDAO.update(singers);
		response.sendRedirect("query.bo");
		
	}
}
