package org.wcy.wee.demo.excel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.StylesTable;
import org.wcy.wee.demo.excel.model.ExcelData;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * 读取Excel	xls(2003),xlsx(2007,2010,2013)
 * @author wcyong
 *
 * date    2015年7月23日
 */
public class ExcelImportTest {
	
	public static void main(String[] args) {
		ExcelImportTest test = new ExcelImportTest();
		try {
			InputStream is = new FileInputStream("F:/test/2.xls");
			//test.importExcel2007(is);
			test.importExcel2003(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//读取Excel xls(2003)
	public void importExcel2003(InputStream is) {
		int batchSize = 1000; //批处理大小
		BufferedInputStream bis = null;
		InputStream dis = null;
		try {
			long beginTime = System.currentTimeMillis();
			
			List<ExcelData> dataList = new ArrayList<ExcelData>();
			//输入流
			bis = new BufferedInputStream(is);
			//创建 org.apache.poi.poifs.filesystem.Filesystem
			POIFSFileSystem poifs = new POIFSFileSystem(bis);
			//从输入流 得到 Workbook(excel 部分)流
			dis = poifs.createDocumentInputStream("Workbook");
			//构造 HSSFRequest
			HSSFRequest req = new HSSFRequest();
			//添加监听
			req.addListenerForAllRecords(new Excel2003ImportListener(dataList, batchSize));
			//创建事件工厂
			HSSFEventFactory factory = new HSSFEventFactory();
			//根据文档输入流处理事件
			factory.processEvents(req, dis);
			
			//把最后剩下的不足batchSize大小数据保存到db
            if (dataList.size() > 0) {
                //doBatchSave(dataList);
            	System.out.println("最后读取:"+dataList.size()+"条数据!----");
            }
            System.out.println(dataList);
			
			long endTime = System.currentTimeMillis();
			System.out.println("seconds:"+ ((endTime - beginTime) / 1000));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭输入流
			IOUtils.closeQuietly(bis);
			//关闭文档流
			IOUtils.closeQuietly(dis);
		}
	}

	//读取Excel xlsx(2007,2010,2013)
	public void importExcel2007(InputStream is) {
		int batchSize = 1000; //批处理大小
		BufferedInputStream bis = null;
		try {
			long beginTime = System.currentTimeMillis();
			
			List<ExcelData> dataList = new ArrayList<ExcelData>();
			bis = new BufferedInputStream(is);
			OPCPackage pkg = OPCPackage.open(bis);
			//ReadOnlySharedStringsTable类将读取XML中所有字串信息的索引到内存
			ReadOnlySharedStringsTable sharedStringsTable = new ReadOnlySharedStringsTable(pkg);
			XSSFReader reader = new XSSFReader(pkg);
			//将xml的字符串索引load到内存中
			StylesTable stylesTable = reader.getStylesTable();
			XMLReader parser = XMLReaderFactory.createXMLReader();
			ContentHandler handler = new Excel2007ImportSheetHandler(dataList,batchSize,sharedStringsTable,stylesTable);
			parser.setContentHandler(handler);
			
			Iterator<InputStream> sheets = reader.getSheetsData();
			while(sheets.hasNext()) {
				InputStream sheet = null;
				try {
					sheet = sheets.next();
					InputSource sheetSource = new InputSource(sheet);
					parser.parse(sheetSource);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					IOUtils.closeQuietly(sheet);
				}
			}
			
			//把最后剩下的不足batchSize大小数据保存到db
            if (dataList.size() > 0) {
                //doBatchSave(dataList);
            	System.out.println("最后读取:"+dataList.size()+"条数据!----");
            }
			
			long endTime = System.currentTimeMillis();
			
			System.out.println("seconds:"+((endTime - beginTime) / 1000));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(bis);
		}
	}
	
}
