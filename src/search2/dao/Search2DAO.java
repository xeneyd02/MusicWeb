package search2.dao;

import java.util.List;

import search2.domain.CriteriaSearch2;
import search2.domain.Search2;

public interface Search2DAO {

	public List<Search2> getForListWithCriteriaCustomer2(CriteriaSearch2 cc2);
	
}
