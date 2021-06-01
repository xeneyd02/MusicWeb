package upload.db;



import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static DataSource dataSource=null;
	static{
		dataSource=new ComboPooledDataSource("www");
	}
	public static Connection getConnection() throws SQLException{
		
			return dataSource.getConnection();
		
	}
	public static void release(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
