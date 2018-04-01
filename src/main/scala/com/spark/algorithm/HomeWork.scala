package com.spark.algorithm

/**
  * Created by kale on 2017/7/17.
  */
object HomeWork {
  def main(args: Array[String]): Unit = {
    //    var list=List(1,3,-4,8,-8,22,-9,78,90,-1)
    //    clearFuNumber(list)
    //    for(elem <- list)println(elem)
//    println(scalaSumCube(1, 2))
//    println(sum(x=> x*x*x)(1,2))
    println(sum(x=> x*x*x)(1)(2))

  }

  //去除数组中第一个负数以后的负数
  //  def clearFuNumber(list: List[Int]): List[Int] = {
  //    var flag:Boolean=false
  //    var result=List[Int]
  //    for(item <- list ){
  //      if(item <0 ){
  //        if(flag){
  //          println("删除的元素是："+item)
  //          list.dropRight(list.indexOf(item))
  //        }
  //        flag=true
  //      }
  //    }
  //
  //  }
  //立方
  def scalaCube(x: Int): Int = {x * x * x}

  //平方
  def scalaSquare(x: Int): Int = {x * x}

  //自身
  def scalaId(x: Int): Int = {x}

  //阶乘
  def scalaFact(x: Int): Int = {if (x == 0) 1 else x * scalaFact(x - 1)}

  //a-b之间的立方和
//  def scalaSumCube(a: Int, b: Int): Int = {if (a > b) 0 else scalaCube(a) + scalaSumCube(a + 1, b)}
//
//  //a-b之间的平方和
//  def scalaSumSquare(a: Int, b: Int): Int = {if(a > b) 0 else scalaSquare(a) + scalaSumSquare(a + 1, b)}
//
//  //a-b之间饿阶乘和
//  def scalaSumFact(a: Int, b: Int): Int = {if (a > b) 0 else scalaFact(a) + scalaSumFact(a + 1, b)}
//
//  //a-b之间的和
//  def scalaSumInt(a: Int, b: Int): Int = {if(a > b) 0 else scalaId(a) + scalaSumInt(a + 1, b)}

  // 高阶函数
//  def sum(f: Int => Int, a: Int, b: Int): Int = {
//    if (a > b) 0 else f(a) + sum(f, a + 1, b)
//  }
  //a-b之间的立方和
//  def scalaSumCube(a: Int, b: Int): Int ={sum(scalaCube,a,b)}
//  //a-b之间的平方和
//  def scalaSumSquare(a: Int, b: Int): Int = {sum(scalaSquare,a,b)}
//  //a-b之间饿阶乘和
//  def scalaSumFact(a: Int, b: Int): Int = {sum(scalaFact,a,b)}
//  //a-b之间的和
//  def scalaSumInt(a: Int, b: Int): Int = {sum(scalaId,a,b)}

  //a-b之间的立方和
//  def scalaSumCube(a: Int, b: Int): Int ={sum(x => x*x*x,a,b)}
//  //a-b之间的平方和
//  def scalaSumSquare(a: Int, b: Int): Int = {sum(x => x*x,a,b)}
//  //a-b之间饿阶乘和
//  def scalaSumFact(a: Int, b: Int): Int = {sum(scalaFact,a,b)}
//  //a-b之间的和
//  def scalaSumInt(a: Int, b: Int): Int = {sum(x => x,a,b)}

  // 高阶函数
//  def sum(f: Int => Int): (Int, Int) => Int = {
//    def sumF(a: Int, b: Int): Int =
//      if (a > b) 0 else f(a) + sumF(a + 1, b)
//
//    sumF
//  }

  //a-b之间的立方和
//  def scalaSumCube: (Int, Int) => Int =sum(x => x*x*x)
//  //a-b之间的平方和
//  def scalaSumSquare: (Int, Int) =>Int = {sum(x => x*x)}
//  //a-b之间饿阶乘和
//  def scalaSumFact: (Int, Int) =>Int = {sum(scalaFact)}
//  //a-b之间的和
//  def scalaSumInt: (Int, Int) =>Int = {sum(x => x)}

  // 柯里化后的 sum 函数
  def sum(f: Int => Int)(a: Int) (b: Int): Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1)(b)

  // 使用柯里化后的高阶函数 !
  sum(x => x * x * x)(1)(10) //=> sumCube(1, 10)
  sum(x => x)(1)(10)           //=> sumInt(1, 10)
}
