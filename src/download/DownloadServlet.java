package download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Login.src.domain.User;
import search.dao.SearchDAO;
import search.dao.SearchDAOJdbcImpl;
import search.domain.Search;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchDAO customerDAO=new SearchDAOJdbcImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		String idStr=request.getParameter("songid");
	
		Search songs=customerDAO.get(Integer.parseInt(idStr));
	
		if(songs!=null){
			request.setAttribute("songs", songs);
		
	List<User> users=(List<User>) request.getSession().getAttribute("users");
	
		
		if(users!=null){
	
		String songid=songs.getSongid()+"";
		String songname=songs.getSongname();
		String songurl=songs.getSongurl();
		String songtype=songs.getSongtype();
		String songsinger=songs.getSongsinger();
		
		response.setContentType("applocation/x-msdownload");
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(songname, "UTF-8"));
	
		String fullFileName=request.getServletContext().getRealPath("/"+songurl+songsinger+"-"+songname+" ."+songtype);

		System.out.print(fullFileName);
		InputStream in=new FileInputStream(fullFileName);
		OutputStream out=response.getOutputStream();
		int b;
		while((b=in.read())!=-1){
			out.write(b);
		}
		in.close();
		out.close();
		
		}else{
			//System.out.print("ÇëµÇÂ¼");
//		request.setAttribute("message", "ÇëµÇÂ¼");
//			request.getRequestDispatcher("downloadServlet?songid=").forward(request, response);
////			
//			String result=null;
//			result="ÇëµÇÂ¼";
//			
//			response.getWriter().println(result);
		}
	}
	}
}
