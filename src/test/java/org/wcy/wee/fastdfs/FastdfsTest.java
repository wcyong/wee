package org.wcy.wee.fastdfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.wcy.wee.common.util.FastDFSClient;

/**
 * fastDFS测试
 * @author wcyong
 *
 */
public class FastdfsTest {

	/**
	 * 上传测试
	 * @throws MyException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testUpload() throws Exception {
		// 1、把FastDFS提供的jar包添加到工程中
		// 2、初始化全局配置。加载一个配置文件。
		String conf = this.getClass().getClassLoader().getResource("client.conf").getPath();
		ClientGlobal.init(conf);
		// 3、创建一个TrackerClient对象。
		TrackerClient trackerClient = new TrackerClient();
		// 4、创建一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 5、声明一个StorageServer对象。
		StorageServer storageServer = null;
		// 6、获得StorageClient对象。
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 7、直接调用StorageClient对象方法上传文件即可。
		String[] results = storageClient.upload_file("G:\\photo\\tree1-full.jpg", "jpg", null);
		for(String s : results) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testFastDFSClient() throws Exception {
		FastDFSClient client = new FastDFSClient("classpath:client.conf");
		String path = client.uploadFile("G:\\photo\\14205094505.jpg");
		System.out.println(path);
	}
}
