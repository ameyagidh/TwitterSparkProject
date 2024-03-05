
##  Spark Twitter Project

## Project outline
<img width="500" alt="bar chart" src= "https://github.com/ameyagidh/TwitterSparkProject/assets/65457905/e228c4bd-2658-4a41-9352-f0b85ba80490">


## Steps to set up the pipeline
First Download and install Xaamp
Use the following links to do so.
**XAAMP:** https://www.apachefriends.org/download.html
**Kafka:** https://www.apache.org/dyn/closer.cgi?path=/kafka/3.1.0/kafka_2.13-3.1.0.tgz

After Downloading kafka.
```bash
$ tar -xzf kafka_2.13-3.1.0.tgz
$ cd kafka_2.13-3.1.0
```
Start Zookeeper.
```bash
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```
Start Kafka Server.
```bash
$ bin/kafka-server-start.sh config/server.properties
```
Create tweets-topic
````
bin/kafka-topics.sh --create --topic tweets-topic --bootstrap-server localhost:9092
````
Create songs-topic
````
bin/kafka-topics.sh --create --topic songs-topic --bootstrap-server localhost:9092
````


Navigate into the DataRetrievingService directory and run.
````
mvn spring-boot:run
````

Open 2 instances of Spark Streaming service and run the main function in **SparkStreamingSongs.scala** in one instance and **SparkStreamingTweets.scala** in the other instance.

Now navigate to the Dashboard directory and run
````
mvn spring-boot:run
````

Now navigate to the front-end folder and open index.html to view the output.
Refresh the dashboard to view updated stats.


**Repository Outline**

| Folder                | Technologies                           | Description                                                                                     |
|-----------------------|----------------------------------------|-------------------------------------------------------------------------------------------------|
| *DataRetrievingService* | Java, Spring Boot, Apache Kafka       | Service responsible for retrieving data from Spotify, MusixMatch, and Twitter APIs.              |
| *SparkStreaming*       | Scala, Spark, Spark ML, Apache Kafka, MySQL | Reads data from Apache Kafka, computes cosine similarity between lyrics and tweet text, and extracts sentiment of lyrics and tweets. |
| *Presentation*         | -                                      | Contains presentation documents.                                                               |
| *Dashboard*            | Java, Spring Boot, JavaScript         | Provides a REST API for data stored in the MySQL database and hosts a dashboard showing the relationship between tweets and songs, along with sentiment analysis of lyrics and songs. |


**Final output**
Bar Chart showing the number of tweets related to the top 50 songs.
<img width="800" alt="bar chart" src="https://github.com/ameyagidh/TwitterSparkProject/assets/65457905/b02e1da3-f855-4897-b1ee-cacfb10f52f8">

Pie Chart showing the sentiment of tweets and songs.
<img width="800" alt="bar chart" src= "https://github.com/ameyagidh/TwitterSparkProject/assets/65457905/02ea7953-136d-4593-ba3e-d6dbc22dc71c">
