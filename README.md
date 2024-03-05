
##  Spark Twitter Project

## Project outline
![Blank diagram](https://github.com/ameyagidh/TwitterSparkProject/assets/65457905/b0c67c9f-c78a-4c2c-b303-06ce0219e650)

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
<img width="345" alt="bar chart" src="https://github.com/ameyagidh/TwitterSparkProject/assets/65457905/dd89c15b-34e5-4cfa-8dd3-cbdf7e77e60c">

Pie Chart showing the sentiment of tweets and songs.
![Sentiment](https://github.com/ameyagidh/TwitterSparkProject/assets/65457905/ea921bef-8c61-43f1-a0fb-33beb38e5ff7)
