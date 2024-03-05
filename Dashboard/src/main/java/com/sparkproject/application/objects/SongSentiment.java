package main.java.com.sparkproject.application.objects;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class SongSentiment {
    public SongSentiment(){

    }
    private int positive;
    private int negative;
    private int neutral;
}
