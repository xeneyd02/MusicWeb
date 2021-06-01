package search.domain;

public class Search2 {

	private String songid;
	private String songname;
	private String songsinger;
	private String songtype;
	private String songurl;
	public String getSongurl() {
		return songurl;
	}
	public void setSongurl(String songurl) {
		this.songurl = songurl;
	}
	public String getSongid() {
		return songid;
	}
	public void setSongid(String songid) {
		this.songid = songid;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public String getSongsinger() {
		return songsinger;
	}
	public void setSongsinger(String songsinger) {
		this.songsinger = songsinger;
	}
	public String getSongtype() {
		return songtype;
	}
	public void setSongtype(String songtype) {
		this.songtype = songtype;
	}
	public Search2(String songid, String songname, String songsinger, String songtype,String songurl) {
		super();
		this.songid = songid;
		this.songname = songname;
		this.songsinger = songsinger;
		this.songtype = songtype;
		this.songurl=songurl;
	}
	@Override
	public String toString() {
		return "Search2 [songid=" + songid + ", songname=" + songname + ", songsinger=" + songsinger + ", songtype="
				+ songtype + ",songurl="+songurl+"]";
	}
	public Search2(String songname) {
		super();
		this.songname = songname;
	}
	
	public Search2(){}
	
}
