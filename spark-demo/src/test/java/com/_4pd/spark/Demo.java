package com._4pd.spark;

import org.apache.spark.SparkConf;

public class Demo {

    public static void main(String[] args) {

        String[] sparkArgs = {
                "--class", "com._4pd.spark.WordCount",
                "--jar",   "src/test/resources/jar-files/word-count-demo.jar"
        };

        // 初始化 SparkConf
        SparkConf sparkConf = new SparkConf();
        // 基本信息设置
        sparkConf.set("spark.submit.deployMode", "cluster");    // Required
        sparkConf.set("spark.app.name", "GG");                  // Required
        sparkConf.set("spark.yarn.queue", "default");           // Required
        sparkConf.set("spark.yarn.appMaxAttempts", "1");
        // 文件资源设置
        sparkConf.set("spark.yarn.jars", "hdfs:///tmp/spark-lib/2.3.0/*.jar");  // Required
        sparkConf.set("spark.yarn.dist.jars", "src/test/resources/jar-files/gson-2.8.0.jar");
        sparkConf.set("spark.yarn.dist.files", String.format("%s,%s,%s",
                "src/test/resources/log-files/log4j-info.properties",
                "src/test/resources/log-files/log4j-warn.properties",
                "src/test/resources/log-files/log4j-debug.properties"));
        // 开启 Spark Event Log
        sparkConf.set("spark.eventLog.enabled", "true");
        sparkConf.set("spark.eventLog.dir", "hdfs:///tmp/jobhistory/spark-demo/");
        // JvmOpt 设置
        sparkConf.set("spark.driver.extraJavaOptions", "-Dlog4j.configuration=log4j-debug.properties");
        sparkConf.set("spark.executor.extraJavaOptions", "-Dlog4j.configuration=log4j-debug.properties");
        // 计算资源设置
        sparkConf.set("spark.driver.cores", "1");
        sparkConf.set("spark.driver.memory", "512m");
        sparkConf.set("spark.executor.instances", "1");
        sparkConf.set("spark.executor.cores", "1");
        sparkConf.set("spark.executor.memory", "512m");

        // 向 YARN 提交 Spark 应用
        SparkSubmitter.submitApp(sparkArgs, sparkConf);

        // http://m7-common-cdh07:8088/proxy/application_1571091072053_54110/jobs/job?id=0

    }

}
