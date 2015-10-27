package org.wcy.wee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestCsv {
	
	private final Logger logger = Logger.getLogger(TestCsv.class);
	
	@Test
	public void test01() {
		getDataByText();
	}
	
	/**
     * 读取csv/txt文件数据
     */
    public void getDataByText()
    {
        // 将任务的任务标志修改为2，代表处理中
        //setTaskFlag(task, dataBase, "2");
        
        // 用符号分割
        StringBuffer sbf = new StringBuffer();
        // 用行分割
        List<String> linelist = new LinkedList<String>();
        String filepath = "f:\\source.csv";
        File file = new File(filepath);
        
        FileInputStream in = null;
        BufferedReader buff = null;
        try
        {
            // 读取文件流
            in = new FileInputStream(file);
            buff = new BufferedReader((new InputStreamReader(in, "UTF-8")));
            int totalSize = 0; //总大小
            int batchSize = 10000;//批处理大小
            // 创建整体数据
            String line = null;
            while ((line = buff.readLine()) != null)
            {
                totalSize++;
                
                linelist.add(line);
                
                if (totalSize % batchSize == 0) {
                    List<Map<String, Object>> mapList = toMapList(linelist);
                    System.out.println(mapList);
                    //保存数据
                    linelist.clear();
                }
                
            }
            if(sbf.length() > 0 || linelist.size() > 0) {
            	List<Map<String, Object>> mapList = toMapList(linelist);
            	System.out.println("===========2=============="+mapList.size());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            try
            {
                if(buff != null) buff.close();
                if(in != null) in.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
    
    private List<Map<String, Object>> toMapList(List<String> linelist)
    {
        List<Map<String, Object>> mapList = new LinkedList<Map<String, Object>>();
        
        if (linelist.size() > 0)
        {
                for (int u = 0; u < linelist.size(); u++)
                {
                    String[] tempStrArr = linelist.get(u).split(",");
                    Map<String, Object> tempMap = new LinkedHashMap<String, Object>();
                    for (int i = 0; i < tempStrArr.length; i++)
                    {
                        tempMap.put(i+"", tempStrArr[i]);
                    }
                    mapList.add(tempMap);
                }
        }
        return mapList;
    }

}
