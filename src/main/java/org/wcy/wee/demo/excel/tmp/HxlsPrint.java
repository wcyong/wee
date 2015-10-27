package org.wcy.wee.demo.excel.tmp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class HxlsPrint extends HxlsAbstract{

	public HxlsPrint(String filename) throws IOException,
			FileNotFoundException, SQLException {
		super(filename);
	}

	@Override
	public void optRows(int sheetIndex,int curRow, List<String> rowlist) throws SQLException {
		for (int i = 0 ;i< rowlist.size();i++){
			System.out.print("'"+rowlist.get(i)+"',");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		HxlsPrint xls2csv;
		try {
			xls2csv = new HxlsPrint("f:/test/3.xls");
			xls2csv.process();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
