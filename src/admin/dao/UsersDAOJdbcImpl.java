package admin.dao;

import java.util.List;

import admin.domain.Users;

public class UsersDAOJdbcImpl extends DAO<Users> implements UsersDAO{

	@Override
	public List<Users> getAll() {
		String sql="SELECT id,name,password FROM users ";
		return getForList(sql);
	}

	@Override
	public void save(Users users) {
		String sql="INSERT INTO users (id,name,password) VALUES(?,?,?)";
		update(sql,users.getId(),users.getName(),users.getPassword());
		
	}

	@Override
	public Users get(Integer id) {
		String sql="SELECT id,name,password FROM users WHERE id= ?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		String sql="DELETE FROM users WHERE id=?";
		update(sql,id);
		
	}

	@Override
	public void update(Users users) {
		String sql="UPDATE users SET name=?,password=? WHERE id=?";
		update(sql,users.getName(),users.getPassword(),users.getId());
		
	}

	@Override
	public long getCountWithName(String name) {
		String sql="SELECT count(id) FROM users WHERE name=?";
		return getForValue(sql,name);
	}

}
