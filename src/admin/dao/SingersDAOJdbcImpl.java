package admin.dao;

import java.util.List;

import admin.domain.Singers;

public class SingersDAOJdbcImpl extends DAO<Singers> implements SingersDAO{

	@Override
	public List<Singers> getAll() {
		String sql="SELECT singerid,singername FROM singers ";
		return getForList(sql);
	}

	@Override
	public void save(Singers singers) {
		String sql="INSERT INTO singers(singerid,singername) VALUES(?,?)";
		update(sql,singers.getSingerid(),singers.getSingername());
		
	}

	@Override
	public Singers get(Integer id) {
		String sql="SELECT singerid,singername FROM singers WHERE singerid= ?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		String sql="DELETE FROM singers WHERE singerid=?";
		update(sql,id);
		
	}

	@Override
	public void update(Singers singers) {
		String sql="UPDATE singers SET singername=? WHERE singerid=?";
		update(sql,singers.getSingername(),singers.getSingerid());
		
	}

	@Override
	public long getCountWithName(String name) {
		String sql="SELECT count(singerid) FROM singers WHERE singername=?";
		return getForValue(sql,name);
	}

}
