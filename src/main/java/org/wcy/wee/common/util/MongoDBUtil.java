package org.wcy.wee.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.wcy.wee.common.vo.Pagination;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

/**
 * MongoDB工具类
 * MongoClient的实例代表数据库连接池，是线程安全的，可以被多线程共享，客户端在多线程条件下仅维持一个实例即可
 */
public class MongoDBUtil {

	private static MongoClient mongoClient = null;
	private static MongoDBUtil mongoDBUtil = null;
	private static String dbName = null;
	
	private MongoDBUtil() {}
	
	static {
		try {
			//读取配置文件
			InputStream inputStream = MongoDBUtil.class.getClassLoader().getResourceAsStream("mongodb.properties");
			Properties props = new Properties();
			props.load(inputStream);
			//如果有多台mongodb服务器，则在配置文件中以,号分隔
			String[] host = props.getProperty("host").split(",");
			String connectionsPerHost = props.getProperty("connectionsPerHost");
			String connectTimeout = props.getProperty("connectTimeout");
			String maxWaitTime = props.getProperty("maxWaitTime");
			dbName = props.getProperty("dbName");
			
			//mongodb服务器列表
			List<ServerAddress> hostList = new ArrayList<ServerAddress>();
			for(int i=0; i<host.length; i++) {
				hostList.add(new ServerAddress(host[i]));
			}
			
			//参数设置
			MongoClientOptions.Builder build = new MongoClientOptions.Builder();
			//连接池设置为300个连接,默认为100
			build.connectionsPerHost(Integer.parseInt(connectionsPerHost));
			//与数据库建立连接的timeout设置为1分钟
			build.connectTimeout(Integer.parseInt(connectTimeout));
			build.maxWaitTime(Integer.parseInt(maxWaitTime));
			MongoClientOptions options = build.build();
			
			//数据库连接实例
			mongoClient = new MongoClient(hostList, options);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*try {
			//mongodb服务器列表
			List<ServerAddress> hostList = new ArrayList<ServerAddress>();
			//hostList.add(new ServerAddress("10.166.191.130", 27017));
			hostList.add(new ServerAddress("192.168.1.105", 27017));
			
			//参数设置
			MongoClientOptions.Builder build = new MongoClientOptions.Builder();
			//连接池设置为300个连接,默认为100
			build.connectionsPerHost(300);
			//与数据库建立连接的timeout设置为1分钟
			build.connectTimeout(1000*60*1);
			build.maxWaitTime(1000*60*2);
			MongoClientOptions options = build.build();
			
			//数据库连接实例
			mongoClient = new MongoClient(hostList, options);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}*/
	}
	
	public static MongoDBUtil getInstance() {
		if(mongoDBUtil == null) {
			mongoDBUtil = new MongoDBUtil();
		}
		return mongoDBUtil;
	}
	
	/**
	 * 获取DB实例
	 * @Title:getDB
	 * @return
	 */
	public DB getDB() {
		DB db = mongoClient.getDB(dbName);
		return db;
	}
	
	/**
	 * 获取集合对象
	 * @Title:getCollection
	 * @param collName
	 * @return
	 */
	public DBCollection getCollection(String collectionName) {
		if(collectionName == null || "".equals(collectionName)) return null;
		try {
			return getDB().getCollection(collectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 向指定的集合中插入数据
	 * @param collectionName
	 * @param object
	 */
	public void insert(String collectionName, DBObject object) {
		try {
			getCollection(collectionName).insert(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 如果更新的数据 不存在 插入一条数据
	 * @param collectionName
	 * @param set
	 * @param where
	 */
	public void updateOrInsert(String collectionName, DBObject set, DBObject where) {
		try {
			getCollection(collectionName).update(where, set, true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 只更新存在的数据,不会新增. 批量更新
	 * @param collectionName
	 * @param set
	 * @param where
	 */
	public void updateExistDataWithBatch(String collectionName, DBObject set, DBObject where) {
		try {
			getCollection(collectionName).update(where, new BasicDBObject("$set", set), false, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除集合中指定条件的数据
	 * @param collectionName
	 * @param object
	 */
	public void delete(String collectionName, DBObject object) {
		try {
			getCollection(collectionName).remove(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 清空集合
	 * @param collectionName
	 */
	public void deleteAll(String collectionName) {
		try {
			List<DBObject> list = findAll(collectionName);
			if(list != null && !list.isEmpty()) {
				for(int i=0; i<list.size(); i++) {
					getCollection(collectionName).remove(list.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询一条记录
	 * @param collectionName
	 * @param obj
	 * @return
	 */
	public DBObject findOne(String collectionName, DBObject obj) {
		try {
			return getCollection(collectionName).findOne(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询所有
	 * @param collectionName
	 * @return
	 */
	public List<DBObject> findAll(String collectionName) {
		try {
			return getCollection(collectionName).find().toArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询指定条数的记录
	 * @param collectionName
	 * @param obj
	 * @param limit
	 * @return
	 */
	public List<DBObject> find(String collectionName, DBObject obj, int limit) {
		try {
			DBCollection coll = getCollection(collectionName);
			DBCursor c = coll.find(obj).limit(limit);
			if(c != null) {
				List<DBObject> list = new ArrayList<DBObject>();
				list = c.toArray();
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询所有，分页查询
	 * @param collectionName
	 * @param pageNo	当前页
	 * @param pageSize	每页显示多少条
	 * @return
	 */
	public Pagination findAll(String collectionName, int pageNo, int pageSize) {
		try {
			DBCollection collection = getCollection(collectionName);
			//总记录数据
			long totalCount = collection.count();
			//构造分页对象
			Pagination pagination = new Pagination(pageNo, pageSize, totalCount);
			DBCursor cursor = collection.find()
										.skip(pagination.getFirstResult())//skip相当于从那条记录开始
										.limit(pageSize);//从skip开始,取多少条记录
			List<DBObject> datas = new ArrayList<DBObject>();
			if(cursor != null) {
				datas = cursor.toArray();
			}
			pagination.setDatas(datas);
			
			return pagination;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询所有，分页查询
	 * @param collectionName
	 * @param pageNo	当前页
	 * @param pageSize	每页显示多少条
	 * @return
	 */
	public Pagination findAll(String collectionName, DBObject where, int pageNo, int pageSize) {
		try {
			DBCollection collection = getCollection(collectionName);
			//总记录数据
			long totalCount = collection.count(where);
			//构造分页对象
			Pagination pagination = new Pagination(pageNo, pageSize, totalCount);
			DBCursor cursor = collection.find(where)
										.skip(pagination.getFirstResult())//skip相当于从那条记录开始
										.limit(pageSize);//从skip开始,取多少条记录
			List<DBObject> datas = new ArrayList<DBObject>();
			if(cursor != null) {
				datas = cursor.toArray();
			}
			pagination.setDatas(datas);
			
			return pagination;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询符合的全部数据
	 * @param collectionName
	 * @param where
	 * @return
	 */
	public List<DBObject> find(String collectionName, DBObject where) {
		DBCursor c = getCollection(collectionName).find(where);
		try {
			if(c != null) {
				List<DBObject> list = new ArrayList<DBObject>();
				list = c.toArray();
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询指定集合的数据条数
	 * @param collectionName
	 * @return
	 */
	public long count(String collectionName) {
		long count = getCollection(collectionName).count();
		return count;
	}
	
	/**
	 * 查询符合条件的集合的数据条数
	 * @param collectionName
	 * @param where
	 * @return
	 */
	public long count(String collectionName, DBObject where) {
		long count = getCollection(collectionName).find(where).count();
		return count;
	}
	
	/**
	 * 将json字符串转换为DBObject对象
	 * @param jsondata
	 * @return
	 */
	public DBObject getDBCursorFromJson(String jsondata){
        return (DBObject) JSON.parse(jsondata);
    }
	
	/**
	 * 将DBObject对象转换为json字符串
	 * @param entry
	 * @return
	 */
    public String getStringDataFromDBObject(DBObject obj){
        return JSON.serialize(obj);
    }
	
	/**
	 * 关闭Mongodb链接
	 */
	public void close() {
		try {
			if(mongoClient != null) {
				mongoClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
