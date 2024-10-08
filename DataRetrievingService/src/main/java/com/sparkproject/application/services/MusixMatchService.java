package main.java.com.sparkproject.application.services;

import main.java.com.sparkproject.application.objects.Message;
import main.java.com.sparkproject.application.objects.Song;
import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusixMatchService  {
    private String title = "Heat Wave", artist = "Glass Animals";

    @Value("${musixmatch.api.token}")
    String musixmatchToken;


    @Autowired
    KafkaService kafkaService;

    public void setTitleAndArtist(String title, String artist) {
        this.artist = artist;
        this.title = title;
    }

    public String getLyrics() throws MusixMatchException {
        MusixMatch musixMatch = new MusixMatch(musixmatchToken);
        Track track = musixMatch.getMatchingTrack(title, artist);
        TrackData data = track.getTrack();
        Lyrics lyrics = musixMatch.getLyrics(data.getTrackId());
        return lyrics.getLyricsBody();
    }

    public void getData(List<Song> songList) {
        try {
             processList(songList);

           kafkaService.publishMessage(new Message(songList,"DataCollectorService",null),"songs-topic");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processList(List<Song> songList) throws MusixMatchException {
        for( Song song : songList){
            setTitleAndArtist(song.getTrackName(),song.getArtistName());
            String lyrics = getLyrics();
            song.setLyrics(lyrics);
            System.out.println(lyrics);
        }
    }
}
