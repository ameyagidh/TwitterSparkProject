package main.java.com.sparkproject.application.objects;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class Message {
    private List<Song> songDetails;
    private String senderId;
    private List<TwitterData> tweets;
}
