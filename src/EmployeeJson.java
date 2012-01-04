

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import jxl.Sheet;
import jxl.Workbook;

public class EmployeeJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(JSON
				.toJSON(getEmployeeList("F:\\人员名单.xls")));
	}

	public static List<Map<String, String>> getEmployeeList(String fileName) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Sheet sheet = getSheet(fileName);
		for (int i = 1; i < sheet.getRows(); i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", ReadExcel.getContent(sheet, 1, i));
			map.put("name", ReadExcel.getContent(sheet, 2, i));
			list.add(map);
		}
		return list;
	}

	public static Sheet getSheet(String fileName) {
		Workbook workbook = null;
		try {
			workbook = ReadExcel.getWorkbook(new FileInputStream(new File(
					fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Sheet[] sheets = workbook.getSheets();
		return sheets[0];
	}
}
