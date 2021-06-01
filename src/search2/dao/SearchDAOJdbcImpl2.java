package search2.dao;

import java.util.List;

import search2.domain.CriteriaSearch2;
import search2.domain.Search2;

public class SearchDAOJdbcImpl2 extends DAO<Search2> implements Search2DAO {

	@Override
	public List<Search2> getForListWithCriteriaCustomer2(CriteriaSearch2 cc2) {

		String sql="SELECT songid,songname,songsinger,songtype,songurl,songen FROM songs WHERE songen LIKE ?";
		
		return getForList(sql,cc2.getSongen());
	}

}
