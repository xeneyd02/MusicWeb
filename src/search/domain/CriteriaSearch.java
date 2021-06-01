package search.domain;

public class CriteriaSearch {

private String singername;

	
	public String getSingername() {
		if(singername==null){
			singername="&&";
		}else{
			singername="%"+singername+"%";
			
		}
		return singername;
	}

	public void setName(String name) {
		this.singername = name;
	}

	

	public CriteriaSearch(String name){
		super();
		this.singername=name;
		
	}
	
}
