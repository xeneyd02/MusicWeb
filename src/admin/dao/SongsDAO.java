package admin.dao;

import java.util.List;

import admin.domain.CriteriaSongs;
import admin.domain.Songs;


public interface SongsDAO {

	public List<Songs> getForListWithCriteriaAdmin(CriteriaSongs cc);
	
	public List<Songs> getAll();
	
	public void save(Songs Songs);
	
	public Songs get(Integer id);
	
	public void delete(Integer id);
	
	public void update(Songs Songs);
	
	public long getCountWithName(String name);
	
}
