package sample

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import  org.apache.spark.mllib.linalg.Vectors

object transformations {

  def main(args :Array[String]) : Unit = {
    val sc = SparkSession.builder().appName("SparkStreaming").master("local[3]").getOrCreate()
    println(sc.sparkContext.appName)
    val sql = sc.sparkContext
    val dataRDD = sql.parallelize(Seq(1,2, 3 ,4,5)) // create rdd
    dataRDD.foreach(println)

    // map
    dataRDD.map( _ + 2 ).foreach(println)

    // flatmap




  }

}
