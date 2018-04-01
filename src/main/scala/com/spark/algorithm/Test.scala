package com.spark.algorithm

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting


/**
  * Created by kale on 2017/7/8.
  */
object Test {
  var number = 0

  def main(args: Array[String]): Unit = {
//    println("hello World!")
//    println(args.length)
//    var age = 30
//    val result = if (age > 30) "worker" else "manager"
//    println(result)
//    for (i <- 0 to 5 if i == 2) {
//      println(i)
//    }
//
//    var flag = true
//    var sum = 0
//    for (i <- 0 to 15 if flag) {
//      sum = sum + i
//      if (i == 5) flag = false
//    }
//    println(sum)
//
//    for (item <- "hello spark".split(" ")) {
//      println(item)
//    }
//
//    import scala.util.control.Breaks._
//    var flag1 = true
//    breakable {
//      while (flag1) {
//        for (i <- "spark") {
//          println(i)
//          if (i == 'r') {
//            flag1 = false
//            println("break while")
//            break
//          }
//        }
//      }
//    }
//
//    sayHello("kale")
//    println("sumrecursive:" + sumrecursive(1 to 100: _*))
//    val dd = Array(1, 2, 3)
//    arrayExamle(dd)
//    for (j <- 0 to 2) {
//      val kk = Test("kale")
//      kk.log("第" + j + "次打印日志")
//
//    }
//    mapExample()
//    tupleExample()


    //    val sparkConf=new SparkConf().setMaster("local").setAppName("test")
    //    val sparkContext=new SparkContext(sparkConf)
  }

  def apply(name: String): Test = {
    println("当前创建的对象是" + number)
    number += 1
    new Test(name)
  }

  def sayHello(name: String) = {
    println("My name is " + name)
  }

  def sumrecursive(numbers: Int*): Int = {
    if (0 == numbers.length) 0
    else numbers.head + sumrecursive(numbers.tail: _*)
  }

  def arrayExamle(list: Array[Int]) = {
    val tt = Array.apply(1, 2, 7, 4, 77, 3, 4)
    for (item <- tt) println(item)

    Sorting.quickSort(tt)
    for (item <- tt) println(item)

    println(tt.mkString("strt:", ",", "end"))

    println(tt.filter { x => x % 2 == 0 }.map { x => x * 10 }.mkString("  "))

    val ttPlusOne = for (item <- tt) yield item + 1
    for (item <- ttPlusOne) println(item)

    val arrayBuffer = ArrayBuffer[Int]()
    arrayBuffer += 1
    arrayBuffer += 2
    arrayBuffer += (3, 4, 5, 6, 7)
    arrayBuffer ++= Array(8, 9, 10)
    arrayBuffer.insert(5, 999)
    arrayBuffer.toArray

    for (item <- arrayBuffer) println(item)

  }

//  def mapExample() = {
//    val map1 = Map("spark" -> 6, "kale" -> 26)
//
//    val map2 = scala.collection.mutable.SortedMap("spark" -> 6, "kale" -> 26, "hadoop" -> 23)
//    map2("kale") = 30
//
//    for ((name, age) <- map2) println(name + ":" + age)
//  }

  def tupleExample() = {
    val tuple1 = ("kale", "kalegege", "shuaige", "laowang")
    println(tuple1._2)
  }

}

class Test(name: String) extends Logger {
  //  var name = "kale"

  def sayHellos = println("welcome to here:" + name)

  override def log(message: String): Unit = {
    println("我的日志是：" + message)
  }
}

trait Logger {
  def log(message: String)
}
