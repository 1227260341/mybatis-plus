package com.plus.demo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;

@RestController
@RequestMapping("/util")
public class TestController {

	@RequestMapping("/download")
	public String get() {

		
		return "test success";
	}
	
	/**
	 * easypoi 导出功能
	 * zj
	 * 2018年8月22日
	 */
	@RequestMapping("/MapExportExcel")
    public String exportMerchantProfitQuery(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ExcelExportEntity> colList = new ArrayList<ExcelExportEntity>();
        ExcelExportEntity colEntity = new ExcelExportEntity("商品名称", "title");
        colEntity.setNeedMerge(true);
        colList.add(colEntity);

        colEntity = new ExcelExportEntity("供应商", "supplier");
        colEntity.setNeedMerge(true);
        colList.add(colEntity);

        ExcelExportEntity deliColGroup = new ExcelExportEntity("得力", "deli");
        List<ExcelExportEntity> deliColList = new ArrayList<ExcelExportEntity>();
        deliColList.add(new ExcelExportEntity("市场价", "orgPrice"));
        deliColList.add(new ExcelExportEntity("专区价", "salePrice"));
        deliColGroup.setList(deliColList);
        colList.add(deliColGroup);

        ExcelExportEntity jdColGroup = new ExcelExportEntity("京东", "jd");
        List<ExcelExportEntity> jdColList = new ArrayList<ExcelExportEntity>();
        jdColList.add(new ExcelExportEntity("市场价", "orgPrice"));
        jdColList.add(new ExcelExportEntity("专区价", "salePrice"));
        jdColGroup.setList(jdColList);
        colList.add(jdColGroup);


        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> valMap = new HashMap<String, Object>();
            valMap.put("title", "名称." + i);
            valMap.put("supplier", "供应商." + i);

            List<Map<String, Object>> deliDetailList = new ArrayList<Map<String, Object>>();
            for (int j = 0; j < 3; j++) {
                Map<String, Object> deliValMap = new HashMap<String, Object>();
                deliValMap.put("orgPrice", "得力.市场价." + j);
                deliValMap.put("salePrice", "得力.专区价." + j);
                deliDetailList.add(deliValMap);
            }
            valMap.put("deli", deliDetailList);

            List<Map<String, Object>> jdDetailList = new ArrayList<Map<String, Object>>();
            for (int j = 0; j < 2; j++) {
                Map<String, Object> jdValMap = new HashMap<String, Object>();
                jdValMap.put("orgPrice", "京东.市场价." + j);
                jdValMap.put("salePrice", "京东.专区价." + j);
                jdDetailList.add(jdValMap);
            }
            valMap.put("jd", jdDetailList);

            list.add(valMap);
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("价格分析表", "数据"), colList,
                list);
        FileOutputStream fos = new FileOutputStream("D:/价格分析表1.tt.xls");
        workbook.write(fos);
        fos.close();
        
        InputStream is = new FileInputStream(new File("D:/价格分析表1.tt.xls"));
   		// 设置response参数，可以打开下载页面
   		response.reset();
   		response.setContentType("application/vnd.ms-excel;charset=utf-8");
   		response.setHeader("Content-Disposition", "attachment;filename=" + new String(("D:/价格分析表1.tt.xls").getBytes(), "iso-8859-1"));
   		ServletOutputStream out = response.getOutputStream();
   		BufferedInputStream bis = null;
   		BufferedOutputStream bos = null;
   		try {
   		    bis = new BufferedInputStream(is);
   		    bos = new BufferedOutputStream(out);
   		    byte[] buff = new byte[2048];
   		    int bytesRead;
   		    // Simple read/write loop.
   		    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
   			bos.write(buff, 0, bytesRead);
   		    }
   		} catch (final IOException e) {
   		    throw e;
   		} finally {
   		    if (bis != null)
   			bis.close();
   		    if (bos != null)
   			bos.close();
   		    File tFile = new File("D:/价格分析表1.tt.xls");
   		    tFile.deleteOnExit();
   		}
        
        return "";
    }
	
	
}
