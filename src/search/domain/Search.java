package search.domain;

public class Search {

	private Integer songid;
	private String songsinger;
	private String songname;
	private String songurl;
	
	
	public Integer getSongid() {
		return songid;
	}




	public void setSongid(Integer songid) {
		this.songid = songid;
	}




	private String songtype;
	
	
	
	
	
	public String getSongurl() {
		return songurl;
	}




	public void setSongurl(String songurl) {
		this.songurl = songurl;
	}




	public String getSongtype() {
		return songtype;
	}




	public void setSongtype(String songtype) {
		this.songtype = songtype;
	}




	public String getSongname() {
		return songname;
	}




	public void setSongname(String songname) {
		this.songname = songname;
	}




	public Search(){
		
	}




	public String getSongsinger() {
		return songsinger;
	}




	public void setSongsinger(String singername) {
		this.songsinger = singername;
	}




	@Override
	public String toString() {
		return "Search [songid=" + songid + ", songsinger=" + songsinger + ", songname=" + songname + ""
				+ ", songtype=" + songtype + ", songurl=" + songurl + "]";
	}




	public Search(String songsinger) {
		super();
		this.songsinger = songsinger;
	}
	
	

}
