package com.spark.test

import java.util

/**
  * Created by kale on 2017/7/11.
  * 1.在scala集合体系中，Iterable是共同的trait，要求继承者实现一些共同的方法，例如对元素的遍历
  * 2。array是基础的集合，不属于scala的集合体系当中
  * 3。scala的集合体系，分为可变集合体系和不可变集合体系
  *
  * 4。List是元素的列表集合，是不可变的
  * head是只第一个元素，tail指s剩下的元素构成的集合
  * 使用::这个操作符来把list和其他的元素进行组合拼装，构建出新的list
  * 如果集合中没有元素，此时为nil，如果list只有一个元素，head就是这个元素，tail就返回nil
  *
  * 5。linkedlist是元素可变的列表
  * 6.set是元素不可重复并无序的集合hashset也是无序的
  * linkedset 可以维护插入元素的顺序
  *
  * x=> (x,1)
  * (_,1)
  *
  * 左边只有一个参数的时候可以用占位符_替代
  */
object FunctionalIterable {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    println(list.head)
    println(list.tail)
    println(0 :: list)

    var linkedList = scala.collection.mutable.LinkedList(1, 2, 3, 4, 5)
    println(linkedList.elem)
    println(linkedList.tail)

    while (linkedList != Nil) {
      println(linkedList.elem)
      linkedList = linkedList.tail
    }

    var copy = linkedList.+:(9)
    println(copy)

    val set = Set(1, 2, 3, 4, 5)
    println(set)

    val setMore = set + 6
    println(setMore)

    val sortedset = scala.collection.mutable.SortedSet(1, 5, 3, 77, 234, 3)
    println(sortedset)

    println(List("i love this girl ", "scala is powerfull").flatMap(_.split(" ")).map((_, 1)).map(_._2).reduce((x,y)=>x + y))

    List(1,2,3,4,5).foreach(println(_))
  }


}
