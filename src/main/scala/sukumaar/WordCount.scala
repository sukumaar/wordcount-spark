package sukumaar

import org.apache.spark.{SparkConf, SparkContext}


object WordCount {
  val sparkConf: SparkConf = new SparkConf()
    .setAppName("sample-word-count")
  /*.setMaster("local[2]")
  .set("spark.driver.host", "localhost")*/

  val sc: SparkContext = SparkContext.getOrCreate(sparkConf)
  sc.setLogLevel("ERROR")

  def main(args: Array[String]): Unit = {
    val current = (args(0), args(1))
    val textFile = sc.textFile(s"${current._1}")
    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    counts.saveAsTextFile(s"${current._2}")
    println("Done WordCount")
  }
}

