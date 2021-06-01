package register;

import java.util.List;







public class UserDAOJdbcImpl extends DAO<User> implements UserDAO{

	public List<User> getForListWithCriteriaUser(CriteriaUser cc){
		String sql="SELECT id,name,password FROM users WHERE name LIKE ? AND password LIKE ?";
		return getForList(sql,cc.getName(),cc.getPassword());
		
		
		
	}
	
	

	@Override
	public void save(User user) {
		String sql="INSERT INTO users(name,password) VALUES(?,?)";
		update(sql,user.getName(),user.getPassword());
	}

	


	@Override
	public long getCountWithName(String name) {
		String sql="SELECT count(id) FROM users WHERE name=?";
		return getForValue(sql,name);
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql="UPDATE users SET name=?,password=? WHERE id=?";
		update(sql,user.getName(),user.getPassword(),user.getId());
		
	}










	
	
	
}
