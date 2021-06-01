package upload.db;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DAO<T> {

	public static QueryRunner runner=new QueryRunner();
	private Class<T> clazz;
	public DAO(){
		Type superClass=getClass().getGenericSuperclass();
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType=(ParameterizedType) superClass;
			Type[] typeArgs=parameterizedType.getActualTypeArguments();
			if(typeArgs!=null&& typeArgs.length>0){
				if(typeArgs[0] instanceof Class){
					clazz=(Class<T>) typeArgs[0];
				}
			}
		}
	}
	public void update(Connection conn,String sql,Object ...args){
		try {
			runner.update(conn, sql, args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<T> getForList(Connection conn,String sql,Object ...args){
		try {
			runner.query(conn, sql, new BeanListHandler<>(clazz), args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
