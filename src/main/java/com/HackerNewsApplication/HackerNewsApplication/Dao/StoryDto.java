package com.HackerNewsApplication.HackerNewsApplication.Dao;

import com.HackerNewsApplication.HackerNewsApplication.entity.Comment1;
import com.HackerNewsApplication.HackerNewsApplication.entity.Users;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoryDto {
    private Long id;
    private String title;
    private String url;
    private int score;
    private LocalDateTime submissionTime;;
    private Users user;
    private List<Comment1> childComments;
}
