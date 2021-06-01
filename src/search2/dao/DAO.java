package search2.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import search2.db.JdbcUtils;
import search2.domain.Search2;



public class DAO<T> {

	private QueryRunner queryRunner=new QueryRunner();
		
	private Class<T> clazz;
	
	public DAO(){
		Type superClass=getClass().getGenericSuperclass();
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType=(ParameterizedType)superClass;
			Type [] typeArgs=parameterizedType.getActualTypeArguments();
		if(typeArgs!=null&&typeArgs.length>0){
			if(typeArgs[0] instanceof Class){
				clazz=(Class<T>) typeArgs[0];
			}
		}
		
		}
		}
	
	
	public List<T> getForList(String sql,Object ...args){
		Connection connection=null;
		try{
			connection=JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	
}
