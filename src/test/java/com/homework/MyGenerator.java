package com.homework;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * Created with IDEA.
 * User:haibo.
 * DATE:2019/2/26/026
 */
public class MyGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E:\\project");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(false);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("haibo");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
//         gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/graduationproject?useUnicode=true&useSSL=false&serverTimezone=UTC&characterEncoding=utf8");

        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(new String[]{"user"}); // 需要生成的表
        // 字段名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 自定义实体父类
//         strategy.setSuperEntityClass("hello.entity.BaseEntity");
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns(new String[]{"id"});
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.fcs.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.fcs.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.fcs.demo.TestServiceImpl");
        // 自定义 controller 父类
//         strategy.setSuperControllerClass("com.risk.controller.BaseController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        mpg.setStrategy(strategy);


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.homework");
        pc.setModuleName("");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();


    }
}