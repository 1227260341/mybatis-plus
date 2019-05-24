package com.plus.demo.util;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 *code is far away from bug with the animal protecting
 *  ┏┓　　　┏┓
 *┏┛┻━━━┛┻┓
 *┃　　　　　　　┃ 　
 *┃　　　━　　　┃
 *┃　┳┛　┗┳　┃
 *┃　　　　　　　┃
 *┃　　　┻　　　┃
 *┃　　　　　　　┃
 *┗━┓　　　┏━┛
 *　　┃　　　┃神兽保佑
 *　　┃　　　┃代码无BUG！
 *　　┃　　　┗━━━┓
 *　　┃　　　　　　　┣┓
 *　　┃　　　　　　　┏┛
 *　　┗┓┓┏━┳┓┏┛
 *　　　┃┫┫　┃┫┫
 *　　　┗┻┛　┗┻┛
 *　　
 *   @Description : MybatisPlus代码生成器
 *   ---------------------------------
 *   @Author : 周振江
 *   @Date : Create in 2017/9/19 14:48　
 */
public class MysqlGeneratorV4 {

	private static String packageUrl="com.zhjs.lzcloud.om.";    //包路径
    private static String packageName="purchase";    //文件路径
    private static String fileUrl ="/src/main/java/com/zhjs/lzcloud/om/" + packageName + "/";    //文件路径
    private static String authorName="zhouzhenjang";     //作者
    private static String table="um_user";                  //table名字
    private static String prefix="om";                     //table前缀
    private static File file = new File(packageName);
    private static String path = file.getAbsolutePath();
//    private static String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/lz_cloud_om?characterEncoding=utf-8&useSSL=false";
//    private static String userName = "root";
//    private static String password = "root";
    
    private static String jdbcUrl = "jdbc:mysql://192.168.1.240:3306/lz_cloud_om_temp?characterEncoding=utf-8&useSSL=false";
    private static String userName = "root";
  private static String password = "mysql";

    public static void main(String[] args) {
    	
    	String tables[] = new String[] { "om_labor_fee"};
    	
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));
        
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/v4/mapper.xml.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+"/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        
        focList.add(new FileOutConfig("/templates/v4/controller.java.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+ fileUrl + "controller/" + tableInfo.getEntityName() + "Controller.java";
            }
        });
        
        focList.add(new FileOutConfig("/templates/v4/mapper.java.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+ fileUrl + "mapper/" + tableInfo.getEntityName() + "Mapper.java";
            }
        });
        
        focList.add(new FileOutConfig("/templates/v4/service.java.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+ fileUrl + "service/" + tableInfo.getEntityName() + "Service.java";
            }
        });
        
        focList.add(new FileOutConfig("/templates/v4/serviceImpl.java.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+ fileUrl + "service/impl/" + tableInfo.getEntityName() + "ServiceImpl.java";
            }
        });
        
        focList.add(new FileOutConfig("/templates/v4/entity.java.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+ fileUrl + "entity/" + tableInfo.getEntityName() + ".java";
            }
        });
        
        focList.add(new FileOutConfig("/templates/v4/transfer.java.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+ fileUrl + "transfer/" + tableInfo.getEntityName() + "Transfer.java";
            }
        });
        
        focList.add(new FileOutConfig("/templates/v4/vo.java.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+ fileUrl + "vo/" + tableInfo.getEntityName() + "Vo.java";
            }
        });
        
        focList.add(new FileOutConfig("/templates/v4/dto.java.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+ fileUrl + "dto/" + tableInfo.getEntityName() + "Dto.java";
            }
        });
        
        
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir(path+"/src/main/java")//输出目录
                        .setFileOverride(true)// 是否覆盖文件
                        .setActiveRecord(false)// 开启 activeRecord 模式
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        .setOpen(false)//生成后打开文件夹
                        .setAuthor(authorName)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                 .setMapperName("%sMapper")
                 .setXmlName("%sMapper")
                 .setServiceName("%sService")
                 .setServiceImplName("%sServiceImpl")
                 .setControllerName("%sController")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL)// 数据库类型
                        .setTypeConvert(new MySqlTypeConvert() {
                            // 自定义数据库表字段类型转换【可选】
                            @Override
                            public DbColumnType processTypeConvert(String fieldType) {
                                System.out.println("转换类型：" + fieldType);
                                // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                                //    return DbColumnType.BOOLEAN;
                                // }
                                return super.processTypeConvert(fieldType);
                            }
                        })
                        .setDriverName("com.mysql.jdbc.Driver")
                        .setUsername(userName)
//                        .setPassword("root")
                        .setPassword(password)
                        .setUrl(jdbcUrl)
//                        .setUrl("jdbc:mysql://localhost:3306/ecampus_new?characterEncoding=utf-8")
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        //.setDbColumnUnderline(true)//全局下划线命名
                        .setTablePrefix(new String[]{prefix})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(tables) // 需要生成的表
                        .setRestControllerStyle(true)
                        //.setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体父类
                        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                        // 自定义实体，公共字段
                        //.setSuperEntityColumns(new String[]{"test_id"})
                        .setTableFillList(tableFillList)
                // 自定义 mapper 父类
//                 .setSuperMapperClass("com.baomidou.demo.TestMapper")
                        .setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper")
                // 自定义 service 父类
                // .setSuperServiceClass("com.baomidou.demo.TestService")
                        .setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService")
                // 自定义 service 实现类父类
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                        .setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl")
                // 自定义 controller 父类
//                .setSuperControllerClass(packageUrl +packageName+".controller.AbstractController")
//                .setSuperControllerClass("com21cnjy.crowdsourcing.common.util.BaseController")
                // 【实体】是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                // .setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                 .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        //.setModuleName("User")
                        .setParent(packageUrl+packageName)// 自定义包路径
                        .setController("controller")// 这里是控制器包名，默认 web
                        .setEntity("entity")
                        .setMapper("mapper")
                        .setService("service")
                        .setServiceImpl("service.impl")
                        //.setXml("mapper")
        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);
                    }
                }.setFileOutConfigList(focList)
        ).setTemplate(
                // 关闭默认 xml 生成，调整生成 至 根目录
                new TemplateConfig().setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                 .setController(null)
                // .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                // .setServiceImpl("...");
        );

        // 执行生成
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}