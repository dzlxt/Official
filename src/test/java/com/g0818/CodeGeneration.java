package com.g0818;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

//代码自动生成
public class CodeGeneration {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig(); //全局对象
        DataSourceConfig dsc =new DataSourceConfig(); //数据源
        PackageConfig pc = new PackageConfig(); //包名
        StrategyConfig sc = new StrategyConfig(); //策略


        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java/com/g0818");
        gc.setAuthor("雷小涛");
        gc.setFileOverride(false);
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.TIME_PACK);
        mpg.setGlobalConfig(gc);

        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/jpa?charset=utf8mb4&useSSL=false&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Drive");
        dsc.setUsername("jpa");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        pc.setController("controller");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setEntity("pojo");
        mpg.setPackageInfo(pc);

        // 策略配置

        sc.setInclude("");
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        mpg.setStrategy(sc);

        mpg.execute();


    }
}
