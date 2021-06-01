package Login.src.dao;

import java.util.List;

import Login.src.domain.User;





public interface UserDAO {

	public List<User> getForListWithCriteriaUser(CriteriaUser cc);
	
	public void save(User user);
	public void update(User user);
	
	public long getCountWithName(String name);
}
