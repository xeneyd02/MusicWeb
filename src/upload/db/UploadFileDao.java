package upload.db;

import java.sql.Connection;
import java.util.List;

import upload.bean.FileUploadBean;



public class UploadFileDao extends DAO<FileUploadBean> {

	public List<FileUploadBean> getFiles(){
		Connection conn=null;
		try{
			conn=JDBCUtils.getConnection();
			String sql="SELECT songid,songname fileName,songurl filePath,file_desc fileDesc FROM songs";
			return getForList(conn,sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn);
		}
		return null;
	}
	public void save(List<FileUploadBean> fileUploadBean){
		Connection conn=null;
		try{
			conn=JDBCUtils.getConnection();
			String sql="INSERT INTO songs(songname,songurl,file_desc) VALUES (?,?,?)";
			for(FileUploadBean bean:fileUploadBean){
				update(conn,sql,bean.getFileName(),bean.getFilePath(),bean.getFileDesc());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(conn);
		}
	}
	
}
