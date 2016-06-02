package com.zhbit.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.zhbit.excel.service.ExportExcelService;
import org.zhbit.excel.service.ImportTableService;

/** 
 * 项目名称：ElecRecord
 * 类名称：ExcelUtil 
 * 类描述： 是处理excel文档的工具，主要有生成excel文档和解释excele文档
 * 创建人：谭柳
 * 创建时间：2016年4月27日 下午6:55:43
 * 修改人：谭柳
 * 修改时间：2016年4月27日 下午6:55:43
 * 修改备注： 
 * @version 
 */ 
public class ExcelUtil {	

    /**
     * 方法描述:解释excel文档的方法,解释后生成一个List集合
     * @param config封装了 对excel处理的相应属性
     * @return  解释后的结果集
     * @throws Exception
     */
    public static  <T> List<T> SimpleImportExcel(ExcelConfig config)throws Exception {
    	//HSSFWorkbook workbook = new HSSFWorkbook(config.getFio());   //创建工作本
		boolean is03Excel=config.getFileName().matches("^.+\\.(?i)(xls)$");
		Workbook workbook = is03Excel? new HSSFWorkbook(config.getFio()) : new XSSFWorkbook(config.getFio());

        Sheet sheet = workbook.getSheet(config.getSheetName());       //创建表
        ImportTableService tableService=new ImportTableService(sheet);   //解释表
        tableService.setStartRow(config.getStartRow());        //设置开始行
        tableService.doImport();
        //直接读取到List中,泛型可以是Map也可以是PO
        //第一个参数是从表格第0列开始依次读取内容放到哪些字段中
//        List<Map> read = tableService.read(new String[]{"a","b","c"}, Map.class);
        List<T> read2 = tableService.read(config.getEntityFiled(), config.getClazz());

        return read2;
    }
    
    

    /**
     * 方法描述:生成Excel文档
     * @param config 生成excel所要的数据
     * @throws Exception
     */
    public static void testSimpleVoExport(ExcelConfig config) throws Exception {
    	HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet(config.getSheetName());

        //ExportExcelService service = new ExportExcelService(getpList(), sheet, "学校课程");
        ExportExcelService service = new ExportExcelService(config.getEntitys(), sheet, config.getEntityFiled(), config.getTitle());
       // service.addDic("KCLX", "1", "国家课程").addDic("KCLX", "2", "学校课程");//设置数据字典
        service.doExport();
        
        workbook.write(config.getFos());


    }

}
