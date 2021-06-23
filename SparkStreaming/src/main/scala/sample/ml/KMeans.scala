package sample.ml

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.clustering.{KMeans, KMeansModel}
import org.apache.spark.sql.SparkSession

import scala.util.Random
Random.setSeed(0L)


object KMeans {

  def main(args :Array[String]) : Unit = {
    val sc = SparkSession.builder().appName("KMeans clustering").master("local[3]").getOrCreate()

    // create Random Data
    val trainData = sc.sparkContext.parallelize( (1 to 100).map { _ =>
      val off = if (Random.nextFloat > 0.5) 0.5 else -0.5
      Vectors.dense( Random.nextFloat + off, Random.nextFloat+off)
  })

    val numClusters = 2
    val numIterations = 20

    val clusters = KMeans.train( trainData, numClusters, numIterations)



}
}