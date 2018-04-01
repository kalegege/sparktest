package com.spark.algorithm

import java.io.IOException

/**
  * Created by kale on 2017/7/13.
  */
object HelloExceptionAndLazyValue {
  def main(args: Array[String]): Unit = {
    try{
        1/0
    }catch {
      case ioException:IOException => println("IOException:"+ ioException.toString)
      case illegalArgumentException:IllegalArgumentException =>println("IllegalArgumentException"+illegalArgumentException.toString)
      case e:Exception => println("other error")
    }

    lazy val score=100
    println("score: "+score)
    println("-------")
  }

}
