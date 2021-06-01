package search.dao;

import java.util.List;

import search.domain.CriteriaSearch;
import search.domain.CriteriaSearch2;
import search.domain.Search;
import search.domain.Search2;


public interface SearchDAO {
	public List<Search> getForListWithCriteriaCustomer(CriteriaSearch cc);
	
	public Search get(Integer id);
}
