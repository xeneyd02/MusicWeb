package search.dao;

import java.util.List;

import search.domain.CriteriaSearch2;
import search.domain.Search;
import search.domain.Search2;

public interface Search2DAO {

	public List<Search2> getForListWithCriteriaCustomer2(CriteriaSearch2 cc2);
	public Search2 get(Integer id);
}
