package main.java.com.sparkproject.application.repository;

import main.java.com.sparkproject.application.objects.Tweet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends CrudRepository<Tweet,Long> {

    @Query("SELECT t FROM Tweet t WHERE t.processed = '0'")
    List<Tweet> findAllUncomputedTweets();

}

