package app.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author <a href="mailto:tianjian@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/18
 * @description
 */
public class ExcleUtil {

    public static String XLS_TYPE = ".xls";

    public static String XLSX_TYPE = ".xlsx";

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param os 输入流
     * @param excelExtName 文件名称后缀（可以用枚举替换）
     * @param sheetName 表格标签
     * @param datas 需要生成的对象信息
     * @param titles 生成表格表头信息
     * @return void
     * @description 根据需要将bean转换为excle文件并输出到文件中
     */
    public static<T> void writeExcel(OutputStream os, String excelExtName, String sheetName, List<T> datas, String[] titles ) throws Exception {
        Workbook wb = getWorkBook(excelExtName, null);
        try {
            Sheet sheet = wb.createSheet(sheetName);

            Row title = sheet.createRow(0);
            for(int i = 0; i < titles.length; i++) {
                Cell cell = title.createCell(i);
                CellStyle cellStyle = createCellStyle(wb);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(titles[i]);
            }

            for(T data : datas) {
                for (int i = 0; i < datas.size(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < titles.length; j++) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue(BeanUtils.getSimpleProperty(data, titles[j]));
                    }
                }
            }
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (wb != null) {
//                wb.close();
            }
        }
    }

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param wb 表单页签对象
     * @return 表格样式
     * @description 给表单页签生成表格样式
     */
    private static CellStyle createCellStyle(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();

        Font font = wb.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 18);

        cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setBorderBottom((short)1);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        return cellStyle;
    }


    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param input 读取文件对象
     * @param sheetName 页签名称
     * @param clazz bean class信息
     * @param params 对应参数信息
     * @param isTitle 是否含有表头
     * @param times 包含时间的字段
     * @return 需要转换的对象集合
     * @description 根据表单和bean生成bean对象集合
     */
    public static<T> List<T> readExcel(InputStream input, String name, String sheetName, Class<T> clazz, String[] params, boolean isTitle, List<Integer> times) throws Exception{
        InputStream is = null;


        ConvertUtils.register(new Converter() {

            public Object convert(Class type, Object value) {
                return value;
            }
        }, Date.class);

        Workbook wb = getWorkBook(name, input);
        try {
            List<T> result = new ArrayList<T>();//对应excel文件

            int sheetSize = wb.getNumberOfSheets();
            for (int i = 0; i < sheetSize; i++) {//遍历sheet页
                Sheet sheet = wb.getSheetAt(i);
                System.out.println("SHEET NAME IS : " + sheet.getSheetName());
                if(!sheet.getSheetName().equals(sheetName)) {
                    continue;
                }
                int rowSize = sheet.getLastRowNum() + 1;
                int start = 0;
                if(isTitle) {
                    start = 1;
                } else {
                    start = 0;
                }
                for (int j = start; j < rowSize; j++) {
                    Row row = sheet.getRow(j);
                    if (row == null) {//略过空行
                        break;
                    }
                    int cellSize = row.getLastCellNum();//行中有多少个单元格，也就是有多少列
                    T t = clazz.newInstance();
                    for (int k = 0; k < cellSize; k++) {
                        Cell cell = row.getCell(k);
                        if (cell != null) {
                            if(times != null && times.contains(k)) {
                                System.out.println(cell.getDateCellValue().toString());
                                Date date = cell.getDateCellValue();
                                BeanUtils.setProperty(t, params[k], date);
                            } else {
                                BeanUtils.setProperty(t, params[k], cell.toString());
                            }
                        }
                    }
                    result.add(t);
                }
            }
            return result;
        } catch (Exception e) {
            throw e;
        } finally {
            if (wb != null) {
//                wb.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    private static Workbook getWorkBook(String fileType, InputStream is) throws Exception {
        Workbook wb = null;
        if (fileType.endsWith(XLS_TYPE)) {
            if(is != null) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new HSSFWorkbook();
            }

        } else if (fileType.endsWith(XLSX_TYPE)) {
            if( is != null) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = wb = new XSSFWorkbook();
            }

        } else {
            throw new Exception("读取的不是excel文件");
        }
        return wb;
    }

    public static void main(String[] args) throws Exception {
    }

}
