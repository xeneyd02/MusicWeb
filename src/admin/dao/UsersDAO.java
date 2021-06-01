package admin.dao;

import java.util.List;

import admin.domain.Users;


public interface UsersDAO {

public List<Users> getAll();
	
	public void save(Users users);
	
	public Users get(Integer id);
	
	public void delete(Integer id);
	
	public void update(Users users);
	
	public long getCountWithName(String name);
	
}
