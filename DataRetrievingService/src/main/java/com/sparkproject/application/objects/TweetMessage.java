package main.java.com.sparkproject.application.objects;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class TweetMessage {
    private List<TwitterData> tweets;
    private String senderId;
}
