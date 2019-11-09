package com._4pd.spark

import org.apache.spark.sql.SparkSession

object WordCount {

  def main(args: Array[String]) {

    // 初始化 Spark Session
    val spark = SparkSession
      .builder
      .appName("Work Count Demo")
      .getOrCreate()

    // 打印 Spark 应用配置信息及系统变量
    envLogger(spark)

    // 准备 Demo 数据
    val words = spark.sparkContext.parallelize(
      Array("hello world",
            "hello hadoop",
            "hello spark",
            "hadoop nice",
            "spark nice"))
      .cache()

    // Word Count
    val counts = words.flatMap(line => line.split(" "))
                      .map(word => (word, 1))
                      .reduceByKey(_ + _)

    // 隐式转换
    import spark.implicits._
    counts.count()
    counts.toDF.show()

    Thread.sleep(3600000)

    spark.stop()
  }

  def envLogger(spark: SparkSession): Unit = {
    import scala.collection.JavaConversions._
    println("SPARK VERSION ============>")
    println(spark.version)
    println("SPARK CONFIGS ============>")
    println(spark.sparkContext.getConf.toDebugString)
    println("ENV ======================>")
    for ((k, v) <- System.getenv) println(s"$k = $v")
    println("PROPERTIES ===============>")
    System.getProperties.list(System.out)
  }

}
