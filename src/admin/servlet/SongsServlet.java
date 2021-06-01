package admin.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.SongsDAO;
import admin.dao.SongsDAOJdbcImpl;

import admin.domain.CriteriaSongs;
import admin.domain.Songs;



public class SongsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SongsDAO songsDAO=new SongsDAOJdbcImpl();
    public SongsServlet() {
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

	private void edit1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr=request.getParameter("id");
		Songs songs=songsDAO.get(Integer.parseInt(idStr));
	if(songs!=null){
		request.setAttribute("songs", songs);
		request.getRequestDispatcher("updatecustomer2.jsp").forward(request, response);
		
	}
	
	}
	private void delete1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id=0;
		id=Integer.parseInt(idStr);
		songsDAO.delete(id);
		response.sendRedirect("query1.ao");
	}
	private void query1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String songname=request.getParameter("");
//		String songsinger=request.getParameter("");
//		String songtype=request.getParameter("");
//		String songurl=request.getParameter("");
//		String songen=request.getParameter("");
//		Integer singerid=Integer.parseInt(request.getParameter(""));
//		String file_desc=request.getParameter("");
//		CriteriaSongs cc=new CriteriaSongs(songname,songsinger,songtype,songurl,songen,singerid,file_desc);
		List<Songs> songs=songsDAO.getAll();
		request.setAttribute("songs", songs);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
		
	}
	private void addCustomer1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String songname=request.getParameter("songname");
		String songsinger=request.getParameter("songsinger");
		String songtype=request.getParameter("songtype");
		String songurl=request.getParameter("songurl");
		String songen=request.getParameter("songen");
		Integer singerid=Integer.parseInt(request.getParameter("singerid"));
		String file_desc=request.getParameter("file_desc");
		long count = songsDAO.getCountWithName(songname);
		if(count>0){
			request.setAttribute("message","管理员用户名"+songname+"已经注册啦");
			request.getRequestDispatcher("/newcustomer2.jsp").forward(request, response);
			return;
		}
		Songs songs=new Songs(songname,songsinger,songtype,songurl,songen,singerid,file_desc);
		songsDAO.save(songs);
		response.sendRedirect("success2.jsp");
	}
	private void update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("songid");
		String songname=request.getParameter("songname");
		String songsinger=request.getParameter("songsinger");
		String songtype=request.getParameter("songtype");
		String songurl=request.getParameter("songurl");
		String songen=request.getParameter("songen");
	    String singerid=request.getParameter("singerid");
		String file_desc=request.getParameter("file_desc");
		String oldName=request.getParameter("oldName");
		if(!oldName.equalsIgnoreCase(songname)){
			long count=songsDAO.getCountWithName(songname);
			if(count>0){
				request.setAttribute("message", "管理员用户名"+songname+"已经注册啦");
				request.getRequestDispatcher("/newcustomer2.jsp").forward(request, response);
				return;
			}
		}
		Songs songs=new Songs(songname,songsinger,songtype,songurl,songen,Integer.parseInt(singerid),file_desc);
		songs.setSongid(Integer.parseInt(id));
		songsDAO.update(songs);
		response.sendRedirect("query1.ao");
		
	}
}
