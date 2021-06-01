package admin.domain;

public class Admin {

	private Integer adminid;
	private String adminname;
	private String adminpassword;
	
	public Admin(){}

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
	public Admin(String adminname,String adminpassword){
		super();
		this.adminname=adminname;
		this.adminpassword=adminpassword;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminname=" + adminname + ", adminpassword=" + adminpassword + "]";
	}
	
}
