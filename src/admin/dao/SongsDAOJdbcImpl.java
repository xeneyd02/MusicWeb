package admin.dao;

import java.util.List;


import admin.domain.CriteriaSongs;
import admin.domain.Songs;


public class SongsDAOJdbcImpl extends DAO<Songs> implements SongsDAO {

	@Override
	public List<Songs> getForListWithCriteriaAdmin(CriteriaSongs cc) {
		String sql="SELECT songid,songname,songsinger,songtype,songurl,songen FROM songs WHERE songname LIKE ? AND songsinger LIKE ?"
				+ " AND songtype LIKE ? AND songurl LIKE ? AND songen LIKE ?";
		return getForList(sql,cc.getSongname(),cc.getSongsinger(),cc.getSongtype(),cc.getSongurl(),cc.getSongen());
	}

	@Override
	public List<Songs> getAll() {
		String sql="SELECT songid,songname,songsinger,songtype,songurl,songen,singerid,file_desc,singerid FROM songs ";
		return getForList(sql);
	}

	@Override
	public void save(Songs Songs) {
		String sql="INSERT INTO songs(songid,songname,songsinger,songtype,songurl,songen,file_desc,singerid) VALUES(?,?,?,?,?,?,?,?)";
		update(sql,Songs.getSongid(),Songs.getSongname(),Songs.getSongsinger(),Songs.getSongtype(),Songs.getSongurl(),Songs.getSongen(),Songs.getFile_desc(),Songs.getSingerid());
				
		
	}

	@Override
	public Songs get(Integer id) {
		String sql="SELECT songid,songname,songsinger,songtype,songurl,songen,file_desc,singerid FROM songs WHERE songid= ?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		String sql="DELETE FROM songs WHERE songid=?";
		update(sql,id);
		
	}

	@Override
	public void update(Songs Songs) {
		String sql="UPDATE songs SET songname=?,songsinger=?,songtype=?,songurl=?,songen=?,file_desc=?,singerid=? WHERE songid=?";
		update(sql,Songs.getSongname(),Songs.getSongsinger(),Songs.getSongtype(),Songs.getSongurl(),Songs.getSongen(),Songs.getFile_desc(),Songs.getSingerid());
		
	}

	@Override
	public long getCountWithName(String name) {
		String sql="SELECT count(songid) FROM songs WHERE songname=?";
		return getForValue(sql,name);
	}

	

}
