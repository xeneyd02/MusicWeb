package search2.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search2.dao.Search2DAO;
import search2.dao.SearchDAOJdbcImpl2;
import search2.domain.CriteriaSearch2;
import search2.domain.Search2;


public class SearchServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	private Search2DAO customerDAO2=new SearchDAOJdbcImpl2();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("searchen");
		
		CriteriaSearch2 cc2=new CriteriaSearch2(name);
		
		List<Search2> customers2=customerDAO2.getForListWithCriteriaCustomer2(cc2);
		if(customers2!=null&&customers2.size()>0){
			System.out.println("SECCESS!!");
			request.setAttribute("customers2", customers2);
			request.getRequestDispatcher("/singer/singerlist.jsp").forward(request, response);
			
		}else{
				System.out.println("找不到与之相关的信息");
			}
		}
	
	}
