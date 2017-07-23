package com.spark.test

/**
  * Created by kale on 2017/7/13.
  */

class Man(val name: String)

object Man {
  implicit def manToSuperMan(man: Man) = new SuperMan(man.name)
}

class SuperMan(val name: String) {
  def makeMiracles = println(this.name + " Wow Wow Wow")
}

object HelloImplicits {
  def main(args: Array[String]): Unit = {
    val man = new Man("scala")
    man.makeMiracles

    implicit  val content="spark"
    talk("kale")
    //    val superMan=new SuperMan("spark")
  }

  def talk(name :String)(implicit content:String)=println(name+":"+content)

}
