import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sano on 21.06.2017.
 */
public class ExelWorker {
  public static boolean nameFound=false;

  // private  XSSFWorkbook workbook;
   private String filePath="";


    public ExelWorker( String filePath) throws IOException {
        this.filePath=filePath;

    }

    public void writeExel(String name,int age,int phone) throws IOException{

       XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(filePath));
        Sheet sheet=workbook.getSheet("Sheet1");
        int rowNum= sheet.getLastRowNum();
        
        for (int i = 0; i <=rowNum; i++) {
        	if(sheet.getRow(i).getCell(1).getStringCellValue().equals(name)){
        		
        		Display.setPanelText("Plesse Enter Other Nme");
        		nameFound=true;


        		break;
        	}
			
		}
        workbook.close();
        if(!nameFound){
            workbook=new XSSFWorkbook(new FileInputStream(filePath));
            Sheet sheet2=workbook.getSheet("Sheet1");


         Row newRow= sheet2.createRow(rowNum+1);
         newRow.createCell(0).setCellValue(rowNum);
         newRow.createCell(1).setCellValue(name);
         newRow.createCell(2).setCellValue(age);
         newRow.createCell(3).setCellValue(phone);
        workbook.write(new FileOutputStream(filePath));
        Display.setPanelText("Its okey");

        workbook.close();
        }
        nameFound=false;

    }

    public void redAndPrintExel() throws IOException {
        XSSFWorkbook workbook;
        workbook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet=workbook.getSheet("Sheet1");


        int rowNum= sheet.getLastRowNum();
        for (int i = 1; i <=rowNum ; i++) {

            XSSFRow row = sheet.getRow(i);
            Display.setAreaText((int) (row.getCell(0).getNumericCellValue()), row.getCell(1).getStringCellValue(), (int) (row.getCell(2).getNumericCellValue()), (int) (row.getCell(3).getNumericCellValue()));
            System.out.println(i+"----");
        }


         workbook.close();
    }

}
