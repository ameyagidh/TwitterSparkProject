package main.java.com.sparkproject.application.repository;

import main.java.com.sparkproject.application.objects.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song,String> {

    @Query("update Song set processed = processed + 1 where title = $title ")
    Integer updateCount( String title);
    
}
