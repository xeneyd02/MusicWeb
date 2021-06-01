package admin.dao;

import java.util.List;

import admin.domain.Admin;
import admin.domain.Singers;

public interface SingersDAO {

	public List<Singers> getAll();
	
public void save(Singers singers);
	
	public Singers get(Integer id);
	
	public void delete(Integer id);
	
	public void update(Singers singers);
	
	public long getCountWithName(String name);
	
}
