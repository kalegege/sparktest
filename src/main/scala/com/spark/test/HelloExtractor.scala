package com.spark.test

/**
  * Created by kale on 2017/7/13.
  */
case class Person(name: String, age: Int)

class DTCoder(val name: String, val salary: Int)

object DTCoder {
  def apply(name: String, salary: Int) {
    println("DTCoder applymethod invoke!")
    new DTCoder(name, salary)
  }

  def unapply(information:String) = {
    Some((information.subSequence(0,information.indexOf("*"))),information.substring(information.indexOf("*")+1))
  }
}

object HelloExtractor {
  def main(args: Array[String]): Unit = {
    //调用工厂构造方法
    val person = Person.apply("spark", 34)
    //调用了提取符unapply,提取出来
//    val Person(name, age) = person
//    println(name + " : " + age)

    person match {
      case Person(name, age) => println("Wow" + name + " : " + age)
    }

    val DTCoder(name,salary)="kale*3400"
    println("name"+" : "+salary)
  }

}
