package admin.domain;

public class Songs {

	private Integer songid;
	private String songname;
	private String songsinger;
	private String songtype;
	private String songurl;
	private String songen;
	private Integer singerid;
	private String file_desc;
	
	public Integer getSingerid() {
		return singerid;
	}

	public void setSingerid(Integer singerid) {
		this.singerid = singerid;
	}

	public String getFile_desc() {
		return file_desc;
	}

	public void setFile_desc(String file_desc) {
		this.file_desc = file_desc;
	}

	public Songs(){}

	public Integer getSongid() {
		return songid;
	}

	public void setSongid(Integer songid) {
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

	public String getSongurl() {
		return songurl;
	}

	public void setSongurl(String songurl) {
		this.songurl = songurl;
	}

	public String getSongen() {
		return songen;
	}

	public void setSongen(String songen) {
		this.songen = songen;
	}


	public Songs(String songname, String songsinger, String songtype, String songurl, String songen, Integer singerid,
			String file_desc) {
		super();
		this.songname = songname;
		this.songsinger = songsinger;
		this.songtype = songtype;
		this.songurl = songurl;
		this.songen = songen;
		this.singerid = singerid;
		this.file_desc = file_desc;
	}

	@Override
	public String toString() {
		return "Songs [songid=" + songid + ", songname=" + songname + ", songsinger=" + songsinger + ", songtype=" + songtype
				+ ", songurl=" + songurl + ", songen=" + songen + ", singerid=" + singerid + ", file_desc=" + file_desc
				+ "]";
	}

	
}
