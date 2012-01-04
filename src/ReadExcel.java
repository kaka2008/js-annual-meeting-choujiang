
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {

	public static Workbook getWorkbook(InputStream stream) {
		if (stream == null)
			return null;
		Workbook wb = null;
		try {
			wb = Workbook.getWorkbook(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wb;
	}

	/**
	 * �õ�һ��sheet��һ��Cell�е�ֵ
	 * 
	 * @param sheet
	 * @param column
	 * @param row
	 * @return
	 */
	public static String getContent(Sheet sheet, int column, int row) {
		return sheet.getCell(column, row).getContents().trim();
	}

}
