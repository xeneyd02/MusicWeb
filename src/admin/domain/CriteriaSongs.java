package admin.domain;

public class CriteriaSongs {

	private String songname;
	private String songsinger;
	private String songtype;
	private String songurl;
	private String songen;
	private Integer singerid;
	public Integer getSingerid() {
		return singerid;
	}

	public void setSingerid(Integer singerid) {
		this.singerid = singerid;
	}
	private String file_desc;
	
	public CriteriaSongs(){}
	
	public String getFile_desc() {
		
		if(file_desc==null){
			file_desc="&&";
		}else{
			file_desc="%"+file_desc+"%";
		}
		
		return file_desc;
	}
	public void setFile_desc(String file_desc) {
		this.file_desc = file_desc;
	}
	public String getSongname() {
		
		if(songname==null){
			songname="&&";
		}else{
			songname="%"+songname+"%";
		}
		
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public String getSongsinger() {
		

		if(songsinger==null){
			songsinger="&&";
		}else{
			songsinger="%"+songsinger+"%";
		}
		
		return songsinger;
	}
	public void setSongsinger(String songsinger) {
		this.songsinger = songsinger;
	}
	public String getSongtype() {
		
		if(songtype==null){
			songtype="&&";
		}else{
			songtype="%"+songtype+"%";
		}
		
		return songtype;
	}
	public void setSongtype(String songtype) {
		this.songtype = songtype;
	}
	public String getSongurl() {
		
		if(songurl==null){
			songurl="&&";
		}else{
			songurl="%"+songurl+"%";
		}
		
		return songurl;
	}
	public void setSongurl(String songurl) {
		this.songurl = songurl;
	}
	public String getSongen() {
		
		if(songen==null){
			songen="&&";
		}else{
			songen="%"+songen+"%";
		}
		
		return songen;
	}
	public void setSongen(String songen) {
		this.songen = songen;
	}

	public CriteriaSongs(String songname, String songsinger, String songtype, String songurl, String songen,
			Integer singerid, String file_desc) {
		super();
		this.songname = songname;
		this.songsinger = songsinger;
		this.songtype = songtype;
		this.songurl = songurl;
		this.songen = songen;
		this.singerid = singerid;
		this.file_desc = file_desc;
	}
	
}
