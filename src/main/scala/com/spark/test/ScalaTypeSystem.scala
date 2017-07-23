package com.spark.test

/**
  * Created by kale on 2017/7/12.
  * scala类型系统编程实战，
  * 1。scala的类和方法和函数都可以是泛型，在源码中可以看到很多方法的泛型，在实际实例化的时候在指定特定的类型
  * 如rdd中关于rdd类的定义就是泛型rdd中几乎所有方法的定义都是泛型，之所以这么做是因为rdd会派生很多子类，通过子类适配各种不同的数据源以及业务逻辑操作
  * 2。上边界表达了泛型的类型必须是某种类型或者某种类型的子类语法为<:
  *    下边界表达了泛型的类型必须是某种类型或者某种类型的父类语法为>:
  * 3.view bounds 可以j进行某中神秘的转换，把你的类型转换成为m目标类型，其实是上下边界的加强版本
  *   T<% writable 必须是writable类型，但没有直接继承writable 需要通过implict实现
  * 4.T:ClassTag,这个其实也是一个类型转换系统，只是在编译的时候，类型信息不够，需要借助于jvm的runtime来通过运行时信息获得完整的类型信息，这个非常重要
  *   因为sparkd的程序编写和运行是区分driver和executer的，只有在运行的时候才知道完整的类型信息
  * 5.逆变和协变-T和+T
  * 6.context bounds T:Ording 这种语法必须编程ording[T]的方式
  */

class Animal[T](val speices: T) {
  def getAnimal(speices: T): T = {
    speices
  }
}

class Engineer
class Expert extends Engineer

class Meeting[+T]

class Maximun[T: Ordering](val x:T,val y:T){
  def bigger(implicit  ordering: Ordering[T])={
    if(ordering.compare(x,y)>0) x else y
  }
}


object ScalaTypeSystem {
  def main(args: Array[String]): Unit = {
    implicit def dog2Person(dog:Dog) = new Person(dog.name)
    val p = new Person("scala")
    val w = new Worker("spark")
    val d=new Dog("big Yellow")

    new Club(p, w).communicate
    new Club[Person](p,d).communicate

    participateMeeting(new Meeting[Expert])

    println(new Maximun("scala","hadoop").bigger)
  }

  def participateMeeting(meeting: Meeting[Engineer]): Unit ={
    println("welcome")
  }

  class Person(val name: String) {
    def talk(person: Person) {
      println(this.name + ":" + person.name)
    }
  }

  class Worker(name: String) extends Person(name)

  class Dog(val name : String)



  class Club[T <% Person](p1: T, p2: T) {
    def communicate {
      p1.talk(p2)
    }
  }

}
