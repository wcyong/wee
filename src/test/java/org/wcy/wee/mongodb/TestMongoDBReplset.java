package org.wcy.wee.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * java程序连接副本集测试
 * @author wcyong
 *
 * @date   2015年10月2日
 */
public class TestMongoDBReplset {
	
	/**
	 * 添加
	 */
	@Test
	public void testInsert() {
		List<ServerAddress> addressess = new ArrayList<ServerAddress>();
		ServerAddress sa1 = new ServerAddress("192.168.1.254",27017);
		ServerAddress sa2 = new ServerAddress("192.168.1.251",27017);
		ServerAddress sa3 = new ServerAddress("192.168.1.253",27017);
		addressess.add(sa1);
		addressess.add(sa2);
		addressess.add(sa3);
		MongoClient client = new MongoClient(addressess);
		MongoDatabase db = client.getDatabase("reptest");
		MongoCollection<Document> coll = db.getCollection("reptest");
		
		//插入
		Document doc = new Document();
		doc.put("name", "xm");
		coll.insertOne(doc);
		
		client.close();
	}
	
	/**
	 * 查询
	 */
	@Test
	public void testFind() {
		List<ServerAddress> addressess = new ArrayList<ServerAddress>();
		ServerAddress sa1 = new ServerAddress("192.168.1.254",27017);
		ServerAddress sa2 = new ServerAddress("192.168.1.251",27017);
		ServerAddress sa3 = new ServerAddress("192.168.1.253",27017);
		addressess.add(sa1);
		addressess.add(sa2);
		addressess.add(sa3);
		MongoClient client = new MongoClient(addressess);
		MongoDatabase db = client.getDatabase("reptest");
		MongoCollection<Document> coll = db.getCollection("reptest");
		
		FindIterable<Document> iterable = coll.find();
		MongoCursor<Document> cursor = iterable.iterator();
		while(cursor.hasNext()) {
			Document d = cursor.next();
			System.out.println(d.get("name"));
		}
		client.close();
	}
	
	/**
	 * 读写分离
	 * 1、设置读写分离需要先在副本节点SECONDARY 设置 setSlaveOk。
	 * 2、在程序中设置副本节点负责读操作
	 */
	@Test
	public void testRead() {
		List<ServerAddress> addressess = new ArrayList<ServerAddress>();
		ServerAddress sa1 = new ServerAddress("192.168.1.254",27017);
		ServerAddress sa2 = new ServerAddress("192.168.1.251",27017);
		ServerAddress sa3 = new ServerAddress("192.168.1.253",27017);
		addressess.add(sa1);
		addressess.add(sa2);
		addressess.add(sa3);
		MongoClient client = new MongoClient(addressess);
		//读操作从副本节点读取
		/**
		 * 读参数除了secondary一共还有五个参数：primary、primaryPreferred、secondary、secondaryPreferred、nearest。
		 * primary:默认参数，只从主节点上进行读取操作；
		 * primaryPreferred:大部分从主节点上读取数据,只有主节点不可用时从secondary节点读取数据。
		 * secondary:只从secondary节点上进行读取操作，存在的问题是secondary节点的数据会比primary节点数据“旧”。
		 * secondaryPreferred:优先从secondary节点进行读取操作，secondary节点不可用时从主节点读取数据；
		 * nearest:不管是主节点、secondary节点，从网络延迟最低的节点上读取数据。
		 */
		ReadPreference preference = ReadPreference.secondary();
		client.setReadPreference(preference);
		
		MongoDatabase db = client.getDatabase("reptest");
		MongoCollection<Document> coll = db.getCollection("reptest");
		FindIterable<Document> iterable = coll.find();
		
		MongoCursor<Document> cursor = iterable.iterator();
		
		while(cursor.hasNext()) {
			Document d = cursor.next();
			System.out.println(d.get("name"));
		}
		client.close();
	}
	
	
}
