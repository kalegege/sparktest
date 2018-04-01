package com.spark.algorithm

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, ObjectInputStream, ObjectOutputStream}

import org.apache.spark.ml.recommendation.ALS.Rating

import scala.io.Source


/**
  * Created by kale on 2017/7/13.
  */
@SerialVersionUID(99L)
class DTSpark(val name: String) extends Serializable

object HelloFileOpps {
  def main(args: Array[String]): Unit = {
    val dtSpark = new DTSpark("kale")
    println(new String(serialize(dtSpark)))

    println(deserialize[DTSpark](serialize[DTSpark](dtSpark)).name)

    val tuple=("kale",3,List(1,2,3))
//    val test=("kale",Rating(1,2,3))
//    val kkk=List("kale is my name and what is your name").flatMap(x => x.split(" ")).map(x => x == "k").values.repartition(2).persist()
    println(tuple._2)
//    println(kkk)
    println((1 to 5).reduceLeft(_ + _))

//    val dd=(1 to 5).map(x => {println(x); x+3})
//    for(item <- dd) println(item)
    val map1=Map("kale"-> 100,"kafka"->99,"spark"->70)
    val keys=List("kale","kafka","spark")
    keys.map(map1(_))

    val map2=Map("kale"-> List(1,2,3),"kafka"->List(4,5,6),"spark"->List(7,8,9))
    val keys2=List("kale","kafka","spark")
    keys.map(map1(_))

//    for (item <- Source.fromFile("/Users/kale/test/a.txt", "GBK").getLines()) println(item)
  }

  def serialize[T](o: T): Array[Byte] = {
    val bos = new ByteArrayOutputStream()
    val oos = new ObjectOutputStream(bos)
    oos.writeObject(o)
    oos.close()
    bos.toByteArray
  }

  def deserialize[T](bytes: Array[Byte]): T = {
    val bis = new ByteArrayInputStream(bytes)
    val ois = new ObjectInputStream(bis)
    ois.readObject.asInstanceOf[T]
  }

}
