package search2.domain;

public class Search2 {

	private String songid;
	private String songname;
	private String songsinger;
	private String songtype;
	private String songurl;
	private String songen;
	public String getSongen() {
		return songen;
	}
	public void setSongen(String songen) {
		this.songen = songen;
	}
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
	public Search2(String songid, String songname, String songsinger, String songtype,String songurl,String songen) {
		super();
		this.songid = songid;
		this.songname = songname;
		this.songsinger = songsinger;
		this.songtype = songtype;
		this.songurl=songurl;
		this.songen=songen;
	}
	@Override
	public String toString() {
		return "Search2 [songid=" + songid + ", songname=" + songname + ", songsinger=" + songsinger + ", songtype="
				+ songtype + ",songurl="+songurl+", songen=" + songen + "]";
	}
	public Search2(String songen) {
		super();
		this.songen = songen;
	}
	
	public Search2(){}
	
}
