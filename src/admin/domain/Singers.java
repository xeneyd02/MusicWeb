package admin.domain;

public class Singers {

	private Integer singerid;
	private String singername;
	public Integer getSingerid() {
		return singerid;
	}
	public void setSingerid(Integer singerid) {
		this.singerid = singerid;
	}
	public String getSingername() {
		return singername;
	}
	public void setSingername(String singername) {
		this.singername = singername;
	}
	public Singers(String singername) {
		super();
		this.singername = singername;
	}
	@Override
	public String toString() {
		return "Singers [singerid=" + singerid + ", singername=" + singername + "]";
	}
	
	public Singers(){}
	
}
