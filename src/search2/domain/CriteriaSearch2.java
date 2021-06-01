package search2.domain;

public class CriteriaSearch2 {

	private String songname;
	private String songsinger;
	private String songtype;
	private String songurl;
	private String songen;
	
	
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
	public CriteriaSearch2(String songname, String songsinger, String songtype,String songurl) {
		super();
		this.songname = songname;
		this.songsinger = songsinger;
		this.songtype = songtype;
		this.songurl=songurl;
	}
	
	public CriteriaSearch2(String songen){
		super();
		this.songen=songen;
	}
	
}
