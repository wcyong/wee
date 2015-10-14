package org.wcy.wee.mongodb;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class TestMongodb {
	
	MongoClient client = null;
	MongoCollection<Document> collection = null;
	
	@Before
	public void setUp() {
		client = new MongoClient("192.168.1.105:27017");
		MongoDatabase database = client.getDatabase("mytest");
		collection = database.getCollection("users");
	}
	
	/**
	 * 添加数组元素
	 */
	@Test
	public void testUpdate() {
		Bson filter = new BasicDBObject("name", "zhangsan");
		Bson update = new BasicDBObject("$push", new BasicDBObject("emails", "ttt@qq.com"));
		
		collection.updateOne(filter, update);
		
	}
	
	/**
	 * 查询数组内容
	 */
	@Test
	public void testFind() {
		Bson filter = new BasicDBObject("name", "zhangsan");
		FindIterable<Document> iterable = collection.find(filter);
		
		//遍历
		MongoCursor<Document> cursor = iterable.iterator();
		while(cursor.hasNext()) {
			Document d = cursor.next();
			System.out.println(d.get("emails"));
		}
	}
	
	/**
	 * 添加
	 */
	@Test
	public void testInsert() {
		Document document = new Document();
		document.put("name", "wwss");
		
		collection.insertOne(document);
	}
	
	/**
	 * 添加数组field
	 */
	@Test
	public void testSet() {
		//为wwss添加一个数组field
		Bson filter = new BasicDBObject("name", "wwss");
		
		Bson update = new BasicDBObject("$set", new BasicDBObject("emails", new String[]{"ynljwcy@gmail.com"}));
		
		collection.updateMany(filter, update);
	}
	
	/**
	 * 添加数组元素
	 */
	@Test
	public void testPush() {
		Bson filter = new BasicDBObject("name", "wwss");
		Bson update = new BasicDBObject("$push", new BasicDBObject("emails", "ynljwcy@hotmail.com"));
		
		collection.updateMany(filter, update);
	}
	
	/**
	 * 删除field
	 */
	@Test
	public void testUnset() {
		Bson filter = new BasicDBObject("name", "wwss");
		Bson update = new BasicDBObject("$unset", new BasicDBObject("emails", "1"));
		
		collection.updateMany(filter, update);
	}
	
	
	
	@After
	public void destory() {
		client.close();
	}
}
