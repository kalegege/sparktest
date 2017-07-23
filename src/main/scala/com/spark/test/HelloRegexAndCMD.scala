package com.spark.test

import sys.process._

/**
  * Created by kale on 2017/7/15.
  */
object HelloRegexAndCMD {
  def main(args: Array[String]): Unit = {
    val pattern="[0-9]+".r
    val result=pattern.findFirstIn("life is short , you need spark! 123")
    println(result)
  }

}
