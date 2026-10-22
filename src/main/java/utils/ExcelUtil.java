package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

	public static Object[][] read(String path, String sh) throws Exception {
		FileInputStream f = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(f);
		Sheet s = wb.getSheet(sh);
		int r = s.getLastRowNum();
		int c = s.getRow(0).getLastCellNum();
		Object[][] o = new Object[r][c];
		DataFormatter df = new DataFormatter();
		for (int i = 1; i <= r; i++) {
			for (int j = 0; j < c; j++) {
				o[i - 1][j] = df.formatCellValue(s.getRow(i).getCell(j));
			}
		}
		wb.close();
		return o;
	}
}
