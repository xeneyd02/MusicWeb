package search.dao;

import java.util.List;

import search.domain.CriteriaSearch;
import search.domain.Search;


public class SearchDAOJdbcImpl extends DAO<Search> implements SearchDAO{

	public List<Search> getForListWithCriteriaCustomer(CriteriaSearch cc){
		//String sql="SELECT singername FROM singers WHERE singername LIKE ? ";
		String sql="SELECT songsinger,songname,songurl,songtype,songid"
				+ " FROM songs,singers"
				+ " WHERE songs.singerid=singers.singerid"
				+ " AND singername LIKE ?";
		//return getForList(sql,cc.getName()==null ? "%%" : "%" +cc.getName()+"%");
		
		return getForList(sql,cc.getSingername());
		
	}

	@Override
	public Search get(Integer id) {
		// TODO Auto-generated method stub
		String sql="SELECT songid,songsinger,songname,songurl,songtype"
				+ " FROM songs"
				
				+ " WHERE songid=?";
	
		return get(sql,id);
	
	}

	
}
