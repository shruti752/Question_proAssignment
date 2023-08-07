package com.HackerNewsApplication.HackerNewsApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "story")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "url")
    private String url;
    @Column(name = "score")
    private int score;
    @Column(name = "time_Of_Submission")
  //  @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime submissionTime;
    @Column(name = "submitter_User")
    private String submitterUser;

}
