package org.wcy.demo.excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.wcy.demo.excel.model.ExcelData;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Excel2007ImportSheetHandler extends DefaultHandler {

	private String dateFormat = "yyyy-MM-dd";
	//批处理大小
	private int batchSize;
	//总行数
	private int totalSize = 0;
	//当前行
	private int rowNumber = 1;
	//存储cell的类型
	private xssfDataType nextDataType = xssfDataType.NUMBER;
	//存储cell的值
	private StringBuffer lastContents = new StringBuffer();
	//存在某一行的数据
	private List<String> currentCellData = new ArrayList<String>();
	//存放读取结果
	private List<ExcelData> dataList;
	//Used to format numeric cell values
	private short formatIndex;
	private String formatString;//格式化字符串
	private final DataFormatter formatter = new DataFormatter();
	//excel样式
	private StylesTable stylesTable;
	private ReadOnlySharedStringsTable sharedStringsTable;
   
   //单元格中的数据可能的数据类型
   enum xssfDataType {
       BOOLEAN,
       ERROR,
       FORMULA,
       INLINE_STRING,
       SST_STRING,
       NUMBER,
   }

	public Excel2007ImportSheetHandler(List<ExcelData> dataList, int batchSize,ReadOnlySharedStringsTable sharedStringsTable,
			StylesTable stylesTable) {
		this.dataList = dataList;
		this.batchSize = batchSize;
		this.sharedStringsTable = sharedStringsTable;
		this.stylesTable = stylesTable;
	}
	
	public Excel2007ImportSheetHandler(List<ExcelData> dataList, int batchSize,ReadOnlySharedStringsTable sharedStringsTable,
			StylesTable stylesTable, String dateFormat) {
		this.dataList = dataList;
		this.batchSize = batchSize;
		this.sharedStringsTable = sharedStringsTable;
		this.stylesTable = stylesTable;
		this.dateFormat = dateFormat;
	}

	/**
	 * 在读取元素开始时的处理
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//如果是行开始，则清空cell数据
		if("row".equals(qName)) {
			//当前行号
			rowNumber = Integer.parseInt(attributes.getValue("r"));
			//从第二行开始读
			if(rowNumber == 1) {
				return;
			}
			currentCellData.clear();
			
			lastContents.setLength(0);
		} else if("inlineStr".equals(qName) || "v".equals(qName)) {
			lastContents.setLength(0);
		} else if("c".equals(qName)) {
			setDataType(attributes);
		}
		
	}

	/**
	 * 处理数据类型
	 * @param attributes
	 */
	private void setDataType(Attributes attributes) {
		this.nextDataType = xssfDataType.NUMBER;
		this.formatIndex = -1;
		this.formatString = null;
		//cell类型
		String cellType = attributes.getValue("t");
		//cell样式
		String cellStyleStr = attributes.getValue("s");
		if ("b".equals(cellType))
		   nextDataType = xssfDataType.BOOLEAN;
		else if ("e".equals(cellType))
		   nextDataType = xssfDataType.ERROR;
		else if ("inlineStr".equals(cellType))
		   nextDataType = xssfDataType.INLINE_STRING;
		else if ("s".equals(cellType))
		   nextDataType = xssfDataType.SST_STRING;
		else if ("str".equals(cellType))
		   nextDataType = xssfDataType.FORMULA;
		else if (cellStyleStr != null) {
		   int styleIndex = Integer.parseInt(cellStyleStr);
		   XSSFCellStyle style = stylesTable.getStyleAt(styleIndex);
		   this.formatIndex = style.getDataFormat();
		   this.formatString = style.getDataFormatString();
		   if (this.formatString == null)
		       this.formatString = BuiltinFormats.getBuiltinFormat(this.formatIndex);
         }
	}

	/**
	 * 在读取元素结束时的 处理
	 * 主要是判断是不是一个单元格结束，是不是一行结束，是的话进行相应的处理
	 * 是单元格则将数据（lastContents）添加到currentCellData的相应位置
	 * 是一行结束的话则将 currentCellData添加到dataList中
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		String thisStr = null;
		//对单元格的数据进行类型处理
		if("v".equals(qName)) {
			thisStr = formatCellData(thisStr);
			currentCellData.add(thisStr == null ? "" : thisStr);
		} else if("row".equals(qName)) {
			if (rowNumber == 1) {
                return;
            }
			if(currentCellData != null && currentCellData.size() != 0) {
				ExcelData data = new ExcelData();
				data.setId(Long.valueOf(currentCellData.get(0)).longValue());
				data.setContent(currentCellData.get(1));
				data.setDate(currentCellData.get(2));
				dataList.add(data);
				
				totalSize++;
				data = null;
			}
			
			//读取batchSize条数据后，就保存到db
			if (totalSize % batchSize == 0) {
            	//保存数据到db
                //doBatchSave(dataList);
				System.out.println("读取:"+dataList.size()+"条数据!-----总数"+totalSize);
                dataList.clear();
            }
		}
		/*//按照顺序添加数据
		if("c".equals(qName)) {
			currentCellData.add(lastContents.toString());
		}*/
	}

	/**
	 * 对解析出来的数据进行类型处理
	 * @param thisStr
	 * @return
	 */
	private String formatCellData(String thisStr) {
		//这几个的顺序不能随便交换，交换了很可能会导致数据错误
		switch (nextDataType) {
		case BOOLEAN:
			char first = lastContents.charAt(0);
		    thisStr = first == '0' ? "FALSE" : "TRUE";
			break;
		case ERROR:
			thisStr = "ERROR:" + lastContents.toString();
			break;
		case FORMULA:
			thisStr = '"' + lastContents.toString() + '"';
			break;
		case INLINE_STRING:
			 XSSFRichTextString rtsi = new XSSFRichTextString(lastContents.toString());
		     thisStr = rtsi.toString();
			break;
		case SST_STRING:
			String sstIndex = lastContents.toString();
		    try {
		        int idx = Integer.parseInt(sstIndex);
		        XSSFRichTextString rtss = new XSSFRichTextString(sharedStringsTable.getEntryAt(idx));
		        thisStr = rtss.toString();
		        rtss = null;
		    }catch (NumberFormatException ex) {
		    }
			break;
		case NUMBER:
			String n = lastContents.toString();
			//如果是日期
			if(DateUtil.isADateFormat(this.formatIndex, this.formatString)) {
				thisStr = formatter.formatRawCellContents(Double.parseDouble(n), this.formatIndex, dateFormat);
			} else if (this.formatString != null) {
		        thisStr = formatter.formatRawCellContents(Double.parseDouble(n), this.formatIndex, this.formatString);
			} else
		        thisStr = n;
			break;
		default:
			thisStr = "";
			break;
		}
		return thisStr;
	}

	/**
	 * 对单元格的数据进行处理
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		lastContents.append(ch, start, length);
	}
	
	
}
