package admin.domain;

public class CriteriaSingers {

	private String singername;

	public String getSingername() {
		if(singername==null){
			singername="&&";
		}else{
			singername="%"+singername+"%";
		}
		
		
		return singername;
	}

	public void setSingername(String singername) {
		this.singername = singername;
	}

	public CriteriaSingers(String singername) {
		super();
		this.singername = singername;
	}
	
	
	
}
