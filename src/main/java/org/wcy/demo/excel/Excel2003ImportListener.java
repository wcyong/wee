package org.wcy.demo.excel;

import java.util.List;

import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.wcy.demo.excel.model.ExcelData;

public class Excel2003ImportListener implements HSSFListener {
	
	private String dateFormat = "yyyy-MM-dd";
	List<ExcelData> dataList;
	//批处理大小
	private int batchSize;
	//总大小
    private int totalSize = 0; 
	private SSTRecord sstRecord;
	private final DataFormatter formatter = new DataFormatter();
	ExcelData current = null;
	
	public Excel2003ImportListener(List<ExcelData> dataList, int batchSize) {
		this.dataList = dataList;
		this.batchSize = batchSize;
	}
	
	public Excel2003ImportListener(List<ExcelData> dataList, int batchSize, String dateFormat) {
		this.dataList = dataList;
		this.batchSize = batchSize;
		this.dateFormat = dateFormat;
	}

	@Override
	public void processRecord(Record record) {
		switch (record.getSid()) {
		case BOFRecord.sid:
			//开始解析到workboot sheet 等
			BOFRecord bof = (BOFRecord)record;
			if(bof.getType() == BOFRecord.TYPE_WORKBOOK) {
				//workbook
			} else if(bof.getType() == BOFRecord.TYPE_WORKSHEET) {
				//sheet
			}
			break;
		case BoundSheetRecord.sid:
			//开始解析BoundSheet的信息
			BoundSheetRecord sheetRecord = (BoundSheetRecord)record;
			System.out.println("sheetName:"+sheetRecord.getSheetname());
			break;
		case RowRecord.sid:
			System.out.println("=================RowRecord");
			//开始解析行
			RowRecord row = (RowRecord)record;
			System.out.println("first column:"+row.getFirstCol()+"---last column:"+row.getLastCol());
			break;
		case SSTRecord.sid:
			System.out.println("=================SSTRecord");
			//SSTRecords存储了在Excel中使用的所有唯一String的数组
			sstRecord = (SSTRecord)record;
			/*for(int i=0; i<sstRecord.getNumUniqueStrings(); i++) {
				System.out.println(sstRecord.getString(i));
			}*/
			break;
		case NumberRecord.sid:
			System.out.println("=================NumberRecord");
			//数字和日期都是用这个格式，所以下面一定要判断是不是日期格式，
			//另外默认的数字也会被视为日期格式，所以如果是数字的话，一定要明确指定格式
			NumberRecord numberRecord = (NumberRecord)record;
			//第一行跳过，从第二行开始读取
			if(numberRecord.getRow() == 0) {
				break;
			}
			//第一列
			if(numberRecord.getColumn() == 0) {
				current = new ExcelData();
				current.setId(Double.valueOf(numberRecord.getValue()).longValue());
			//第二列
			} else if(numberRecord.getColumn() == 1) {
				//short formatIndex = numberRecord.getXFIndex();
				//String formatString = BuiltinFormats.getBuiltinFormat(formatIndex);
				//String cellValue = formatter.formatRawCellContents(numberRecord.getValue(), formatIndex, dateFormat);
				String cellValue = getCellValue(numberRecord);
                current.setContent(cellValue);
                add(current);
            }
			break;
		case LabelSSTRecord.sid:
			System.out.println("=================LabelSSTRecord");
			//解析一个String类型的单元格值（存储在SSTRecord）
			LabelSSTRecord lrec = (LabelSSTRecord)record;
			if(lrec.getRow() == 0) {
				break;
			}
			//第一列
			if(lrec.getColumn() == 0) {
				current = new ExcelData();
				String value = sstRecord.getString(lrec.getSSTIndex()).getString();
				current.setId(Double.valueOf(value).longValue());
			} else if(lrec.getColumn() == 1) {
				 String value = sstRecord.getString(lrec.getSSTIndex()).getString();
                 current.setContent(value);
                 add(current);
			}
			break;
		case BoolErrRecord.sid:
			System.out.println("=================BoolErrRecord");
			BoolErrRecord ber = (BoolErrRecord)record;
			if(ber.isBoolean()) {
				if(ber.getRow() == 0) {
					break;
				}
				if(ber.getColumn() == 0) {
					current = new ExcelData();
					//current.setId(ber.getBooleanValue());
				}
			}
			break;
		case BlankRecord.sid:
			System.out.println("=================BlankRecord");
			BlankRecord br = (BlankRecord)record;
			break;
		case FormulaRecord.sid:
			System.out.println("=================FormulaRecord");
			FormulaRecord fr = (FormulaRecord)record;
			System.out.println(fr.getValue());
			break;
		default:
			break;
		}
	}

	private String getCellValue(NumberRecord numberRecord) {
		//判断是否是日期类型
		//HSSFDateUtil.isInternalDateFormat(numberRecord.getXFIndex());
		short formatIndex = numberRecord.getXFIndex();
		String formatString = BuiltinFormats.getBuiltinFormat(formatIndex);
		String celllValue = "";
		System.out.println("************");
		System.out.println(formatString);
		System.out.println(DateUtil.isInternalDateFormat(numberRecord.getXFIndex()));
		System.out.println(DateUtil.isADateFormat(formatIndex, formatString));
		System.out.println("************");
		if(DateUtil.isADateFormat(formatIndex, formatString)) {
			celllValue = formatter.formatRawCellContents(numberRecord.getValue(), formatIndex, dateFormat);
		} else {
			celllValue = String.valueOf(Double.valueOf(numberRecord.getValue()).longValue());
		}
		return celllValue;
	}

	private void add(ExcelData excelData) {
		dataList.add(excelData);
		totalSize++;
		
        //读取batchSize条数据后，就保存到db
		if (totalSize % batchSize == 0) {
        	//保存数据到db
            //doBatchSave(dataList);
			System.out.println("读取:"+dataList.size()+"条数据!-----总数"+totalSize);
            dataList.clear();
        }
	}


}
