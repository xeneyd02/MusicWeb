package admin.domain;

public class CriteriaAdmin {

	private String adminname;
	private String adminpassword;
	public String getAdminname() {
		
		if(adminname==null){
			adminname="&&";
		}else{
			adminname="%"+adminname+"%";
		}
		
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {

		if(adminpassword==null){
			adminpassword="&&";
		}else{
			adminpassword="%"+adminpassword+"%";
		}
		
		
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public CriteriaAdmin(String adminname, String adminpassword) {
		super();
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}
	
	
}
