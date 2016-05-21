import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CryptCells {

    /**
     * Encrypt.
     *
     * @param filepath  the filepath
     * @param key       the encryption key
     * @param indexes   the column to be encrypted
     * @param sheetindx the index of the sheet to work on
     * @throws Exception the exception
     */

    public static void encrypt(String filepath, String key, ArrayList<Integer> indexes, Integer sheetindx) throws Exception {

        // Initialization vector
        // If the key length if not 16 bytes we add the missing byte/s.
        while (key.length() != 16) {
            key += "k";
        }

        try {

            FileInputStream fileInputStream = new FileInputStream(filepath);
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet worksheet = workbook.getSheetAt(sheetindx);

            // Declare a date formatter
            DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
            Iterator<Row> rowIterator = worksheet.iterator();
            int rowCount = -1;

            // iterate over each column of each row of the file. If the index of the column correspond to one of the indexes provided we
            // crypt the value of the cell otherwise we just copy it.
            while (rowIterator.hasNext()) {
                rowCount += 1;
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (indexes.contains(cell.getColumnIndex() + 1) && rowCount != 0) try {
                        cell.getDateCellValue();
                        String formattedDate = formatter.formatCellValue(cell);
                        cell.setCellValue(AES.encrypt(formattedDate, key.getBytes()));
                    } catch (Exception e) {
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                cell.setCellValue(AES.encrypt(String.valueOf(cell.getNumericCellValue()), key.getBytes()));
                                break;
                            case Cell.CELL_TYPE_STRING:
                                cell.setCellValue(AES.encrypt(cell.getStringCellValue(), key.getBytes()));
                                break;
                        }
                    }
                }
            }
            fileInputStream.close();
            FileOutputStream outFile = new FileOutputStream(new File(filepath));
            workbook.write(outFile);
            outFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
