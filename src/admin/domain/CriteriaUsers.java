package admin.domain;

public class CriteriaUsers {

	private String name;
	private String password;
	public String getName() {
		
		if(name==null){
			name="&&";
		}else{
			name="%"+name+"%";
		}
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		
		

		if(password==null){
			password="&&";
		}else{
			password="%"+password+"%";
		}
		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CriteriaUsers(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	
	
}
