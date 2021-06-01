package search.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search.dao.SearchDAO;
import search.dao.SearchDAOJdbcImpl;
import search.domain.Search;

/**
 * Servlet implementation class Servlet2Servlet
 */
public class Servlet2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchDAO customerDAO=new SearchDAOJdbcImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String idStr=request.getParameter("songid");
	
		Search songs=customerDAO.get(Integer.parseInt(idStr));
	
		if(songs!=null){
			request.setAttribute("songs", songs);
			request.getRequestDispatcher("/playinterface/playinterface.jsp").forward(request, response);
		}
	
	}

}
