package com.spark.algorithm

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source


/**
  * Created by kale on 2017/7/21.
  */
object AccessFile {
  def main(args: Array[String]): Unit = {
    //屏蔽不必要的日志显示在终端上

    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

    Logger.getLogger("org.apache.eclipse.jetty.server").setLevel(Level.OFF)
    //设置运行环境

    val sparkConf = new SparkConf().setMaster("local").setAppName("spark sql test")

    val sc = new SparkContext(sparkConf)

    //textFile 默认只支持Utf-8格式,这种方法都到的是乱码
    // 这里用的是文件夹路径，也可以指定到具体文件
    val head1="/Users/kale/test/"
    val head2="e:\\test\\"
    val url = "access_cache_cache-10.101.192.21_20170720.log"
    val url1 = "c.txt"
    val url2 = "AccessLog_TVB_IPS01_20170401.log"
    val url3="c.txt"

    sc.textFile(head2+ url3)
//      .map(p => new String(p.getBytes,0,p.length ,"utf-8"))
//      .flatMap(s => s.split("\\|"))
//      .map(x => (x, 1))
//      .reduceByKey(_ + _)
//      .collect
      .foreach(println)

    //    val rdd = sc.hadoopFile("/Users/kale/test/"+url, classOf[TextInputFormat], classOf[LongWritable], classOf[Text], 1)
    //      .map(p => new String(p._2.getBytes, 0, p._2.getLength, "GBK"))
    //      .flatMap(s => s.split(","))
    //      .map(x => (x, 1))
    //      .reduceByKey(_ + _)
    //      .collect
    //      .foreach(println)


    //通过封装后的方法读取GBK文件,并讲每一行数据以字符串格式返回(RDD[String])
    //    transfer(sc,"/Users/hduser/Downloads/gbk").foreach(println)

    //    println(getFile("/Users/kale/test/access_cache_cache-10.101.192.21_20170720.log"))

    //    println(getFile("/Users/kale/test/c.txt"))
    //    getFile1("/Users/kale/test/c.txt")
    //    println(getFile2("/Users/kale/test/c.txt"))
  }

  def getFile(url: String): String = {
    val file = Source.fromFile(url)
    var result = ""
    for (item <- file.getLines()) result += item
    file.close()
    result
  }

  def getFile1(url: String) = {
    val file = Source.fromFile(url)
    for (item <- file.getLines()) {
      val items = item.split("\\|")
      for (elem <- items) {
        println(elem)
      }
    }
    file.close()
  }

  def getFile2(url: String) = {
    val file = Source.fromFile(url)
    var result = ()
    for (item <- file.getLines()) {
      val items = item.split("\\|")

      result = (items(14), items(13), items(3), items(2))
      println("区域：" + items(14) + "点播服务器IP:" + items(13) + "节目的编排地址:" + items(3) + "节目名称:" + items(2))
    }
    file.close()
    result
  }

}
