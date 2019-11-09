package com._4pd.spark;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.yarn.api.records.ApplicationId;
import org.apache.hadoop.yarn.api.records.ApplicationReport;
import org.apache.spark.SparkConf;
import org.apache.spark.deploy.yarn.Client;
import org.apache.spark.deploy.yarn.ClientArguments;

@Slf4j
class SparkSubmitter {

    /**
     * 用于提交 Spark 应用，需传入 Spark 应用的参数及配置，详见: xxx
     *
     * @param sparkArgs, Spark 应用参数
     * @param sparkConf, Spark 应用配置
     */
    static void submitApp(String[] sparkArgs, SparkConf sparkConf) {
        // 构造 ClientArguments 用于提交 Spark 应用
        ClientArguments cArgs = new ClientArguments(sparkArgs);
        // 使用 spark-yarn 提供的 Client 提交 Spark 应用
        Client client = new Client(cArgs, sparkConf);
        // 完成提交动作
        ApplicationId applicationId = client.submitApplication();
        // 获取实时报告
        ApplicationReport report = client.getApplicationReport(applicationId);
        // LOG
        log.info("Application: {} submitted, tracking url is {}.",
                applicationId, report.getTrackingUrl());
    }

}