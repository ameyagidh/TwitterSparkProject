package main.java.com.sparkproject.application.objects;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class TweetSentiment {
    public TweetSentiment(){

    }
    private int positive;
    private int negative;
    private int neutral;
}
