package com.spark.test

/**
  * Created by kale on 2017/7/10.
  * 1.函数和变量一样作为一等公民，函数可以直接赋值给变量
  * 2.函数更常用的方式是匿名函数，定义的时候只需要说明输入参数的类型和函数体即可，
  * 不需要名称，但是需要使用的话一般会把这个匿名函数赋值给一个变量常量,spark源码中大量存在的方法
  * 3.函数可以作为参数直接传递给函数，这极大简化了编程的语法，
  * 第一：以前java的方式是new出一个接口的实例，并且在接口实例饿得多回调方法中来实现业务逻辑，
  * 现在是直接把回调方法callback传递给我们的函数，且在函数体中直接使用，这毫无疑问的简化了代码的编写，提升了开发效率
  * 第二：这种方式非常方便编写复杂的业务逻辑和控制逻辑，对于机器学习，深度学习，图计算等而言至关重要
  *
  * 函数作为函数的参数传递的编程方式是称之为g高阶函数的编程方式，
  * 4.函数式编程一个非常强大的地方之一在于函数的返回值可以是函数,当函数的返回类型是函数的时候，这个时候表明scala的函数实现了闭包
  *   scala闭包的内幕是：scala的函数背后是类和对象，所以scala的参数都作为了对象的成员！！！！，所以后续可以继续访问，
  *   这就是scala实现闭包的内幕
  * 5。curing可以维护变量在内存中的状态，且实现返回函数的链式功能，可以实现非常复杂的算法和逻辑
  */


object functionalProgramming {
  def main(args: Array[String]): Unit = {
    val hiData = hiBigData _
    hiData("kale")

    val f = (name: String) => println("bye," + name)
    f("kafaka")

    def getName(func: (String) => Unit, name: String): Unit = {
      func(name)
    }

    getName(f, "scala")

//    Array(1 to 10: _*).map((item: Int) => 2 * item).foreach(x => println(x))


    def funcResult(message: String) = (name: String) => println(message + "bye," + name)
    funcResult("~!")("java") //curring函数写法,必须掌握这种写法，只要是复杂的scala函数式编程，代码就一定会使用这种写法

    val result=funcResult("~!")
    result("java")

  }

  def hiBigData(name: String) {
    println("hi ," + name)
  }

}
