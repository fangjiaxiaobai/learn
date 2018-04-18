package com.chinesepander.excel.annotation;


import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Excel 导出
 *      导出xlsx文件格式，支持大数量导出
 * @author fangjiaxiaobai@163.com
 * @date 2018-04-18
 */
public class ExportExcel {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 工作薄对象
     */
    private SXSSFWorkbook wb;

    /**
     * 工作表对象
     */
    private Sheet sheet;

    /**
     * 样式列表
     */
    private Map<String,CellStyle> styles;

    /**
     * 当前行号
     */
    private int rowNum;

    /**
     * 注解列表
     */
    List<Object[]> annotationList = Lists.newArrayList();

    /**
     * 构造函数
     * @param title 表格标题，传空值，表示无标题
     * @param cls 实体对象，通过annotation.ExportField获取标题
     */
    public ExportExcel(String title,Class<?> cls){

    }

    /**
     *  构造函数
     * @param title 表格标题
     * @param cls 实体对象, 需通过ExcelField获取标题
     * @param type 导出类型，0 导入+导出， 1 导入， 2 导出
     * @param groups 导入分组
     */
    public ExportExcel(String title,Class<?> cls,int type,int ...groups){

        // 获取所有字段，但不包含父类字段。
        Field[] fields = cls.getDeclaredFields();
        // 遍历实体类的所有字段
        for (Field field : fields) {
            ExcelField ef = field.getAnnotation(ExcelField.class);

            if(ef!=null && (ef.type() ==0 || ef.type() == type)){
                if(groups!=null && groups.length>0){
                    boolean inGroup = false;
                    for (int group : groups) {
                        if(inGroup){
                            break;
                        }
                        for (int i : ef.groups()) {
                            if(i == group){
                                inGroup = true;
                                annotationList.add(new Object[]{ef,field});
                                break;
                            }
                        }
                    }
                }else{
                    annotationList.add(new Object[]{ef,field});
                }
            }
        }

        // 获取所有方法,不能获取其父类(父接口)的方法
        Method[] ms = cls.getDeclaredMethods();
        for (Method m : ms) {
            ExcelField ef = m.getAnnotation(ExcelField.class);
            if(ef!=null && (ef.type()==0||ef.type()==type)){
                if(null!=groups && groups.length>0){
                    boolean inGroup = false;
                    for (int group : groups) {
                        if(inGroup){
                            break;
                        }

                        for (int i : ef.groups()) {
                            if(group == i){
                                inGroup = true;
                                annotationList.add(new Object[]{ef,m});
                                break;
                            }
                        }

                    }
                }
            }else{
                annotationList.add(new Object[]{ef,m});
            }
        }

        /**
         Reports Comparators defined as lambda expressions which could be expressed using methods like Comparator.comparing().
         Some comparators like (person1, person2) -> person1.getName().compareTo(person2.getName()) could be simplified
         like this: Comparator.comparing(Person::getName).
         Also suggests to replace chain comparisons with Comparator.thenComparing(),
         e.g.
            int res = o1.first.compareTo(o2.first);
            if(res == 0)
                res = o1.second.compareTo(o2.second);
            if(res == 0)
                res = o1.third - o2.third;
            return res;
         will be replaced with
            objs.sort(Comparator.comparing((Obj o) -> o.first).thenComparing(o -> o.second).thenComparingInt(o -> o.third));
         */
        Collections.sort(annotationList,
                (o1,o2)->{
            return new Integer(((ExcelField)o1[0]).sort()).compareTo(
                    new Integer(((ExcelField)o2[0]).sort())
            );
        });

        annotationList.sort( (o1,o2)->{
            return new Integer(((ExcelField)o1[0]).sort()).compareTo(
                    new Integer(((ExcelField)o2[0]).sort())
            );});


        for (Object[] objects : annotationList) {



        }
    }





}
