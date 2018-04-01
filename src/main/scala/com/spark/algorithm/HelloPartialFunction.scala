package com.spark.algorithm

/**
  * Created by kale on 2017/7/13.
  */
object HelloPartialFunction {
  def main(args: Array[String]): Unit = {
    val sample = 1 to 20
    val isEven: PartialFunction[Int, Unit] = {
      case x if x % 2 == 0 => println(x + " is even")
    }
    //    val c1 :Int=3
    isEven(4)

    val evenNumbers = sample collect isEven
//    evenNumbers.foreach(println)

    val isOdd: PartialFunction[Int, Unit] = {
      case x if x % 2 == 1 =>  println(x + " is odd")
    }

    val numbers = sample map (isEven orElse isOdd)

  }

}
