simple word count example in spark with maven for newbies

> mvn clean compile package

move wordcount-spark-1.0-SNAPSHOT-jar-with-dependencies.jar to the spark environment

> spark-submit --class sukumaar.WordCount --master yarn  --deploy-mode client  wordcount-spark-1.0-SNAPSHOT-jar-with-dependencies.jar  <input-path> <output-path>