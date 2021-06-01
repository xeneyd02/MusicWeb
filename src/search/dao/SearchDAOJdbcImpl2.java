package search.dao;

import java.util.List;

import search.domain.CriteriaSearch2;
import search.domain.Search;
import search.domain.Search2;

public class SearchDAOJdbcImpl2 extends DAO<Search2> implements Search2DAO {

	@Override
	public List<Search2> getForListWithCriteriaCustomer2(CriteriaSearch2 cc2) {

		String sql="SELECT songname,songsinger,songtype,songurl,songid FROM songs WHERE songname LIKE ?";
		
		return getForList(sql,cc2.getSongname());
	}
	@Override
	public Search2 get(Integer id) {
		// TODO Auto-generated method stub
		String sql="SELECT songid,songsinger,songname,songurl,songtype"
				+ " FROM songs"
				
				+ " WHERE songid=?";
	
		return get(sql,id);
	
	}

}
