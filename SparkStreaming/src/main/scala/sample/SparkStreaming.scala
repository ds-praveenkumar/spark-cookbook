package sample

import org.apache.spark.sql.SparkSession

object SparkStreaming {

  def main(args :Array[String]) : Unit ={
    val sc = SparkSession.builder().appName("SparkStreaming").master("local[3]").getOrCreate()
    println(sc.sparkContext.appName)



  }

}
