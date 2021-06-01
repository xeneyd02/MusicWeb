package search.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search.dao.Search2DAO;
import search.dao.SearchDAO;
import search.dao.SearchDAOJdbcImpl;
import search.dao.SearchDAOJdbcImpl2;
import search.domain.CriteriaSearch;
import search.domain.CriteriaSearch2;
import search.domain.Search;
import search.domain.Search2;


public class SearchServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private SearchDAO customerDAO=new SearchDAOJdbcImpl();
	
	private Search2DAO customerDAO2=new SearchDAOJdbcImpl2();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("searchname");
		
		CriteriaSearch2 cc2=new CriteriaSearch2(name);
		
		List<Search2> customers2=customerDAO2.getForListWithCriteriaCustomer2(cc2);
		if(customers2!=null&&customers2.size()>0){
			System.out.println("SECCESS!!");
			request.setAttribute("customers2", customers2);
			request.getRequestDispatcher("/searchSinger/searchSinger.jsp").forward(request, response);
			//response.sendRedirect("searchSinger/searchSinger.jsp");
		}else{
			System.out .println("没有叫这个名字的歌曲");
			CriteriaSearch cc=new CriteriaSearch(name);
			List<Search> customers=customerDAO.getForListWithCriteriaCustomer(cc);
			if(customers!=null&&customers.size()>0){
				request.setAttribute("customers", customers);
				request.getRequestDispatcher("/searchSinger/searchSinger1.jsp").forward(request, response);
				//response.sendRedirect("searchSinger/searchSinger1.jsp");
			}else{
				System.out.println("找不到与之相关的信息");
			}
		}
	
	}
}