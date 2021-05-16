package sample

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SparkStreaming {

  def main(args :Array[String]) : Unit ={
    val sc = SparkSession.builder().appName("SparkStreaming").master("local[3]").getOrCreate()
    println(sc.sparkContext.appName)

    // nc -lk 9999

    val df = sc.readStream
      .format("socket")
      .option("host","localhost")
      .option("port",9999)
      .load()

    val wordsDF = df.select(explode(split(df("value")," ")).alias("word"))

    val count = wordsDF.groupBy("word").count()
    val query = count.writeStream
      .format("console")
      .outputMode("complete")
      .start()
      .awaitTermination()

  }

}
