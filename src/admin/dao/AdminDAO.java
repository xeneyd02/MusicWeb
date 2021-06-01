package admin.dao;

import java.util.List;

import admin.domain.Admin;
import admin.domain.CriteriaAdmin;

public interface AdminDAO {

	public List<Admin> getForListWithCriteriaAdmin(CriteriaAdmin cc);
	
	public List<Admin> getAll();
	
	public void save(Admin admin);
	
	public Admin get(Integer adminid);
	
	public void delete(Integer adminid);
	
	public void update(Admin admin);
	
	public long getCountWithName(String name);
	
}
