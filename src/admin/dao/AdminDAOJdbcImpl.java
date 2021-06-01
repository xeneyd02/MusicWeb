package admin.dao;

import java.util.List;

import admin.domain.Admin;
import admin.domain.CriteriaAdmin;

public class AdminDAOJdbcImpl extends DAO<Admin> implements AdminDAO {

	@Override
	public List<Admin> getForListWithCriteriaAdmin(CriteriaAdmin cc) {

		String sql="SELECT adminid,adminname,adminpassword FROM admin WHERE adminname LIKE ? AND adminpassword LIKE ?";
		return getForList(sql,cc.getAdminname(),cc.getAdminpassword());
	
	}

	@Override
	public List<Admin> getAll() {
		String sql="SELECT adminid,adminname,adminpassword FROM admin ";
		return getForList(sql);
	}

	@Override
	public void save(Admin admin) {
		String sql="INSERT INTO admin(adminid,adminname,adminpassword) VALUES(?,?,?)";
		update(sql,admin.getAdminid(),admin.getAdminname(),admin.getAdminpassword());
		
	}

	@Override
	public Admin get(Integer adminid) {
		String sql="SELECT adminid,adminname,adminpassword FROM admin WHERE adminid= ?";
		return get(sql,adminid);
	}

	@Override
	public void delete(Integer adminid) {
		String sql="DELETE FROM admin WHERE adminid=?";
		update(sql,adminid);
	}

	@Override
	public void update(Admin admin) {
		String sql="UPDATE admin SET adminname=?,adminpassword=? WHERE adminid=?";
		update(sql,admin.getAdminname(),admin.getAdminpassword(),admin.getAdminid());
		
	}

	@Override
	public long getCountWithName(String name) {
		String sql="SELECT count(adminid) FROM admin WHERE adminname=?";
		return getForValue(sql,name);
	}

}
