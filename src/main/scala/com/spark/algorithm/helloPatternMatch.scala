package com.spark.algorithm

import scala.collection.immutable.HashMap

/**
  * Created by kale on 2017/7/11.
  */

class DataFrameWork

case class ComputerFrameWork(name: String, popular: Boolean) extends DataFrameWork

case class StorageFrameWork(name: String, popular: Boolean) extends DataFrameWork

object helloPatternMatch {
  def main(args: Array[String]): Unit = {
    //    getSalary("kale")
    //    getSalary("sss",6)
//    val character = Array(1 to 10)
//    println(character)
//    val character2 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//    println(character2)
//    getMatchType(character)
//    getMatchType(character2)
//    getMatchType(List(1, 2, 3, 4))
//
//    for (item <- character) {
//      for (d <- item) {
//        println(d)
//      }
//    }
//    for (item <- character2) {
//      println(item)
//    }


    //    getMatchCollection(Array("spark","hadoop"))

    //    getBigDataType(ComputerFrameWork("spark",true))
    //    getBigDataType(StorageFrameWork("hdfs",false))

//    getValue("spark1", HashMap("spark" -> "the hottest", "hadoop" -> "the oldest"))
  }

  def getSalary(name: String, age: Int): Unit = {
    name match {
      case "spark" => println("10万美金每年")
      case "hadoop" => println("5万美金每年")
      case _ if name == "kale" => println("300万美金每年")
      case _name if age >= 5 => println("name:" + _name + "--age:" + age + "--312万美金每年")
      case _ => println("3万美金每年")
    }
  }

  def getMatchType(msg: Any): Unit = {
    msg match {
      case i: Int => println("Integer")
      case s: String => println("String")
      case d: Double => println("Double")
      case array: Array[Int] => println("array")
      case list: List[Int] => println("list")
      case array: Array[Range] => println("range")
      case _ => println("Unkown type")
    }
  }

  def getMatchCollection(msg: Array[String]): Unit = {
    msg match {
      case Array("scala") => println("One Element")
      case Array("scala", "java") => println("Two Elements")
      case Array("spark", _*) => println("Many Elements")
      case _ => println("Unkown type")
    }
  }

  def getBigDataType(data: DataFrameWork): Unit = {
    data match {
      case ComputerFrameWork(name, popular) => println("computer name:" + name + "--popular:" + popular)
      case StorageFrameWork(name, popular) => println("storage name:" + name + "--popular:" + popular)
      case _ => println("Other type")

    }
  }

  def getValue(key: String, content: HashMap[String, String]): Unit = {
    content.get(key) match {
      case Some(value) => println(value)
      case None => println("not found ")
    }
  }
}
