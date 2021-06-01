package register;

import java.util.List;





public interface UserDAO {

	public List<User> getForListWithCriteriaUser(CriteriaUser cc);
	
	public void save(User user);
	public void update(User user);
	
	public long getCountWithName(String name);
}
